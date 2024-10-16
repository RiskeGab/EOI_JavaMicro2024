
public class Empresa {
	String nombre;
	Direccion direccion;
	Empleado[] empleados;
	int numEmpleados;
	
	public Empresa(String nombre, Direccion direccion, int capacidad) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.empleados = new Empleado[capacidad];
		numEmpleados = 0;
	}
	
	public Empresa(Empresa e) {
		this.nombre = e.nombre;
		this.numEmpleados = e.numEmpleados;
		this.direccion = new Direccion(e.direccion);
		this.empleados = new Empleado[e.empleados.length];
		for(int i = 0; i < e.numEmpleados; i++) {
			this.empleados[i] = new Empleado(e.empleados[i]);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	
	public void addEmpleado(Empleado e) {
		if(numEmpleados < empleados.length) {
			empleados[numEmpleados++] = e;
		}
	}
	
	public Empleado getEmpleado(int pos) {
		if(pos >= 0 && pos < numEmpleados) {
			return empleados[pos];
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		String empresa = "Empresa '" + nombre + "'\n";
		empresa += "Dirección: " + direccion + "\n";
		empresa += "Empleados:\n";
		for(int i = 0; i < numEmpleados; i++) {
			empresa += "- " + empleados[i] + "\n";
		}
		
		return empresa;
	}
}
