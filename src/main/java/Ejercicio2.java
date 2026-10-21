import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        String rutaBase = "C:\\AD\\Ejercicios";
        File directorioNuevo = new File(rutaBase, "nuevo Directorio");

        File fichero1 = new File(rutaBase + File.separator + "miDirectorio" + File.separator + "fichero_de_texto.txt");

        File fichero2 = new File(directorioNuevo, "fichero_de_texto2.txt");

        do {
            System.out.println("\n--- MENÚ ACCESO A DATOS ---");
            System.out.println("1) Crear directorio 'nuevo Directorio'");
            System.out.println("2) Crear fichero 'fichero_de_texto2.txt' en 'nuevo Directorio'");
            System.out.println("3) Eliminar el fichero 'fichero_de_texto.txt'");
            System.out.println("4) Eliminar el directorio 'nuevo Directorio'");
            System.out.println("5) Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        if (!directorioNuevo.exists()) {
                            boolean creado = directorioNuevo.mkdirs();
                            if (creado) {
                                System.out.println("Directorio 'nuevo Directorio' creado con éxito.");
                            } else {
                                System.out.println("No se pudo crear el directorio.");
                            }
                        } else {
                            System.out.println("ℹ El directorio 'nuevo Directorio' ya existe.");
                        }
                        break;

                    case 2:
                        if (!directorioNuevo.exists()) {
                            System.out.println("Directorio 'nuevo Directorio' no existe.");
                        }
                        if (!fichero2.exists()) {
                            boolean creado = fichero2.createNewFile();
                            if (creado) {
                                System.out.println("Fichero 'fichero_de_texto2.txt' creado con éxito.");
                            } else {
                                System.out.println("No se pudo crear el fichero.");
                            }
                        } else {
                            System.out.println("El fichero ya existe.");
                        }
                        break;

                    case 3:
                        if (fichero1.exists()) {
                            boolean eliminado = fichero1.delete();
                            if (eliminado) {
                                System.out.println("Fichero 'fichero_de_texto.txt' eliminado correctamente.");
                            } else {
                                System.out.println("No se pudo eliminar el fichero.");
                            }
                        } else {
                            System.out.println("ℹ El fichero 'fichero_de_texto.txt' no existe.");
                        }
                        break;

                    case 4:
                        if (directorioNuevo.exists()) {
                            boolean eliminado = directorioNuevo.delete();
                            if (eliminado) {
                                System.out.println("✔ Directorio 'nuevo Directorio' eliminado correctamente.");
                            } else {
                                System.out.println("✖ No se pudo eliminar. (Asegúrate de que el directorio esté vacío).");
                            }
                        } else {
                            System.out.println("ℹ El directorio no existe.");
                        }
                        break;

                    case 5:
                        System.out.println("Saliendo del programa");
                        break;

                    default:
                        System.out.println("Opción no válida. Introduce un número entre 1 y 5.");
                }

            } catch (IOException e) {
                System.out.println("Error de E/S al manipular el fichero: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Por favor, introduce un número entero válido.");
                scanner.next();
            }

        } while (opcion != 5);

        scanner.close();
    }
}