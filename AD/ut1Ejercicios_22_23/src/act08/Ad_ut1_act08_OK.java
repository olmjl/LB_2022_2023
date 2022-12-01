package act08;

import java.io.*;
import java.util.Scanner;

/**
 * Trabajo con ficheros binarios. DataStreams Haz un programa Java que permita:
 * a)	Crear un fichero binario, con el nombre que el usuario quiera (pedir por
 * pantalla), en el mismo paquete que el fichero .java que contenga el main 
 * b)
 * Pedir al usuario información para insertar 2 registros en el fichero, cada
 * uno de ellos (vehículos) con la siguiente estructura: 
 *      marca modelo año color pintura_metalizada(sí o no) 
 * c)	Leer el archivo y mostrarlo por consola con el formato 
 *      marca, modelo, color
 *
 * Nota: Cada vez que se ejecute el programa, se añadirá la nueva información a
 * la que ya contenga el fichero.
 */
public class Ad_ut1_act08_OK {

    public static void main(String[] args) {

        //a) Crear fichero binario
        Scanner sc = new Scanner(System.in);
        //String nombreFichero = JOptionPane.showInputDialog("Indica el nombre del fichero:");
        System.out.print("Indica el nombre del fichero: ");
        String nombreFichero = sc.nextLine();

        File rutaFichero = new File("src/act08/", nombreFichero);

        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new FileOutputStream(rutaFichero, true));
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el Stream: " + e.getMessage());
        }

        // b) Pedir info para añadir 2 registros al fichero
        String marca, modelo, color;
        int anio;
        boolean pMetalizada;
        try {
            for (int i = 0; i < 2; i++) {
                System.out.print("Introduzca la marca del vehículo: ");
                dos.writeUTF(sc.nextLine());
                System.out.print("Introduzca el modelo: ");
                dos.writeUTF(sc.nextLine());
                System.out.print("Introduzca el año: ");
                dos.writeInt(sc.nextInt());
                sc.nextLine();
                System.out.print("Introduzca el color: ");
                dos.writeUTF(sc.nextLine());
                String respuesta = "";

                System.out.print("Pintura metalizada (s/n): ");
                respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("s")) {
                    dos.writeBoolean(true);
                } else {
                    dos.writeBoolean(false);
                }

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

        // c) Leer el archivo y mostrar por consola marca modelo y color
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(rutaFichero));

            System.out.printf("Contenido del fichero: %s\n", rutaFichero.getAbsolutePath());

            while (true) {
                marca = dis.readUTF();
                modelo = dis.readUTF();
                anio = dis.readInt();
                color = dis.readUTF();
                pMetalizada = dis.readBoolean();
                System.out.println("Marca: " + marca + ", modelo: " + modelo + ", color: " + color);
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
