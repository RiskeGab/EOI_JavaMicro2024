import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Productos_v1 {
    // Scanner a nivel de clase para reutilizarlo en todos los métodos
    private static Scanner sc = new Scanner(System.in); 

    // Añade un producto (nombre y precio) a un archivo
    public static void anyadirProducto(Path archivo) {
        System.out.print("Introduce el nombre del producto: ");
        String nombre = sc.nextLine();  // Leer el nombre del producto
        System.out.print("Introduce el precio del producto: ");
        String precio = sc.nextLine();  // Leer el precio del producto

        // Escribir el producto en el archivo
        try (PrintWriter print = new PrintWriter(new FileWriter(archivo.toString(), true))) {
            print.println(nombre  + ";" + precio);  // Guardar el producto
        }
        catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
    }

    // Muestra todos los productos en el archivo
    public static void mostrarProductos(Path archivo) {
        try  {
              // Leer todas las líneas del fichero
            List<String> lineas = Files.readAllLines(archivo);

            // Recorrer la lista y mostrar cada línea individualmente
            for (String linea : lineas) {
                System.out.println(linea);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
    }

    // Borra un producto de un archivo si coincide con el nombre proporcionado
    public static void borrarProducto(Path archivo) {
        System.out.print("Introduce el nombre del producto a borrar: ");
        String productoABorrar = sc.nextLine();  // Leer el producto a borrar

        try {
            List<String> lineas = Files.readAllLines(archivo);  // Leer todas las líneas
            String regex = "^" + productoABorrar + ";.+$";
            boolean productoEncontrado = lineas.removeIf(linea -> linea.matches(regex));  // Eliminar la línea correspondiente

            if (productoEncontrado) {
                Files.write(archivo, lineas);  // Reescribir el archivo con las líneas actualizadas
                System.out.println("Producto '" + productoABorrar + "' ha sido borrado.\n");
            } else {
                System.out.println("Producto '" + productoABorrar + "' no encontrado.\n");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
    }

    // Edita un producto en el archivo si coincide con el nombre proporcionado
    public static void editarProducto(Path archivo) {
        System.out.print("Introduce el nombre del producto a editar: ");
        String productoAEditar = sc.nextLine();  // Leer el producto a editar
    
        try {
            List<String> lineas = Files.readAllLines(archivo);  // Leer todas las líneas
            String regex = "^" + productoAEditar + ";.+$";  // Expresión regular para encontrar el producto
    
            boolean productoEncontrado = false;
            for (int i = 0; i < lineas.size() && !productoEncontrado; i++) {
                String linea = lineas.get(i);
                if (linea.matches(regex)) {
                    productoEncontrado = true;
    
                    // Solicitar nuevos datos del producto
                    System.out.print("Introduce el nuevo nombre del producto: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Introduce el nuevo precio del producto: ");
                    String nuevoPrecio = sc.nextLine();
    
                    // Actualizar la línea con los nuevos valores
                    lineas.set(i, nuevoNombre + ";" + nuevoPrecio);
                }
            }
    
            if (productoEncontrado) {
                Files.write(archivo, lineas);  // Reescribir el archivo con las líneas actualizadas
                System.out.println("Producto '" + productoAEditar + "' ha sido editado.\n");
            } else {
                System.out.println("Producto '" + productoAEditar + "' no encontrado.\n");
            }
    
        } catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
    }    

    // Muestra un menú para gestionar los productos de un archivo
    public static void menu() {
        System.out.print("\nIntroduce un nombre de archivo: ");
        String nombreFichero = sc.nextLine();  // Leer el nombre del archivo
        Path archivo = Paths.get(nombreFichero);  // Crear la ruta del archivo

        int opcion;
        do {
            System.out.println();
            System.out.println("1) Mostrar productos");
            System.out.println("2) Añadir producto");
            System.out.println("3) Editar producto");
            System.out.println("4) Borrar producto");
            System.out.println("0) Salir");
            System.out.print("Introduce opcion: ");
            opcion = sc.nextInt();  // Leer la opción del menú
            sc.nextLine();  // Limpiar el buffer
            System.out.println();

            // Ejecutar la opción seleccionada
            switch(opcion) {
                case 1:
                    mostrarProductos(archivo);
                    break;
                case 2:
                    anyadirProducto(archivo);
                    break;
                case 3:
                    editarProducto(archivo);
                    break;
                case 4:
                    borrarProducto(archivo);
                    break;
            }
        } while(opcion != 0);  // Repetir hasta que el usuario decida salir

        sc.close();  // Cerrar el Scanner al finalizar 
    }

    public static void main(String[] args) {
        menu();
    }
}
