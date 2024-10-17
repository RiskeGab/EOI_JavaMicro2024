import java.util.Random;

public abstract class Animal implements IHablador {
    private double peso;
    private String nombre;

    public Animal(double peso, String nombre) {
        this.peso = peso;
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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

    // Método abstracto
    public abstract String getTipoAnimal();

    @Override
    public String toString() {
        return String.format("%s: %.2f kilos", nombre, peso);
    }
    
    @Override
    public boolean equals(Object obj) {
        // Comprobamos que el objeto no es nulo y sea Animal o derivado
        if(obj == null || ! (obj instanceof Animal)) return false;
        Animal a = (Animal)obj; // Casting -> Igual que hacer (Animal)obj.
        return nombre.equals(a.nombre) && peso == a.peso;
    }
}