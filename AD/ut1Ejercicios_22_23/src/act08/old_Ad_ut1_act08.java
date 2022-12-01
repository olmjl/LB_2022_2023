package act08;

import java.io.*;
import java.util.Scanner;

/**
 * Trabajo con ficheros binarios. DataStreams
 * Haz un programa Java que permita:
 * a)	Crear un fichero binario, con el nombre que el usuario quiera (pedir por pantalla),
 *      en el mismo paquete que el fichero .java que contenga el main
 * b)	Pedir al usuario información para insertar 4 registros en el fichero, cada uno de ellos
 *      con la siguiente estructura:
 *          nombre dni edad
 * c)	Leer el archivo y mostrarlo por consola con el formato nombre, edad, dni
 *
 * Nota: Cada vez que se ejecute el programa, se añadirá la nueva información a la que ya contenga
 * el fichero.
 */
public class old_Ad_ut1_act08 {

    public static void main(String[] args) {

        //a) Crear fichero binario
        Scanner sc = new Scanner(System.in);
        //String nombreFichero = JOptionPane.showInputDialog("Indica el nombre del fichero:");
        System.out.print("Indica el nombre del fichero: ");
        String nombreFichero = sc.nextLine();

        File rutaFichero = new File("src/act08/",nombreFichero);

        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new FileOutputStream(rutaFichero, true));
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el Stream: " + e.getMessage());
        }

        // b) Pedir info para añadir 4 registros al fichero
        String nombre, dni;
        int edad;
        try {
            for (int i=0; i < 4; i++) {
                System.out.print("Introduzca el nombre: ");
                dos.writeUTF(sc.nextLine());
                System.out.print("Introduzca el dni: ");
                dos.writeUTF(sc.nextLine());
                System.out.print("Introduzca la edad: ");
                dos.writeInt(sc.nextInt());
                sc.nextLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // c) Leer el archivo y mostrar por consola nombre edad dni en ese orden
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(rutaFichero));

            System.out.printf("Contenido del fichero: %s\n" , rutaFichero.getAbsolutePath());

            while (true) {
                nombre = dis.readUTF(); //recupera el nombre
                dni = dis.readUTF(); //recupera el DNI
                edad = dis.readInt(); //recupera la edad
                System.out.println("Nombre: " + nombre + ", edad: " + edad + ", DNI: " + dni);
            }
            //Como no sabemos la longitud del fichero, tenemos que controlar la
            //excepción EndOfFile (EOF). Cuando se produce, terminamos de leer
            //y mostramos un mensaje en el catch
        } catch (EOFException ex) {
            System.out.println("FIN DE FICHERO");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    } //Fin del main

} //Fin de la clase
