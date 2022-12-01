package act14;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class FichAleatorio {

    public static void main(String[] args) {

        try (RandomAccessFile raFile = new RandomAccessFile("src/demos/acceso_aleatorio/fichero0.dat", "rw");) {    // Create a random access file 
            // Clear the file to destroy the old contents if exists
            raFile.setLength(0);

            // Write new integers to the file
            for (int i = 0; i < 200; i++) {
                raFile.writeInt(i);
            }

            // Display the current length of the file
            System.out.println("Current file length is " + raFile.length());

            // Retrieve the first number
            raFile.seek(0); // Move the file pointer to the beginning
            System.out.println("The first number is " + raFile.readInt());

            // Retrieve the second number
            raFile.seek(1 * 4); // Move the file pointer to the second number
            System.out.println("The second number is " + raFile.readInt());

            // Retrieve the tenth number
            raFile.seek(9 * 4); // Move the file pointer to the tenth number
            System.out.println("The tenth number is " + raFile.readInt());

            // Modify the eleventh number
            raFile.writeInt(555);

            // Append a new number to the end
            raFile.seek(raFile.length()); // Move the file pointer to the end
            raFile.writeInt(999);

            // Display the new length
            System.out.println("The new length is " + raFile.length());

            // Retrieve the new eleventh number
            raFile.seek(10 * 4); // Move the file pointer to the eleventh number
            
            System.out.println("The eleventh number is " + raFile.readInt());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FichAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FichAleatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

    } //Fin método main

} //Fin clase FichAleatorio

/* 
    Fuente: 
    Libro Liang p735
 */
