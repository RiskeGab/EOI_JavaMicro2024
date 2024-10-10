import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Ejercicios3 {

    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in); 

    // Método que verifica si un número es par o impar
    public static void apartado4() {
        int[] dias = {31,28,31,30,31,30,31,31,30,31,30,31};
        System.out.print("Mes: ");
        int mes = sc.nextInt();
        System.out.print("Día: ");
        int dia = sc.nextInt();

        int total = 0;
        for(int i = 0; i < mes - 1; i++) {
            total += dias[i];
        }
        total += dia;
        System.out.println("Día del año: " + total);
    }

    public static void apartado11() {
        String[] nombres = {"Juan", "Antonio", "Luis", "Tania"};
		int[][] notas = {
				{4, 7, 8, 2},
				{8, 7, 7, 9},
				{5, 3, 9, 2},
				{9, 3, 7, 9}
		};
		
		for(int i = 0; i < nombres.length; i++) {
			// int total = 0;
			// for(int j = 0; j < notas[i].length; j++) {
			// 	total += notas[i][j];
			// }
			// double media = (double)total / notas[i].length;
            double media = Arrays.stream(notas[i]).average().getAsDouble();
			System.out.printf("Nombre: %s, media: %.2f\n", nombres[i], media);
		}
    }

    // Método principal que llama a cada uno de los apartados
    public static void main(String[] args) throws IOException {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer la opción del usuario
            sc.nextLine();  // Quitar el salto de línea sobrante

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Cambiar la condición para terminar el bucle
            } else {
                try {
                    // Llamar al método correspondiente según la opción seleccionada
                    Ejercicios3.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o ocurrió un problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar
    }
}

