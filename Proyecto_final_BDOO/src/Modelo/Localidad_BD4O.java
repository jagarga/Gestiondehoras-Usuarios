/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Marín
 */
public class Localidad_BD4O {
    
    private int idLocalidad;
    private String nombrelocalidad;

    public Localidad_BD4O(int idLoc, String nom) {
        idLocalidad = idLoc;
        nombrelocalidad = nom; 
    }
    
    public int getidLocalidad() {
        return idLocalidad;
    }
    
     public void setidLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
     
     public String getnombrelocalidad() {
        return nombrelocalidad;
    }
    
     public void setnombrelocalidad(String nombrelocalidad) {
        this.nombrelocalidad = nombrelocalidad;
    }
     
     
    @Override
             public String toString(){
    return "idLocalidad: "+this.idLocalidad + " nombrelocalidad: " + this.nombrelocalidad;
    }
             
     
     
}
