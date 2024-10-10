import java.math.BigInteger;
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

    public static int suma3(int ...nums) {
        int total = 0;
        for(int n: nums) {
            total += n;
        }

        return total;
    }

    public static void math() {
        double n1 = -23.40;
        double n2 = 2.649532;

        System.out.println(Math.abs(n1)); // 23.4
        System.out.println(Math.round(n2)); // 3
        System.out.println(Math.max(23, 43)); // 43
        System.out.println(Math.min(4, 5)); // 4
        System.out.println(Math.sqrt(25)); // 5
        System.out.println(Math.pow(2, 4)); // 16

        System.out.println(Integer.MAX_VALUE); // 2147483647 (32 bits)
        System.out.println(Long.MAX_VALUE); // 9223372036854775807 (64 bits)
        System.out.println(Float.MAX_VALUE); // 3.4028235E38 (64 bits)
    }

    public static void compararCadenas() {
        System.out.println("A".compareTo("x")); // -55 (65-120)
        System.out.println("mona".compareTo("mono")); // -14 (a - o)

        Persona[] personas = {
            new Persona("Pepito", 35),
            new Persona("Juan", 14),
            new Persona("María", 52),
            new Persona("Ana", 47),
        };
        System.out.println(Arrays.toString(personas));
        Arrays.sort(personas, (p1, p2) -> p1.nombre().compareTo(p2.nombre()));
        System.out.println(Arrays.toString(personas));
        Arrays.sort(personas, (p1, p2) -> p1.edad() - p2.edad());
        System.out.println(Arrays.toString(personas));
    }

    public static void buscarCadenas() {
        String s = "Mi perro se llama Comeniños";
        System.out.println(s.indexOf("perro")); // 3
        System.out.println(s.indexOf("perro", 4)); // -1
        System.out.println(s.indexOf("gato")); // -1

        System.out.println(s.contains("perro")); // true
        System.out.println(s.contains("gato")); // false
    }

    public static void reemplazaCadenas() {
        String s = "Mi perro se llama Comeniños";
        String s1 = s.replace("perro", "koala");
        System.out.println(s1); // Mi koala se llama Comeniños
        String s2 = s.replace("e", "a");
        System.out.println(s2);

        // ReplaceAll recibe una expresión regular
        String s3 = s.replaceAll("[aeiou]", "_");
        System.out.println(s3); // M_ p_rr_ s_ ll_m_ C_m_n_ñ_s
    }

    public static void substring() {
        String s = "Mi perro se llama Comeniños";
        String animal = s.substring(3, 8);
        System.out.println(animal); // perro
        System.out.println(s.substring(18)); // Comeniños
    }

    public static void split() {
        String s = "pato-gato-perro-koala";
        String[] animales = s.split("-");
        System.out.println(Arrays.toString(animales));
        System.out.println("Hay " + animales.length + " animales"); // Hay 4 animales
    }

    public static void main(String[] args) throws Exception {
        // hola();
        // saluda("Pepito");
        // suma(2, 7);
        // suma2(3, 6, 8);
        // suma2(1,4,8, 2, 4);
        // suma2();
        // int res = suma3(3,5, 7);
        // System.out.println("Resultado: " + res);
        // math();
        // compararCadenas();
        // buscarCadenas();
        reemplazaCadenas();
        // substring();
        // split();
    }
}
