import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Empresas_v1 {
    // Mapa estático para almacenar las empresas creadas. La clave es el nombre de la empresa.
    static Map<String, Empresa> empresas = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarDatos(); // Cargar los datos almacenados previamente de empresas y empleados.
        mostrarMenu(); // Mostrar el menú principal al usuario.
        scanner.close(); // Cerrar el scanner una vez finalizado el programa.
    }

    // Método que muestra el menú principal y permite al usuario elegir una opción.
    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Crear Empresa");
            System.out.println("2. Listar Empresas");
            System.out.println("3. Añadir Empleado a Empresa");
            System.out.println("4. Listar Empleados de Empresa");
            System.out.println("5. Guardar y Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer después de leer un entero.

            // Ejecutar la opción seleccionada por el usuario.
            switch (opcion) {
                case 1:
                    crearEmpresa(); // Crear una nueva empresa.
                    break;
                case 2:
                    listarEmpresas(); // Listar todas las empresas creadas.
                    break;
                case 3:
                    añadirEmpleadoAEmpresa(); // Añadir un nuevo empleado a una empresa existente.
                    break;
                case 4:
                    listarEmpleadosDeEmpresa(); // Listar los empleados de una empresa específica.
                    break;
                case 5:
                    guardarDatos(); // Guardar todos los datos de empresas y empleados, y salir.
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5); // El bucle se mantiene hasta que el usuario elige la opción de guardar y salir.
    }

    // Método para crear una nueva empresa.
    public static void crearEmpresa() {
        System.out.println("=== Crear Empresa ===");
        System.out.print("Nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine(); // Leer el nombre de la nueva empresa.
        
        // Verificar si la empresa ya existe.
        if (empresas.containsKey(nombreEmpresa)) {
            System.out.println("La empresa ya existe.");
            return;
        }
        // Solicitar los datos de la dirección de la empresa.
        System.out.print("Calle: ");
        String calle = scanner.nextLine();
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer.

        // Crear la dirección y la empresa, luego agregarla al mapa de empresas.
        Direccion direccion = new Direccion(calle, numero);
        Empresa empresa = new Empresa(nombreEmpresa, direccion, 10);
        empresas.put(nombreEmpresa, empresa);

        System.out.println("Empresa creada con éxito.");
    }

    // Método para listar todas las empresas almacenadas.
    public static void listarEmpresas() {
        System.out.println("=== Listar Empresas ===");
        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas."); // Mensaje si no hay empresas.
        } else {
            // Mostrar cada empresa registrada.
            int i = 1;
            for (String nombreEmpresa : empresas.keySet()) {
                System.out.println(i + ". " + nombreEmpresa);
                i++;
            }
        }
    }

    // Método para añadir un empleado a una empresa existente.
    public static void añadirEmpleadoAEmpresa() {
        listarEmpresas(); // Mostrar las empresas disponibles para que el usuario elija.
        System.out.print("Nombre de la empresa para añadir empleado: ");
        String nombreEmpresa = scanner.nextLine(); // Leer el nombre de la empresa seleccionada.

        Empresa empresa = empresas.get(nombreEmpresa); // Obtener la empresa correspondiente.
        if (empresa != null) {
            // Solicitar los datos del nuevo empleado.
            System.out.print("Nombre del empleado: ");
            String nombreEmpleado = scanner.nextLine();
            System.out.print("Salario del empleado: ");
            int salario = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer.

            // Crear el nuevo empleado y añadirlo a la empresa.
            Empleado empleado = new Empleado(nombreEmpleado, salario);
            empresa.addEmpleado(empleado);

            System.out.println("Empleado añadido con éxito.");
        } else {
            System.out.println("La empresa no existe."); // Mensaje si la empresa no se encuentra.
        }
    }

    // Método para listar los empleados de una empresa específica.
    public static void listarEmpleadosDeEmpresa() {
        listarEmpresas(); // Mostrar las empresas disponibles.
        System.out.print("Nombre de la empresa para listar empleados: ");
        String nombreEmpresa = scanner.nextLine(); // Leer el nombre de la empresa seleccionada.

        Empresa empresa = empresas.get(nombreEmpresa); // Obtener la empresa correspondiente.
        if (empresa != null) {
            // Mostrar los empleados de la empresa.
            System.out.println(empresa);
        } else {
            System.out.println("La empresa no existe."); // Mensaje si la empresa no se encuentra.
        }
    }

    // Método para guardar los datos de empresas y empleados en un archivo de texto.
    public static void guardarDatos() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("empresas.txt"))) {
            // Guardar los datos de cada empresa.
            for (Empresa empresa : empresas.values()) {
                writer.println(empresa.getNombre() + ";" + empresa.getDireccion().getCalle() + ";" + empresa.getDireccion().getNumero());
                // Guardar los empleados asociados a cada empresa.
                for (Empleado empleado : empresa.empleados) {
                    writer.println("EMP;" + empleado.getNombre() + ";" + empleado.getSalario());
                }
            }
            System.out.println("Datos guardados. Saliendo...");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage()); // Mensaje en caso de error al guardar.
        }
    }

    // Método para cargar los datos desde el archivo al iniciar el programa.
    public static void cargarDatos() {
        Path path = Paths.get("empresas.txt"); // Definir la ruta del archivo.
        if (Files.exists(path)) {
            try {
                // Leer todas las líneas del archivo.
                List<String> lineas = Files.readAllLines(path);
                Empresa empresaActual = null;

                // Procesar cada línea del archivo.
                for (String linea : lineas) {
                    String[] partes = linea.split(";");
                    if (partes[0].equals("EMP")) {
                        // Si es un empleado, añadirlo a la empresa actual.
                        Empleado empleado = new Empleado(partes[1], Integer.parseInt(partes[2]));
                        if (empresaActual != null) {
                            empresaActual.addEmpleado(empleado);
                        }
                    } else {
                        // Si es una empresa, crearla y actualizar la empresa actual.
                        Direccion direccion = new Direccion(partes[1], Integer.parseInt(partes[2]));
                        empresaActual = new Empresa(partes[0], direccion, 10);
                        empresas.put(partes[0], empresaActual);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al cargar datos: " + e.getMessage()); // Mensaje en caso de error al cargar.
            }
        }
    }
}
