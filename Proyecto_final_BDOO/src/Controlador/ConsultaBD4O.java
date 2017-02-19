/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Entrada_BD4O;
import Modelo.Proyecto_BD4O;
import Modelo.Proyecto_Usuarios_BD4O;
import Modelo.Salida_BD4O;
import Modelo.Usuario;
import Modelo.UsuarioFicha;
import Vista.Vista;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.db4o.Db4o.*;

/**
 * Fichero: ConsultaSQL.java
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 06-abr-2014
 */
public class ConsultaBD4O {

    static Vista v = new Vista();

    //Método para obtener un arraylist con todos los usuarios del sistema
    public static ArrayList<Usuario> obtenusuarios() {

        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");

        ArrayList<Usuario> usuarios = new ArrayList<>();



        try {

            //System.out.println("Objetos Usuarios");
            Query query = baseDatos.query();
            Constraint constrain = query.constrain(Usuario.class);
            ObjectSet res = query.execute();
            //System.out.println("Objetos Usuario recuperados " + res.size());
            while (res.hasNext()) {
                //System.out.println(res.next());
                usuarios.add((Usuario) res.next());
            }



//Crea un objeto del tipo que te estas trayendo de la bd


        } finally {
            baseDatos.close();
        }



        return usuarios;
    }

    //Método para añadir un usuario
    public static void añadirusuario(int idus, String nom, String ape1, String ape2, String tip, String em, String pass, int cp) {

        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");

        try {
            Usuario Us10=new Usuario(idus,nom,ape1,ape2,tip,em,pass,cp);
            baseDatos.store(Us10);
            v.mostrarmensajeinformacion("Usuario añadido correctamente");

        } finally {
            baseDatos.close();
        }

        }

        //Método para borrar un usuario
    

    public static void borrarusuario(int idusuario) {

        
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");

        try {
            
           Usuario u= new Usuario(idusuario,null, null, null, null, null, null, 0);
            ObjectSet res= baseDatos.queryByExample(u);
            u=(Usuario)res.next();
            baseDatos.delete(u); 
            
            v.mostrarmensajeinformacion("Usuario borrado correctamente");

        } finally {
            baseDatos.close();
        }

    }

    //Método para asignar proyectos al usuario en cuestión
    public static void asignarproyecto( int idusuario, int idproyecto) {

        
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");

        try {
            Proyecto_Usuarios_BD4O pu= new Proyecto_Usuarios_BD4O(idusuario,idproyecto);
            baseDatos.store(pu);
            v.mostrarmensajeinformacion("Proyecto asignado correctamente");

        } finally {
            baseDatos.close();
        }

      

    }

    //Método para crear proyectos
    public static void crearproyecto( int idproyecto, String nombre, int precio) {

       ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");

        try {
            Proyecto_BD4O pu= new Proyecto_BD4O(idproyecto,nombre, precio);
            baseDatos.store(pu);
            v.mostrarmensajeinformacion("Proyecto creado correctamente");

        } finally {
            baseDatos.close();
        }

    }


       //Método para obtener un arraylist con todas las entradas o salidas de todos los usuarios
    public static ArrayList<UsuarioFicha> obtenusuariofichaentrada(int iduser) {

        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");
        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();

        int idusuario;
        String fecha;
        String hora;



        try {
            
            Query query = baseDatos.query();
            Constraint constrain = query.constrain(Entrada_BD4O.class);
            ObjectSet res = query.execute();
            //System.out.println("Objetos Usuario recuperados " + res.size());
            while (res.hasNext()) {
                //System.out.println(res.next());
                Entrada_BD4O en = (Entrada_BD4O) res.next();
                
                //UsuarioFicha user = new UsuarioFicha(en.getidUsuarios(), en.getfecha(), en.gethora());//le mandas los parametros necesarios al constructor
                //usuarios.add(user); //agregas ese objeto a la lista  
                
               if (en.getidUsuarios() == iduser) {    //buscamos el usuario en cuestion      
                    //Creas un objeto del tipo que te estas trayendo de la bd
                    UsuarioFicha user = new UsuarioFicha(en.getidUsuarios(), en.getfecha(), en.gethora());//le mandas los parametros necesarios al constructor
                    usuarios.add(user); //agregas ese objeto a la lista  
                }
                
                
            }
            }finally {
            baseDatos.close();
        }


        return usuarios;
    }
    
    
        //Método para obtener un arraylist con todas las entradas o salidas de todos los usuarios
    public static ArrayList<UsuarioFicha> obtenusuariofichasalida(int iduser) {

        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");
        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();

        int idusuario;
        String fecha;
        String hora;



        try {
            
            Query query = baseDatos.query();
            Constraint constrain = query.constrain(Salida_BD4O.class);
            ObjectSet res = query.execute();
            //System.out.println("Objetos Usuario recuperados " + res.size());
            while (res.hasNext()) {
                //System.out.println(res.next());
                Salida_BD4O en = (Salida_BD4O) res.next();
                
                //UsuarioFicha user = new UsuarioFicha(en.getidUsuarios(), en.getfecha(), en.gethora());//le mandas los parametros necesarios al constructor
                //usuarios.add(user); //agregas ese objeto a la lista  
                
               if (en.getidUsuarios() == iduser) {    //buscamos el usuario en cuestion      
                    //Creas un objeto del tipo que te estas trayendo de la bd
                    UsuarioFicha user = new UsuarioFicha(en.getidUsuarios(), en.getfecha(), en.gethora());//le mandas los parametros necesarios al constructor
                    usuarios.add(user); //agregas ese objeto a la lista  
                }
                
            }
            }finally {
            baseDatos.close();
        }


        return usuarios;
    }
    
    
    
