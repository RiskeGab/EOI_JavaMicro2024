public class App {
    public static void ejemplo1() {
        Animal a = new Animal();
        a.comer();
        
        Ave ave = new Ave(false);
        ave.comer(); // Heredado de Animal
        ave.ponerHuevos();
        System.out.println(ave.getNombre()); // Animal desconocido
    }
    public static void main(String[] args) {
        ejemplo1();
    }
}
