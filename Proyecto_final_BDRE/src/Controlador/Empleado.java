/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioFicha;
import Util.Util;
import Vista.Vista;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Fichero: Empleado.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 01-mar-2014
 */
public class Empleado {

    Util u = new Util();
    Vista v = new Vista();
    ArrayList<UsuarioFicha> fichajes = new ArrayList<>(); //Array para almacenar todos los fichajes

    public Date menu(String user, int idusuario, int opcion, Date fechaIni) throws ParseException {


        switch (opcion) {

            case 1:

                fichar(idusuario);

                break;
            case 2:

                desfichar(idusuario);

                break;

            case 3:

                ArrayList<UsuarioFicha> entradas = new ArrayList<>();
                ArrayList<UsuarioFicha> salidas = new ArrayList<>();
                String fechaentrada = null;
                String horaentrada = null;
                String fechasalida = null;
                String horasalida = null;
                Date hoy = new Date(); //fecha del momento en que se piden las estadisticas
                int mesactual = hoy.getMonth(); //mes actual para solo obtener las horas del mes actual
                long time = 0;  //variable auxiliar para obtener el tiempo
                long time2 = 0;  //variable para obtener el tiempo de este mes
                long time3 = 0;  //variable para obtener el tiempo de el mes pasado


                Connection Conexion;   //Variable para la conexion con la base de datos
                Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos
                if (Conexion == null) {
                    JOptionPane.showMessageDialog(null, "Conexión no realizada");
                }

                //Obtenermos dos arrays con las entradas y salidas del usuario para sacar el tiempo rabajado
                entradas = ConsultaSQL.obtenusuarioficha(1, idusuario, Conexion);
                salidas = ConsultaSQL.obtenusuarioficha(2, idusuario, Conexion);
                int fichajes = salidas.size() - 1;  //variable para saber las veces que se ha acabado de fichar y no tener en cuanta si un usuario esta dentro

                for (int i = 0; i <= fichajes; i++) {

                    fechaentrada = entradas.get(i).getFecha();
                    horaentrada = entradas.get(i).gethora();

                    fechasalida = salidas.get(i).getFecha();
                    horasalida = salidas.get(i).gethora();

                    DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
                    Date entrada = null;
                    Date salida = null;

                    entrada = inputFormat.parse(fechaentrada + ":" + horaentrada);
                    salida = inputFormat.parse(fechasalida + ":" + horasalida);
                    
                    if (salida.getMonth() == mesactual) {  //sacamos solo las horas del mes actual
                        time = restarhorastotales(entrada, salida, time2);
                        time2 = time2 + time;
                    }

                    if (salida.getMonth() == (mesactual - 1) & (mesactual == 0)) {  //sacamos las horas en el caso de que el mes anterior sea diciembre (un año menos)
                        time = restarhorastotales(entrada, salida, time3);
                        time3 = time3 + time;
                    }
                    if (salida.getMonth() == (mesactual - 1) & (mesactual != 0)) {  //sacamos solo las horas del mes pasado
                        time = restarhorastotales(entrada, salida, time3);
                        time3 = time3 + time;
                    }
                }
                
                String horastrabajadasestemes = u.pasardemilisahoras(time2);
                String horastrabajadasmespasado = u.pasardemilisahoras(time3);
                
                v.mostrarmensajeinformacion("Horas trabajadas este mes:    " + horastrabajadasestemes + "\n \n" + "Horas trabajadas el mes pasado:     " + horastrabajadasmespasado);

                break;


            case 4:

                break;

        }

        //return fechaInicial;
        return null;
    }

    public void fichar(int idusuario) {

        Date fechaInicial = new Date();
        int posicion;  //posicion en la tabla donde va a ir el nuevo registro

        Connection Conexion;   //Variable para la conexion con la base de datos
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos
        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        fichajes = ConsultaSQL.obtenfichajes(1, Conexion); //Devuelve un array con todos los fichajes 
        posicion = fichajes.size() + 1;

        ConsultaSQL.fichar(1, Conexion, idusuario, posicion);

    }

