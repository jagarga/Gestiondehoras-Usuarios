/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Fichero: Util.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 18-nov-2013
 */
public class Util {

    public int leerInt(String texto) {

        int valorint = 0;

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        String linea;
        try {
            System.out.print(texto);
            linea = buffer.readLine();
            valorint = Integer.parseInt(linea);
        } catch (IOException | NumberFormatException e) {
        }

        return valorint;
    }

    public String leerString(String texto) {

        String valorstring = null;

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(input);
        try {
            System.out.print(texto);
            valorstring = buffer.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return valorstring;

    }

    public void fin() {

        System.out.print("Fin \n");
        System.exit(0);

    }

    public String obtenfecha(Calendar date) {

        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = format1.format(date.getTime());
        //System.out.println(fecha);

        return fecha;

    }

    public String obtenhora(Calendar date) {

        SimpleDateFormat format2 = new SimpleDateFormat("HH:mm:ss");
        String hora = format2.format(date.getTime());
        //System.out.println(hora);

        return hora;

    }

    public String pasardemilisahoras(long time) {

        String horastrabajadas = null;
        long diff = 0;

        diff = time;

        // calcular la diferencia en segundos
        long diffSeconds = (diff / 1000) % 60;

        // calcular la diferencia en minutos
        long diffMinutes = (diff / (60 * 1000)) % 60;

        // calcular la diferencia en horas
        long diffHours = diff / (60 * 60 * 1000);

        // calcular la diferencia en dias
        long diffDays = diff / (24 * 60 * 60 * 1000);

        horastrabajadas = String.valueOf(diffHours) + ":" + String.valueOf(diffMinutes) + ":" + String.valueOf(diffSeconds);
        
        return horastrabajadas;
    }
}
