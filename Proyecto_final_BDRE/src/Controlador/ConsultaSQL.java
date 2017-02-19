/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioFicha;
import Vista.Vista;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Fichero: ConsultaSQL.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 06-abr-2014
 */
public class ConsultaSQL {

    static Vista v = new Vista();

    //Método para obtener un arraylist con todos los usuarios del sistema
    public static ArrayList<Usuario> obtenusuarios(Connection conexion) {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;

        int idusuario;
        String nombre;
        String apellido1;
        String apellido2;
        String tipo;
        String email;
        String contraseña;
        String proyecto;


        try {
            //Sentencia SQL
            stmt = conexion.createStatement(); //Por defecto s�lo lectura y movimiendo hacia delante
            String sql = "select * from usuarios";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

// Lo que va entre comillas es el nombre del campo de tu bd
                idusuario = Integer.parseInt(rs.getString("idUsuarios"));
                nombre = rs.getString("nombre");
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                tipo = rs.getString("tipo");
                email = rs.getString("email");
                contraseña = rs.getString("password");
                proyecto = rs.getString("nombre");
//Crea un objeto del tipo que te estas trayendo de la bd
                Usuario user = new Usuario(idusuario, nombre, apellido1, apellido2, tipo, email, contraseña, proyecto);//le mandas los parametros necesarios al constructor
                usuarios.add(user); //agregas ese objeto a la lista
            }


        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;
    }

    //Método para añadir un usuario
    public static void añadirusuario(Connection conexion, int idus, String nom, String ape1, String ape2, String tip, String em, String pass, int cp) {

        Statement stmt = null;

        try {
            stmt = conexion.createStatement();
            String sql = "INSERT INTO usuarios VALUES (" + idus + ",'" + nom + "','" + ape1 + "','" + ape2 + "','" + tip + "','" + em + "'," + cp + ", '" + pass + "' )";
            stmt.executeUpdate(sql);
            v.mostrarmensajeinformacion("Usuario añadido correctamente");

        } catch (SQLException ex) {
            v.mostrarmensajeerror(ex.getMessage());
        } catch (Exception ex) {
            v.mostrarmensajeerror(ex.getMessage());
        }

    }

    //Método para borrar un usuario
    public static void borrarusuario(Connection conexion, int idusuario) {


        Statement stmt = null;

        try {
            stmt = conexion.createStatement();
            String sql = "DELETE FROM `gestionempleados`.`usuarios` WHERE `usuarios`.`idUsuarios` =" + idusuario;
            stmt.executeUpdate(sql);
            v.mostrarmensajeinformacion("Usuario borrado correctamente");

        } catch (SQLException ex) {
            v.mostrarmensajeerror(ex.getMessage());
        } catch (Exception ex) {
            v.mostrarmensajeerror(ex.getMessage());
        }

    }

    //Método para asignar proyectos al usuario en cuestión
    public static void asignarproyecto(Connection conexion, int idusuario, int idproyecto) {

        Statement stmt = null;

        try {
            stmt = conexion.createStatement();
            String sql = "INSERT INTO proyecto_usuarios VALUES (" + idproyecto + "," + idusuario + ")";
            stmt.executeUpdate(sql);
            v.mostrarmensajeinformacion("Proyecto asignado correctamente");

        } catch (SQLException ex) {
            v.mostrarmensajeerror(ex.getMessage());
        } catch (Exception ex) {
            v.mostrarmensajeerror(ex.getMessage());
        }

    }

    //Método para crear proyectos
    public static void crearproyecto(Connection conexion, int idproyecto, String nombre, int precio) {

        Statement stmt = null;

        try {
            stmt = conexion.createStatement();
            String sql = "INSERT INTO proyectos VALUES (" + idproyecto + ", '" + nombre + "'," + precio + ")";
            stmt.executeUpdate(sql);
            v.mostrarmensajeinformacion("Proyecto creado correctamente");

        } catch (SQLException ex) {
            v.mostrarmensajeerror(ex.getMessage());
        } catch (Exception ex) {
            v.mostrarmensajeerror(ex.getMessage());
        }

    }