    public void desfichar(int idusuario) throws ParseException {

        Date fechaFinal = new Date();
        int posicion;  //posicion en la tabla donde va a ir el nuevo registro
        ArrayList<UsuarioFicha> entradas = new ArrayList<>();
        ArrayList<UsuarioFicha> salidas = new ArrayList<>();

        Connection Conexion;   //Variable para la conexion con la base de datos
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos
        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        fichajes = ConsultaSQL.obtenfichajes(2, Conexion); //Devuelve un array con todos los fichajes
        posicion = fichajes.size() + 1;

        ConsultaSQL.fichar(2, Conexion, idusuario, posicion);

        //Obtenermos dos arrays con las entradas y salidas del usuario para sacar el tiempo rabajado
        entradas = ConsultaSQL.obtenusuarioficha(1, idusuario, Conexion);
        salidas = ConsultaSQL.obtenusuarioficha(2, idusuario, Conexion);

        ConsultaSQL.horastrabajadashoy(posicion, Conexion, entradas, salidas);

    }

    public String restarhoras(Date inicio, Date fin) {

        Date fechaInicial = inicio;
        Date fechaFinal = fin;

        Calendar calFechaInicial = Calendar.getInstance();
        Calendar calFechaFinal = Calendar.getInstance();

        calFechaInicial.setTime(fechaInicial);
        calFechaFinal.setTime(fechaFinal);

        // conseguir la representacion de la fecha en milisegundos
        long milis1 = calFechaInicial.getTimeInMillis();
        long milis2 = calFechaFinal.getTimeInMillis();

        // calcular la diferencia en milisengundos
        long diff = milis2 - milis1;

        // calcular la diferencia en segundos
        long diffSeconds = (diff / 1000) % 60;

        // calcular la diferencia en minutos
        long diffMinutes = (diff / (60 * 1000)) % 60;

        // calcular la diferencia en horas
        long diffHours = diff / (60 * 60 * 1000);

        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        String horastrabajadas = String.valueOf(diffHours) + ":" + String.valueOf(diffMinutes) + ":" + String.valueOf(diffSeconds);

        //cambiamos el formato de la fecha
        String fecha = u.obtenfecha(calFechaFinal);
        String tiempoinicial = u.obtenhora(calFechaInicial);
        String tiempofinal = u.obtenhora(calFechaFinal);

        return horastrabajadas;

    }

    //Metodo para sacar el total de horas
    public long restarhorastotales(Date inicio, Date fin, long time) {

        String horastrabajadas = null;
        long diff = 0;

        Date fechaInicial = inicio;
        Date fechaFinal = fin;

        Calendar calFechaInicial = Calendar.getInstance();
        Calendar calFechaFinal = Calendar.getInstance();

        calFechaInicial.setTime(fechaInicial);
        calFechaFinal.setTime(fechaFinal);

        // conseguir la representacion de la fecha en milisegundos
        long milis1 = calFechaInicial.getTimeInMillis();
        long milis2 = calFechaFinal.getTimeInMillis();

        // calcular la diferencia en milisengundos
        diff = milis2 - milis1;

        // calcular la diferencia en segundos
        long diffSeconds = (diff / 1000) % 60;

        // calcular la diferencia en minutos
        long diffMinutes = (diff / (60 * 1000)) % 60;

        // calcular la diferencia en horas
        long diffHours = diff / (60 * 60 * 1000);

        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        horastrabajadas = String.valueOf(diffHours) + ":" + String.valueOf(diffMinutes) + ":" + String.valueOf(diffSeconds);

        //cambiamos el formato de la fecha
        String fecha = u.obtenfecha(calFechaFinal);
        String tiempoinicial = u.obtenhora(calFechaInicial);
        String tiempofinal = u.obtenhora(calFechaFinal);

        return diff;

    }

    public String compruebaentrada(int iduser) {

        //String usuario = user;
        String estado = null;

        ArrayList<UsuarioFicha> entradas = new ArrayList<>(); //Creamos array para que lea las veces que ha fichado hasta el momento un usuario en ese mismo mes
        ArrayList<UsuarioFicha> salidas = new ArrayList<>();


        Connection Conexion;   //Variable para la conexion con la base de datos
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos

        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        entradas = ConsultaSQL.obtenusuarioficha(1, iduser, Conexion); //llamamos al metodo que realiza la sentencia
        salidas = ConsultaSQL.obtenusuarioficha(2, iduser, Conexion); //llamamos al metodo que realiza la sentencia

        try {
            Conexion.close();   //cerramos la conexion con la BD
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (entradas.size() > salidas.size()) {
            estado = "Dentro";
        } else {
            estado = "Fuera";
        }

        return estado;
    }
}
