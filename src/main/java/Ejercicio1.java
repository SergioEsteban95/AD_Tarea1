import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Ejercicio1 {
    public static void main(String[] args) {
        String rutaDirectorio = "C:\\AD\\Ejercicios\\miDirectorio";
        String rutaFichero = rutaDirectorio + File.separator + "fichero_de_texto.txt";

        File directorio = new File(rutaDirectorio);

        try {
            if (!directorio.exists()) {
                boolean directorioCreado = directorio.mkdirs();
                if (directorioCreado) {
                    System.out.println("Directorio creado correctamente: " + directorio.getAbsolutePath());
                } else {
                    System.out.println("No se pudo crear el directorio.");
                    return;
                }
            } else {
                System.out.println("El directorio ya existe.");
            }

            File fichero = new File(rutaFichero);

            if (!fichero.exists()) {
                boolean ficheroCreado = fichero.createNewFile();
                if (ficheroCreado) {
                    System.out.println("Fichero de texto creado correctamente: " + fichero.getName());
                } else {
                    System.out.println("No se pudo crear el fichero.");
                }
            } else {
                System.out.println("El fichero ya existe.");
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error de E/S (I/O): " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Fin del programa");
    }
}
