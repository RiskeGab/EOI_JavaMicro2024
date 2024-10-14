public class Persona {
    private String nombre;
    private int edad;
    
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    public Persona(Persona p) {
        this.nombre = p.nombre;
        this.edad = p.edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    public void saluda() {
        System.out.println("Nombre: " + nombre + ", edad: " + edad);        
    }

    public static Persona[] copiaArray(Persona[] array) {
        Persona[] copia = new Persona[array.length];

        for(int i=0; i<array.length; i++) {
            if (array[i] == null) {
                copia[i] = null;
            }
            else {
                copia[i] = new Persona(array[i]);
            }
        }

        return copia;
    }

    public boolean estoyEnArray(Persona[] array) {
        for(Persona persona:array) {
            if (this == persona) return true;
        }
        return false;
    }
}
