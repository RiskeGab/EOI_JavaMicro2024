public record Persona(String nombre, int edad) implements IHablador {
    @Override
    public void hablar() {
        System.out.printf("Hola, soy %s y tengo %d años\n", nombre, edad);
    }
}
