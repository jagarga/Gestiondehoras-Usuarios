/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author José Marín
 */
public class Usuario {

    private int idusuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipo;
    private String email;
    private String contraseña;
    private String proyecto;

    public Usuario(int idus, String nom, String ape1, String ape2, String tip, String em, String pass, String proy) {

        idusuario = idus;
        nombre = nom;
        apellido1 = ape1;
        apellido2 = ape2;
        tipo = tip;
        email = em;
        contraseña = pass;
        proyecto = proy;

    }

    public int getidusuario() {
        return idusuario;
    }

    public void setidusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido1() {
        return apellido1;
    }

    public void setapellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getapellido2() {
        return apellido2;
    }

    public void setapellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String gettipo() {
        return tipo;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getcontraseña() {
        return contraseña;
    }

    public void setcontraseña(String pass) {
        this.contraseña = pass;
    }

    public String getproyecto() {
        return proyecto;
    }

    public void setproyecto(String proy) {
        this.proyecto = proy;
    }
}
