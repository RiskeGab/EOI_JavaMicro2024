import java.util.Random;

public class Animal {
    private double peso;
    private String nombre;

    public Animal() {
        this.peso = 1;
        this.nombre = "Animal desconocido";
    }

    public double getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void comer() {
        peso += new Random().nextDouble() * 0.5;
        System.out.printf("Ñam ñam. Ahora peso %.2f kilos\n", peso);
    }
}