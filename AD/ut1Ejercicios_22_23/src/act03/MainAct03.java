package act03;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UT1 act 03. Crear directorio d:/ad/ut1_act03 y un fichero datos.txt en él
 * 
 */
public class MainAct03 {

    public static void main(String[] args) {
        File rutaDirectorio = new File("d:/ad/ut1_act03");
        File rutaFichero = new File(rutaDirectorio, "datos.txt");
        
        // ESTO NO HACE FALTA. SÓLO PARA VER OTROS MÉTODOS
        System.out.println("Fichero Absolute path: " + rutaFichero.getAbsolutePath());
        System.out.println("Fichero Parent: " + rutaFichero.getParent());
        System.out.println("Directorio absolute path: " + rutaDirectorio.getAbsolutePath());
        System.out.println("Directorio parent: " + rutaDirectorio.getParent());
        //HASTA AQUÍ
        
        //se comprueba si el fichero existe o no
        if (!rutaFichero.exists()) {  
            System.out.println("Fichero " + rutaFichero.getName() + " no existe");
            //se comprueba si la ruta existe o no
            if (!rutaDirectorio.exists()) {  
                System.out.println("El directorio " + rutaDirectorio.getName() + " no existe");
                if (rutaDirectorio.mkdirs()) { //se crea la ruta. Si se ha creado correctamente
                    System.out.println("Directorio creado");
                    crearFichero(rutaFichero);
                } else {
                    System.err.println("No se ha podido crear " + rutaDirectorio.getName());
                }
            } else {  //si la ruta existe creamos el fichero
                crearFichero(rutaFichero);
            }
        //el fichero existe. Mostramos el tamaño
        } else { 
            System.out.println("Fichero " + rutaFichero.getName() + " existe");
            System.out.println("Tamaño " + rutaFichero.length() + " bytes");
        }
    } //Fin método main

    private static void crearFichero(File f) {
        try {
            if (f.createNewFile()) {  //se crea el fichero. Si se ha creado correctamente
                System.out.println("Fichero " + f.getName() + " creado");
            } else {
                System.err.println("No se ha podido crear " + f.getName());
            }
        } catch (IOException ex) {
            Logger.getLogger(MainAct03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

} //Fin clase MainAct03

/* 
    Fuente: http://puntocomnoesunlenguaje.blogspot.com/2013/05/clase-file-java.html
    
Si suponemos que no existe el fichero ni el directorio la ejecución del programa produce la siguiente salida:
c:\ficheros\datos.txt
c:\ficheros
c:\ficheros
c:\
Fichero datos.txt no existe
El directorio ficheros no existe
Directorio creado
Fichero datos.txt creado

Si volvemos a ejecutar el programa después de crear la ruta y el fichero, se muestra:
c:\ficheros\datos.txt
c:\ficheros
c:\ficheros
c:\
Fichero datos.txt existe
Tamaño 0 bytes


 */
