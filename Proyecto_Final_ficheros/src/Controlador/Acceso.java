/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import Vista.VistaAdministrador;
import Vista.VistaFichar;
import Vista.Vista;
import Vista.VistaAcceder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Fichero: Acceso.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 29-mar-2014
 */
public class Acceso {
    
    Vista vis = new Vista();

    public void acceso(int id, String pass, VistaAcceder a) throws ParseException {

        int identifica = id;
        String contraseña = pass;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        ficheros fi = new ficheros();
        usuarios = fi.compruebaficherousuarios();  //accedemos a las clase que comprueba que existe el fichero y guarda todas las entradas del mes en un array

        //LOCALIZAMOS EL USUARIO QUE HA ENTRADO

        int usuarioactual = 0;
        String passactual = null;
        int i = 0;
        int j = 0;  //Variable para saber si se ha encontrado el usuario

//Usuario user = usuarios.get(i);
        while (i < usuarios.size()) {

            Usuario user = usuarios.get(i);
            usuarioactual = user.getidusuario();

            if (identifica == usuarioactual) {  //localizamos el usuario que ha entrado

                passactual = user.getcontraseña();
                j = 1;  //Ponemos uno porque ya hemos encontrado el usuario

                if (passactual.equals(contraseña)) {   //Comprobamos la 

                    Date fecha = new Date(); //fecha para poder mostrar en el panel el mes actual
                    DateFormat fechaFormat = new SimpleDateFormat("d-M-YYYY");
                    String fechaactual = fechaFormat.format(fecha);  //Mostramos fecha
                    DateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
                    String horaactual = horaFormat.format(fecha);   //Mostramos hora


                    if (user.gettipo().equals("Administrador")) {  //Obtenemos el tipo de empleado

                        VistaAdministrador va = new VistaAdministrador(user.getNombre(), fechaactual, horaactual);
                        va.setVisible(true);
                        a.setVisible(false);

                    } else {   //No es admnistrador, abrimos el menu de empleado

                        //Primero averiguamos si el usuario esta dentro o fuera
                        Empleado e = new Empleado();
                        String estado = e.compruebaentrada(user.getNombre());
                        
                        VistaFichar v = new VistaFichar(user.getNombre(), fechaactual, horaactual, estado);
                        v.setVisible(true);
                        a.setVisible(false);
                    }

                } else {

                    vis.mostrarmensajeerror("Contraseña incorrecta");
                }
            }

            i++;
        }

        if (j == 0) {  //Si se entra en el if es porque no existe el usuario

            vis.mostrarmensajeerror("Usuario incorrecto");
        }

    }
}
