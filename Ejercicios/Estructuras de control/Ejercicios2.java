import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Ejercicios2 {

    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in); 

    // Método que verifica si un número es par o impar
    public static void apartado1() {
        System.out.print("Introduce un número: ");
        int num = sc.nextInt();  // Leer un número entero desde la entrada

        // Verificar si el número es par o impar
        if (num % 2 == 0) {
            System.out.println(num + " es par");
        } else {
            System.out.println(num + " es impar");
        }

        // Otra forma de mostrar el resultado usando el operador ternario
        System.out.println(num + " es " + (num % 2 == 0 ? "par" : "impar"));
    }

    // Método que comprueba si una letra es mayúscula
    public static void apartado3() {
        System.out.print("Escribe una letra: ");
        String cadena = sc.nextLine();  // Leer una cadena de texto
        char c = cadena.charAt(0);  // Obtener el primer carácter de la cadena

        // Verificar si el carácter es una letra mayúscula
        if (c >= 'A' && c <= 'Z') {
            System.out.println("'" + c + "' es una letra mayúscula");
        } else {
            System.out.println("'" + c + "' no es una letra mayúscula");
        }

        // Otra forma de mostrar el resultado usando el operador ternario
        System.out.println("'" + c + "'" + (c >= 'A' && c <= 'Z' ? "" : " no") + " es una letra mayúscula");
    }

    // Método que compara dos cadenas de texto para ver si son iguales
    public static void apartado4() {
        System.out.print("Escribe una cadena: ");
        String cadena1 = sc.nextLine();  // Leer la primera cadena

        System.out.print("Escribe otra cadena: ");
        String cadena2 = sc.nextLine();  // Leer la segunda cadena

        // Comparar si ambas cadenas son iguales
        if (cadena1.equals(cadena2)) {
            System.out.println("Las cadenas sí son iguales");
        } else {
            System.out.println("Las cadenas no son iguales");
        }

        // Otra forma de mostrar el resultado usando el operador ternario
        System.out.println("Las cadenas " + (cadena1.equals(cadena2) ? "sí" : "no") + " son iguales");
    }

    // Método que realiza una división entre dos números
    public static void apartado5() {
        System.out.print("Escribe un número: ");
        int num1 = sc.nextInt();  // Leer el primer número

        System.out.print("Escribe otro número: ");
        int num2 = sc.nextInt();  // Leer el segundo número

        // Verificar si el segundo número no es 0 para evitar división por cero
        if (num2 != 0) {
            System.out.println("La división es: " + num1 / num2);
        } else {
            System.out.println("No se puede dividir");
        }

        // Otra forma de mostrar el resultado usando el operador ternario
        System.out.println(num2 != 0 ? ("La división es: " + num1 / num2) : "No se puede dividir");
    }

    // Método que valida una hora introducida por el usuario
    public static void apartado7() {
        System.out.print("Escribe las horas: ");
        int horas = sc.nextInt();  // Leer las horas

        System.out.print("Escribe los min: ");
        int min = sc.nextInt();  // Leer los minutos

        System.out.print("Escribe los seg: ");
        int seg = sc.nextInt();  // Leer los segundos

        // Verificar si la hora es válida
        if (horas >= 0 && horas <= 23 && min >= 0 && min <= 59 && seg >= 0 && seg <= 59) {
            System.out.printf("%02d:%02d:%02d\n", horas, min, seg);  // Mostrar la hora formateada
        } else {
            System.out.println("La hora no es válida");
        }
    }

    // Método que determina la cantidad de días que tiene un mes
    public static void apartado9() {
        System.out.print("Introduce un mes: ");
        int mes = sc.nextInt();  // Leer el número del mes

        // Usar un switch para determinar la cantidad de días del mes
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("El mes tiene 31 días");
            case 4, 6, 9, 11 -> System.out.println("El mes tiene 30 días");
            case 2 -> System.out.println("El mes tiene 28 días");
            default -> System.out.println("Mes erróneo");  // Caso por defecto si el mes no es válido
        }

        // Imprimir el nombre del mes usando otro switch
        switch (mes) {
            case 1 -> System.out.print("Enero");
            case 2 -> System.out.print("Febrero");
            case 3 -> System.out.print("Marzo");
            case 4 -> System.out.print("Abril");
            case 5 -> System.out.print("Mayo");
            case 6 -> System.out.print("Junio");
            case 7 -> System.out.print("Julio");
            case 8 -> System.out.print("Agosto");
            case 9 -> System.out.print("Septiembre");
            case 10 -> System.out.print("Octubre");
            case 11 -> System.out.print("Noviembre");
            case 12 -> System.out.print("Diciembre");
        }

        // Repetir el mensaje con la cantidad de días del mes
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println(" tiene 31 días");
            case 4, 6, 9, 11 -> System.out.println(" tiene 30 días");
            case 2 -> System.out.println(" tiene 28 días");
            default -> System.out.println("Mes erróneo");
        }
    }

    // Método que clasifica caracteres en tipos (signos de puntuación, números, etc.)
    public static void apartado10() {
        System.out.print("Introduce una letra: ");
        int letra = sc.nextLine().charAt(0);  // Leer un carácter

        // Usar un switch para clasificar el carácter
        switch (letra) {
            case '.', ',', ';', ':' -> System.out.println("Signo de puntuación");
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> System.out.println("Número");
            default -> System.out.println("Otro carácter");
        }
    }

    // Método que cuenta hacia atrás de 20 a 1 utilizando un bucle while y un bucle for
    public static void apartado13() {
        int i = 20;  // Inicialización de la variable

        // Usar un bucle while para contar hacia atrás
        while (i >= 1) {
            System.out.print(i + " ");
            i--;
        }
        System.out.println();

        // Usar un bucle for para el mismo propósito
        for (i = 20; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Método que suma números hasta que se introduce un 0
    public static void apartado14() {
        int suma = 0, num;

        // Usar un bucle do-while para sumar números hasta que el usuario ingrese 0
        do {
            System.out.print("Introduce un núm (0 para salir): ");
            num = sc.nextInt();  // Leer un número
            suma += num;  // Sumar el número a la variable acumulada

        } while (num != 0);  // Continuar mientras no se introduzca un 0

        System.out.println("Suma: " + suma);  // Mostrar la suma total
    }

    // Método que cuenta la cantidad de cifras de un número
    public static void apartado15() {
        System.out.print("Introduce un núm: ");
        int num = sc.nextInt();  // Leer un número
        int cifras = 0;  // Inicializar el contador de cifras

        // Usar un bucle while para contar las cifras del número
        while (num != 0) {
            num /= 10;  // Dividir el número por 10 en cada iteración
            cifras++;  // Incrementar el contador
        }

        System.out.println("Cifras: " + cifras);  // Mostrar la cantidad de cifras
    }

    public static void apartado19() {
        System.out.print("Introduce un núm: ");
        int num = sc.nextInt();  // Leer un número

        for(int i = 1; i <= num; i++) {
            System.out.print(i);
            if(i < num) {
                System.out.print(", ");
            }
        }
    }

    // Método principal que llama a cada uno de los apartados
    public static void main(String[] args) throws IOException {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-15,19) o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer la opción del usuario
            sc.nextLine();  // Quitar el salto de línea sobrante

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Cambiar la condición para terminar el bucle
            } else {
                try {
                    // Llamar al método correspondiente según la opción seleccionada
                    Ejercicios2.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o ocurrió un problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar
    }
}
