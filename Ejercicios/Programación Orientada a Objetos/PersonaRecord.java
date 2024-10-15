public record PersonaRecord(String nombre, int edad) {
    public PersonaRecord(PersonaRecord p) {
        this(p.nombre(), p.edad());
    }

    public void saluda() {
        System.out.printf("%s tiene %d años\n", nombre(), edad());
    }
}
