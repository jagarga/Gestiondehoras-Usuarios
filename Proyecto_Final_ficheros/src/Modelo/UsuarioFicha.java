/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 * Fichero: UsuarioFicha.java
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 01-mar-2014
 */

public class UsuarioFicha {
    
    private String nombre;
    private String fecha;
    private String entrada;
    private String salida;
    private String tiempo;
    
    
    public UsuarioFicha(String nom, String fech, String entra, String sale, String horastrabajadas) {
        
        nombre = nom;
        fecha = fech;
        entrada = entra;
        salida = sale;
        tiempo = horastrabajadas;   
        
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
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
    public String getEntrada() {
        return entrada;
    }

    /**
     * @return the salida
     */
    public String getSalida() {
        return salida;
    }

    /**
     * @return the tiempo
     */
    public String getTiempo() {
        return tiempo;
    }
    
    

}
