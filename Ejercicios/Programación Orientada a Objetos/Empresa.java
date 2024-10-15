public class Empresa {
    private String nombre;  // Nombre de la empresa
    private Persona[] empleados;  // Array de empleados de la empresa
    private int numEmpleados;  // Número actual de empleados en la empresa
    
    // Constructor: inicializa el nombre de la empresa, un array de empleados con tamaño 100, y el número de empleados en 0
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new Persona[100];
        this.numEmpleados = 0;
    }

    // Getter para el nombre de la empresa
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre de la empresa
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para obtener el array de empleados
    public Persona[] getEmpleados() {
        return empleados;
    }

    // Setter para establecer un nuevo array de empleados
    public void setEmpleados(Persona[] empleados) {
        this.empleados = empleados;
    }

    // Getter para obtener el número actual de empleados
    public int getNumEmpleados() {
        return numEmpleados;
    }

    // Setter para establecer el número de empleados
    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    // Método para contratar a un nuevo empleado
    public void contrataEmpleado(Persona empleado) {
        // Si aún hay espacio en el array, añade el empleado y aumenta el número de empleados
        if (numEmpleados < empleados.length) {
            empleados[numEmpleados] = empleado;
            numEmpleados++;
        }
    }

    // Método para mostrar todos los empleados de la empresa
    public void mostrarEmpleados() {
        // Recorre hasta el número actual de empleados y muestra su nombre y edad
        for(int i = 0; i < numEmpleados; i++) {
            System.out.println("Nombre: " + empleados[i].getNombre() + " - Edad: " + empleados[i].getEdad());
        }
    }

    // Método para despedir a un empleado por su posición en el array
    public void despideEmpleado(int pos) {
        // Desplaza todos los empleados desde la posición a eliminar hacia la izquierda
        for(int i = pos; i < numEmpleados - 1; i++) {
            empleados[i] = empleados[i + 1];
        }
        numEmpleados--;  // Disminuye el número de empleados
    } 

    // Método para despedir a un empleado por su nombre
    public void despideEmpleado(String nombre) {
        // Busca el empleado por su nombre
        for(int i = 0; i < numEmpleados; i++) {
            // Si el nombre coincide, llama al método que despide por posición
            if (empleados[i].getNombre().equals(nombre)) {
                despideEmpleado(i);  // Despide al empleado en la posición encontrada
                break;  // Termina el bucle una vez encontrado el empleado
            }
        }
    } 
}