    //Método para obtener un arraylist con todas las entradas o salidas del usuario en cuestion
    public static ArrayList<UsuarioFicha> obtenusuarioficha(int entraosale, int iduser, Connection conexion) {

        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String tabla = null;

        int idusuario;
        String fecha;
        String hora;

        //if para saber si la tabla a la que hay que acceder es a la entrada o a la de slida
        if (entraosale == 1) {
            tabla = "entrada";
        } else {
            tabla = "salida";
        }

        try {
            //Sentencia SQL
            stmt = conexion.createStatement(); //Por defecto s�lo lectura y movimiendo hacia delante
            String sql = "select * from " + tabla;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                idusuario = Integer.parseInt(rs.getString("idUsuarios"));
                fecha = rs.getString("fecha");
                hora = rs.getString("hora");


                if (idusuario == iduser) {    //buscamos el usuario en cuestion      
                    //Creas un objeto del tipo que te estas trayendo de la bd
                    UsuarioFicha user = new UsuarioFicha(idusuario, fecha, hora);//le mandas los parametros necesarios al constructor
                    usuarios.add(user); //agregas ese objeto a la lista  
                }

            }


        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;
    }

    //Método para obtener un arraylist con todas las entradas o salidas de todos los usuarios
    public static ArrayList<UsuarioFicha> obtenfichajes(int entraosale, Connection conexion) {

        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String tabla = null;

        int idusuario;
        String fecha;
        String hora;

        //if para saber si la tabla a la que hay que acceder es a la entrada o a la de slida
        if (entraosale == 1) {
            tabla = "entrada";
        } else {
            tabla = "salida";
        }

        try {
            //Sentencia SQL
            stmt = conexion.createStatement(); //Por defecto s�lo lectura y movimiendo hacia delante
            String sql = "select * from " + tabla;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                idusuario = Integer.parseInt(rs.getString("idUsuarios"));
                fecha = rs.getString("fecha");
                hora = rs.getString("hora");

                //Creas un objeto del tipo que te estas trayendo de la bd
                UsuarioFicha user = new UsuarioFicha(idusuario, fecha, hora);//le mandas los parametros necesarios al constructor
                usuarios.add(user); //agregas ese objeto a la lista  

            }


        } catch (SQLException ex) {
            Logger.getLogger(ConsultaSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;
    }

    //Método insertar en la tabla de entrada o salida los datos
    public static void fichar(int entraosale, Connection conexion, int idusuario, int posicion) {

        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        String tabla = null;

        //Variables de sql para gestionar el tiempo
        java.util.Date utilDate = new java.util.Date(); //fecha actual
        long lnMilisegundos = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
        java.sql.Time sqlTime = new java.sql.Time(lnMilisegundos);
        java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(lnMilisegundos);


        //if para saber si la tabla a la que hay que acceder es a la entrada o a la de slida
        if (entraosale == 1) {
            tabla = "entrada";
        } else {
            tabla = "salida";
        }

        try {
            //Sentencia SQL
            stmt = conexion.createStatement(); //Por defecto s�lo lectura y movimiendo hacia delante
            String sql = "INSERT INTO " + tabla + " VALUES (" + posicion + ", " + idusuario + ", '" + sqlDate + "', '" + sqlTimestamp + "')";
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            v.mostrarmensajeerror(ex.getMessage());
        } catch (Exception ex) {
            v.mostrarmensajeerror(ex.getMessage());
        }

    }

    //Método para obtener las horas trabajadas en la ultima fichada
    public static String horastrabajadashoy(int posicion, Connection conexion, ArrayList<UsuarioFicha> entradas, ArrayList<UsuarioFicha> salidas) throws ParseException {

        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        int idusuario;
        String fechaentrada = null;
        String horaentrada = null;
        String fechasalida = null;
        String horasalida = null;

        fechaentrada = entradas.get(entradas.size() - 1).getFecha();
        horaentrada = entradas.get(entradas.size() - 1).gethora();

        fechasalida = salidas.get(entradas.size() - 1).getFecha();
        horasalida = salidas.get(entradas.size() - 1).gethora();

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        Date entrada = null;
        Date salida = null;

            entrada = inputFormat.parse(fechaentrada + ":" + horaentrada);
            salida = inputFormat.parse(fechasalida + ":" + horasalida);

        
        Empleado e = new Empleado();
        String horastrabajadas = e.restarhoras(entrada, salida); //Restamos la salida menos la entrada para obtener el tiempo trabajado

        v.mostrarmensajeinformacion("Horas trabajadas:    " + horastrabajadas);

        return fechaentrada;
    }
}
