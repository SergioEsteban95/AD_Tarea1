import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        String rutaBase = "C:\\AD\\Ejercicios";
        File directorioNuevo = new File(rutaBase, "nuevo Directorio");
        File fichero1 = new File(rutaBase + File.separator + "miDirectorio" + File.separator + "fichero_de_texto.txt");
        File fichero2 = new File(directorioNuevo, "fichero_de_texto2.txt");

        String[] provinciasAndalucia = {
                "Almería", "Cádiz", "Córdoba", "Granada",
                "Huelva", "Jaén", "Málaga", "Sevilla"
        };

        do {
            System.out.println("\n--- MENÚ ACCESO A DATOS ---");
            System.out.println("a) Crear directorio 'nuevo Directorio'");
            System.out.println("b) Crear fichero 'fichero_de_texto2.txt' en nuevo Directorio");
            System.out.println("c) Eliminar el fichero 'fichero_de_texto.txt'");
            System.out.println("d) Eliminar 'nuevo Directorio' (aunque tenga archivos)");
            System.out.println("e) Escribir las provincias de Andalucía en fichero_de_texto2.txt");
            System.out.println("f) Salir");
            System.out.print("Elige una opción (a-f): ");

            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.isEmpty()) continue;
            opcion = entrada.charAt(0);

            try {
                switch (opcion) {
                    case 'a':
                        if (!directorioNuevo.exists()) {
                            if (directorioNuevo.mkdirs()) {
                                System.out.println("Directorio 'nuevo Directorio' creado con éxito.");
                            } else {
                                System.out.println("No se pudo crear el directorio.");
                            }
                        } else {
                            System.out.println("El directorio ya existe.");
                        }
                        break;

                    case 'b':
                        if (!directorioNuevo.exists()) {
                            System.out.println("Directorio 'nuevo Directorio' no existe.");
                        }
                        if (!fichero2.exists()) {
                            if (fichero2.createNewFile()) {
                                System.out.println("Fichero 'fichero_de_texto2.txt' creado con éxito.");
                            } else {
                                System.out.println("No se pudo crear el fichero.");
                            }
                        } else {
                            System.out.println("El fichero ya existe.");
                        }
                        break;

                    case 'c':
                        if (fichero1.exists()) {
                            if (fichero1.delete()) {
                                System.out.println("Fichero 'fichero_de_texto.txt' eliminado correctamente.");
                            } else {
                                System.out.println("No se pudo eliminar el fichero.");
                            }
                        } else {
                            System.out.println("El fichero 'fichero_de_texto.txt' no existe.");
                        }
                        break;

                    case 'd':
                        if (directorioNuevo.exists()) {
                            borrarDirectorioRecursivo(directorioNuevo);
                            System.out.println("Directorio 'nuevo Directorio' y su contenido eliminados.");
                        } else {
                            System.out.println("El directorio no existe.");
                        }
                        break;

                    case 'e':
                        if (!fichero2.exists()) {
                            System.out.println("EL fichero 'fichero_de_texto2.txt' no existe.");
                        }

                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero2))) {
                            for (String provincia : provinciasAndalucia) {
                                bw.write(provincia);
                                bw.newLine();
                            }
                            System.out.println("Provincias de Andalucía escritas correctamente en el fichero2.");
                        }
                        break;

                    case 'f':
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Introduce una letra entre a y f.");
                }

            } catch (IOException e) {
                System.out.println("Error de E/S: " + e.getMessage());
            }

        } while (opcion != 'f');

        scanner.close();
    }

    private static void borrarDirectorioRecursivo(File f) {
        if (f.isDirectory()) {
            File[] ficheros = f.listFiles();
            if (ficheros != null) {
                for (File hijo : ficheros) {
                    borrarDirectorioRecursivo(hijo);
                }
            }
        }
        f.delete();
    }
}
