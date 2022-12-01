package act06;

import java.io.File;
import javax.swing.JOptionPane;

public class MainAct06_v2 {

    public static void main(String[] args) {
        
        String ruta = JOptionPane.showInputDialog("Introduzca un directorio:");

        File directorio = new File(ruta);
        File[] lista = directorio.listFiles();

        String cadena = "";

        for (File f : lista) {
            if (f.isDirectory()) {
                cadena += ("Directorio --> " + f.getName() + "\n");
            } else {
                cadena += ("Archivo --> " + f.getName() + "\n");
            }
        }

        JOptionPane.showMessageDialog(null, cadena,
                "Contenido del directorio " + ruta, 
                JOptionPane.INFORMATION_MESSAGE, 
                null);

    } //Fin método main

} //Fin clase MainAct06_v2

/* 
    Fuente: 
 */

/*
Con Scanner:

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca una ruta: ");
        String ruta = sc.next();
        
        File directorio = new File(ruta);  
        File[] lista = directorio.listFiles();
        
        String cadena = "";
        
        for (File f : lista) {
            if (f.isDirectory()) {
                cadena += ("Directorio --> " + f.getName() + "\n");
            } else {
                cadena += ("Archivo --> " + f.getName() + "\n");
            }
        }
        
        System.out.println("Contenido del directorio " + ruta + ":\n" + cadena);
*/
