import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicios5 {
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in); 

    // Lee un archivo de números y los suma, mostrando los resultados
    public static void apartado1() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombre = sc.nextLine();  // Leer el nombre del archivo
        Path ruta = Paths.get(nombre);  // Crear la ruta del archivo
        int suma = 0;

        System.out.println("Suma los números del fichero '" + nombre + "' leyendo línea a línea");
        StringJoiner joiner = new StringJoiner(" + ");  // Unir las líneas para mostrar la operación

        // Leer el archivo línea por línea
        try(BufferedReader buffer = new BufferedReader(new FileReader(ruta.toString()))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                suma += Integer.parseInt(linea);  // Sumar el valor numérico de cada línea
                joiner.add(linea);  // Añadir la línea al joiner
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
        System.out.println(joiner + " = " + suma);  // Mostrar la suma final

        suma = 0;
        System.out.println("Suma los números del fichero '" + nombre + "' leyendo todas las líneas de golpe");
        List<String> lineas = null;
        try {
            lineas = Files.readAllLines(ruta);  // Leer todas las líneas de una vez
            for(String linea:lineas) {
                suma += Integer.parseInt(linea);  // Sumar cada línea
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }

        System.out.println(String.join(" + ", lineas) + " = " + suma);  // Mostrar la suma final
    }

    // Escribe líneas de texto en un archivo hasta que se introduce "FIN"
    public static void apartado2() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombre = sc.nextLine();  // Leer el nombre del archivo
        Path ruta = Paths.get(nombre);  // Crear la ruta del archivo
        String linea = "";

        // Abrir el archivo para escritura
        try (PrintWriter print = new PrintWriter(ruta.toString())) {
            while(!linea.equals("FIN")) {
                System.out.print("Escribe un texto o FIN para acabar: ");
                linea = sc.nextLine();  // Leer la línea del usuario
                if (!linea.equals("FIN")) {
                    print.println(linea);  // Escribir en el archivo si no es "FIN"
                }
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
    }

    // Calcula la media de notas y muestra la más alta y más baja de un archivo
    public static void apartado3() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombre = sc.nextLine();  // Leer el nombre del archivo
        Path ruta = Paths.get(nombre);  // Crear la ruta del archivo

        double total = 0;
        double media;

        double notaMasAlta = 0;
        double notaMasBaja = 10;        

        String alumnoNotaMasAlta = "";
        String alumnoNotaMasBaja = "";

        try {
            List<String> lineas = Files.readAllLines(ruta);  // Leer todas las líneas
            for(String linea: lineas) {
                String[] datos = linea.split(";");  // Dividir línea en nombre y nota
                double nota = Double.parseDouble(datos[1]);  // Convertir nota a double
                total += nota;

                // Determinar nota más alta y más baja
                if (nota > notaMasAlta) {
                    alumnoNotaMasAlta = datos[0];
                    notaMasAlta = nota;
                }
                if (nota < notaMasBaja) {
                    alumnoNotaMasBaja = datos[0];
                    notaMasBaja = nota;
                }
            }
            media = total / lineas.size();  // Calcular la media
            System.out.println("Media: " + media);
            System.out.println("Nota más alta: " + notaMasAlta);
            System.out.println("Nota más baja: " + notaMasBaja);
            System.out.println("Alumno nota más alta: " + alumnoNotaMasAlta);
            System.out.println("Alumno nota más baja: " + alumnoNotaMasBaja);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
    }

    // Añade un producto (nombre y precio) a un archivo
    public static void anyadirProducto(Path archivo) {
        System.out.println("Introduce el nombre del producto: ");
        String nombre = sc.nextLine();  // Leer el nombre del producto
        System.out.println("Introduce el precio del producto: ");
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
            List<String> lineas = Files.readAllLines(archivo);  // Leer todas las líneas
            System.out.println(lineas);  // Mostrar los productos
        }
        catch (Exception e) {
            System.err.println(e.getMessage());  // Manejo de errores
        }
    }

    // Borra un producto de un archivo si coincide con el nombre proporcionado
    public static void borrarProducto(Path archivo) {
        System.out.println("Introduce el nombre del producto a borrar: ");
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
        System.out.println("Introduce el nombre del producto a editar: ");
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
                    System.out.println("Introduce el nuevo nombre del producto: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.println("Introduce el nuevo precio del producto: ");
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

    // Muestra un menú para gestionar productos de un archivo
    public static void apartado4() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombreFichero = sc.nextLine();  // Leer el nombre del archivo
        Path archivo = Paths.get(nombreFichero);  // Crear la ruta del archivo

        int opcion;
        do {
            System.out.println("1) Mostrar productos");
            System.out.println("2) Añadir producto");
            System.out.println("3) Editar producto");
            System.out.println("4) Borrar producto");
            System.out.println("0) Salir");
            opcion = sc.nextInt();  // Leer la opción del menú
            sc.nextLine();  // Limpiar el buffer

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
    }

    // Método principal que llama a cada uno de los apartados
    public static void main(String[] args) {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-4) o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer la opción del usuario
            sc.nextLine();  // Limpiar el buffer

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Terminar el bucle
            } else {
                try {
                    // Llamar al método correspondiente según la opción seleccionada
                    Ejercicios5.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o se produjo otro problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar 
    }
}
