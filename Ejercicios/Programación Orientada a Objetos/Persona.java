public class Persona {
    private String nombre;  // Nombre de la persona
    private int edad;  // Edad de la persona
    
    // Constructor: inicializa los atributos nombre y edad, valida que la edad sea no negativa
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        if (edad >= 0) {  // Verificación de que la edad sea válida
            this.edad = edad;
        }
    }

    // Constructor copia: crea una nueva Persona a partir de otra, copiando nombre y edad
    public Persona(Persona p) {
        this.nombre = p.nombre;
        this.edad = p.edad;
    }

    // Getter para el nombre de la persona
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre de la persona
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para la edad de la persona
    public int getEdad() {
        return edad;
    }

    // Setter para la edad, solo establece el valor si es no negativa
    public void setEdad(int edad) {
        if (edad >= 0) {  // Verificación de que la edad sea válida
            this.edad = edad;
        }
    }

    // Método para que la persona salude, mostrando su nombre y edad
    public void saluda() {
        System.out.println("Nombre: " + nombre + ", edad: " + edad);        
    }

    // Método estático para hacer una copia profunda de un array de personas
    public static Persona[] copiaArray(Persona[] array) {
        Persona[] copia = new Persona[array.length];  // Crea un nuevo array del mismo tamaño

        // Itera sobre el array original
        for(int i = 0; i < array.length; i++) {
            if (array[i] == null) {  // Si la posición está vacía, también lo estará en la copia
                copia[i] = null;
            } else {
                // Crea una nueva Persona copiando los datos de la original
                copia[i] = new Persona(array[i]);
            }
        }

        return copia;  // Devuelve la copia del array
    }

    // Método para verificar si esta Persona está en el array dado
    public boolean estoyEnArray(Persona[] array) {
        // Itera sobre el array y compara las referencias de los objetos
        for(Persona persona : array) {
            if (this == persona) return true;  // Si la referencia es la misma, devuelve true
        }
        return false;  // Si no encuentra la persona, devuelve false
    }
}
