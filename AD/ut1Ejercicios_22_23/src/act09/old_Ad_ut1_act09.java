package act09;

import java.io.*;
import java.util.Scanner;

/**
 * Trabajo con ficheros binarios. DataStreams
 *
 * Modifica el programa anterior para que lo que se añada al fichero sean objetos Persona con atributos nombre,
 * dni y edad.
 * Nota: Cada vez que se ejecute el programa, se sobrescribirá la información que contenga el fichero (si ya existe)
 *
 * Haz un programa Java que permita:
 * a)	Crear un fichero binario, con el nombre que el usuario quiera (pedir por pantalla),
 *      en el mismo paquete que el fichero .java que contenga el main
 * b)	Pedir al usuario información para insertar 4 registros en el fichero, cada uno de ellos
 *      con la siguiente estructura:
 *          nombre dni edad
 * c)	Leer el archivo y mostrarlo por consola con el formato nombre, edad, dni
 *
 */
public class old_Ad_ut1_act09 {

    public static void main(String[] args) {

        old_Persona persona;

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

        // b) Pedir info para añadir 4 registros al fichero
        String nombre, dni;
        int edad;
        try {
            for (int i=0; i < 2; i++) {
                System.out.print("Introduzca el nombre: ");
                nombre = sc.nextLine();
                //oos.writeUTF(sc.nextLine());
                System.out.print("Introduzca el dni: ");
                dni = sc.nextLine();
                //oos.writeUTF(sc.nextLine());
                System.out.print("Introduzca la edad: ");
                edad = sc.nextInt();
                //oos.writeInt(sc.nextInt());
                sc.nextLine();
                persona = new old_Persona(nombre, dni, edad);
                oos.writeObject(persona);  //Escribimos la persona en el fichero binario
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
                persona = (old_Persona) ois.readObject();  //Leemos una old_Persona como objeto
                System.out.println("Nombre: " + persona.getNombre()
                        + ", edad: " + persona.getEdad()
                        + ", DNI: " + persona.getDni());
            }
            //Como no sabemos la longitud del fichero, tenemos que controlar la
            //excepción EndOfFile (EOF). Cuando se produce, terminamos de leer
            //y mostramos un mensaje en el catch
        } catch (EOFException ex) {
            System.out.println("FIN DE FICHERO");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
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
