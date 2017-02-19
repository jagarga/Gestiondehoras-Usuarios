/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Fichero: MostrarUsuarios.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 01-may-2014
 */
public class MostrarUsuarios {

    public static String muestrausuarios() {

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
            
            usuariostxt= usuariostxt + (usuarios.get(i).getidusuario())  + " " + (usuarios.get(i).getNombre())  + " " + (usuarios.get(i).getapellido1())  + " " + (usuarios.get(i).getapellido2()) + "\n"   ;
            
        }


        return usuariostxt;
    }
    
    
    
    
}
