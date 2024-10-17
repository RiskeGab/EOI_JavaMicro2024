import java.util.Scanner;

public class Horoscopo_v1 {
    // Objeto Scanner para leer la entrada del usuario
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Variable para controlar cuándo salir del programa
        boolean salir = false;

        // Bucle principal del programa
        while (!salir) {
            // Mostrar el menú al usuario
            System.out.println();
            System.out.println("1. Introducir fecha de nacimiento");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            System.out.println();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Llamar al método que calcula el signo zodiacal
                    obtenerSigno();
                    break;
                case 2:
                    // Salir de la aplicación
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    // Si no se introduce una opción de menú correcta, se informa al usuario
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        // Cerrar el scanner al finalizar el programa
        scanner.close();
    }

    // Método para obtener el signo zodiacal del usuario
    public static void obtenerSigno() {
        // Pedir al usuario que introduzca su fecha de nacimiento
        System.out.print("Introduce tu día de nacimiento: ");
        int dia = scanner.nextInt();
        System.out.print("Introduce tu mes de nacimiento (1-12): ");
        int mes = scanner.nextInt();

        // Validar si la fecha introducida es válida
        if (!fechaValida(dia, mes)) {
            System.out.println("Fecha incorrecta. Inténtalo de nuevo.");
            return; // Salir del método si la fecha no es válida
        }

        // Calcular el signo zodiacal basado en el día y el mes
        String signo = calcularSignoZodiacal(dia, mes);
        // Obtener una descripción muy breve del signo zodiacal
        String descripcion = obtenerDescripcionSigno(signo);

        // Verificar si se ha calculado un signo válido
        if (signo != null) {
            System.out.println("\nTu signo zodiacal es: " + signo);
            System.out.println("Descripción: " + descripcion);
        } else {
            System.out.println("Fecha incorrecta. Inténtalo de nuevo.");
        }
    }

    // Método para validar la fecha (día y mes) introducida por el usuario
    public static boolean fechaValida(int dia, int mes) {
        // Verificar que el mes esté entre 1 y 12
        if (mes < 1 || mes > 12) {
            return false;
        }

        // Determinar el número máximo de días que puede tener el mes introducido
        int diasEnMes;
        switch (mes) {
            case 2: // Febrero puede tener hasta 29 días en años bisiestos (aquí asumimos 29 para simplicidad)
                diasEnMes = 29;
                break;
            case 4: case 6: case 9: case 11: // Meses con 30 días
                diasEnMes = 30;
                break;
            default: // Meses con 31 días
                diasEnMes = 31;
        }

        // Verificar que el día esté dentro del rango adecuado para el mes
        return (dia >= 1) && (dia <= diasEnMes);
    }

    // Método para calcular el signo zodiacal basado en el día y el mes
    public static String calcularSignoZodiacal(int dia, int mes) {
        if ((dia >= 21 && mes == 3) || (dia <= 20 && mes == 4)) {
            return "Aries";
        } else if ((dia >= 21 && mes == 4) || (dia <= 21 && mes == 5)) {
            return "Tauro";
        } else if ((dia >= 22 && mes == 5) || (dia <= 21 && mes == 6)) {
            return "Géminis";
        } else if ((dia >= 22 && mes == 6) || (dia <= 23 && mes == 7)) {
            return "Cáncer";
        } else if ((dia >= 24 && mes == 7) || (dia <= 23 && mes == 8)) {
            return "Leo";
        } else if ((dia >= 24 && mes == 8) || (dia <= 23 && mes == 9)) {
            return "Virgo";
        } else if ((dia >= 24 && mes == 9) || (dia <= 23 && mes == 10)) {
            return "Libra";
        } else if ((dia >= 24 && mes == 10) || (dia <= 22 && mes == 11)) {
            return "Escorpio";
        } else if ((dia >= 23 && mes == 11) || (dia <= 21 && mes == 12)) {
            return "Sagitario";
        } else if ((dia >= 22 && mes == 12) || (dia <= 20 && mes == 1)) {
            return "Capricornio";
        } else if ((dia >= 21 && mes == 1) || (dia <= 19 && mes == 2)) {
            return "Acuario";
        } else if ((dia >= 20 && mes == 2) || (dia <= 20 && mes == 3)) {
            return "Piscis";
        } else {
            return null; // Devolver null si la fecha no corresponde a ningún signo
        }
    }

    // Método para obtener la descripción de un signo zodiacal dado
    public static String obtenerDescripcionSigno(String signo) {
        switch (signo) {
            case "Aries":
                return "Los Aries son valientes, enérgicos y aventureros.";
            case "Tauro":
                return "Los Tauro son fiables, pacientes y determinados.";
            case "Géminis":
                return "Los Géminis son versátiles, curiosos y comunicativos.";
            case "Cáncer":
                return "Los Cáncer son emocionales, protectores y cariñosos.";
            case "Leo":
                return "Los Leo son seguros, generosos y apasionados.";
            case "Virgo":
                return "Los Virgo son detallistas, prácticos y analíticos.";
            case "Libra":
                return "Los Libra son equilibrados, diplomáticos y encantadores.";
            case "Escorpio":
                return "Los Escorpio son intensos, leales y misteriosos.";
            case "Sagitario":
                return "Los Sagitario son optimistas, aventureros y filosóficos.";
            case "Capricornio":
                return "Los Capricornio son disciplinados, responsables y ambiciosos.";
            case "Acuario":
                return "Los Acuario son independientes, innovadores y humanitarios.";
            case "Piscis":
                return "Los Piscis son imaginativos, sensibles y empáticos.";
            default:
                return "Descripción no disponible."; // Caso por defecto si el signo no tiene descripción
        }
    }
}
