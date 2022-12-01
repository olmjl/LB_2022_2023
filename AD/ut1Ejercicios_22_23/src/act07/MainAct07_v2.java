package act07;

import java.io.File;
import java.io.IOException;

public class MainAct07_v2 {

    public static void main(String[] args) throws IOException {

        //Creamos objetos File
        File rutaDirectorioPadre = new File("D:\\ad\\ut1_act07");
        File rutaFicheroDat = new File(rutaDirectorioPadre, "fich_binario.dat");
        File rutaFicheroTxt = new File(rutaDirectorioPadre, "fichero.txt");
        File rutaSubdir1 = new File(rutaDirectorioPadre, "dir1");
        File rutaSubdir2 = new File(rutaDirectorioPadre, "dir2");

        if (!rutaDirectorioPadre.mkdirs()) {
            System.out.println("No se ha podido crear el directorio");
            return;
        }

        //Creo los ficheros y directorios
        rutaFicheroDat.createNewFile();
        rutaFicheroTxt.createNewFile();
        rutaSubdir1.mkdir();
        rutaSubdir2.mkdir();

        // 2) Mostrar si se ha creado correctamente
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Apartado 7.2. Mostrando contenido del directorio de la Actividad 7");
        String[] lista = rutaDirectorioPadre.list();
        for (String ruta : lista) {
            System.out.println(ruta);
        }

        // 3) Recorremos el directorio act07
        File[] listaElementos = rutaDirectorioPadre.listFiles();

        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Apartado 7.3. Mostrando si son ficheros o directorios y sus permisos");
        for (File elemento : listaElementos) {
            // a. Mostrar si son ficheros o directorios
            if (elemento.isDirectory()) {
                System.out.println(elemento.getName() + " es un directorio. " + "Su ruta absoluta es: " + elemento.getAbsolutePath());
            } else {
                System.out.println(elemento.getName() + " es un fichero. " + "Su ruta absoluta es: " + elemento.getAbsolutePath());
            }

            // b. Mostrar permisos 
            mostrarPermisos(elemento);

        } //Fin del for

        // 5) Mostrar el directorio padre de fich_binario.dat
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Apartado 7.4. Mostrando el directorio padre de fich_binario.dat");
        System.out.printf("El directorio padre de %s es %s \n", rutaFicheroDat.getName(), rutaFicheroDat.getParent());

        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Apartado 7.5. Modificando y mostrando los atributos de fich_binario.dat");
        // 5) Modifique los atributos de fich_binario.dat para que sea de lectura/escritura. 
        //    Muestre por consola los atriubutos para verificar que este apartado 
        //    se ha realizado de forma correcta
        rutaFicheroDat.setReadOnly();
//        ficheroDat.setExecutable(false);
//        ficheroDat.setWritable(true);

        mostrarPermisos(rutaFicheroDat);

    } //Fin método main

    private static void mostrarPermisos(File elemento) {
        String cadenaPermisos = "";

        if (elemento.canRead()) {
            cadenaPermisos += "read, ";
        } else {
            cadenaPermisos += "not readable, ";
        }
        if (elemento.canWrite()) {
            cadenaPermisos += "write, ";
        } else {
            cadenaPermisos += "not writable, ";
        }
        if (elemento.canExecute()) {
            cadenaPermisos += "execute ";
        } else {
            cadenaPermisos += "not executable ";
        }

        System.out.println("Permisos de " + elemento.getAbsolutePath() + ": " + cadenaPermisos);
    }

} //Fin clase MainAct07_v2

/* 
    Fuente: mezcla. Casi todo mío. Idea de https://www.discoduroderoer.es/clase-file-y-sus-metodos/

 */
