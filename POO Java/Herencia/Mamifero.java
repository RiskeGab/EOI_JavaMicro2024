public class Mamifero extends Animal {
    private boolean carnivoro;

    public Mamifero(double peso, String nombre, boolean carnivoro) {
        super(peso, nombre);
        this.carnivoro = carnivoro;
    }

    @Override
    public void comer() {
        super.comer();
        System.out.println("He comido: " + (carnivoro ? "carne" : "hierba"));
    }

    public String getTipoAnimal() {
        return "Mamífero";
    }
}
