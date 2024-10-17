import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void ejemploClaseAnonima() {
        Operation suma = new Operation() {
            @Override
            public int operar(int n1, int n2) {
                return n1 + n2;
            }
        };

        System.out.println(suma.operar(23, 15)); // 38
    }

    public static void ejemploLambda1() {
        Operation suma = (n1, n2) -> n1 + n2;
        Operation resta = (n1, n2) -> n1 - n2;

        System.out.println(suma.operar(23, 15)); // 38
        System.out.println(resta.operar(23, 15)); // 8
    }

    public static void ejemploLambda2() {
        Supplier<String> getPalabra = () -> {
            String[] palabras = { "perro", "casa", "gato", "cerdo" };
            return palabras[new Random().nextInt(palabras.length)];
        };
        System.out.println(getPalabra.get()); // casa
    }

    public static void ejemploLambda3() {
        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
        List<String> strings2 = new ArrayList<>();
        Consumer<String> print = s -> System.out.println(s);
        Consumer<String> add = s -> strings2.add(s);
        print.accept(strings.get(0)); // one
        // El método forEach es un ejemplo de método que recibe un Consumer
        strings.forEach(print);
        /* Se pueden concatenar acciones con el método .andThen(Consumer)) */
        strings.forEach(print.andThen(add));
        System.out.println(strings2.toString());
    }

    public static void ejemploLambda4() {
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 10;
        System.out.println(p1.test("Hola mundo")); // true
        // Se pueden unir predicados con 'and' y 'or' y negarlos con 'negate'
        Predicate<String> p3 = p1.and(p2); // Comprueba p1 y p2
        System.out.println(p3.test("Hola mundo")); // false
        System.out.println(p1.or(p2).test("Hola mundo")); // true

        List<Integer> nums = new ArrayList<>(List.of(12, 5, 2, 7, 28));
        nums.removeIf(n -> n % 2 == 0);
        System.out.println(nums); // [5, 7]
    }

    public static void ejemploLambda5() {
        BiFunction<String, Integer, String> substr = (s, i) -> s.substring(i);
        Function<String, String> toUpper = s -> s.toUpperCase();
        // Se pueden concatenar funciones con 'andThen'
        BiFunction<String, Integer, String> subUpper = substr.andThen(toUpper);
        System.out.println(subUpper.apply("hola mundo", 5)); // MUNDO

        // Si la Function recibe y devuelve el mismo tipo, se puede crear como
        // UnaryOperator
        UnaryOperator<String> toUpper2 = s -> s.toUpperCase();

        List<Integer> nums = new ArrayList<>(List.of(12, 5, 2, 7, 28));
        nums.replaceAll(n -> n * 2);
        System.out.println(nums); // [24, 10, 4, 14, 56]
    }

    public static void streamFilter() {
        List<Persona> personas = List.of(
                new Persona("Paco", 24),
                new Persona("Ana", 61),
                new Persona("Marco", 7),
                new Persona("Marta", 36),
                new Persona("Alex", 15),
                new Persona("Sarah", 49));

        personas.stream().filter(p -> p.edad() < 18).forEach(p -> System.out.println(p));

        List<String> palabras = Arrays.asList("coche", "moto", "aro", "cebolla", "tomate");
        palabras.stream().filter(p -> p.length() < 5).forEach(p -> System.out.println(p));
    }

    public static void streamMap() {
        List<String> palabras = Arrays.asList("coche", "moto", "aro", "cebolla", "tomate");
        palabras.stream().map(p -> p.length()).filter(n -> n >= 5).forEach(l -> System.out.println(l));

        List<Integer> nums = Arrays.asList(4, 6, 12, 8);
        nums.stream()
            .map(n -> new Cuadrado(n))
            .map(c -> c.getArea())
            .forEach(a -> System.out.println(a));
        // nums.stream().map(n -> {
        // Cuadrado c = new Cuadrado(n);
        // return c.getArea();
        // }).forEach(a -> System.out.println(a));
    }

    public static void streamMatch() {
        List<Integer> nums = Arrays.asList(4, 6, 12, 8, 15);
        boolean todosPares = nums.stream().allMatch(n -> n % 2 == 0);
        boolean algunoPar = nums.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Todos pares: " + todosPares + ". Alguno es par: " + algunoPar);
    }

    public static void streamFind() {
        int[] nums = {15, 17, 21, 97, 141};
        var num = Arrays.stream(nums).filter(n -> n % 2 == 0).findFirst();
        // System.out.println(num.getAsInt()); // Exception in thread "main" java.util.NoSuchElementException: No value present
        if(num.isPresent()) System.out.println(num.getAsInt());
        System.out.println(num.orElse(0));
    }

    public static void streamSorted() {
        int[] nums = {14, 17, 91, 4, 22, 94, 2, 7};
        Arrays.stream(nums).filter(n -> n % 2 == 0).sorted().forEach(System.out::println);

        List<Persona> personas = List.of(
            new Persona("Paco", 24),
            new Persona("Ana", 61),
            new Persona("Marco", 7),
            new Persona("Marta", 36),
            new Persona("Alex", 15),
            new Persona("Sarah", 49),
            new Persona("Alberto", 49)
        );

        // personas.stream().sorted((p1, p2) -> Integer.compare(p1.edad(), p2.edad())).forEach(System.out::println);
        // personas.stream().sorted(Comparator.comparing(p -> p.edad())).forEach(System.out::println);
        // personas.stream().sorted(Comparator.comparing(Persona::edad)).forEach(System.out::println);
        // personas.stream().sorted(Comparator.comparing(Persona::nombre).reversed()).forEach(System.out::println);
        personas.stream().sorted(Comparator.comparing(Persona::edad).thenComparing(Persona::nombre)).forEach(System.out::println);
    } 

    public static void streamSkipLimit() {
        List<Persona> personas = List.of(
            new Persona("Paco", 24),
            new Persona("Ana", 61),
            new Persona("Marco", 7),
            new Persona("Marta", 36),
            new Persona("Alex", 15),
            new Persona("Sarah", 49),
            new Persona("Alberto", 49)
        );

        Persona p = personas.stream()
            .sorted(Comparator.comparing(Persona::edad).reversed())
            .skip(3).findFirst().orElse(null);
        System.out.println("Cuarta persona más mayor: " + p);

        personas.stream()
            .sorted(Comparator.comparing(Persona::edad).reversed())
            .limit(3).forEach(System.out::println);
    }

    public static void main(String[] args) {
        // ejemploClaseAnonima();
        // ejemploLambda1();
        // ejemploLambda2();
        // ejemploLambda3();
        // ejemploLambda4();
        // ejemploLambda5();
        // streamFilter();
        // streamMap();
        // streamMatch();
        // streamFind();
        // streamSorted();
        streamSkipLimit();
    }
}