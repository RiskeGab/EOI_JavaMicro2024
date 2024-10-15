import java.util.Objects;

public class ProductoClass {
    final String nombre;
    final double precio;
    
    public ProductoClass(String nombre, double precio) {
        Objects.requireNonNull(nombre);
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoClass(ProductoClass p) {
        this(p.nombre, p.precio);
    }

    public String nombre() {
        return nombre;
    }

    public double precio() {
        return precio;
    }

    public double getPrecioImpuestos(double porciento) {
        return precio() * (porciento / 100 + 1);
    }

    // Es como setPrecio pero devuelve un producto nuevo
    public ProductoClass withPrecio(double precio) { 
        return new ProductoClass(this.nombre, precio);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProductoClass other = (ProductoClass) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Producto2 [nombre=" + nombre + ", precio=" + precio + "]";
    }

    
}
