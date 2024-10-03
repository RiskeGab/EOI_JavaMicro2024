public class App {
    public static void comparaCadenas() {
        String s1 = "Hola";
        String s2 = "Hola";
        String s3 = "Ho";
        s3 += "la";

        // Con strings y objetos == compara si son el MISMO objeto (no el mismo valor)
        System.out.println(s1 == s2); // true (compilador detecta mismo valor y crea un solo objeto asignado a ambas
                                      // variables)
        System.out.println(s1 == s3); // false (compilador engañado, objetos diferentes)
        System.out.println(s1.equals(s3)); // true (forma correcta de comparar strings)
    }

    public static void operarCaracteres() {
        // Operaciones aritméticas con char fuerzan su conversión a int
        System.out.println('ஆ' + 1); // 2951

        int c = 'ஆ';
        System.out.println(c); // 2950

        char c2 = 'ஆ';
        System.out.println((int) c2); // 2950
        System.out.println((char) 2950); // ஆ
    }

    public static void operadoresLogicos() {
        int edad = 25;
        int anyosCarnet = 6;
        String sexo = "Masculino";
        String nombre = "Pepe";
        boolean esPepeMayor = edad >= 18 && nombre.equals("Pepe");
        System.out.println(esPepeMayor); // true

        boolean tieneDescuento = (sexo.equals("Masculino") && anyosCarnet > 10) ||
                (sexo.equals("Femenino") && anyosCarnet > 5);
        System.out.println(tieneDescuento); // false
    }

    public static void conversionTipos() {
        int n1 = 5;
        int n2 = 4;
        System.out.println(n1 / n2); // 1 (división entera)
        System.out.println(n1 / (double) n2); // 1.25
        System.out.println((int) 'ஆ'); // 2950
        System.out.println((char) 2950); // ஆ

        String s1 = "45";
        int num1 = Integer.parseInt(s1);
        String s2 = "45.54";
        double num2 = Double.parseDouble(s2);

        System.out.println(String.valueOf(n1) + n2); // "54"

        double num3 = 53.2435;
        String cadena2 = String.format("%.2f", num3);
        System.out.println(cadena2); // 53,24

        char digito = '6';
        System.out.println((int)digito + 23); // 77 (54 + 23)
        System.out.println(Integer.parseInt(String.valueOf(digito)) + 23); // 29 (6 + 23)
        System.out.println(Character.getNumericValue(digito) + 23); // 29 (6 + 23)
    }

    public static void main(String[] args) throws Exception {
        int n1 = 165;
        System.out.println("""
            Este programa de Java empieza con un String multilinea
            Esta es otra línea
                Y esta otra, que está indentada
            Número: %d
            """.formatted(n1));
        // comparaCadenas();
        // operarCaracteres();
        // operadoresLogicos();
        // conversionTipos();
    }
}
