import java.util.Scanner;
import java.io.IOException;

public class Ejercicios1 {

    private static Scanner sc = new Scanner(System.in); // Scanner a nivel de clase para reutilizarlo en todos los apartados

    // Suma dos números fijos y muestra el resultado
    public static void apartado1() {
        int n1 = 36, n2 = 27;
        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
    }

    // Realiza operaciones básicas (suma, resta, multiplicación, división y módulo) entre dos números enteros
    public static void apartado2() {
        int n1 = 15, n2 = 4;
        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2)); // Suma
        System.out.println(n1 + " - " + n2 + " = " + (n1 - n2)); // Resta
        System.out.println(n1 + " * " + n2 + " = " + (n1 * n2)); // Multiplicación
        System.out.println(n1 + " / " + n2 + " = " + (n1 / n2)); // División entera
        System.out.println(n1 + " % " + n2 + " = " + (n1 % n2)); // Resto de la división
    }

    // Compara dos números enteros y muestra los resultados de las comparaciones
    public static void apartado3() {
        int n1 = 6, n2 = 6;
        System.out.println(n1 + " es menor que " + n2 + ": " + (n1 < n2));
        System.out.println(n1 + " es igual que " + n2 + ": " + (n1 == n2));
        System.out.println(n1 + " es mayor o igual que " + n2 + ": " + (n1 >= n2));
    }

    // Muestra cuatro valores de tipo double y realiza una operación matemática compleja
    public static void apartado4() {
        double a = 2.5, b = 3.5, c = 4.0, d = 5.0;
        System.out.print(a + " " + b + " " + c + " " + d); // Imprime los valores sin salto de línea
        double resultado = ((a + b) * c) / d; // Suma los dos primeros, multiplica por el tercero y divide por el cuarto
        System.out.println("\nResultado: " + resultado);
    }

    // Incrementa, decrementa y duplica el valor de una variable entera
    public static void apartado5() {
        int n = 1;
        System.out.println("Valor inicial de N = " + n);
        n += 77; // Incrementa en 77
        System.out.println("N + 77 = " + n);
        n -= 3; // Decrementa en 3
        System.out.println("N - 3 = " + n);
        n *= 2; // Duplica el valor
        System.out.println("N * 2 = " + n);
    }

    // Cambia los valores de cuatro variables entre sí
    public static void apartado6() {
        int a = 1, b = 2, c = 3, d = 4;
        System.out.println("Valores iniciales: A = " + a + " B = " + b + " C = " + c + " D = " + d);
        b = c; // B toma el valor de C
        c = a; // C toma el valor de A
        a = d; // A toma el valor de D
        d = b; // D toma el valor de B (que era el valor original de C)
        System.out.println("B toma el valor de C -> B = " + b);
        System.out.println("C toma el valor de A -> C = " + c);
        System.out.println("A toma el valor de D -> A = " + a);
        System.out.println("D toma el valor de B -> D = " + d);
    }

    // Muestra la posición Unicode de dos caracteres y la diferencia entre ellos
    public static void apartado7() {
        char c1 = 'b', c2 = 'k';
        System.out.println("'" + c1 + "' tiene la posición " + (int) c1); // Muestra la posición Unicode de 'b'
        System.out.println("'" + c2 + "' tiene la posición " + (int) c2); // Muestra la posición Unicode de 'k'
        System.out.println("Diferencia entre '" + c1 + "' y '" + c2 + "': " + (c2 - c1)); // Diferencia entre las posiciones
    }

    // Realiza varias operaciones incrementales y multiplicativas en tres variables
    public static void apartado8() {
        int a = 5;
        int b = ++a; // Preincremento: a = 6, b = 6
        int c = a++; // Postincremento: c = 6, a = 7
        b = b * 5; // Multiplica b por 5
        a = a * 2; // Multiplica a por 2
        System.out.println("a = " + a + ", b = " + b + ", c = " + c); // Muestra los valores finales de a, b y c
    }

    // Solicita el nombre del usuario y lo saluda
    public static void apartado9() {
        System.out.print("¿Cuál es tu nombre?: ");
        String nombre = sc.nextLine();
        System.out.println("¡Hola, " + nombre + "!");
    }

    // Le pide un número entero al usuario y muestra el doble y el triple de dicho número
    public static void apartado10() {
        System.out.print("Dime un número: ");
        int num = sc.nextInt(); // Lee el número ingresado por el usuario
        System.out.println("Doble: " + (num * 2) + ", triple: " + (num * 3)); // Calcula y muestra el doble y el triple
    }

    // Convierte grados centígrados a grados Fahrenheit
    public static void apartado11() {
        System.out.print("Grados centígrados: ");
        double gradosC = sc.nextDouble(); // Lee los grados centígrados
        double gradosF = 32 + (9 * gradosC / 5); // Convierte a Fahrenheit usando la fórmula
        System.out.println("Grados Fahrenheit: " + gradosF);
    }

    // Lee un número de 3 cifras y muestra cada cifra por separado (centenas, decenas, unidades)
    public static void apartado12() {
        System.out.print("Dime un número de 3 cifras: ");
        int num = sc.nextInt(); // Lee el número de 3 cifras
        int unidades = num % 10; // Obtiene las unidades
        int decenas = (num / 10) % 10; // Obtiene las decenas
        int centenas = (num / 100) % 10; // Obtiene las centenas
        System.out.println("Centenas: " + centenas + ", decenas: " + decenas + ", unidades: " + unidades);
    }

    // Calcula el número de la suerte sumando día, mes y año de nacimiento, y luego sumando las cifras del resultado
    public static void apartado13() {
        System.out.print("Fecha de nacimiento (día mes año): ");
        int dia = sc.nextInt(); // Lee el día de nacimiento
        int mes = sc.nextInt(); // Lee el mes de nacimiento
        int anyo = sc.nextInt(); // Lee el año de nacimiento
        int suma = dia + mes + anyo;
        int num1 = suma % 10;
        int num2 = (suma / 10) % 10;
        int num3 = (suma / 100) % 10;
        int num4 = (suma / 1000) % 10;
        int numSuerte = num1 + num2 + num3 + num4; 
        System.out.println("Tu número de la suerte es: " + numSuerte);
    }

    // Pregunta la edad del usuario e informa cuántos años tendrá en 15 años
    public static void apartado14() {
        System.out.print("¿Cuál es tu edad?: ");
        int edad = sc.nextInt(); // Lee la edad del usuario
        System.out.println("En 15 años tendrás: " + (edad + 15) + " años"); // Calcula la edad en 15 años
    }

    // Pregunta el nombre y precio de tres productos y muestra los datos formateados con IVA
    public static void apartado15() {
        System.out.print("Producto 1: ");
        String prod1 = sc.nextLine(); // Lee el nombre del primer producto
        System.out.print("Precio 1: ");
        double precio1 = sc.nextDouble(); // Lee el precio del primer producto

        sc.nextLine(); // Consumir el salto de línea
        System.out.print("Producto 2: ");
        String prod2 = sc.nextLine(); // Lee el nombre del segundo producto
        System.out.print("Precio 2: ");
        double precio2 = sc.nextDouble(); // Lee el precio del segundo producto

        sc.nextLine(); // Consumir el salto de línea
        System.out.print("Producto 3: ");
        String prod3 = sc.nextLine(); // Lee el nombre del tercer producto
        System.out.print("Precio 3: ");
        double precio3 = sc.nextDouble(); // Lee el precio del tercer producto

        // Imprime los encabezados de la tabla
        System.out.printf("%-15s%12s%12s\n", "NOMBRE", "PRECIO", "CON IVA");
        // Imprime cada producto con su precio y el precio con IVA (21%)
        System.out.printf("%-15s%11.2f€%11.2f€\n", prod1, precio1, (precio1 * 1.21));
        System.out.printf("%-15s%11.2f€%11.2f€\n", prod2, precio2, (precio2 * 1.21));
        System.out.printf("%-15s%11.2f€%11.2f€\n", prod3, precio3, (precio3 * 1.21));
    }

    // Solicita tres dígitos al usuario, los suma y muestra el resultado
    public static void apartado16() {
        System.out.print("Escribe el primer dígito: ");
        int digito1 = sc.nextInt();
        System.out.print("Escribe el segundo dígito: ");
        int digito2 = sc.nextInt();
        System.out.print("Escribe el tercer dígito: ");
        int digito3 = sc.nextInt();
        int suma = digito1 + digito2 + digito3;
        System.out.println("Has escrito: " + digito1 + " + " + digito2 + " + " + digito3 + " = " + suma);
    }

    // Pregunta el nombre y la edad del usuario, y muestra la salida formateada
    public static void apartado17() {
        System.out.print("¿Cuál es tu nombre?: ");
        String nombre = sc.nextLine();
        System.out.print("¿Cuál es tu edad?: ");
        int edad = sc.nextInt();
        System.out.println("Estos son tus datos\n\tnombre: " + nombre + "\n\tedad: " + edad);
    }    

    // Método principal que llama a cada uno de los apartados
    public static void main(String[] args) throws IOException {
        boolean ejecutando = true; // Variable que controla si el bucle sigue ejecutándose
    
        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-15) o 0 para salir: ");
            int opcion = sc.nextInt();
            sc.nextLine(); // Quitar el salto de línea sobrante
    
            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false; // Cambiar la condición para terminar el bucle
            } else {
                try {
                    Ejercicios1.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o ocurrió un problema.");
                }
            }
        }
    
        sc.close(); // Cerrar el Scanner al finalizar
    }
}
