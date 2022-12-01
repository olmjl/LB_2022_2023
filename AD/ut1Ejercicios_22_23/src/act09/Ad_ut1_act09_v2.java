package act09;

import java.io.*;
import java.util.Scanner;

/**
 * Trabajo con ficheros binarios. DataStreams
 * Modifica el programa anterior para que lo que se añada al fichero sean objetos Vehiculo con
 * atributos marca, modelo, año, color y pinturaMetalizada.
 * Nota: Cada vez que se ejecute el programa, se sobrescribirá la información que contenga el fichero (si ya existe)
 */
public class Ad_ut1_act09_v2 {

    public static void main(String[] args) {

        Vehiculo vehiculo;

        //a) Crear fichero binario
        Scanner sc = new Scanner(System.in);
        //String nombreFichero = JOptionPane.showInputDialog("Indica el nombre del fichero:");
        System.out.print("Indica el nombre del fichero: ");
        String nombreFichero = sc.nextLine();

        File rutaFichero = new File("src/act09/",nombreFichero);

        ObjectOutputStream oos = null;

        //Creamos el output stream con el fichero
        try {
            //oos = new ObjectOutputStream(new FileOutputStream(rutaFichero, true));
            oos = new ObjectOutputStream(new FileOutputStream(rutaFichero));  // <-- Sin el true!!
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el Stream: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // b) Pedir info para añadir 2 registros al fichero
        String marca, modelo, color;
        int anio;
        String pMetalizada;
        
        try {
            for (int i=0; i < 2; i++) {
                System.out.print("Introduzca la marca: ");
                marca = sc.nextLine();
                //oos.writeUTF(sc.nextLine());
                System.out.print("Introduzca el modelo: ");
                modelo = sc.nextLine();
                //oos.writeUTF(sc.nextLine());
                System.out.print("Introduzca el año: ");
                anio = sc.nextInt();
                //oos.writeInt(sc.nextInt());
                sc.nextLine();
                System.out.print("Introduzca el color: ");
                color = sc.nextLine();
                System.out.print("Pintura metalizada (s/n): ");
                pMetalizada = sc.nextLine();
                if (pMetalizada.equalsIgnoreCase("s")) {
                    pMetalizada = "true";
                } else {
                    pMetalizada = "false";
                }
                vehiculo = new Vehiculo(marca, modelo, anio, color, Boolean.parseBoolean(pMetalizada));
                oos.writeObject(vehiculo);  //Escribimos el Vehiculo en el fichero binario
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // c) Leer el archivo y mostrar por consola nombre edad dni en ese orden
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(rutaFichero));

            System.out.printf("Contenido del fichero: %s\n" , rutaFichero.getAbsolutePath());

            while (true) {
                //nombre = ois.readUTF(); //recupera el nombre
                //dni = ois.readUTF(); //recupera el DNI
                //edad = ois.readInt(); //recupera la edad
                vehiculo = (Vehiculo) ois.readObject();  //Leemos un Vehiculo como objeto
                System.out.println(vehiculo);
            }
            //Como no sabemos la longitud del fichero, tenemos que controlar la
            //excepción EndOfFile (EOF). Cuando se produce, terminamos de leer
            //y mostramos un mensaje en el catch
        } catch (EOFException ex) {
            System.out.println("FIN DE FICHERO");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    } //Fin del main

} //Fin de la clase
