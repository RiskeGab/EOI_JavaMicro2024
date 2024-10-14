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

    public static void apartado1() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombre = sc.nextLine();
        Path ruta = Paths.get(nombre);
        int suma = 0;

        System.out.println("Suma los números del fichero '" + nombre + "' leyendo línea a línea");
        StringJoiner joiner = new StringJoiner(" + ");

        try(BufferedReader buffer = new BufferedReader(new FileReader(ruta.toString()))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                suma += Integer.parseInt(linea);
                joiner.add(linea);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(joiner + " = " + suma);


        suma = 0;
        System.out.println("Suma los números del fichero '" + nombre + "' leyendo todas las líneas de golpe");
        List<String> lineas = null;
        try {
            lineas = Files.readAllLines(ruta);
            for(String linea:lineas) {
                suma += Integer.parseInt(linea);
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(String.join(" + ", lineas) + " = " + suma);
    }

    public static void apartado2() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombre = sc.nextLine();
        Path ruta = Paths.get(nombre);
        String linea = "";

        try (PrintWriter print = new PrintWriter(ruta.toString())) {
            while(!linea.equals("FIN")) {
                System.out.print("Escribe un texto o FIN para acabar: ");
                linea = sc.nextLine();
                if (!linea.equals("FIN")) {
                    print.println(linea);
                }
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void apartado3() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombre = sc.nextLine();
        Path ruta = Paths.get(nombre);

        double total = 0;
        double media;

        double notaMasAlta = 0;
        double notaMasBaja = 10;        

        String alumnoNotaMasAlta = "";
        String alumnoNotaMasBaja = "";

        try {
            List<String> lineas = Files.readAllLines(ruta);
            for(String linea: lineas) {
                String[] datos = linea.split(";");
                double nota = Double.parseDouble(datos[1]);
                total += nota;

                if (nota > notaMasAlta) {
                    alumnoNotaMasAlta = datos[0];
                    notaMasAlta = nota;
                }
                if (nota < notaMasBaja) {
                    alumnoNotaMasBaja = datos[0];
                    notaMasBaja = nota;
                }
            }
            media = total / lineas.size();
            System.out.println("Media: " + media);
            System.out.println("Nota más alta: " + notaMasAlta);
            System.out.println("Nota más baja: " + notaMasBaja);
            System.out.println("Alumno nota más alta: " + alumnoNotaMasAlta);
            System.out.println("Alumno nota más baja: " + alumnoNotaMasBaja);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void anyadirProducto(String nombreFichero) {
        Path archivo = Paths.get(nombreFichero);
        System.out.println("Introduce el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el precio del producto: ");
        String precio = sc.nextLine(); 

        try (PrintWriter print = new PrintWriter(new FileWriter(archivo.toString(), true))) {
            print.println(nombre  + ";" + precio);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void mostrarProductos(String nombreFichero) {
        Path archivo = Paths.get(nombreFichero);
        try  {
            List<String> lineas = Files.readAllLines(archivo);
            System.out.println(lineas);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void apartado4() {
        System.out.print("Introduce un nombre de archivo: ");
        String nombre = sc.nextLine();
        int opcion;
        do {
            System.out.println("1) Mostrar productos");
            System.out.println("2) Añadir producto");
            System.out.println("0) Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    mostrarProductos(nombre);
                case 2:
                    anyadirProducto(nombre);
                    break;
            }
        } while(opcion != 0);
    }

    // Método principal que llama a cada uno de los apartados
    public static void main(String[] args) {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-...) o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer la opción del usuario
            sc.nextLine();  // Quitar el salto de línea sobrante

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Cambiar la condición para terminar el bucle
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
