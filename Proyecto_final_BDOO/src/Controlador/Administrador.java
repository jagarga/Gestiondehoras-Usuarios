/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.Vista;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
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



        ConsultaBD4O.añadirusuario(idus, nom, ape1, ape2, tip, em, pass, cp); //llamamos al metodo que realiza la sentencia


    }

    public void borrarusuario(int idus) {

     

        ConsultaBD4O.borrarusuario(idus); //llamamos al metodo que realiza la sentencia




    }

    public void asignarproyecto(int idus, int idproyecto) {

       

        ConsultaBD4O.asignarproyecto(idus, idproyecto); //llamamos al metodo que realiza la sentencia

       

    }

    public void crearproyecto(int idproyecto, String tipo, int precio) {


        

        ConsultaBD4O.crearproyecto( idproyecto, tipo, precio); //llamamos al metodo que realiza la sentencia

       


    }

    public static String muestrausuarios() {  //metodo para que el administrador pueda ver los usuarios

        String usuariostxt = ""; //String que contendra el texto a enviar a la vista para mostrar los usuarios
  
        ArrayList<Usuario> usuarios = ConsultaBD4O.obtenusuarios();

        for (int i = 0; i < usuarios.size(); i++) {

            usuariostxt = usuariostxt + (usuarios.get(i).getidusuario()) + " " + (usuarios.get(i).getNombre()) + " " + (usuarios.get(i).getapellido1()) + " " + (usuarios.get(i).getapellido2()) + "\n";

        }

        return usuariostxt;
    }
}