package act05;

import java.io.File;

public class MainAct05 {

    public static void main(String[] args) {

        //recorrerDirectorios(".");
        recorrerDirectoriosv2(".", "");
    }

    public static void recorrerDirectorios(String ruta) {
        //Se crea un objeto file con la ruta del directorio
        File directorio = new File(ruta);
        //Se comprueba si la ruta existe
        if (!directorio.exists()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no existe.");
            return;
        }
        //Se comprueba si es un directorio   <-- ESTO NO HARÍA FALTA, PERO VIENE BIEN PARA OTRO EJERCICIO
        if (!directorio.isDirectory()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no es un directorio");
            return;
        }

        System.out.println("Contenido del directorio " + directorio.getAbsolutePath());

        //obtener todo el contenido del directorio
        File[] lista = directorio.listFiles();

        if (lista.length == 0) {
            System.out.println("Directorio vacío");
            return;
        }

        //se recorre el directorio y se muestran primero los archivos
        for (File s : lista) {
            if (s.isFile()) {
                System.out.println("Archivo ->  " + s.getName());
            } else {
                recorrerDirectorios(s.getAbsolutePath());  // <-- Importante. Pasar el path del elemento que se esté leyendo
            }
        }
        //se recorre de nuevo el directorio y se obtienen los subdirectorios
//        for (File s : lista) {        
//            //Si es un directorio se vuelve a llamar al método
//            if (s.isDirectory()) {
//                recorrerDirectorios(s.getAbsolutePath());  // <-- Importante. Pasar el path del elemento que se esté leyendo
//            }
//        }

    } //Fin método recorrerDirectorios

    public static void recorrerDirectoriosv2(String ruta, String t) {
        //public static void verContenido(File carpeta,String t) {
        
        File carpeta = new File(ruta);

        System.out.printf("%sDirectorio --> %s\n", t, carpeta.getName());

        int i = 0;

        File[] contenidoRuta = carpeta.listFiles();

        if (contenidoRuta != null) {

            for (File fichero : contenidoRuta) {
                if (fichero.isDirectory()) {
                    t += "    ";
                    recorrerDirectoriosv2(fichero.getAbsolutePath(), t);
                    i = t.length();
                    t = t.substring(0, i - 4);
                } else {
                    t += "    ";
                    System.out.printf("%sArchivo --> %s%n", t, fichero.getName());
                    i = t.length();
                    t = t.substring(0, i - 4);
                }
            }
        }
    }

} //Fin clase MainAct05
