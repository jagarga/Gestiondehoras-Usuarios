/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Fichero: ficheros.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 01-mar-2014 Clase que comprueba que existe las carpetas necesarias para
 * guardar las horas
 */
public class ficheros {

    public File compruebaficherohoras() {

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        Date fechaInicial = new Date();
        Calendar calFechaInicial = Calendar.getInstance();
        calFechaInicial.setTime(fechaInicial);
        int año = calFechaInicial.get(Calendar.YEAR);
        int mes = calFechaInicial.get(Calendar.MONTH);

        String carpetaño = Integer.toString(año);
        String carpetames = meses[(mes)];

        File folderhoras = new File("Ficheros\\Horas");
        File foldermes = null;

        if (!folderhoras.exists()) {

            folderhoras.mkdir();
        }

        File folderaño = new File("Ficheros\\Horas\\" + carpetaño);
        //File folderaño = new File("x:\\devtroce\\java");

        if (!folderaño.exists()) {

            folderaño.mkdir();
            foldermes = new File("Ficheros\\Horas\\" + carpetaño + "\\" + carpetames);


            if (!foldermes.exists()) {

                foldermes.mkdir();
            }



        } else {

            foldermes = new File("Ficheros\\Horas\\" + carpetaño + "\\" + carpetames);


            if (!foldermes.exists()) {

                foldermes.mkdir();
            }

        }


        return foldermes;

    }

    public ArrayList<Usuario> compruebaficherousuarios() {

        File file = new File("Ficheros\\Usuarios\\Usuarios.csv");   //carpeta donde esta el excel con el controlde usuarios

        ArrayList<Usuario> usuarios = new ArrayList<>();

        //LEEMOS EL EXCEL CON EL CONTROL DE USUARIOS
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) {

                    StringTokenizer st = new StringTokenizer(s, ";");

                    int identificador = Integer.parseInt(st.nextToken());
                    String nom = st.nextToken();
                    String apellido1 = st.nextToken();
                    String apellido2 = st.nextToken();
                    String tipo = st.nextToken();
                    String email = st.nextToken();
                    String password = st.nextToken();
                    String proyectos = st.nextToken();

                    usuarios.add(new Usuario(identificador, nom, apellido1, apellido2, tipo, email, password, proyectos));

                }
                fr.close();
                //System.out.print("Leido correctamente de: fichero.csv \n \n");

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return usuarios;
    }
}
