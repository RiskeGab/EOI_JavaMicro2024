import java.util.Arrays;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void ejemploArrays1() {
        int[] numeros = new int[6];
        numeros[0] = 50;
        numeros[3] = 12;
        // numeros[6] = 10; // Index 6 out of bounds for length 6
        System.out.println(Arrays.toString(numeros));

        int[] numeros2 = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(numeros2));
    }

    public static void ejemploArrays2() {
        int[] numeros = { 12, 6, 14, 21, 24 };
        for (int i = 0; i < numeros.length; i++) {
            System.out.printf("Índice: %d, valor: %d\n", i, numeros[i]);
        }
        for (int n : numeros) {
            System.out.println(n);
        }
    }

    public static void ejemploArrays3() {
        int[] numeros = { 1, 2, 3, 4, 5 };
        int[] numeros2 = numeros;

        numeros2[0] = 99;
        System.out.println(Arrays.toString(numeros));// [99,2,3,4,5]
    }

    public static void buscarEnArray() {
        String[] nombres = { "Juan", "Ana", "Pedro", "Eva", "Paco" };
        boolean encontrado = false; // Nos indicará si hemos encontrado el valor
        System.out.print("Nombre a buscar: ");
        String buscar = sc.nextLine(); // Valor a buscar en el array

        // La condición también incluye que no hayamos encontrado lo que buscamos
        for (int i = 0; i < nombres.length && !encontrado; i++) {
            if (nombres[i].equals(buscar)) {
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("El nombre " + buscar + " está en el array");
        } else {
            System.out.println(buscar + " no encontrado...");
        }
    }

    public static void buscarEnArray2() {
        String[] nombres = { "Juan", "Ana", "Pedro", "Eva", "Paco" };
        System.out.print("Nombre a buscar: ");
        String buscar = sc.nextLine(); // Valor a buscar en el array

        if (Arrays.stream(nombres).anyMatch(n -> n.equals("Pedro"))) {
            System.out.println("El nombre " + buscar + " está en el array");
        } else {
            System.out.println(buscar + " no encontrado...");
        }
    }

    static void redimensionaArray() {
        String[] nombres = { "Juan", "Ana", "Pedro", "Eva", "Paco" };
        String[] nombresAux = new String[10];

        for (int i = 0; i < nombres.length; i++) {
            nombresAux[i] = nombres[i];
        }
        nombres = nombresAux; // La variable nombres apunta al array redimensionado
        nombres[5] = "Marta";
        System.out.println(Arrays.toString(nombres));
    }

    static void redimensionaArray2() {
        String[] nombres = { "Juan", "Ana", "Pedro", "Eva", "Paco" };

        nombres = Arrays.copyOf(nombres, 10);
        nombres[5] = "Marta";
        System.out.println(nombres.length); // 10
        System.out.println(String.join(", ", nombres)); // Juan, Ana, Pedro, Eva, Paco, Marta, null, null, null, null
    }

    static void borrarArray() {
        int[] nums = { 15, 6, 9, 12, 20 };
        System.out.println("Números guardados: " + nums.length); // Números guardados: 5
        // Ahora vamos a borrar la posición 2 (número 9)
        for (int i = 2; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1]; // Desplazamos los números a la izquierda
        }
        nums = Arrays.copyOf(nums, nums.length - 1);
        System.out.println(Arrays.toString(nums)); // [15, 6, 12, 20] (posición borrada con éxito)
    }

    static void insertarArray() {
        int[] nums = { 15, 6, 9, 12, 20 };
        // Ahora vamos a insertar el número 2 en la posición 3
        nums = Arrays.copyOf(nums, nums.length + 1); // Redimensionamos array
        for (int i = nums.length - 2; i >= 3; i--) {
            nums[i + 1] = nums[i]; // Desplazamos los números a la derecha
        }
        nums[3] = 2; // Añadimos el 2 en la posición 3
        System.out.println(Arrays.toString(nums)); // [15, 6, 9, 2, 12, 20] (posición insertada con éxito)
    }

    static void ordenarArrays() {
        int[] nums = { 15, 6, 9, 12, 20 };
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) { // Intercambiamos
                    int aux = nums[i];
                    nums[i] = nums[j];
                    nums[j] = aux;
                }
            }
        }
        System.out.println(Arrays.toString(nums)); // [6, 9, 12, 15, 20] (Ordenados)
    }

    static void ordenarArrays2() {
        int[] nums = { 15, 6, 9, 12, 20 };
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // [6, 9, 12, 15, 20] (Ordenados)
    }

    static void arrayMulti() {
        int[][] array2D;

        array2D = new int[5][];
        array2D[0] = new int[]{1,2,3,4};
        array2D[1] = new int[4];
        array2D[2] = new int[6];
        array2D[3] = new int[3];
        array2D[4] = new int[4];
        System.out.println(Arrays.deepToString(array2D));
        //[[1, 2, 3, 4], [0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0], [0, 0, 0, 0]]

        for(int i = 0; i < array2D.length; i++) {
            for(int j = 0; j < array2D[i].length; j++) {
                System.out.printf("[%d, %d] -> %d, ", i, j, array2D[i][j]);
            }
            System.out.println();
        }

        System.out.println("************* Foreach ***********");
        for(int[] nums: array2D) {
            for(int n: nums) {
                System.out.print(n + ", ");
            }
            System.out.println();
        }
    }

    public static void recorreCadenas() {
        String cad = "Programando en Java";
        for(int i = 0; i < cad.length(); i++) {
            System.out.printf("%d: %s, ", i, cad.charAt(i));
        }
    }

    public static void parametrosPrograma(String[] args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) throws Exception {
        // ejemploArrays1();
        // ejemploArrays2();
        // ejemploArrays3();
        // buscarEnArray();
        // buscarEnArray2();
        // redimensionaArray();
        // redimensionaArray2();
        // ordenarArrays();
        // ordenarArrays2();
        // arrayMulti();
        // recorreCadenas();
        parametrosPrograma(args);
    }
}
