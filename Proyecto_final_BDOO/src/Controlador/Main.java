/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Entrada_BD4O;
import Modelo.Proyecto_BD4O;
import Modelo.Proyecto_Usuarios_BD4O;
import Modelo.Salida_BD4O;
import Vista.VistaPrincipal;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;


/**
 *
 * @author Javier Garcia Garcia <javigarciavlc@gmail.com>
 * @date 17-nov-2013
 */
public class Main {

    public static void main(String[] args) throws Exception {

        VistaPrincipal p = new VistaPrincipal();  
        p.setVisible(true);    //llamamos a la vista principal del menu
        
        //Creacio_bd.objeto(); //Metodo creacion de bd4o
       
        
        ObjectContainer baseDatos=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"basedatos.db4o");
        try{
          System.out.println("Objetos Localidad");
            Query query= baseDatos.query();
            Constraint constrain = query.constrain(Salida_BD4O.class);
            ObjectSet res= query.execute();
            System.out.println("Objetos Localidad recuperados "+res.size());
            while (res.hasNext()){
            System.out.println(res.next());
            }}finally{
        baseDatos.close();
        }
    }
}
