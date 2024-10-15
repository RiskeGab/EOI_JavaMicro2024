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

    public static void main(String[] args) {
        // ejemplo1();
        // ejemplo2();
        ejemplo3();
    }
}
