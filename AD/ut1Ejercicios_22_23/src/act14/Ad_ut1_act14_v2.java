package act14;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Sin try with resources
 *
 */
public class Ad_ut1_act14_v2 {

    public static void main(String[] args) {

        //try (RandomAccessFile raFile = new RandomAccessFile("src/act14/fichero0_v2.dat", "rw");) {    // Create a random access file

        RandomAccessFile raFile = null;
        try {
            raFile = new RandomAccessFile("src/act14/fichero0_v2.dat", "rw"); // Create a random access file
            // Clear the file to destroy the old contents if exists
            raFile.setLength(0);
            System.out.println("La longitud actual del fichero es " + raFile.length());

            // Write 200 new integers to the file
            System.out.println("Escribimos los números del 0 al 199 en el fichero...");
            for (int i = 0; i < 200; i++) {
                raFile.writeInt(i);
            }

            // Display the current length of the file
            System.out.println("La longitud actual del fichero es " + raFile.length());

            // Retrieve the first number
            raFile.seek(0); // Move the file pointer to the beginning
            System.out.println("El primer número es: " + raFile.readInt());

            // Retrieve the second number
            raFile.seek(1 * 4); // Move the file pointer to the second number
            System.out.println("El segundo número es: " + raFile.readInt());

            // Retrieve the tenth number
            raFile.seek(9 * 4); // Move the file pointer to the tenth number
            System.out.println("El décimo número es: " + raFile.readInt());

            // Modify the eleventh number
            System.out.println("Modificamos el úndecimo valor (lo cambiamos por 555)...");
            raFile.writeInt(555);

            // Append a new number to the end
            System.out.println("Añadimos 999 al final del fichero...");
            raFile.seek(raFile.length()); // Move the file pointer to the end
            raFile.writeInt(999);

            // Display the new length
            System.out.println("La nueva longitud del fichero es: " + raFile.length());

            // Retrieve the new eleventh number
            raFile.seek(10 * 4); // Move the file pointer to the eleventh number
            System.out.println("El undécimo número es: " + raFile.readInt());

        } catch (FileNotFoundException fnfe) {
            System.out.println("Error al crear el objeto RandomAccessFile. " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Error de I/O. " + ioe.getMessage());
        }
        
        try {
            leerFichero(raFile);
        } catch (IOException ex) {
            System.out.println("Error de I/O al leer. " + ex.getMessage());
        }

    } //Fin método main

    private static void leerFichero(RandomAccessFile fichero) throws IOException { {
        
        fichero.seek(0);
        System.out.println("-------------- CONTENIDO FICHERO   -------------");
        while (fichero.getFilePointer() != fichero.length()) {
            System.out.println("Número " + fichero.readInt());
        }
        System.out.println("------------------ FIN FICHERO   ---------------");
    }

    }

} //Fin clase FichAleatorio

/* 
    Fuente: 
    Libro Liang p735
 */
