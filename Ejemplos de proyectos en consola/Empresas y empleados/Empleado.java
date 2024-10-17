
public class Empleado {
    private String nombre;
    private int salario;
    
    public Empleado(String nombre, int salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
    
    public Empleado(Empleado e) {
        this.nombre = e.nombre;
        this.salario = e.salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nombre + " (" + salario + "€)";
    }
}
