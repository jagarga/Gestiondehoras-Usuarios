/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioFicha;
import Util.Util;
import Vista.Vista;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    public Date menu(String user, int opcion, Date fechaIni) throws ParseException {

        String usuario = user;
        //int opcion2 = 9999;
        int opcion2 = opcion;
        int condicion;  //variable para distinguir entre entrada y salida

        ArrayList<UsuarioFicha> fichajes = new ArrayList<>(); //Creamos array para que lea las veces que ha fichado hasta el momento un usuario en ese mismo mes

        ficheros f = new ficheros();
        Date fechaInicial = fechaIni;
        Date fechaFinal = null;

        File ruta = f.compruebaficherohoras(); // se comprueba que existe el fichero correspondiente al mes y año y si no lo crea
        fichajes = v.readFile(fichajes, ruta, user); //lee el fichero correspondiente al usuario en el mes correspondiente y guarda todos sus registros en un array



        //opcion2 = v.Opcion();

        switch (opcion2) {

            case 1:

                condicion = 1;

                File ruta1 = f.compruebaficherohoras(); //vuelve a comprobar el fichero
                fechaInicial = fichar(); //el usuario ficha y el sistema registra a hora a la que ha entrado
                UsuarioFicha fichadorentra = restarhoras(usuario, fechaInicial, fechaInicial, condicion);
                fichajes.add(fichadorentra);
                v.writefile(fichajes, ruta1, user);

                break;
            case 2:

                condicion = 2;

                File ruta2 = f.compruebaficherohoras(); //vuelve a comprobar el fichero
                fechaFinal = desfichar(fechaInicial); //el usuario desficha y devuelve el tiempo en el que sale
                //Recuperamos la ultima fecha de entrada del fichero y la formateamos               
                String fechaInicio = fichajes.get((fichajes.size() - 1)).getFecha() + ":" + fichajes.get((fichajes.size() - 1)).getEntrada();
                DateFormat Format = new SimpleDateFormat("dd-MM-yyyy:HH:mm:ss");
                fechaInicial = Format.parse(fechaInicio);

                UsuarioFicha fichador = restarhoras(usuario, fechaInicial, fechaFinal, condicion); //calculamos el tiempo que ha estado dentro y creamos un objeto Usuarioficha
                fichajes.add(fichador); //Añadimos este ultimo objeto al array creado a partir del fichero de ese mismo mes
                v.writefile(fichajes, ruta2, user);  //volvemos a escribir todos los registros del array al fichero


                break;

            case 3:

                int segundos = 0;
                int minutos = 0;
                int horas = 0;
                String horastotales = null;
                String outputText = null;
                String outputText2 = null;
                String outputText3 = null;

                //Definimos los formatos para convertir la hora
                DateFormat outputFormatseg = new SimpleDateFormat("ss");
                DateFormat outputFormatmin = new SimpleDateFormat("mm");
                DateFormat outputFormathor = new SimpleDateFormat("HH");
                DateFormat inputFormat = new SimpleDateFormat("HH:mm:ss");

                for (int i = 0; i < fichajes.size(); i++) {

                    String inputText = fichajes.get(i).getTiempo();
                    Date date = inputFormat.parse(inputText);
                    outputText = outputFormatseg.format(date);   // pasamos cada tiempo a segundos para poder sumarlo
                    outputText2 = outputFormatmin.format(date);   // pasamos cada tiempo a minutos para poder sumarlo
                    outputText3 = outputFormathor.format(date);    // pasamos cada tiempo a horas para poder sumarlo

                    segundos = segundos + Integer.parseInt(outputText);   //sumamos los segundos
                    minutos = minutos + Integer.parseInt(outputText2);    //sumamos los minutos
                    horas = horas + Integer.parseInt(outputText3);        //sumamos las horas
                }

                //Para no exceder de 60 minutos o segundos
                if (segundos > 59) {
                    minutos = minutos + 1;
                    segundos = (segundos - 60);
                }

                if (minutos > 59) {
                    horas = horas + 1;
                    minutos = (minutos - 60);
                }


                String tiempotrabajado = horas + ":" + minutos + ":" + segundos + "\n";
                String texto = " Empleado: " + usuario + "\n Tiempo trabajado este mes: " + tiempotrabajado;
                v.mostrarmensajeinformacion(texto);
                break;

            case 4:

                break;

        }

        return fechaInicial;

    }

    public Date fichar() {

        Date fechaInicial = new Date();

        return fechaInicial;

    }

    public Date desfichar(Date inicio) {

        Date fechaInicial = inicio;
        Date fechaFinal = new Date();


        return fechaFinal;

    }

    public UsuarioFicha restarhoras(String usuario, Date inicio, Date fin, int condicion) {

        //Date fechaInicial= new Date ();
        //Date fechaFinal= new Date (); 

        Date fechaInicial = inicio;
        Date fechaFinal = fin;
        /**
         * Creamos una instancia de la clase calendar
         */
        Calendar calFechaInicial = Calendar.getInstance();
        Calendar calFechaFinal = Calendar.getInstance();
        /**
         * Le pasamos el objeto Date al metodo set time
         */
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

        UsuarioFicha user;

        if (condicion == 1) {

            user = new UsuarioFicha(usuario, fecha, tiempoinicial, "Entrada", horastrabajadas);

        } else {

            user = new UsuarioFicha(usuario, fecha, tiempoinicial, tiempofinal, horastrabajadas);

        }

        return user;
    }

    public String compruebaentrada(String user) {

        String usuario = user;
        String estado = null;

        ArrayList<UsuarioFicha> fichajes = new ArrayList<>(); //Creamos array para que lea las veces que ha fichado hasta el momento un usuario en ese mismo mes
        ficheros f = new ficheros();

        File ruta = f.compruebaficherohoras(); // se comprueba que existe el fichero correspondiente al mes y año y si no lo crea
        fichajes = v.readFile(fichajes, ruta, user); //lee el fichero correspondiente al usuario en el mes correspondiente y guarda todos sus registros en un array

        if ((fichajes.isEmpty()) == false) {

            if (fichajes.get((fichajes.size() - 1)).getSalida().equals("Entrada")) {

                estado = "Dentro";

            } else {

                estado = "Fuera";

            }
        }

        return estado;
    }
}
