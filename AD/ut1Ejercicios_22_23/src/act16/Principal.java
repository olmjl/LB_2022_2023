package act16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 *
 */
public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String ruta = "src/act16/precios.dat";
        
        Metodos m = new Metodos();

        RandomAccessFile raf = new RandomAccessFile(ruta, "rw");
        rellenarFichero(raf);

        m.leerArchivo(ruta);
        m.cambiarPrecios(ruta);
        m.leerArchivo(ruta);

    } //Fin método main

    private static void rellenarFichero(RandomAccessFile raf) throws IOException {
        for (int i = 1000; i <= 1025; i++) {
            raf.writeInt(i);
            raf.writeDouble(Math.random() * 200 + 1);
        }
    }

} //Fin clase Principal

