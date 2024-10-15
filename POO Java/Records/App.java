public class App {

    public static void ejemploRecord() {
        ProductoRecord p = new ProductoRecord("Mesa", 100);
        System.out.println(p.nombre() + " - " + p.precio());
        System.out.println(p);
        ProductoRecord p2 = new ProductoRecord("Mesa", 100);
        System.out.println(p.equals(p2));

        System.out.println(p.getPrecioImpuestos(20)); // 120
        
        // Producto p3 = new ProductoRecord(null, 30); // Exception in thread "main" java.lang.NullPointerException
        p = p.withPrecio(145.95);
        System.out.println(p); // ProductoRecord[nombre=Mesa, precio=145.95]
    }

    public static void ejemploClass() {
        ProductoClass p = new ProductoClass("Mesa", 100);
        System.out.println(p.nombre() + " - " + p.precio());
        System.out.println(p);
        ProductoClass p2 = new ProductoClass("Mesa", 100);
        System.out.println(p.equals(p2));

        System.out.println(p.getPrecioImpuestos(20)); // 120
        
        // ProductoClass p3 = new ProductoClass(null, 30); // Exception in thread "main" java.lang.NullPointerException
        p = p.withPrecio(145.95);
        System.out.println(p); // ProductoClass[nombre=Mesa, precio=145.95]
    }

    public static void main(String[] args) {
        ProductoRecord p = new ProductoRecord("Mesa", 100);
        System.out.println(p.nombre() + " - " + p.precio());
        System.out.println(p);
        ProductoRecord p2 = new ProductoRecord("Mesa", 100);
        System.out.println(p.equals(p2));

        System.out.println(p.getPrecioImpuestos(20)); // 120
        
        // Producto p3 = new Producto(null, 30); // Exception in thread "main" java.lang.NullPointerException
        p = p.withPrecio(145.95);
        System.out.println(p); // Producto[nombre=Mesa, precio=145.95]
    }
}
