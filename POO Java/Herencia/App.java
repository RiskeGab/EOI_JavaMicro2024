import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void ejemplo1() {
        // Clase abstracta. No puedo instanciar objetos de la misma
        // Animal a = new Animal(6, "Algo raro");
        // a.comer();
        // System.out.println(a);

        Ave ave = new Ave(1.4, "Loro", true);
        ave.comer(); // Heredado de Animal
        ave.ponerHuevos();
        System.out.println(ave);
    }

    public static void ejemplo2() {
        Animal leon = new Mamifero(210, "León", true);
        leon.comer();
    }

    public static void ejemplo3() {
        Mamifero leon = new Mamifero(210, "León", true);
        Mamifero leon2 = new Mamifero(210, "León", true);
        if (leon == leon2)
            System.out.println("Son el mismo objeto (referencia)");
        else
            System.out.println("No son el mismo objeto (referencia)");

        if (leon.equals(leon2))
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");
    }

    public static void saludarAnimal(Animal a) {
        System.out.println("Hola " + a.getNombre());
        switch (a) {
            case Mamifero m -> System.out.println("Eres carnívoro?: " + m.isCarnivoro());
            case Ave ave -> ave.ponerHuevos();
            default -> { break; }
        }
    }

    public static void polimorfismo1() {
        Animal mamifero = new Mamifero(23, "perro", true);
        saludarAnimal(mamifero);
        System.out.println(((Mamifero) mamifero).isCarnivoro());
        Animal ave = new Ave(2, "Gallina", false);
        saludarAnimal(ave);
        ave.comer();
    }

    public static void polimorfismo2() {
        List<Object> lista = new ArrayList<>();
        lista.add(new Mamifero(400, "rinoceronte", false));
        lista.add("Hola");
        lista.add(LocalDate.now());
        lista.add(45);

        for(Object o: lista) {
            System.out.println(o.toString());
        }

        List<Animal> animales = new ArrayList<>();
        animales.add(new Mamifero(400, "rinoceronte", false));
        animales.add(new Ave(3, "gallina", false));
        animales.add(new Mamifero(13, "zorro", true));

        for(Animal a: animales) {
            a.comer();
        }
    }

    public static void polimorfismo3() {
        List<IHablador> lista = new ArrayList<>();
        lista.add(new Persona("Pedro", 34));
        lista.add(new Ave(3, "gallina", false));
        lista.add(new Mamifero(13, "zorro", true));

        for(IHablador hablador: lista) {
            hablador.hablar();
            if(hablador instanceof Ave) {
                ((Ave) hablador).ponerHuevos();
            }
        }
    }

    public static void main(String[] args) {
        // ejemplo1();
        // ejemplo2();
        // ejemplo3();
        // polimorfismo1();
        // polimorfismo2();
        polimorfismo3();
    }
}
