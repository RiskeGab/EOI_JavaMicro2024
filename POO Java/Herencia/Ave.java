import java.util.Random;

public class Ave extends Animal {
    private boolean puedeVolar;

    public Ave(boolean puedeVolar) {
        this.puedeVolar = puedeVolar;
    }

    public boolean getPuedeVolar() {
        return puedeVolar;
    }

    public void ponerHuevos() {
        int numHuevos = new Random().nextInt(6) + 1;
        System.out.printf("He puesto %d huevos\n", numHuevos);
        System.out.println(getNombre());
        setNombre("Pepito");
    }
}