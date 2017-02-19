/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.Vista;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Fichero: Administrador.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 30-mar-2014
 */
public class Administrador {

    Vista v = new Vista();

    public void añadirusuario(int idus, String nom, String ape1, String ape2, String tip, String em, String pass) {

        ArrayList<Usuario> usuarios = new ArrayList<>(); //array para guardar los usuarios existentes

        ficheros fi = new ficheros();
        usuarios = fi.compruebaficherousuarios();  //accedemos a las clase que comprueba que existe el fichero y guarda todas las entradas del mes en un array

        int i = 0; //contador
        int j = 0; // Variable para saber si el id ya existe

        while (i < usuarios.size()) { //recorremos todos los usuarios para comprobar si existe el id introducido

            if (usuarios.get(i).getidusuario() == idus) {

                j = 1;
            }
            i++;
        }


        if (j == 1) {
            v.mostrarmensajeerror("Ya existe un usuario con ese identificador");

        } else {

            Usuario user = new Usuario(idus, nom, ape1, ape2, tip, em, pass, "Ninguno");

            usuarios.add(user); //Añadimos este ultimo objeto al array creado a partir del fichero de ese mismo mes
            //v.writefile(fichajes, ruta2, user);  //volvemos a escribir todos los registros del array al fichero

            v.writefileusuarios(usuarios);  //Escribe el nuevo usuario en el .csv de usuarios
            v.mostrarmensajeinformacion("Usuario añadido correctamente");

        }

    }

    public void borrarusuario(int idus) {

        ArrayList<Usuario> usuarios = new ArrayList<>(); //array para guardar los usuarios existentes

        ficheros fi = new ficheros();
        usuarios = fi.compruebaficherousuarios();  //accedemos a las clase que comprueba que existe el fichero y guarda todas las entradas del mes en un array

        int i = 0; //contador
        int j = 0; // Variable para saber si el id ya existe
        int pos = 9999;  //Variable para almaenar la posicion del usuario a borrar

        while (i < usuarios.size()) { //recorremos todos los usuarios para comprobar si existe el id introducido

            if (usuarios.get(i).getidusuario() == idus) {

                j = 1;
                pos = i;
            }
            i++;
        }


        if (j == 1) {
            usuarios.remove(pos);
            v.writefileusuarios(usuarios);  //Escribe el nuevo usuario en el .csv de usuarios
            v.mostrarmensajeinformacion("Usuario borrado correctamente");

        } else {

            v.mostrarmensajeerror("No existe un usuario con ese identificador");
        }
    }

    public void asignarproyecto(int idus, String proyecto) {

        ArrayList<Usuario> usuarios = new ArrayList<>(); //array para guardar los usuarios existentes

        ficheros fi = new ficheros();
        usuarios = fi.compruebaficherousuarios();  //accedemos a las clase que comprueba que existe el fichero y guarda todas las entradas del mes en un array

        int i = 0; //contador
        int j = 0; // Variable para saber si el id ya existe
        int pos = 9999;  //Variable para almaenar la posicion del usuario a borrar

        while (i < usuarios.size()) { //recorremos todos los usuarios para comprobar si existe el id introducido

            if (usuarios.get(i).getidusuario() == idus) {

                j = 1;
                pos = i;
            }
            i++;
        }


        if (j == 1) {
            usuarios.get(pos).setproyecto(proyecto);  //Le asignamos el proyecto al usuario
            v.writefileusuarios(usuarios);  //Escribe el nuevo usuario en el .csv de usuarios
            v.mostrarmensajeinformacion("Proyecto asignado correctamente");

        } else {

            v.mostrarmensajeerror("No existe un usuario con ese identificador");
        }

    }

    public static String muestrausuarios() {  //metodo para que el administrador pueda ver los usuarios

        String usuariostxt = ""; //String que contendra el texto a enviar a la vista para mostrar los usuarios

        ficheros fi = new ficheros();
        ArrayList<Usuario> usuarios = fi.compruebaficherousuarios();

        for (int i = 0; i < usuarios.size(); i++) {

            usuariostxt = usuariostxt + (usuarios.get(i).getidusuario()) + " " + (usuarios.get(i).getNombre()) + " " + (usuarios.get(i).getapellido1()) + " " + (usuarios.get(i).getapellido2()) + "\n";

        }

        return usuariostxt;
    }
}