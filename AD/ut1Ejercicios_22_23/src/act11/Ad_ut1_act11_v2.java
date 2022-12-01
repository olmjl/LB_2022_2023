package act11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Crea un fichero de texto con el nombre y contenido que tu quieras. Ahora crea
 * una aplicación que lea este fichero de texto carácter a carácter y muestre su
 * contenido por pantalla sin espacios. Por ejemplo, si un fichero tiene el
 * siguiente texto “Esto es una prueba”, deberá mostrar “Estoesunaprueba”.
 *
 * IMPORTANTE: Ver qué pasa si no haces el close de FileWriter / Reader
 * 
 * Support for try-with-resources — introduced in Java 7 — allows us to declare resources to be 
 * used in a try block with the assurance that the resources will be closed after the execution 
 * of that block.
 * The resources declared need to implement the AutoCloseable interface.
 *
 */
public class Ad_ut1_act11_v2 {
    public static void main(String[] args) {
        final String stringNombreFichero = "src/act11/caracteres.txt";
        //long inicio = System.currentTimeMillis();
        rellenarFichero(stringNombreFichero);
        leerFichero(stringNombreFichero);
        //long fin = System.currentTimeMillis();
        //System.out.println(fin - inicio + " milisegundos");
    } //Fin método main

    private static void rellenarFichero(String stringNombreFichero) {
        final String contenido = "Este es un método que añade contenido a un "
                + "fichero de texto carácter a carácter";

        //A resource has to be both declared and initialized inside the try:
        try (FileWriter fw = new FileWriter(stringNombreFichero)) {

            char[] array = contenido.toCharArray();
            for (int i = 0; i < array.length; i++) {
                fw.write(array[i]);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //Fin rellenarFichero

    private static void leerFichero(String stringNombreFichero) {

        try (FileReader fr = new FileReader(stringNombreFichero)) {
            int valor = fr.read();
            while (valor != -1) {
                //Si el caracter es un espacio no lo muestra
                if ((char) valor != ' ') {
                    System.out.print((char) valor);
                }
                valor = fr.read();
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println("Problemas con la E/S " + e);
        } 
    } //Fin leerFichero

} //Fin clase

/* 
    Fuente: 
https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-de-ficheros-en-java/
 */
