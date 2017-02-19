/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Marín
 */
public class Salida_BD4O {
 
  private int idsalida;
  private int idUsuarios;
  private String fecha;
  private String hora;
   

    public Salida_BD4O(int iden, int idus,String f,String h ) {
        idsalida = iden;
        idUsuarios = idus;
        fecha = f;
        hora = h;   
    }
    
    public int getidentrada() {
        return idsalida;
    }
    
     public void setidentrada(int idsalida) {
        this.idsalida = idsalida;
    }
    
     public int getidUsuarios() {
        return idUsuarios;
    }
    
     public void setidUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
     
     public String getfecha() {
        return fecha;
    }
    
     public void setfecha(String fecha) {
        this.fecha = fecha;
    }
    
     public String gethora() {
        return hora;
    }
    
     public void sethora(String hora) {
        this.hora = hora;
    }
     @Override
             public String toString(){
    return "idsalida: "+this.idsalida + " idUsuarios: " + this.idUsuarios + " fecha: " +this.fecha + " hora: " +this.hora;
    }
}
