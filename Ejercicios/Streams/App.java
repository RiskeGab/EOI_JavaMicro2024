import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in);

    // A partir de una lista de personas, devuelve sus nombres ordenados alfabéticamente
    public static void apartado3() {
        List<Persona> personas = List.of(
            new Persona("Paco", 24),
            new Persona("Ana", 61),
            new Persona("Marco", 7),
            new Persona("Marta", 36),
            new Persona("Alex", 15),
            new Persona("Sarah", 49),
            new Persona("Alberto", 49)
        );
        List<String> nombres = personas.stream().map(Persona::nombre).sorted().collect(Collectors.toList());
        System.out.println(nombres);
    }

    // Método principal que ejecuta los apartados según la selección del usuario
    public static void main(String[] args) throws Exception {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-9) o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer la opción del usuario
            sc.nextLine();  // Limpiar el buffer

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Terminar el bucle
            } else {
                try {
                    // Llamar al método correspondiente según la opción seleccionada
                    App.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o se produjo otro problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar
    }
}
