import java.util.Objects;

public record ProductoRecord(String nombre, double precio) {
    public ProductoRecord { // Constructor compacto (solo records)
        Objects.requireNonNull(nombre);
    }

    public ProductoRecord(ProductoRecord p) {
        this(p.nombre, p.precio);
    }

    public double getPrecioImpuestos(double porciento) {
        return precio() * (porciento / 100 + 1);
    }

    // Es como setPrecio pero devuelve un producto nuevo
    public ProductoRecord withPrecio(double precio) { 
        return new ProductoRecord(this.nombre, precio);
    }
}
