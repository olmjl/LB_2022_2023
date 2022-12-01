package act15;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ad_ut1_act15_v2 {

    public static void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("----------------------  MENÚ INCIAL  -----------------------------");
            System.out.println("1.-Añadir numero de tipo float al final del fichero.");
            System.out.println("2.-Sustituir número por valor");
            System.out.println("3.-Sustituir número por posición.");
            System.out.println("4.-Mostrar el fichero creado.");
            System.out.println("5.-Salir del programa");
            System.out.print("Elige opción (1-5): ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: {
                    crearFichero();
                    break;
                }
                case 2: {
                    sustituirValorFloat();
                    break;
                }
                case 3: {
                    sustituirPosicionFloat();
                    break;
                }
                case 4: {
                    leerFichero();
                    break;
                }
                case 5: {
                    System.out.println("Gracias por usar el programa....");
                    break;
                }
                default: {
                    System.out.println("Opcion no es correcta");
                }
            }
        } while (opcion != 5);

    }

    public static void crearFichero() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File("src/act15/fichero15.dat");
            raf = new RandomAccessFile(fichero, "rw");
            anadirNumeroAlFinal(raf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void anadirNumeroAlFinal(RandomAccessFile raf) throws Exception {
        Scanner teclado = new Scanner(System.in);
        float numero;
        System.out.print("Introduce un numero Float para añadir al final del fichero: ");
        numero = teclado.nextFloat();
        raf.seek(raf.length());
        raf.writeFloat(numero);

    }

    public static void leerFichero() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File("src/act15/fichero15.dat");
            raf = new RandomAccessFile(fichero, "r");
            mostrarFichero(raf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void mostrarFichero(RandomAccessFile raf) throws Exception {
        raf.seek(0);
        System.out.println("-------------- CONTENIDO FICHERO   -------------");
        while (raf.getFilePointer() != raf.length()) {
            System.out.println(raf.readFloat());
        }
        System.out.println("------------------ FIN FICHERO   ---------------");
    }

    /**
     * Busca un valor que se pedirá por pantalla dentro del fichero. Si existe
     * lo modifica por otro que también se pedirá por pantalla Si no se
     * encuentra el valor, se muestra mensaje
     */
    public static void sustituirValorFloat() {
        Scanner teclado = new Scanner(System.in);
        float sustituir, numero;
        int i = 0;
        boolean encontrado = false;

        RandomAccessFile raf = null;

        try {
            File fichero = new File("src/act15/fichero15.dat");
            raf = new RandomAccessFile(fichero, "rw");

            System.out.print("Introduce el valor que deseas sustituir: ");
            sustituir = teclado.nextFloat();

            raf.seek(0);   // <-- Nos situamos al inicio del fichero
            while (raf.getFilePointer() != raf.length()) {
                numero = raf.readFloat();
                if (numero == sustituir) {
                    System.out.println("Valor encontrado en la posicion " + (i+1));
                    raf.seek(i * 4);
                    System.out.print("Introduce el nuevo valor: ");
                    raf.writeFloat(teclado.nextFloat());
                    encontrado = true;
                    break;
                }
                i++;
            }

            if (!encontrado) {
                System.out.println("Valor no encontrado en el fichero.");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }

    } //Fin sustituirValorFloat

    /**
     * Sustituye el valor de la POSICIÓN que se pida por pantalla por otro valor
     * que también se pedirá por pantalla
     */
    public static void sustituirPosicionFloat() {
        Scanner teclado = new Scanner(System.in);
        float nuevo, numero;
        int posicionLeida, posicionReal;
        int i = 0;

        RandomAccessFile raf = null;

        try {
            File fichero = new File("src/act15/fichero15.dat");
            raf = new RandomAccessFile(fichero, "rw");
            raf.seek(0);

            Long posiciones = (raf.length() / 4);
            System.out.printf("Introduce la posicion que deseas sustituir (1 .. %d): ", posiciones.intValue());
            posicionLeida = teclado.nextInt();
            posicionReal = posicionLeida - 1;

            if (posicionReal < (raf.length() / 4)) {
                System.out.print("Introduce el nuevo valor: ");
                //Nos colocamos en la posición
                raf.seek(posicionReal * 4);
                //Escribimos
                raf.writeFloat(teclado.nextFloat());
            } else {
                System.out.println("La posición debe ser menor que " + (raf.length() / 4));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }

    } //Fin sustituirPosicionFloat

    public static void main(String[] args) {
        menu();
    }

}


/* 
    Fuente: 
 */
