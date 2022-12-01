package act16;

import java.io.*;

public class Metodos {

    // Propiedades
    private int r;
    private double p;
    private RandomAccessFile raf = null;
    //private DecimalFormat precio = new DecimalFormat("#.##");
    //private DecimalFormat ref = new DecimalFormat("#");

    // Métodos
    public void leerArchivo(String nombre) {

        RandomAccessFile raf = null;
        try {
            File fichero = new File(nombre);
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
            System.out.printf("REF: %d. Precio = %.2f \n", raf.readInt(), raf.readDouble());
        }
        System.out.println("------------------ FIN FICHERO   ---------------");
    }

    public void cambiarPrecios(String nombre) {
        System.out.println("Cambiamos los precios...");
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(nombre, "rw");
            raf.seek(0);

            while (raf.getFilePointer() != raf.length()) {

                // Uno es ref. y otro el precio
                r = raf.readInt();
                p = raf.readDouble();
                if (p > 100) {
                    raf.seek(raf.getFilePointer() - 8);
                    raf.writeDouble(p * 0.90);
                } else {
                    raf.seek(raf.getFilePointer() - 8);
                    raf.writeDouble(p * 1.10);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
