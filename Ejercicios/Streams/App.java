import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in);

    private static List<Persona> personas = List.of(
        new Persona("Paco", 24),
        new Persona("Ana", 61),
        new Persona("Marco", 7),
        new Persona("Marta", 36),
        new Persona("Alex", 15),
        new Persona("Sarah", 49),
        new Persona("Alberto", 49)
    );

    private static List<IFigura> figuras = Arrays.asList(
        new Cuadrado(4),
        new Circulo(4.6),
        new Cuadrado(12),
        new Circulo(7),
        new Cuadrado(6.5)
    );

    // A partir de una lista de números, devuelve la media de aquellos que sean mayores que 10.
    public static void apartado1() {
        List<Integer> numeros = Arrays.asList(3, 14, 7, 21, 9, 31, 16);
        double media = numeros.stream()
            .mapToInt(Integer::intValue)
            .filter(n -> n >= 10)
            .average()
            .getAsDouble();
        System.out.println("Media: " + media);

        double media2 = numeros.stream()
            .filter(n -> n >= 10)
            .collect(Collectors.averagingInt(n -> n));
        System.out.println("Media: " + media2);
    }

    // A partir de una lista de personas, devuelve una lista con las 2 más jovenes que tengan al menos 18 años y muéstra la lista por consola.
    public static void apartado2() {
        List<Persona> mayores = personas.stream()
            .filter(p -> p.edad() >= 18)
            .sorted(Comparator.comparing(Persona::edad))
            .limit(2)
            .toList();

        System.out.println(mayores);
    }

    // A partir de una lista de personas, devuelve sus nombres ordenados alfabéticamente
    public static void apartado3() {
        List<String> nombres = personas.stream().map(Persona::nombre).sorted().collect(Collectors.toList());
        System.out.println(nombres);
    }

    // A partir de una lista de personas, devuelve los 3 nombres más largos separados por un guion.
    public static void apartado4() {
        String nombres = personas.stream()
            .map(Persona::nombre)
            .sorted(Comparator.comparing(String::length).reversed())
            .limit(3)
            .collect(Collectors.joining("-"));
        System.out.println(nombres);
    }

    public static void apartado5() {
        Persona joven = personas.stream()
            .sorted(Comparator.comparing(Persona::edad))
            .findFirst()
            .orElse(null);

        System.out.println(joven);
    }

    public static void apartado7() {
        IFigura figura = figuras.stream()
            .sorted(Comparator.comparing(IFigura::getArea).reversed())
            .findFirst()
            .orElse(null);

        System.out.println(figura);
    }

    public static void apartado8() {
        IFigura figura = figuras.stream()
            .filter(f -> f instanceof Cuadrado)
            .sorted(Comparator.comparing(IFigura::getArea).reversed())
            .findFirst()
            .orElse(null);

        System.out.println(figura);
    }

    public static void apartado9() {
        double suma = figuras.stream()
            .filter(f -> f instanceof Circulo)
            .mapToDouble(IFigura::getArea)
            .sum();

        System.out.println(suma);
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
