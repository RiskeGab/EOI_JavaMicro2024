import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {
    // Scanner a nivel de clase para reutilizarlo en los métodos que lo requieran
    private static Scanner sc = new Scanner(System.in); 

    // Apartado 1: Manipulaciones básicas con una lista de números
    public static void apartado1() {
        // Crear una lista inicial con los números 10, 20, 30 y 40
        List<Integer> numeros = new ArrayList<>(Arrays.asList(10,20,30,40));

        // Añadir los números 50 y 60
        numeros.add(50);
        numeros.add(60);
        
        // Eliminar el número en la posición 1 (equivalente a eliminar el 20)
        numeros.remove(1);
        
        // Insertar los números 25 y 26 en la posición 1 (antes del 30)
        numeros.add(1, 26);
        numeros.add(1, 25);
        
        // Invertir el orden de la lista
        Collections.reverse(numeros);
        
        // Mostrar la lista resultante
        System.out.println(numeros);
    }

    // Apartado 2: Gestión de empleados y copia de objetos
    public static void apartado2() {
        // Crear una empresa y añadir empleados
        Empresa emp = new Empresa("Mi empresa", new Direccion("Reyes Católicos", 15), 5);
        emp.addEmpleado(new Empleado("Pepe", 20000));
        emp.addEmpleado(new Empleado("Ana", 18000));
        emp.addEmpleado(new Empleado("Juan", 35000));
        
        // Crear una copia de la empresa con modificaciones
        Empresa copiaEmp = new Empresa(emp);
        copiaEmp.getEmpleado(0).setNombre("María"); // Cambiar el nombre del primer empleado en la copia
        copiaEmp.getDireccion().setNumero(99); // Cambiar la dirección en la copia
        copiaEmp.addEmpleado(new Empleado("Paco", 100000)); // Añadir un nuevo empleado
        
        // Mostrar la empresa original y la copia
        System.out.println(emp);
        System.out.println("----------------------");
        System.out.println(copiaEmp);
    }
    
    // Apartado 3: Uso de un mapa con DNI como clave y Persona como valor
    public static void apartado3() {
        Map<String, Persona> personas = new HashMap<>();
        // Añadir personas al mapa
        personas.put("59245512R", new Persona("59245512R", "Juan", 28));
        personas.put("23564784Y", new Persona("23564784Y", "Pepe", 35));
        personas.put("54373825O", new Persona("54373825O", "María", 36));
        
        // Recorrer y mostrar las personas con su DNI
        personas.forEach((dni, persona) -> System.out.println(dni + " => " + persona));
    }
    
    // Apartado 4: Operaciones con una lista de números
    public static void apartado4() {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(2, 14, 20, 34, 27, 567, 1264, 586, 34, 63));
        
        // Dividir todos los números por 2
        numeros.replaceAll(n -> n / 2);
        System.out.println(numeros);
        
        // Eliminar los números impares
        numeros.removeIf(n -> n % 2 == 1);
        System.out.println(numeros);
    }
    
    // Apartado 5: Conjunto de palabras introducidas por el usuario
    public static void apartado5() {
        Set<String> palabras = new HashSet<>();
        String palabra = null;
        
        // Leer palabras hasta que el usuario escriba "salir"
        do {
            System.out.print("Introduce palabra (salir para terminar): ");
            palabra = sc.nextLine();
            if(!palabra.toLowerCase().equals("salir")) {
                if(palabras.contains(palabra)) {
                    System.out.println("La palabra introducida está repetida.");
                } else {
                    palabras.add(palabra);
                }
            }
        } while(!palabra.toLowerCase().equals("salir"));
        
        // Mostrar las palabras introducidas
        System.out.println("Palabras introducidas: ");
        palabras.forEach(p -> System.out.println(p));
    }

    // Método principal: Menú de selección de apartados
    public static void main(String[] args) {
        boolean ejecutando = true;  // Controlar el bucle del menú

        // Mostrar el menú y ejecutar el apartado seleccionado
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-5) o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer opción del usuario
            sc.nextLine();  // Limpiar el buffer

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Salir del bucle
            } else {
                try {
                    // Ejecutar el método correspondiente al apartado seleccionado
                    App.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o se produjo otro problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar
    }
}
