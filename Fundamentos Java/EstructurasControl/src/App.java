import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void ejemploFor1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Repetición número " + (i + 1));
        }
    }

    public static void ejemploFor2() {
        for (int i = 1, j = 10; i <= 10 && j > 0; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
    }

    public static void ejemploFor3() {
        int total = 0;
        for (; total < 100;) {
            System.out.println("Escribe un número (acumulado: " + total + "): ");
            int num = sc.nextInt();
            total += num;
        }
        System.out.println("El total acumulado ha sido " + total);
    }

    public static void ejemploForeach() {
        int[] array = { 9, 12, 26, 34 };
        for (int num : array) { // Recorremos los números de arriba
            // En cada repetición, num toma el valor del siguiente número
            System.out.println(num);
        }
    }

    public static void ejemploBreak() {
        int[] array = { 1, 4, 8, 12, 16, 21 };
        System.out.println("Número a buscar:");
        int num = sc.nextInt();

        boolean encontrado = false;

        // for (int i = 0; i < array.length; i++) {
        // if(array[i] == num) {
        // encontrado = true;
        // break;
        // }

        // System.out.println("Voy por el número: " + array[i]);
        // }

        for (int n : array) {
            if (n == num) {
                encontrado = true;
                break;
            }
            System.out.println("Voy por el número: " + n);
        }

        System.out.println(encontrado ? "Sí está" : "No está");
    }

    public static void ejemploBucleAnidado1() {
        for (int tabla = 1; tabla <= 5; tabla++) {
            for (int num = 1; num <= 10; num++) {
                System.out.println(tabla + " x " + num + " = " + (tabla * num));
            }
        }
    }

    // Dibujar un rectángulo
    public static void ejemploBucleAnidado2() {
        int alto = 5;
        int ancho = 8;
        for (int fila = 0; fila < alto; fila++) {
            for (int col = 0; col < ancho; col++) {
                System.out.print("*");
            }
            System.out.println(); // Generamos salto de línea
        }
    }

    public static void main(String[] args) throws Exception {
        // ejemploFor1();
        // ejemploFor2();
        // ejemploFor3();
        // ejemploForeach();
        // ejemploBreak();
        // ejemploBucleAnidado1();
        ejemploBucleAnidado2();
    }
}
