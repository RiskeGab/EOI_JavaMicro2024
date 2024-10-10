public record Persona(String nombre, int edad) {
    @Override
    public final String toString() {
        return String.format("%s (%d)", nombre, edad);
    }
}
