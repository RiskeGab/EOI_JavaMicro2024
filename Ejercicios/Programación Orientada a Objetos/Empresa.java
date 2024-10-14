public class Empresa {
    private String nombre;
    private Persona[] empleados;
    private int numEmpleados;
    
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.empleados = new Persona[100];
        this.numEmpleados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Persona[] empleados) {
        this.empleados = empleados;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public void contrataEmpleado(Persona empleado) {
        if (numEmpleados < empleados.length) {
            empleados[numEmpleados] = empleado;
            numEmpleados++;
        }
    }

    public void mostrarEmpleados() {
        for(int i=0; i < numEmpleados; i++) {
            System.out.println("Nombre: " + empleados[i].getNombre() + " - Edad: " + empleados[i].getEdad());
        }
    }

    // ["Juan", "Jose", "Merche", "Luis", "Gabriel"];
    public void despideEmpleado(int pos) {
        for(int i=pos; i < numEmpleados - 1; i++) {
            empleados[i] = empleados[i+1];
        }
        numEmpleados--;
    } 

    // ["Juan", "Jose", "Merche", "Luis", "Gabriel"];
    public void despideEmpleado(String nombre) {
        for(int i=0; i < numEmpleados; i++) {
            if (empleados[i].getNombre().equals(nombre)) {
                despideEmpleado(i);
                break;
            }
        }
    } 
}
