package Funciones;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Funciones {
    public static void apartado4(String nombre, String... trabajos) {
        String t = trabajos.length == 0 ? "No ha trabajado nunca" : String.join(", ", trabajos);
        System.out.println(nombre + ": " + t);
    }

    public static boolean apartado5(int numero) {
        for (int i = 2; i <= numero / 2; i++) {
            if (numero % i == 0) {
                return false; // No es primo
            }
        }

        return true; // Es primo
    }

    public static int apartado9(String cadena, String trozo) {
        int veces = 0;
        int pos = -1;
        do {
            pos = cadena.indexOf(trozo, pos + 1);
            if (pos != -1) {
                veces++;
            }
        } while (pos != -1);

        return veces;
    }

    public static double apartado11(String cadena) {
        String[] nums = cadena.split(";");

        int total = 0;
        for (String n : nums) {
            total += Integer.parseInt(n);
        }
        return total / (float) nums.length;

        // Con streams
        // return Arrays.stream(nums).mapToInt(s ->
        // Integer.parseInt(s)).average().getAsDouble();
    }

    public static void ordenarArrays() {
        int[] nums = { 2, 45, 65, 36, 23, 114 };
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // [2, 23, 36, 45, 65, 114]

        String[] palabras = { "cerebro", "vaca", "si", "ele" };
        // Ordenamos en función de la longitud de las palabras
        Arrays.sort(palabras);
        System.out.println(String.join(", ", palabras)); // si, ele, vaca, cerebro
        
        Arrays.sort(palabras, (p1, p2) -> p1.length() - p2.length());
        System.out.println(String.join(", ", palabras));

        Arrays.sort(palabras, (s1, s2) -> s2.compareTo(s1));
        // Arrays.sort(palabras, Comparator.reverseOrder());
        System.out.println(String.join(", ", palabras));
        
    }

    public static void main(String[] args) {
        // apartado4("Juan", "Payaso", "Malabarista");
        // apartado4("Marta", "Cobrador del frac", "Sexador de pollos", "Carpintero");
        // apartado4("Paco");

        // System.out.println("57 es primo: " + (apartado5(57) ? "Sí" : "No"));
        // System.out.println("47 es primo: " + (apartado5(47) ? "Sí" : "No"));

        // System.out.println(apartado9("cocinando cocos con chocolate", "co")); // 5

        // System.out.printf("Media: %.2f\n", apartado11("3;19;7;4;10"));

        ordenarArrays();
    }
}
