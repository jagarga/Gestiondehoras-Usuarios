/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.Vista;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Fichero: Administrador.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 30-mar-2014
 */
public class Administrador {

    Vista v = new Vista();

    public void añadirusuario(int idus, String nom, String ape1, String ape2, String tip, String em, String pass, int cp) {

        Connection Conexion;   //Variable para la conexion con la base de datos
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos

        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        ConsultaSQL.añadirusuario(Conexion, idus, nom, ape1, ape2, tip, em, pass, cp); //llamamos al metodo que realiza la sentencia

        try {
            Conexion.close();   //cerramos la conexion con la BD
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarusuario(int idus) {

        Connection Conexion;   //Variable para la conexion con la base de datos
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos

        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        ConsultaSQL.borrarusuario(Conexion, idus); //llamamos al metodo que realiza la sentencia

        try {
            Conexion.close();   //cerramos la conexion con la BD
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void asignarproyecto(int idus, int idproyecto) {

        Connection Conexion;   //Variable para la conexion con la base de datos
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos

        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        ConsultaSQL.asignarproyecto(Conexion, idus, idproyecto); //llamamos al metodo que realiza la sentencia

        try {
            Conexion.close();   //cerramos la conexion con la BD
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearproyecto(int idproyecto, String tipo, int precio) {


        Connection Conexion;   //Variable para la conexion con la base de datos
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos

        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        ConsultaSQL.crearproyecto(Conexion, idproyecto, tipo, precio); //llamamos al metodo que realiza la sentencia

        try {
            Conexion.close();   //cerramos la conexion con la BD
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static String muestrausuarios() {  //metodo para que el administrador pueda ver los usuarios

        String usuariostxt = ""; //Sintrg que contendra el texto a enviar a la vista para mostrar los usuarios

        Connection Conexion;   //Variable para la conexion con la base de datos
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Conexion = ConexionDB.GetConnection();  //conectamos con nuestra base de datos

        if (Conexion == null) {
            JOptionPane.showMessageDialog(null, "Conexión no realizada");
        }

        usuarios = ConsultaSQL.obtenusuarios(Conexion);   //extraemos los usuarios del sistema de la base de datos

        try {
            Conexion.close();  //cerramos la conexion con la base de datos
        } catch (SQLException ex) {
            Logger.getLogger(Acceso.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < usuarios.size(); i++) {

            usuariostxt = usuariostxt + (usuarios.get(i).getidusuario()) + " " + (usuarios.get(i).getNombre()) + " " + (usuarios.get(i).getapellido1()) + " " + (usuarios.get(i).getapellido2()) + "\n";

        }


        return usuariostxt;
    }
}