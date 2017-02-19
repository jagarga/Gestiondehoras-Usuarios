
package Controlador;

import Modelo.Entrada_BD4O;
import Modelo.Localidad_BD4O;
import Modelo.Proyecto_BD4O;
import Modelo.Proyecto_Usuarios_BD4O;
import Modelo.Salida_BD4O;
import Modelo.Usuario;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.Db4o.*;




public class Creacio_bd {
   

    public static void objeto() {
        ObjectContainer baseDatos=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),"basedatos.db4o");
        try{
            
           //CREA ENTRADAS EN LA BASE DE DATOS.
            
            //Localidad_BD4O l2= new Localidad_BD4O(1235, "Catarroja");
            //baseDatos.store(l2);
            
            //ENTRADAS LOCALIDAD
            
            
            Localidad_BD4O l2= new Localidad_BD4O(462508,"Valencia");
            Localidad_BD4O l3= new Localidad_BD4O(462495,"Utiel");
            Localidad_BD4O l4= new Localidad_BD4O(462460,"Tous");
            baseDatos.store(l2);
            baseDatos.store(l3);
            baseDatos.store(l4);
            
            
           
            
            //CREACION USUARIO
            Usuario Us1=new Usuario(12345,"Jose","Marin","Malagon","admin","jmarin@gmail.com","123",462508);
            Usuario Us2=new Usuario(23456, "Luisa","Fernandez","Vera","user1","luferve@gmail.com","456",462508);
            Usuario Us3=new Usuario(34567, "Julio","Marin","Campos","user1","jumarca@gmail.com","456",462508);
            Usuario Us4=new Usuario(45678, "Javier","Garcia","Garcia","admin","jagarga@gmail.com","123",462508);
            Usuario Us5=new Usuario(56789, "Emilio","Pascual","Martinez","user1","empamar@gmail.com","456",462508);
            Usuario Us6=new Usuario(67890, "Amparo","Marzal","Pascual","user2","amarpas@gmail.com","456",462508);
            Usuario Us7=new Usuario(78901, "Sergio","Moreno","Blanco","user2","semobla@gmail.com","456",462508);
            Usuario Us8=new Usuario(1, "Javier","Garcia","Garcia","admin","javigarciavlc@gmail.com","123",462508);
            Usuario Us9=new Usuario(2, "Andres","Iniesta","Garcia","user1","andresvlc@gmail.com","456",462508);
            Usuario Us10=new Usuario(4, "Paco","Aldarias","Ceed","admin","paco@gmail.com","123",46260);
            baseDatos.store(Us1);
            baseDatos.store(Us2);
            baseDatos.store(Us3);
            baseDatos.store(Us4);
            baseDatos.store(Us5);
            baseDatos.store(Us6);
            baseDatos.store(Us7);
            baseDatos.store(Us8);
            baseDatos.store(Us9);
            baseDatos.store(Us10);
            
            
            
           
            //ENTRADAS PROYECTOS
            Proyecto_BD4O p1= new Proyecto_BD4O(54321, "Diseño web",13);
            Proyecto_BD4O p2= new Proyecto_BD4O(43210, "Aplicaciones multimedia",19);
            Proyecto_BD4O p3= new Proyecto_BD4O(98765, "Bases de datos",11);
            baseDatos.store(p1);
            baseDatos.store(p2);
            baseDatos.store(p3);
            
            //ENTRADAS PROYECTO_USUARIOS
            
            Proyecto_Usuarios_BD4O PU1= new Proyecto_Usuarios_BD4O(54321, 12345);
            Proyecto_Usuarios_BD4O PU2= new Proyecto_Usuarios_BD4O(54321, 23456);
            Proyecto_Usuarios_BD4O PU3= new Proyecto_Usuarios_BD4O(54321, 34567);
            Proyecto_Usuarios_BD4O PU4= new Proyecto_Usuarios_BD4O(43210, 45678);
            Proyecto_Usuarios_BD4O PU5= new Proyecto_Usuarios_BD4O(43210, 56789);
            Proyecto_Usuarios_BD4O PU6= new Proyecto_Usuarios_BD4O(98765, 67890);
            baseDatos.store(PU1);
            baseDatos.store(PU2);
            baseDatos.store(PU3);
            baseDatos.store(PU4);
            baseDatos.store(PU5);
            baseDatos.store(PU6);
           
            
            
            //ENTRADAS HORA DE ENTRADA
            
            Entrada_BD4O E1= new Entrada_BD4O(0,12345,"2014-01-20","10:11:12");
            Entrada_BD4O E2= new Entrada_BD4O(0,23456, "2014-01-20","09:00:12");
            Entrada_BD4O E3= new Entrada_BD4O(0,34567, "2014-01-20","09:01:12");
            Entrada_BD4O E4= new Entrada_BD4O(0,45678, "2014-01-20","09:00:00");
            Entrada_BD4O E5= new Entrada_BD4O(0,56789, "2014-01-20","09:01:00");
            Entrada_BD4O E6= new Entrada_BD4O(0,67890, "2014-01-20","09:00:00");
            Entrada_BD4O E7= new Entrada_BD4O(0,78901, "2014-01-20","09:01:34");
            Entrada_BD4O E8= new Entrada_BD4O(0,12345, "2014-01-20","15:00:00");
            Entrada_BD4O E9= new Entrada_BD4O(0,23456, "2014-01-20","15:01:34");
            Entrada_BD4O E10= new Entrada_BD4O(0,34567, "2014-01-20","15:00:00");
            Entrada_BD4O E11= new Entrada_BD4O(0,45678, "2014-01-20","15:01:34");
            Entrada_BD4O E12= new Entrada_BD4O(0,56789, "2014-01-20","15:00:00");
            Entrada_BD4O E13= new Entrada_BD4O(0,67890, "2014-01-20","15:01:34");
            Entrada_BD4O E14= new Entrada_BD4O(0,78901, "2014-01-20","15:00:00");
            Entrada_BD4O E15= new Entrada_BD4O(0,12345, "2014-01-21","10:11:12");
            Entrada_BD4O E16= new Entrada_BD4O(0,23456, "2014-01-21","09:00:12");
            Entrada_BD4O E17= new Entrada_BD4O(0,34567, "2014-01-21","09:01:12");
            Entrada_BD4O E18= new Entrada_BD4O(0,45678, "2014-01-21","09:00:00");
            Entrada_BD4O E19= new Entrada_BD4O(0,56789, "2014-01-21","09:01:00");
            Entrada_BD4O E20= new Entrada_BD4O(0,67890, "2014-01-21","09:00:00");
            Entrada_BD4O E21= new Entrada_BD4O(0,78901, "2014-01-21","09:01:34");
            Entrada_BD4O E22= new Entrada_BD4O(0,12345, "2014-01-21","15:00:00");
            Entrada_BD4O E23= new Entrada_BD4O(0,23456, "2014-01-21","15:01:34");
            Entrada_BD4O E24= new Entrada_BD4O(0,34567, "2014-01-21","15:00:00");
            Entrada_BD4O E25= new Entrada_BD4O(0,45678, "2014-01-21","15:01:34");
            Entrada_BD4O E26= new Entrada_BD4O(0,56789, "2014-01-21","15:00:00");
            Entrada_BD4O E27= new Entrada_BD4O(0,67890, "2014-01-21","15:01:34");
            Entrada_BD4O E28= new Entrada_BD4O(0,78901, "2014-01-12","15:00:00");
            baseDatos.store(E1);
            baseDatos.store(E2);
            baseDatos.store(E3);
            baseDatos.store(E4);
            baseDatos.store(E5);
            baseDatos.store(E6);
            baseDatos.store(E7);
            baseDatos.store(E8);
            baseDatos.store(E9);
            baseDatos.store(E10);
            baseDatos.store(E11);
            baseDatos.store(E12);
            baseDatos.store(E13);
            baseDatos.store(E14);
            baseDatos.store(E15);
            baseDatos.store(E16);
            baseDatos.store(E17);
            baseDatos.store(E18);
            baseDatos.store(E19);
            baseDatos.store(E20);
            baseDatos.store(E21);
            baseDatos.store(E22);
            baseDatos.store(E23);
            baseDatos.store(E24);
            baseDatos.store(E25);
            baseDatos.store(E26);
            baseDatos.store(E27);
            baseDatos.store(E28);
            
            
            //ENTRADAS HORA DE SALIDA
            

            Salida_BD4O SA1= new Salida_BD4O(0,12345, "2014-01-20","13:11:12");
            Salida_BD4O SA2= new Salida_BD4O(0,23456, "2014-01-20","13:00:12");
            Salida_BD4O SA3= new Salida_BD4O(0,34567, "2014-01-20","13:01:12");
            Salida_BD4O SA4= new Salida_BD4O(0,45678, "2014-01-20","13:00:00");
            Salida_BD4O SA5= new Salida_BD4O(0,56789, "2014-01-20","13:01:00");
            Salida_BD4O SA6= new Salida_BD4O(0,67890, "2014-01-20","13:00:00");
            Salida_BD4O SA7= new Salida_BD4O(0,78901, "2014-01-20","13:01:34");
            Salida_BD4O SA8= new Salida_BD4O(0,12345, "2014-01-20","17:01:34");
            Salida_BD4O SA9= new Salida_BD4O(0,23456, "2014-01-20","17:01:34");
            Salida_BD4O SA10= new Salida_BD4O(0,34567, "2014-01-20","17:00:00");
            Salida_BD4O SA11= new Salida_BD4O(0,45678, "2014-01-20","17:01:34");
            Salida_BD4O SA12= new Salida_BD4O(0,56789, "2014-01-20","17:00:00");
            Salida_BD4O SA13= new Salida_BD4O(0,67890, "2014-01-20","17:01:34");
            Salida_BD4O SA14= new Salida_BD4O(0,78901, "2014-01-20","18:00:00");
            Salida_BD4O SA15= new Salida_BD4O(0,12345, "2014-01-21","13:11:12");
            Salida_BD4O SA16= new Salida_BD4O(0,23456, "2014-01-21","13:00:12");
            Salida_BD4O SA17= new Salida_BD4O(0,34567, "2014-01-21","13:01:12");
            Salida_BD4O SA18= new Salida_BD4O(0,45678, "2014-01-21","13:00:00");
            Salida_BD4O SA19= new Salida_BD4O(0,56789, "2014-01-21","13:01:00");
            Salida_BD4O SA20= new Salida_BD4O(0,67890, "2014-01-21","13:00:00");
            Salida_BD4O SA21= new Salida_BD4O(0,78901, "2014-01-21","13:01:34");
            Salida_BD4O SA22= new Salida_BD4O(0,12345, "2014-01-21","18:00:00");
            Salida_BD4O SA23= new Salida_BD4O(0,23456, "2014-01-21","17:01:34");
            Salida_BD4O SA24= new Salida_BD4O(0,34567, "2014-01-21","17:00:00");
            Salida_BD4O SA25= new Salida_BD4O(0,45678, "2014-01-21","17:01:34");
            Salida_BD4O SA26= new Salida_BD4O(0,56789, "2014-01-21","17:00:00");
            Salida_BD4O SA27= new Salida_BD4O(0,67890, "2014-01-21","17:01:34");
            Salida_BD4O SA28= new Salida_BD4O(0,78901, "2014-01-21","18:00:00");
            baseDatos.store(SA1);
            baseDatos.store(SA2);
            baseDatos.store(SA3);
            baseDatos.store(SA4);
            baseDatos.store(SA5);
            baseDatos.store(SA6);
            baseDatos.store(SA7);
            baseDatos.store(SA8);
            baseDatos.store(SA9);
            baseDatos.store(SA10);
            baseDatos.store(SA11);
            baseDatos.store(SA12);
            baseDatos.store(SA13);
            baseDatos.store(SA14);
            baseDatos.store(SA15);
            baseDatos.store(SA16);
            baseDatos.store(SA17);
            baseDatos.store(SA18);
            baseDatos.store(SA19);
            baseDatos.store(SA20);
            baseDatos.store(SA21);
            baseDatos.store(SA22);
            baseDatos.store(SA23);
            baseDatos.store(SA24);
            baseDatos.store(SA25);
            baseDatos.store(SA26);
            baseDatos.store(SA27);
            baseDatos.store(SA28);
            
           
            
           
       
            
        }finally{
        baseDatos.close();
        }
        
      
}}
