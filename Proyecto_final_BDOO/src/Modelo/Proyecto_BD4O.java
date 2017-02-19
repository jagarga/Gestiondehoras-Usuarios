/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Marín
 */
public class Proyecto_BD4O {
  
    private int idProyectos;
    private String tipo;
    private int Precio_hora; 

    public Proyecto_BD4O(int idPr, String tip,int Ph ) {
        idProyectos = idPr;
        tipo = tip;
        Precio_hora = Ph;    
    }
    
    public int getidProyectos() {
        return idProyectos;
    }
    
     public void setidProyectos(int idProyectos) {
        this.idProyectos = idProyectos;
    }
    
     public String gettipo() {
        return tipo;
    }
    
     public void settipo(String tipo) {
        this.tipo = tipo;
    }
     
     public int getPrecio_hora() {
        return Precio_hora;
    }
    
     public void Precio_hora(int Precio_hora) {
        this.Precio_hora = Precio_hora;
    }
     
     @Override
             public String toString(){
    return "idProyectos: "+this.idProyectos + " tipo: " + this.tipo + " Precio_hora: " +this.Precio_hora;
    }
}

