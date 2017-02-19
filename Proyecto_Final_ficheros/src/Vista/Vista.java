/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Usuario;
import Modelo.UsuarioFicha;
import Util.Constantes;
import Util.Util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class Vista {

    public int Opcion() {

        int opcion;

        System.out.print("OPERACIONES \n");

        System.out.print("0. Fin \n");
        System.out.print("1. Fichar \n");
        System.out.print("2. Desfichar \n");
        System.out.print("3. Mostrar horas del mes \n");
        //System.out.print("4. Grabar Fcihero \n \n");

        String texto = "Opcion?:";

        Util u = new Util();
        opcion = u.leerInt(texto);
        System.out.print("\n");


        if ((opcion > 4) || (opcion < 0)) {

            String error = error(1);
            System.out.print("Error: " + error + "\n");

        }

        return opcion;

    }

    public String error(int error) {

        String err = null;

        switch (error) {
            case 1:
                err = "Opción incorrecta del menu \n";
                break;
            case 2:
                err = "Valor debe ser positivo en la edad \n";
                break;

        }

        return err;

    }

    public void writefile(ArrayList clientes, File ruta, String user) {

        File file = new File(ruta, user + ".csv");

        ArrayList<UsuarioFicha> a = clientes;


        try {
            FileWriter fw = new FileWriter(file);
            for (UsuarioFicha a1 : a) {
                fw.write(a1.getNombre() + ";" + a1.getFecha() + ";" + a1.getEntrada() + ";" + a1.getSalida() + ";" + a1.getTiempo());
                fw.write("\r\n");
            }
            fw.close();
            System.out.print("Grabado correctamente en: fichero.csv \n \n");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public ArrayList readFile(ArrayList fichajes, File ruta, String user) {


        File file = new File(ruta, user + ".csv");

        ArrayList<UsuarioFicha> fichador = fichajes;

        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) {

                    StringTokenizer st = new StringTokenizer(s, ";");

                    String nombre = st.nextToken();
                    String fecha = st.nextToken();
                    String entrada = st.nextToken();
                    String salida = st.nextToken();
                    String tiempo = st.nextToken();

                    fichador.add(new UsuarioFicha(nombre, fecha, entrada, salida, tiempo));

                }
                fr.close();
                System.out.print("Leido correctamente de: fichero.csv \n \n");

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        return fichador;
    }

    public void writefileusuarios(ArrayList usuarios) {

        File file = new File("Ficheros\\Usuarios\\Usuarios.csv");

        ArrayList<Usuario> a = usuarios;


        try {
            FileWriter fw = new FileWriter(file);
            for (Usuario a1 : a) {
                fw.write(a1.getidusuario() + ";" + a1.getNombre() + ";" + a1.getapellido1() + ";" + a1.getapellido2() + ";" + a1.gettipo() + ";" + a1.getemail() + ";" + a1.getcontraseña() + ";" + a1.getproyecto());
                fw.write("\r\n");
            }
            fw.close();
            System.out.print("Grabado correctamente en: fichero.csv \n \n");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void mostrarmensajeinformacion(String texto) {
        
        JOptionPane.showMessageDialog(null, texto, "Informacion", JOptionPane.INFORMATION_MESSAGE);

        
    }

    public void mostrarmensajeerror(String texto) {
        
        JOptionPane.showMessageDialog(null, texto, "ERROR", JOptionPane.WARNING_MESSAGE);
        
    }
}
