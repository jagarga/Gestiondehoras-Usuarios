/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 * Fichero: UsuarioFicha.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 01-mar-2014
 */
public class UsuarioFicha {

    private int nombre;
    private String fecha;
    private String hora;
    private String salida;
    private String tiempo;
    private Date fecha2;
    private Time hora2;

    public UsuarioFicha(int id, String fech, String time) {

        nombre = id;
        fecha = fech;
        hora = time;

    }

    public UsuarioFicha(int id, Date fech, Time time) {

        nombre = id;
        fecha2 = fech;
        hora2 = time;

    }

    /**
     * @return the nombre
     */
    public int getNombre() {
        return nombre;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the entrada
     */
    public String gethora() {
        return hora;
    }
    
        /**
     * @return the fecha2
     */
    public Date getFecha2() {
        return fecha2;
    }

    /**
     * @return the hora2
     */
    public Time gethora2() {
        return hora2;
    }
}