    //Método para obtener un arraylist con todas las entradas o salidas de todos los usuarios
    public static ArrayList<UsuarioFicha> obtenfichajesentrada() {

        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");
        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();

        int idusuario;
        String fecha;
        String hora;



        try {
            
            Query query = baseDatos.query();
            Constraint constrain = query.constrain(Entrada_BD4O.class);
            ObjectSet res = query.execute();
            //System.out.println("Objetos Usuario recuperados " + res.size());
            while (res.hasNext()) {
                //System.out.println(res.next());
                Entrada_BD4O en = (Entrada_BD4O) res.next();
                
                UsuarioFicha user = new UsuarioFicha(en.getidUsuarios(), en.getfecha(), en.gethora());//le mandas los parametros necesarios al constructor
                usuarios.add(user); //agregas ese objeto a la lista  
            }
            }finally {
            baseDatos.close();
        }


        return usuarios;
    }
    
    
        //Método para obtener un arraylist con todas las entradas o salidas de todos los usuarios
    public static ArrayList<UsuarioFicha> obtenfichajesalida() {

        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");
        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();

        int idusuario;
        String fecha;
        String hora;



        try {
            
            Query query = baseDatos.query();
            Constraint constrain = query.constrain(Salida_BD4O.class);
            ObjectSet res = query.execute();
            //System.out.println("Objetos Usuario recuperados " + res.size());
            while (res.hasNext()) {
                //System.out.println(res.next());
                Salida_BD4O en = (Salida_BD4O) res.next();
                
                UsuarioFicha user = new UsuarioFicha(en.getidUsuarios(), en.getfecha(), en.gethora());//le mandas los parametros necesarios al constructor
                usuarios.add(user); //agregas ese objeto a la lista  
            }
            }finally {
            baseDatos.close();
        }


        return usuarios;
    }
 
    public static void ficharentrada(int idusuario, int posicion) {
    
        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();

        Date fecha = new Date();
        DateFormat fechaformat = new SimpleDateFormat ("YYYY-MM-dd");
        DateFormat horaformat = new SimpleDateFormat ("HH:mm:ss");
        
        String fechaactual= fechaformat.format(fecha);
        String horaactual= horaformat.format(fecha);
        
        
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");

        try {
            Entrada_BD4O en = new Entrada_BD4O(posicion, idusuario, fechaactual, horaactual);
            baseDatos.store(en);
            v.mostrarmensajeinformacion("Entrada añadida correctamente");

        } finally {
            baseDatos.close();
        }
          
    }
    
    
        public static void ficharsalida(int idusuario, int posicion) {
    
        ArrayList<UsuarioFicha> usuarios = new ArrayList<>();

        Date fecha = new Date();
        DateFormat fechaformat = new SimpleDateFormat ("YYYY-MM-dd");
        DateFormat horaformat = new SimpleDateFormat ("HH:mm:ss");
        
        String fechaactual= fechaformat.format(fecha);
        String horaactual= horaformat.format(fecha);
        
        
        ObjectContainer baseDatos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "basedatos.db4o");

        try {
            Salida_BD4O en = new Salida_BD4O(posicion, idusuario, fechaactual, horaactual);
            baseDatos.store(en);
            v.mostrarmensajeinformacion("Salida añadida correctamente");

        } finally {
            baseDatos.close();
        }
          
    }
    
    
   
    //Método para obtener las horas trabajadas en la ultima fichada
    public static String horastrabajadashoy(int posicion, ArrayList<UsuarioFicha> entradas, ArrayList<UsuarioFicha> salidas) throws ParseException {

        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        int idusuario;
        String fechaentrada = null;
        String horaentrada = null;
        String fechasalida = null;
        String horasalida = null;

        fechaentrada = entradas.get(entradas.size() - 1).getFecha();
        horaentrada = entradas.get(entradas.size() - 1).gethora();

        fechasalida = salidas.get(entradas.size() - 1).getFecha();
        horasalida = salidas.get(entradas.size() - 1).gethora();

        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        Date entrada = null;
        Date salida = null;

        entrada = inputFormat.parse(fechaentrada + ":" + horaentrada);
        salida = inputFormat.parse(fechasalida + ":" + horasalida);


        Empleado e = new Empleado();
        String horastrabajadas = e.restarhoras(entrada, salida); //Restamos la salida menos la entrada para obtener el tiempo trabajado

        v.mostrarmensajeinformacion("Horas trabajadas:    " + horastrabajadas);

        return fechaentrada;
    }
}
