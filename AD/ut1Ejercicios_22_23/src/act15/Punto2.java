package act15;

//package act06;
//
//import java.io.File;
//import java.io.RandomAccessFile;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Punto1 {
//
//    public static void menu() {
//        Scanner teclado = new Scanner(System.in);
//        int opcion;
//        do {
//            System.out.println("----------------------  MENÚ INCIAL  -----------------------------");    
//            System.out.println("1.-Añadir numeros de tipo float al principio del fichero");
//            System.out.println("2.-Añadir numero de tipo float al final del fichero.");
//            System.out.println("3.-Mostrar el fichero creado.");
//            System.out.println("4.-Sustituir un número indicado por el usuario por otro numero que también te indique el usuario.");
//            System.out.println("5.-Salir del programa");
//            System.out.print("Elige opción (1-5): ");
//            opcion = teclado.nextInt();
//
//            switch (opcion) {
//                case 1: {
//                    crearFichero();
//
//                    break;
//                }
//                case 2: {
//                    crearFichero2();
//
//                    break;
//                }
//                case 3: {
//                    leerFichero();
//                    break;
//                }
//                case 4: {
//                    sustituirValorFloat();
//                    break;
//                }
//                case 5: {
//                    System.out.println("Gracias por usar el programa....");
//                    break;
//                }
//                default: {
//                    System.out.println("Opcion no es correcta");
//                }
//            }
//        } while (opcion != 5);
//
//    }
//
//    public static void crearFichero() {
//        RandomAccessFile raf = null;
//        try {
//            File fichero = new File("src/act06/punto1_fichero.dat");
//            raf = new RandomAccessFile(fichero, "rw");
//            anadirNumerosPrincipio(raf);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (raf != null) {
//                    raf.close();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//    }
//
//    public static void anadirNumerosPrincipio(RandomAccessFile raf) throws Exception {
//        Scanner teclado = new Scanner(System.in);
//        float numero;
//        System.out.print("Introduce un numero Float para añadir al principio del fichero: ");
//        numero = teclado.nextFloat();
//        raf.seek(0);
//        raf.writeFloat(numero);
//
//    }
//
//    public static void crearFichero2() {
//        RandomAccessFile raf = null;
//        try {
//            File fichero = new File("src/act06/punto1_fichero.dat");
//            raf = new RandomAccessFile(fichero, "rw");
//            anadirNumerosFinal(raf);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (raf != null) {
//                    raf.close();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    public static void anadirNumerosFinal(RandomAccessFile raf) throws Exception {
//        Scanner teclado = new Scanner(System.in);
//        float numero;
//        System.out.print("Introduce un numero Float para añadir al final del fichero: ");
//        numero = teclado.nextFloat();
//        raf.seek(raf.length());
//        raf.writeFloat(numero);
//
//    }
//
//    public static void leerFichero() {
//        RandomAccessFile raf = null;
//        try {
//            File fichero = new File("src/act06/punto1_fichero.dat");
//            raf = new RandomAccessFile(fichero, "r");
//            mostrarFichero(raf);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (raf != null) {
//                    raf.close();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    public static void mostrarFichero(RandomAccessFile raf) throws Exception {
//        float numero;
//        raf.seek(0);
//        while (true) {
//            numero = raf.readFloat();
//            System.out.println(numero);
//        }
//    }
//
//    /**
//     * Sustituye un valor por otro que se pedirá por pantalla.
//     * Si no se encuentra el valor, se muestra mensaje
//     */
//    public static void sustituirValorFloat() {
//        Scanner teclado = new Scanner(System.in);
//        float sustituir, nuevo, numero;
//        int i = 0;
//
//        RandomAccessFile raf = null;
//
//        try {
//            File fichero = new File("src/act06/punto1_fichero.dat");
//            raf = new RandomAccessFile(fichero, "rw");
//            raf.seek(0);
//
//            System.out.print("Introduce la posicion que deseas sustituir: ");
//            sustituir = teclado.nextFloat();
//            
//            if (sustituir <= (raf.length()/4)) {
//                System.out.print("Introduce el nuevo valor: ");
//                nuevo = teclado.nextFloat();
//            } else {
//                System.out.println("La posición debe ser menor que " + (raf.length()/4));
//            }
//            
//            
//
//            while (true) {
//                numero = raf.readFloat();
//                if (numero == sustituir) {
//                    System.out.println("Encontrado en la posicion " + i);
//                    raf.seek(i * 4);
//                    raf.writeFloat(nuevo);
//                }
//                i++;
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (raf != null) {
//                    raf.close();
//                }
//            } catch (Exception e2) {
//                System.out.println(e2.getMessage());
//            }
//        }
//
//    } //Fin sustituirValorFloat
//    
//    /**
//     * Sustituye el valor de la posición que se pida por pantalla por otro
//     * valor que también se pedirá por pantalla
//     */
//    public static void sustituirPosicionFloat() {
//        Scanner teclado = new Scanner(System.in);
//        float sustituir, nuevo, numero;
//        int i = 0;
//
//        RandomAccessFile raf = null;
//
//        try {
//            File fichero = new File("src/act06/punto1_fichero.dat");
//            raf = new RandomAccessFile(fichero, "rw");
//            raf.seek(0);
//
//            System.out.print("Introduce la posicion que deseas sustituir: ");
//            sustituir = teclado.nextFloat();
//            
//            if (sustituir <= (raf.length()/4)) {
//                System.out.print("Introduce el nuevo valor: ");
//                nuevo = teclado.nextFloat();
//            } else {
//                System.out.println("La posición debe ser menor que " + (raf.length()/4));
//            }
//            
//            
//
//            while (true) {
//                numero = raf.readFloat();
//                if (numero == sustituir) {
//                    System.out.println("Encontrado en la posicion " + i);
//                    raf.seek(i * 4);
//                    raf.writeFloat(nuevo);
//                }
//                i++;
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (raf != null) {
//                    raf.close();
//                }
//            } catch (Exception e2) {
//                System.out.println(e2.getMessage());
//            }
//        }
//
//    } //Fin sustituirPosicionFloat
//
//    public static void main(String[] args) {
//        menu();
//    }
//
//}
//
//
///* 
//    Fuente: 
//*/
