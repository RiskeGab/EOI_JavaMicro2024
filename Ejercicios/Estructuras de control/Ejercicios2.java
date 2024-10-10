import java.util.Scanner;

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

    // Método que verifica si un número es múltiplo de 10
    public static void apartado2() {
        System.out.print("Introduce un número: ");
        int num = sc.nextInt();  // Leer un número entero

        // Verificar si el número es múltiplo de 10
        if (num % 10 == 0) {
            System.out.println(num + " es múltiplo de 10");
        } else {
            System.out.println(num + " no es múltiplo de 10");
        }

        // Otra forma de mostrar el resultado usando el operador ternario
        System.out.println(num + (num % 10 == 0 ? "" : " no") + " es múltiplo de 10");
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

    // Método que muestra el mayor de tres números
    public static void apartado6() {
        System.out.print("Escribe el primer número: ");
        int num1 = sc.nextInt();  // Leer el primer número

        System.out.print("Escribe el segundo número: ");
        int num2 = sc.nextInt();  // Leer el segundo número

        System.out.print("Escribe el tercer número: ");
        int num3 = sc.nextInt();  // Leer el tercer número

        // Verificar cuál es el mayor de los tres números
        int mayor = num1;  // Suponemos que el primero es el mayor
        if (num2 > mayor) {
            mayor = num2;  // Si el segundo es mayor, actualizamos
        }
        if (num3 > mayor) {
            mayor = num3;  // Si el tercero es mayor, actualizamos
        }

        System.out.println("El mayor de los tres números es: " + mayor);
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

    // Método que verifica si un número es par o impar usando el operador ternario
    public static void apartado8() {
        System.out.print("Introduce un número: ");
        int num = sc.nextInt();  // Leer un número entero

        // Usar el operador ternario para determinar si es par o impar y mostrar el resultado
        System.out.println(num + " es " + (num % 2 == 0 ? "par" : "impar"));
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

    // Método que ofrece un menú para realizar operaciones aritméticas
    public static void apartado11() {
        System.out.print("Introduce el primer número: ");
        int num1 = sc.nextInt();  // Leer el primer número

        System.out.print("Introduce el segundo número: ");
        int num2 = sc.nextInt();  // Leer el segundo número

        // Mostrar el menú
        System.out.println("Selecciona una opción:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        int opcion = sc.nextInt();  // Leer la opción seleccionada

        // Realizar la operación seleccionada
        switch (opcion) {
            case 1:
                System.out.println("La suma es: " + (num1 + num2));
                break;
            case 2:
                System.out.println("La resta es: " + (num1 - num2));
                break;
            case 3:
                System.out.println("La multiplicación es: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("La división es: " + (num1 / num2));
                } else {
                    System.out.println("No se puede dividir por 0");
                }
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    // Método que calcula el precio de una entrada con descuentos en función de la edad y si es socio
    public static void apartado12() {
        double precioEntrada = 50;  // Precio inicial de la entrada
        System.out.print("Introduce tu edad: ");
        int edad = sc.nextInt();  // Leer la edad del usuario
        sc.nextLine();  // Limpiar el buffer del Scanner

        // Si es menor de edad, aplicar un descuento del 25%
        if (edad < 18) {
            precioEntrada *= 0.75;
            System.out.println("Eres menor de edad. El precio de la entrada con un 25% de descuento es: " + precioEntrada);
        } 
        // Si es mayor de edad pero no jubilado
        else if (edad < 65) {
            System.out.print("¿Eres socio? (s/n): ");
            String esSocio = sc.nextLine().toLowerCase();  // Leer si es socio

            // Si es socio, aplicar un descuento del 40%
            if (esSocio.equals("s")) {
                precioEntrada *= 0.60;
                System.out.println("Eres socio. El precio de la entrada con un 40% de descuento es: " + precioEntrada);
            } else {
                System.out.println("No eres socio. El precio de la entrada es: " + precioEntrada);
            }
        } 
        // Si es jubilado, aplicar un descuento del 75%
        else {
            precioEntrada *= 0.25;
            System.out.println("Eres jubilado. El precio de la entrada con un 75% de descuento es: " + precioEntrada);
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

    // Método que dibuja una línea de asteriscos, con y sin bucle for
    public static void apartado16() {
        System.out.print("Introduce un número: ");
        int num = sc.nextInt();  // Leer el número

        System.out.println("Línea de asteriscos usando bucle for:");
        // Usar un bucle for para dibujar la línea de asteriscos
        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();  // Salto de línea al final

        System.out.println("Línea de asteriscos con repeat:");
        // Dibujar la línea de asteriscos sin usar bucle for (usando repeat)
        System.out.println("*".repeat(num));
    }

    // Método que muestra los números del 1 al 30, excluyendo los divisibles por 3
    public static void apartado17() {
        // Usar un bucle for para recorrer los números del 1 al 30
        for (int i = 1; i <= 30; i++) {
            // Si el número es divisible por 3, se salta usando continue
            if (i % 3 == 0) {
                continue;  // Saltar a la siguiente iteración
            }
            System.out.print(i + " ");  // Imprimir el número si no es divisible por 3
        }
        System.out.println();  // Salto de línea al final
    }

    // Método que muestra los números de 5 en 5, del 0 al 100
    public static void apartado18() {
        // Usar un bucle for para mostrar los números del 0 al 100 en pasos de 5
        for (int i = 0; i <= 100; i += 5) {
            System.out.print(i + " ");  // Imprimir el número
        }
        System.out.println();  // Salto de línea al final
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

    // Método que suma números hasta que el usuario introduce 0, usando un bucle infinito
    public static void apartado20() {
        int suma = 0;  // Inicializar la suma
        while (true) {  // Bucle infinito
            System.out.print("Introduce un número (0 para salir): ");
            int num = sc.nextInt();  // Leer el número

            // Si el número es 0, salir del bucle
            if (num == 0) {
                break;
            }

            // Si el número es negativo, saltar a la siguiente iteración
            if (num < 0) {
                continue;
            }

            suma += num;  // Sumar el número a la variable acumulada
        }
        System.out.println("Suma total: " + suma);  // Mostrar la suma total
    }

    // Método que muestra los divisores de un número
    public static void apartado21() {
        System.out.print("Introduce un número: ");
        int num = sc.nextInt();  // Leer el número

        // Usar un bucle for para encontrar los divisores
        System.out.print("Divisores de " + num + ": ");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");  // Imprimir el divisor
            }
        }
        System.out.println();  // Salto de línea al final
    }

    // Método que escribe los números del 1 al 9 cinco veces en una misma línea
    public static void apartado22() {
        // Usar un bucle para escribir los números cinco veces
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(j);  // Imprimir los números del 1 al 9
            }
        }
        System.out.println();  // Salto de línea al final
    }

    // Método que escribe los números del 1 al 9, luego del 1 al 8, y así sucesivamente
    public static void apartado23() {
        // Usar un bucle for para controlar la cantidad de números por fila
        for (int i = 9; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);  // Imprimir los números del 1 hasta i
            }
            System.out.println();  // Salto de línea después de cada fila
        }
    }

    // Método que dibuja un cuadrado de asteriscos usando for y repeat
    public static void apartado24() {
        System.out.print("Introduce el tamaño del cuadrado: ");
        int tam = sc.nextInt();  // Leer el tamaño del cuadrado

        System.out.println("Cuadrado usando bucles for:");
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.print("*");  // Dibujar un asterisco
            }
            System.out.println();  // Salto de línea al final de cada fila
        }

        System.out.println("\nCuadrado usando repeat:");
        for (int i = 0; i < tam; i++) {
            System.out.println("*".repeat(tam));  // Dibujar una fila completa usando repeat
        }
    }

    // Método que dibuja una escalera de bajada con asteriscos, con y sin bucles anidados
    public static void apartado25() {
        System.out.print("Introduce el tamaño de la escalera: ");
        int tam = sc.nextInt();  // Leer el tamaño

        System.out.println("Escalera usando bucles anidados:");
        for (int i = 1; i <= tam; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");  // Dibujar un asterisco
            }
            System.out.println();  // Salto de línea al final de cada fila
        }

        System.out.println("\nEscalera usando repeat:");
        for (int i = 1; i <= tam; i++) {
            System.out.println("*".repeat(i));  // Dibujar directamente la cantidad de asteriscos usando repeat()
        }
    }

    public static void apartado26() {
        System.out.print("Introduce un núm: ");
        int num = sc.nextInt();  // Leer un número

        // Con bucles anidados
        // for(int i = 1; i <= num; i++) {
        //     for(int j = 1; j <= num - i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // Sin bucles anidados
        for(int i = 1; i <= num; i++) {
            System.out.println(" ".repeat(num - i) + "*".repeat(i));
        }
    }

    public static void apartado27() {
        System.out.print("Alto: ");
        int alto = sc.nextInt();  // Leer un número
        System.out.print("Ancho: ");
        int ancho = sc.nextInt();

        // for (int fila = 1; fila <= alto; fila++) {
        //     for (int col = 1; col <= ancho; col++) {
        //         System.out.print(fila == 1 || fila == alto || col == 1 || col == ancho ? "*" : " ");
        //     }
        //     System.out.println(); // Generamos salto de línea
        // }

        // Sin anidar bucles
        for(int i = 0; i < alto; i++) {
            if (i == 0 || i == alto - 1) {
                System.out.println("*".repeat(ancho));
            }
            if (i > 0 && i < alto - 1) {
                System.out.println("*"+" ".repeat(ancho-2)+"*");
            }
        }
    }

    public static void apartado28() {
        System.out.print("Alto: ");
        int alto = sc.nextInt();  // Leer un número

        for(int i = 1; i <= alto; i++) {
            System.out.println(" ".repeat(alto - i) + "*".repeat(i * 2 - 1));
        }
    }

    // Método que dibuja una pirámide hueca, con y sin bucles for
    public static void apartado29() {
        System.out.print("Introduce la altura de la pirámide: ");
        int altura = sc.nextInt();  // Leer la altura de la pirámide

        System.out.println("Pirámide hueca usando bucles for:");
        for (int i = 1; i <= altura; i++) {
            // Imprimir los espacios antes de los asteriscos
            for (int j = 1; j <= (altura - i); j++) {
                System.out.print(" ");
            }

            // Dibujar los asteriscos y los espacios internos
            if (i == 1) {
                System.out.println("*");  // El vértice superior de la pirámide
            } else if (i == altura) {
                // Imprimir la fila completa de asteriscos en la base
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                System.out.print("*");  // El primer asterisco
                for (int j = 1; j <= (2 * i - 3); j++) {
                    System.out.print(" ");  // Espacios internos
                }
                System.out.println("*");  // El último asterisco
            }
        }

        System.out.println("\nPirámide hueca sin bucles for (usando repeat):");
        for (int i = 1; i <= altura; i++) {
            // Espacios antes de los asteriscos
            System.out.print(" ".repeat(altura - i));

            // Dibujar los asteriscos y espacios
            if (i == 1) {
                System.out.println("*");  // Vértice superior
            } else if (i == altura) {
                System.out.println("*".repeat(2 * i - 1));  // Base completa
            } else {
                System.out.println("*" + " ".repeat(2 * i - 3) + "*");  // Lados de la pirámide con espacios en el medio
            }
        }
    }

    // Método que dibuja una pirámide invertida, con y sin bucles for
    public static void apartado30() {
        System.out.print("Introduce la altura de la pirámide invertida: ");
        int altura = sc.nextInt();  // Leer la altura de la pirámide

        System.out.println("Pirámide invertida usando bucles for:");
        for (int i = altura; i >= 1; i--) {
            // Imprimir los espacios antes de los asteriscos
            for (int j = 1; j <= (altura - i); j++) {
                System.out.print(" ");
            }

            // Imprimir los asteriscos en cada fila
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }

            // Salto de línea después de cada fila
            System.out.println();
        }

        System.out.println("\nPirámide invertida usando repeat:");
        for (int i = altura; i >= 1; i--) {
            // Imprimir los espacios antes de los asteriscos
            System.out.print(" ".repeat(altura - i));

            // Imprimir la fila de asteriscos
            System.out.println("*".repeat(2 * i - 1));
        }
    }

    // Método que dibuja un rombo, con y sin bucles for y repeat
    public static void apartado31() {
        int ancho;
        
        // Pedir al usuario un número impar para el ancho del rombo
        do {
            System.out.print("Introduce un número impar para el ancho del rombo: ");
            ancho = sc.nextInt();  // Leer el ancho
        } while (ancho % 2 == 0);  // Repetir si el número no es impar

        int altura = (ancho + 1) / 2;  // Calcular la altura de la mitad del rombo

        System.out.println("Rombo usando bucles for (sin repeat):");
        for (int i = 1; i <= altura; i++) {
            // Espacios antes de los asteriscos
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            // Asteriscos
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();  // Salto de línea al final de cada fila
        }

        // Dibujar la parte inferior (pirámide invertida) sin usar repeat()
        for (int i = altura - 1; i >= 1; i--) {
            // Espacios antes de los asteriscos
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            // Asteriscos
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();  // Salto de línea al final de cada fila
        }

        System.out.println("\nRombo usando repeat:");

        for (int i = 1; i <= altura; i++) {
            // Espacios y asteriscos
            System.out.print(" ".repeat(altura - i));  // Espacios
            System.out.println("*".repeat(2 * i - 1));  // Asteriscos
        }

        // Dibujar la parte inferior (pirámide invertida) usando repeat()
        for (int i = altura - 1; i >= 1; i--) {
            // Espacios y asteriscos
            System.out.print(" ".repeat(altura - i));  // Espacios
            System.out.println("*".repeat(2 * i - 1));  // Asteriscos
        }
    }

    // Método principal que llama a cada uno de los apartados
    public static void main(String[] args) {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-31) o 0 para salir: ");
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
                    System.out.println("Error: No se encontró el apartado o se produjo otro problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar
    }
}
