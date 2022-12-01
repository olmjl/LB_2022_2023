package act04;

import java.io.File;

/**
 * Mostrar el contenido del directorio actual, indicando si cada elemento es un
 * fichero o un subdirectorio
 *
 */
public class MainAct04 {

    public static void main(String[] args) {
        
        File directorio = new File(".");  //directorio actual
        File[] lista = directorio.listFiles();
        for (File f : lista) {
            if (f.isDirectory()) {
                System.out.println("Directorio --> " + f.getName());
            } else {
                System.out.println("Archivo --> " + f.getName());
            }
            
        }
    } //Fin método main

} //Fin clase MainAct04

/*
Sólo mostrar nombres:
        File directorio = new File(".");  //directorio actual
        String[] lista = directorio.list();
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
*/