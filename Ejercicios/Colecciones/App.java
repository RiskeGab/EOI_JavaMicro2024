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
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in); 

    public static void apartado1() {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(10,20,30,40));
        numeros.add(50);
        numeros.add(60);
        
        numeros.remove(1);
        
        numeros.add(1, 26);
        numeros.add(1, 25);
        
        Collections.reverse(numeros);
        
        System.out.println(numeros);
    }

    public static void apartado2() {
        Empresa emp = new Empresa("Mi empresa", new Direccion("Reyes Católicos", 15), 5);
        emp.addEmpleado(new Empleado("Pepe", 20000));
        emp.addEmpleado(new Empleado("Ana", 18000));
        emp.addEmpleado(new Empleado("Juan", 35000));
        
        Empresa copiaEmp = new Empresa(emp);
        copiaEmp.getEmpleado(0).setNombre("María");
        copiaEmp.getDireccion().setNumero(99);
        copiaEmp.addEmpleado(new Empleado("Paco", 100000));
        
        System.out.println(emp);
        System.out.println("----------------------");
        System.out.println(copiaEmp);
    }
    
    public static void apartado3() {
        Map<String, Persona> personas = new HashMap<String, Persona>();
        personas.put("59245512R", new Persona("23564784Y", "Juan", 28));
        personas.put("23564784Y", new Persona("23564784Y", "Pepe", 35));
        personas.put("54373825O", new Persona("23564784Y", "María", 36));
        
        personas.forEach((dni, persona) -> System.out.println(dni + " => " + persona));
    }
    
    public static void apartado4() {
        List<Integer> numeros = new ArrayList<>(Arrays.asList(2, 14, 20, 34, 27, 567, 1264, 586, 34, 63));
        
        numeros.replaceAll(n -> n / 2);
        System.out.println(numeros);
        
        numeros.removeIf(n -> n % 2 == 1);
        System.out.println(numeros);
    }
    
    public static void apartado5() {
        Set<String> palabras = new HashSet<>();
        String palabra = null;
        
        do {
            System.out.print("Introduce palabra (salir para terminar): ");
            palabra = sc.nextLine();
            if(!palabra.toLowerCase().equals("salir")) {
                if(palabras.contains(palabra)) {
                    System.out.println("La palabra introducida está repetida....");
                } else {
                    palabras.add(palabra);
                }
            }
        } while(!palabra.toLowerCase().equals("salir"));
        
        System.out.println("Palabras introducidas: ");
        palabras.forEach(p -> System.out.println(p));
    }

    public static void main(String[] args) {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-5) o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer la opción del usuario
            sc.nextLine();  // Limpiar el buffer

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Terminar el bucle
            } else {
                try {
                    // Llamar al método correspondiente según la opción seleccionada
                    App.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o se produjo otro problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar 
    }
}
