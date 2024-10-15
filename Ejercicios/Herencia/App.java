import java.util.Scanner;

public class App {
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in);

    /**
     * Crea una clase llamada Tienda con un método llamado bienvenida que imprima por consola “¡Bienvenido a nuestra tienda!”. 
     * Crea otra clase llamada TiendaLicores que herede de Tienda. 
     * Crea un objeto del tipo TiendaLicores y llama al método bienvenida.
     */
    public static void apartado1() {
        TiendaLicores tiendaLicores = new TiendaLicores();
        tiendaLicores.bienvenida();
    }

    /**
     * Sobrescribe el método bienvenida en la clase TiendaLicores. 
     * Deberá hacer lo mismo que la clase base y añadir el mensaje “Si eres menor de 18 años, fuera de aquí”
     */
    public static void apartado2() {
        apartado1();
    }

    /**
     * Crea una clase llamada Figura. Esta clase será abstracta y tendrá los
     * métodos getPerimetro y getArea como abstractos también. Crea la clase
     * Cuadrado y Circulo que hereden de Figura e implementa dichos métodos
     * junto a los atributos que necesites: lado para el cuadrado y radio para el círculo.
     */
    public static void apartado5() {
        Cuadrado cua = new Cuadrado(4.5);
        Circulo cir = new Circulo(4);

        System.out.printf("Cuadrado. Área: %.2f, Perímetro: %.2f\n", cua.getArea(), cua.getPerimetro());
        System.out.printf("Círculo. Área: %.2f, Perímetro: %.2f\n", cir.getArea(), cir.getPerimetro());
    }

    /**
     * Lo mismo que el apartado 5 pero implementando la interfaz IFigura
     */
    public static void apartado6() {
        apartado6();
    }

    // Método principal que ejecuta los apartados según la selección del usuario
    public static void main(String[] args) throws Exception {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-8) o 0 para salir: ");
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
