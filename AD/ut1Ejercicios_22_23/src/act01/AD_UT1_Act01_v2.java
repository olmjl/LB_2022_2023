package act01;

import java.io.File;
import java.io.IOException;

public class AD_UT1_Act01_v2 {

    public static void main(String[] args) {

        String stringDirectorioPrueba = System.getProperty("user.home")
                + "\\Documents\\prueba";

        boolean exito = false;
        File fileDirectorioPrueba = null;

        //  a) Crear directorio prueba en Mis Documentos  ---------------------------
        fileDirectorioPrueba = new File(stringDirectorioPrueba);
        exito = fileDirectorioPrueba.mkdir();
        try {
            if (exito) {
                System.out.println("Directorio: " + stringDirectorioPrueba + " creado");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        //  b) Crear 2 ficheros de texto en el directorio prueba
        File fichero1 = new File(stringDirectorioPrueba, "miFichero1.txt");
        File fichero2 = new File(stringDirectorioPrueba, "miFichero2.txt");

        comprobarCreacionFichero(fichero1);
        comprobarCreacionFichero(fichero2);

        //  c) crear prueba/subcarpeta1/subcarpeta2
        String subcarpetas = stringDirectorioPrueba + "\\subcarpeta1\\subcarpeta2"; // <-- ruta absoluta 
        try {
            exito = (new File(subcarpetas)).mkdirs();
            if (exito) {
                System.out.println("Directorios: " + subcarpetas + " creados");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        //  d) crear archivo de texto bajo subcarpeta2
        File fichero3 = new File(subcarpetas, "miFichero3.txt");
        comprobarCreacionFichero(fichero3);

    } //Fin método main

    private static void comprobarCreacionFichero(File fichero) {
        try {
            if (fichero.createNewFile()) {
                System.out.printf("Archivo %s creado correctamente.\n", fichero.getName());
            } else {
                System.out.printf("Archivo %s ya existe.\n", fichero.getName());
            }
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        }
    }

} //Fin clase 
