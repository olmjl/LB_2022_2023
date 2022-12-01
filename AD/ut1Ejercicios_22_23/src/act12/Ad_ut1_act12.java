package act12;

import java.io.*;

/**
 * ACTIVIDAD 1.12: Modifica el ejercicio anterior utilizando buffers en lugar de
 * leer/escribir carácter a carácter. Además, el programa deberá sustituir las
 * letras mayúsculas por minúsculas y viceversa.
 *
 * ACTIVIDAD 1.11: Crea un fichero de texto con el nombre y contenido que tu
 * quieras. Ahora crea una aplicación que lea este fichero de texto carácter a
 * carácter y muestre su contenido por pantalla sin espacios. Por ejemplo, si un
 * fichero tiene el siguiente texto “Esto es una prueba”, deberá mostrar
 * “Estoesunaprueba”.
 *
 * IMPORTANTE: Ver qué pasa si no haces el close de FileWriter / Reader
 *
 * Support for try-with-resources — introduced in Java 7 — allows us to declare
 * resources to be used in a try block with the assurance that the resources
 * will be closed after the execution of that block. The resources declared need
 * to implement the AutoCloseable interface.
 *
 */
public class Ad_ut1_act12 {

    public static void main(String[] args) {
        final String stringNombreFichero = "src/act12/caracteres.txt";
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
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(stringNombreFichero))) {

//            char[] array = contenido.toCharArray();
//            for (int i = 0; i < array.length; i++) {
//                bfw.write(array[i]);
//            }
            bfw.write(contenido);
            bfw.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } //Fin rellenarFichero

    private static void leerFichero(String stringNombreFichero) {

        //try (FileReader fr = new FileReader(stringNombreFichero)) {
        try (BufferedReader bfr = new BufferedReader(new FileReader(stringNombreFichero))) {
            //int valor = fr.read();
            String linea;
            String lineaConvertida = "";

            while ((linea = bfr.readLine()) != null) {
                lineaConvertida = linea.replace(" ", "").toUpperCase();
                System.out.println(lineaConvertida);
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } 
    } 
}//Fin clase