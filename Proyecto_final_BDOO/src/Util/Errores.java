/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Fichero: Errores.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 01-feb-2014
 */
public class Errores {

    public boolean validaremail(String input) throws Exception {

        int validador = 0;

        // comprueba que no empieze por @
        Pattern p = Pattern.compile("^@");
        Matcher m = p.matcher(input);
        if (m.find()) {
            System.out.println("Las direcciones email no empiezan @");
            validador++;
        }

        // comprueba que no empieze por www.
        p = Pattern.compile("^www.");
        m = p.matcher(input);
        if (m.find()) {
            System.out.println("Los emails no empiezan por www");
            validador++;
        }

        // comprueba que contenga @
        p = Pattern.compile("@");
        m = p.matcher(input);
        if (!m.find()) {
            System.out.println("El email no tiene arroba");
            validador++;
        }

        // comprueba que contenga punto
        p = Pattern.compile(".");
        m = p.matcher(input);
        if (!m.find()) {
            System.out.println("El email no tiene punto");
            validador++;
        }

        // comprueba que no contenga caracteres prohibidos	
        p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
        m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        boolean resultado = m.find();
        boolean caracteresIlegales = false;

        while (resultado) {
            caracteresIlegales = true;
            m.appendReplacement(sb, "");
            resultado = m.find();
        }

        // Añade el ultimo segmento de la entrada a la cadena
        m.appendTail(sb);

        input = sb.toString();

        if (caracteresIlegales) {
            System.out.println("El email contiene caracteres ilegales");
            validador++;
        }

        if (validador == 0) {

            return true;

        } else {
            System.out.println("Error: Email incorrecto \n");
            return false;
        }

    }
}
