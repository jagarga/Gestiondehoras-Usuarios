/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Marín
 */
public class Entrada_BD4O {
    
  private int identrada;
  private int idUsuarios;
  private String fecha;
  private String hora;
   

    public Entrada_BD4O(int iden, int idus,String f,String h ) {
        identrada = iden;
        idUsuarios = idus;
        fecha = f;
        hora = h;   
    }
    
    public int getidentrada() {
        return identrada;
    }
    
     public void setidentrada(int identrada) {
        this.identrada = identrada;
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
    return "identrada: "+this.identrada + " idUsuarios: " + this.idUsuarios + " fecha: " +this.fecha + " hora: " +this.hora;
    }
}
