import java.util.ArrayList;
import java.util.List;

public class Empresa {
    String nombre;
    Direccion direccion;
    List<Empleado> empleados;
    
    public Empresa(String nombre, Direccion direccion, int capacidad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.empleados = new ArrayList<>(capacidad);
    }
    
    public Empresa(Empresa e) {
        this.nombre = e.nombre;
        this.direccion = new Direccion(e.direccion);
        this.empleados = new ArrayList<>();
        for(Empleado empleado: e.empleados) {
            this.empleados.add(new Empleado(empleado));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    
    public void addEmpleado(Empleado e) {
        empleados.add(e);
    }
    
    public Empleado getEmpleado(int pos) {
        if(pos >= 0 && pos < empleados.size()) {
            return empleados.get(pos);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        String empresa = "Empresa '" + nombre + "'\n";
        empresa += "Dirección: " + direccion + "\n";
        empresa += "Empleados:\n";
        for(Empleado empleado: empleados) {
            empresa += "- " + empleado + "\n";
        }
        
        return empresa;
    }
}
