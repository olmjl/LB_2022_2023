package act10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Descarga una imagen con el logo de Java en tu carpeta de Descargas. Llámalo 
 * logo-java (con la extensión que sea). A continuación, utilizando los conocimientos 
 * adquiridos durante esta unidad, elabora un programa Java que cree una carpeta 
 * en Documents/Documentos llamada copia y haga una copia de logo-java allí.
 *
 * Recomendación: utiliza System.getProperty para obtener la ruta personal de Windows 
 * de tu usuario. De esta manera las rutas serán más genéricas y el programa funcionará 
 * en diferentes máquinas.
 *
 */
public class Ad_ut1_act10_CopiarImagen {
    public static void main(String[] args) {
        FileInputStream flujoEntrada = null;
        FileOutputStream flujoSalida = null;

        String rutaDescargas = System.getProperty("user.home") + "/Downloads";
        File rutaImagenOriginal = new File(rutaDescargas, "java_logo.jpg");
        String rutaCopia = System.getProperty("user.home") + "/Documents/copia";
        File directorioCopia = new File(rutaCopia);

        try {
            if (!directorioCopia.mkdir()) {
                System.out.println("El directorio ya existe");
            }
            //
            File imagenCopia = new File(directorioCopia, "java_logo.jpg");

            flujoEntrada = new FileInputStream(rutaImagenOriginal); // Archivo fuente
            flujoSalida = new FileOutputStream(imagenCopia); // Nuevo archivo

            int i = 0;
            while ((i = flujoEntrada.read()) != -1) {
                flujoSalida.write(i);
            }

            if (imagenCopia.exists()) {
                System.out.printf("Fichero %s copiado correctamente en %s. %n", rutaImagenOriginal.getAbsolutePath()
                        ,directorioCopia.getAbsolutePath());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {    // No olvide cerrar el flujo y liberar los recursos pertinentes
            if (flujoEntrada != null) {
                try {
                    flujoEntrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (flujoSalida != null) {
                try {
                    flujoSalida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //Necesario???
            flujoEntrada = null;
            flujoSalida = null;
        }
    } //Fin método main

} //Fin clase Ad_ut1_act10_CopiarImagen

