import java.util.Scanner;

public class App {
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in);

    // Muestra el nombre y la edad de una Persona, y luego intenta asignar una edad inválida
    public static void apartado1() {
        Persona p = new Persona("Fernando", 36);
        System.out.println("Nombre: " + p.getNombre() + ", edad: " + p.getEdad());

        // Intenta establecer una edad negativa, lo que probablemente cause una validación
        p.setEdad(-36);
        System.out.println("Nombre: " + p.getNombre() + ", edad: " + p.getEdad());        
    }

    // Hace que una Persona salude con el método saluda()
    public static void apartado2() {
        Persona p = new Persona("Fernando", 36);
        p.saluda();     
    }

    // Crea dos objetos Persona, uno como copia del otro, y los modifica y muestra sus saludos
    public static void apartado3() {
        Persona p1 = new Persona("David", 18);
        Persona p2 = new Persona(p1);  // Copia a p1 en p2

        p2.setNombre("Ana");  // Cambia el nombre de la copia
        p2.setEdad(25);  // Cambia la edad de la copia

        p1.saluda();  // Saludo de la persona original
        p2.saluda();  // Saludo de la copia modificada
    }

    // Crea un array de personas y hace que cada una salude
    public static void apartado4() {
        Persona[] personas = {
            new Persona("Ana", 30),
            new Persona("David", 15),
            new Persona("Pepe", 22),
            new Persona("Paco", 45)
        };

        // Itera sobre el array y llama al método saluda() de cada persona
        for(Persona persona:personas) {
            persona.saluda();
        }
    }

    // Crea un array de personas y su copia, luego cambia nombres y muestra saludos
    public static void apartado5() {
        Persona[] personas = {
            new Persona("Ana", 30),
            new Persona("David", 15),
            new Persona("Pepe", 22),
            new Persona("Paco", 45)
        };
        
        // Crea una copia del array original
        Persona[] personasCopia = Persona.copiaArray(personas);

        // Cambia nombres en el array original y en su copia
        personas[0].setNombre("Arturo");
        personasCopia[0].setNombre("Pedro");

        personas[0].saluda();  // Saludo del array original
        personasCopia[0].saluda();  // Saludo del array copiado
    }

    // Crea un array de personas con algunos valores nulos y copia el array
    public static void apartado6() {
        Persona[] personas = {
            new Persona("Ana", 30),
            null,  // Un valor nulo en el array
            new Persona("Pepe", 22),
            null
        };
        
        // Crea una copia del array que contiene valores nulos
        Persona[] personasCopia = Persona.copiaArray(personas);

        personasCopia[0].saluda();  // Llama al método saluda() de la primera persona no nula
    }

    // Verifica si una Persona está en un array de personas
    public static void apartado7() {
        Persona p1 = new Persona("Juan", 89);
        Persona p2 = new Persona("Jose", 90);
        Persona p3 = new Persona("María", 78);
        Persona p4 = new Persona("Consuelo", 99);
        
        Persona[] personas = { p1, p2, p3 };

        // Comprueba si p1 y p4 están en el array
        System.out.println("¿" + p1.getNombre() + " está en el array? " + p1.estoyEnArray(personas));
        System.out.println("¿" + p4.getNombre() + " está en el array? " + p4.estoyEnArray(personas));
    }

    // Crea una empresa y muestra su nombre
    public static void apartado8() {
        Empresa empresa = new Empresa("LDIL");
        System.out.println("Empresa " + empresa.getNombre() + " creada");
    }

    // Crea una empresa, contrata empleados y muestra la lista de empleados
    public static void apartado9() {
        Empresa empresa = new Empresa("LDIL");
        System.out.println("Empresa " + empresa.getNombre() + " creada");    
        
        // Crea varias personas y las contrata en la empresa
        Persona p1 = new Persona("Juan", 64);
        Persona p2 = new Persona("Jose", 63);
        Persona p3 = new Persona("María", 60);

        empresa.contrataEmpleado(p1);
        empresa.contrataEmpleado(p2);
        empresa.contrataEmpleado(p3);

        empresa.mostrarEmpleados();  // Muestra los empleados de la empresa
    }

    // Contrata varios empleados en una empresa, luego despide a uno por posición y otro por nombre
    public static void apartado10() {
        Empresa empresa = new Empresa("LDIL");
        System.out.println("Empresa " + empresa.getNombre() + " creada");    
        
        // Crea varias personas y las contrata en la empresa
        Persona p1 = new Persona("Juan", 64);
        Persona p2 = new Persona("Jose", 63);
        Persona p3 = new Persona("Merche", 60);
        Persona p4 = new Persona("Luis", 61);
        Persona p5 = new Persona("Gabriel", 60);

        empresa.contrataEmpleado(p1);
        empresa.contrataEmpleado(p2);
        empresa.contrataEmpleado(p3);
        empresa.contrataEmpleado(p4);
        empresa.contrataEmpleado(p5);        

        System.out.println("\nTodos los empleados:");
        empresa.mostrarEmpleados();  // Muestra todos los empleados

        System.out.println("\nDespués de despedir al de la posición 2:");
        empresa.despideEmpleado(2);  // Despide al empleado en la posición 2
        empresa.mostrarEmpleados();

        System.out.println("\nDespués de despedir a Luis:");
        empresa.despideEmpleado("Luis");  // Despide al empleado con nombre "Luis"
        empresa.mostrarEmpleados();
    }

    // Método principal que ejecuta los apartados según la selección del usuario
    public static void main(String[] args) throws Exception {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-10) o 0 para salir: ");
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
