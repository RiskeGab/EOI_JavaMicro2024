
public class Direccion {
	private String calle;
	private int numero;
	
	public Direccion(String calle, int numero) {
		this.calle = calle;
		this.numero = numero;
	}
	
	public Direccion(Direccion d) {
		this.calle = d.calle;
		this.numero = d.numero;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Calle '" + calle + "', numero " + numero;
	}
}
