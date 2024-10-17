import java.util.Random;

public class Ave extends Animal {
    private boolean puedeVolar;

    public Ave(double peso, String nombre, boolean puedeVolar) {
        super(peso, nombre); // Llamada explícita al constructor base
        this.puedeVolar = puedeVolar;
    }

    public boolean getPuedeVolar() {
        return puedeVolar;
    }

    @Override
    public void comer() {
        // Definimos que un ave aumenta su peso un 5% siempre al comer
        setPeso(getPeso() * 1.05);
        System.out.printf("Pio pio. He  comido y ahora peso %.2f kilos\n",
                getPeso());
    }

    public void ponerHuevos() {
        int numHuevos = new Random().nextInt(6) + 1;
        System.out.printf("He puesto %d huevos\n", numHuevos);
    }

    @Override
    public String getTipoAnimal() {
        return "Ave";
    }

    @Override
    public void hablar() {
        System.out.println("El ave emite un graznido");
    }
}