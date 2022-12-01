package act01;

import java.io.File;
import java.io.IOException;

public class AD_UT1_Act01 {

    public static void main(String[] args) {

        String directorio = "C:\\Users\\JuanLuis\\Documents\\prueba";

        // Crear un directorio
        boolean exito = false;

        //  ------------------   a) Crear directorio prueba en Mis Documentos  ---------------------------
        try {
            // Declaración de variables
            exito = (new File(directorio)).mkdir();
            if (exito) {
                System.out.println("Directorio: " + directorio + " creado");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        //  ------------------  b) Crear 2 ficheros de texto en el directorio prueba
        try {
            File fichero1 = new File(directorio, "miFichero.txt");
            File fichero2 = new File(directorio, "miFichero2.txt");

            if (fichero1.createNewFile() && fichero2.createNewFile()) {
                System.out.println("Se han creado los ficheros correctamente");
            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ioe) {
            ioe.getMessage();
        }

        //  ------------------ c) crear prueba/subcarpeta1/subcarpeta2
        String subcarpetas = "C:\\Users\\JuanLuis\\Documents\\prueba\\subcarpeta1\\subcarpeta2"; // <-- ruta absoluta 
        try {
            exito = (new File(subcarpetas)).mkdirs();

            if (exito) {
                System.out.println("Directorios: " + subcarpetas + " creados");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        //  ------------------ d) crear archivo de texto bajo subcarpeta2
        
            File fichero3 = new File(subcarpetas, "miFichero.txt");
        try {
            if (fichero3.createNewFile()) {
                System.out.println("Se ha creado el fichero 3 correctamente");
            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ioe) {
            ioe.getMessage();
        }

    } //Fin método main

} //Fin clase CrearFichero

/* 
    Fuente: 
 */
/**
 *
 */
/*

private static void borrarFicheros(String ruta) {
        File f = new File(ruta); // define la ruta del archivo
        if (f.exists() && f.isDirectory()) {// Si existe la ruta y es un directorio...
            if (f.listFiles().length == 0) {     // Si está vacío (no tiene ni archivos ni directorios), se puede borrar
                f.delete();
            } else { // El directorio NO está vacío. Determinamos si hay un subdirectorio
                File[] arrayFicheros = f.listFiles();
                int longitudArray = f.listFiles().length;
                for (int i = 0; i < longitudArray; i++) { //Recorremos el array y miramos si el elemento leído es un directorio
                    if (arrayFicheros[i].isDirectory()) {
                        borrarFicheros(arrayFicheros[i].getAbsolutePath()); // Llamamos al método borrarFiche de forma recursiva y obtenga la ruta del subdirectorio
                    } else {  //Es un archivo
                        arrayFicheros[i].delete(); // Lo eliminamos
                    }
                }
            } //Fin del else
            f.delete();

        } //Fin del if (si existe y es un directorio)

    } //Fin método borrarFicheros

package ejercicio;

import java.io.File;
import java.io.IOException;

public class UT1_ACT01_Miguel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ruta="/users/Tanque Autista/documents/prueba";
		File carpetas=new File(ruta);
		carpetas.mkdir();
		carpetas=new File(ruta+"/subcarpeta1/subcarpeta2");
		carpetas.mkdirs();
		File ficheros=new File(ruta+"/fichero1.txt");
		try {
			ficheros.createNewFile();
			ficheros=new File(ruta+"/fichero2.txt");
			ficheros.createNewFile();
			ficheros=new File(ruta+"/subcarpeta1/subcarpeta2/fichero3.txt");
			ficheros.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carpetas=new File(ruta);
		borrarContenido(carpetas);
	}
	public static void borrarContenido(File carpeta) {
		File[] ficheros=carpeta.listFiles();
		for (int i = 0; i < ficheros.length; i++) {
			if (ficheros[i].isDirectory()) {
				borrarContenido(ficheros[i]);
			}
			ficheros[i].delete();
		}
		carpeta.delete();
	}
}

*/
