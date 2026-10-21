import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        File ficheroEmpleados = new File("C:\\AD\\Ejercicios\\Empleados.txt");

        String[] ids = {"001", "002", "003", "004", "005", "006", "007", "008", "009", "010"};
        String[] nombres = {"Ana Pérez", "Carlos Gómez", "Elena Ruiz", "David López", "Sofía Martín",
                "Javier Torres", "Lucía Romero", "Mateo Ruiz", "Carmen Gil", "Sergio Ramos"};

        System.out.println("=== 1. FileWriter y FileReader == <");

        try (FileWriter fw = new FileWriter(ficheroEmpleados)) {
            for (int i = 0; i < ids.length; i++) {
                String linea = ids[i] + " - " + nombres[i] + "\n";
                fw.write(linea);
            }
            System.out.println("Empleados escritos correctamente con FileWriter.");
        } catch (IOException e) {
            System.out.println("Error al escribir con FileWriter: " + e.getMessage());
        }

        System.out.println("\n--- Leyendo contenido con FileReader ---");
        try (FileReader fr = new FileReader(ficheroEmpleados)) {
            int valor;
            while ((valor = fr.read()) != -1) {
                System.out.print((char) valor);
            }
        } catch (IOException e) {
            System.out.println("Error al leer con FileReader: " + e.getMessage());
        }


        System.out.println("\n========================================================");
        System.out.println("=== 2. BufferedWriter y BufferedReader ===");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEmpleados))) {
            for (int i = 0; i < ids.length; i++) {
                bw.write("ID: " + ids[i] + " | Nombre: " + nombres[i]);
                bw.newLine();
            }
            System.out.println("Empleados reescritos correctamente con BufferedWriter.");
        } catch (IOException e) {
            System.out.println("Error al escribir con BufferedWriter: " + e.getMessage());
        }

        System.out.println("\n--- Leyendo contenido línea a línea con BufferedReader ---");
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEmpleados))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer con BufferedReader: " + e.getMessage());
        }
    }
}
