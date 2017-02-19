/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Marín
 */
public class Proyecto_Usuarios_BD4O {
    
    private int Proyectos_idProyectos;
    private int Usuarios_idUsuarios; 
    
    
    public Proyecto_Usuarios_BD4O(int idPr, int idus ) {
        Proyectos_idProyectos = idPr;
        Usuarios_idUsuarios = idus;    
    }
    
    public int getProyectos_idProyectos() {
        return Proyectos_idProyectos;
    }
    
     public void setProyectos_idProyectos(int Proyectos_idProyectos) {
        this.Proyectos_idProyectos = Proyectos_idProyectos;
    }

     
     public int getUsuarios_idUsuarios() {
        return Usuarios_idUsuarios;
    }
    
     public void setUsuarios_idUsuarios(int Usuarios_idUsuarios) {
        this.Usuarios_idUsuarios = Usuarios_idUsuarios;
    }
     
     @Override
             public String toString(){
    return "idProyectos: "+this.Proyectos_idProyectos + " idUsuarios: " + this.Usuarios_idUsuarios;
    }  
}

