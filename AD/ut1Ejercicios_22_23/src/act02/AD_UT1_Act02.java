package act02;

import java.io.File;
import java.io.IOException;

/**
 * ACTIVIDAD 1.2. Añadir a la 1.1 el borrado de prueba y todo su contenido
 *
 */
public class AD_UT1_Act02 {

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
        
        // ACTIVIDAD 1.2. 
        borrarContenidoDirectorio(fileDirectorioPrueba);

    } //Fin método main

    /**
     * Muestra mensaje si se ha creado correctamente el fichero o ya existía
     * @param fichero 
     */
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
    } // Fin comprobarCreacionFichero

    /**
     * Elimina un directorio y todos los archivos y directorios que cuelgan de
     * él de forma recursiva
     *
     * @param ruta Ruta absoluta del directorio
     */
    private static void borrarContenidoDirectorio(File ruta) {

        File[] contenido = ruta.listFiles();

//        for (int i = 0; i < contenido.length; i++) {
//            if (contenido[i].isDirectory()) {
//                borrarFicheros(contenido[i]);
//            }
//            contenido[i].delete();
//        }
        for (File elemento : contenido) {
            if (elemento.isDirectory()) {
                borrarContenidoDirectorio(elemento);
            } else {
                elemento.delete();
                System.out.printf("Elemento %s borrado.\n", elemento.getAbsolutePath());
            }
        }

        ruta.delete();
        System.out.printf("Carpeta %s borrada\n", ruta.getAbsolutePath());

    } //Fin método borrarFicheros

} //Fin clase AD_UT1_Act02
