import java.util.Arrays;

public class App {
    public static void hola() {
        System.out.println("Hola mundo!");
    }

    public static void saluda(String nombre) {
        System.out.println("Hola " + nombre);
    }

    public static void suma(int n1, int n2) {
        System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
    }

    /**
     * Suma una cantidad indeterminada de números
     */
    public static void suma2(int ...nums) {
        int total = 0;
        for(int n: nums) {
            total += n;
        }
        System.out.println(Arrays.toString(nums).replace(", ", " + ") + " = " + total);
    }

    public static void main(String[] args) throws Exception {
        hola();
        saluda("Pepito");
        suma(2, 7);
        suma2(3, 6, 8);
        suma2(1,4,8, 2, 4);
        suma2();
    }
}
