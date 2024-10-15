import java.util.Scanner;

public class App {
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in);

    public static void apartado1() {
        Persona p = new Persona("Fernando", 36);
        System.out.println("Nombre: " + p.getNombre() + ", edad: " + p.getEdad());

        p.setEdad(-36);
        System.out.println("Nombre: " + p.getNombre() + ", edad: " + p.getEdad());        
    }

    public static void apartado2() {
        Persona p = new Persona("Fernando", 36);
        p.saluda();     
    }

    public static void apartado3() {
        Persona p1 = new Persona("David", 18);
        Persona p2 = new Persona(p1);

        p2.setNombre("Ana");
        p2.setEdad(25);

        p1.saluda();
        p2.saluda();
    }

    public static void apartado4() {
        Persona[] personas = {
            new Persona("Ana", 30),
            new Persona("David", 15),
            new Persona("Pepe", 22),
            new Persona("Paco", 45)
        };

        for(Persona persona:personas) {
            persona.saluda();
        }
    }

    public static void apartado5() {
        Persona[] personas = {
            new Persona("Ana", 30),
            new Persona("David", 15),
            new Persona("Pepe", 22),
            new Persona("Paco", 45)
        };
        
        Persona[] personasCopia = Persona.copiaArray(personas);

        personas[0].setNombre("Arturo");
        personasCopia[0].setNombre("Pedro");

        personas[0].saluda();
        personasCopia[0].saluda();
    }

    public static void apartado6() {
        Persona[] personas = {
            new Persona("Ana", 30),
            null,
            new Persona("Pepe", 22),
            null
        };
        
        Persona[] personasCopia = Persona.copiaArray(personas);

        personasCopia[0].saluda();
    }

    public static void apartado7() {
        Persona p1 = new Persona("Juan", 89);
        Persona p2 = new Persona("Jose", 90);
        Persona p3 = new Persona("María", 78);
        Persona p4 = new Persona("Consuelo", 99);
        
        Persona[] personas = { p1, p2, p3 };

        System.out.println("¿" + p1.getNombre() + " está en el array? " + p1.estoyEnArray(personas));
        System.out.println("¿" + p4.getNombre() + " está en el array? " + p4.estoyEnArray(personas));
    }

    public static void apartado8() {
        Empresa empresa = new Empresa("LDIL");
        System.out.println("Empresa " + empresa.getNombre() + " creada");
    }

    public static void apartado9() {
        Empresa empresa = new Empresa("LDIL");
        System.out.println("Empresa " + empresa.getNombre() + " creada");    
        
        Persona p1 = new Persona("Juan", 64);
        Persona p2 = new Persona("Jose", 63);
        Persona p3 = new Persona("María", 60);

        empresa.contrataEmpleado(p1);
        empresa.contrataEmpleado(p2);
        empresa.contrataEmpleado(p3);

        empresa.mostrarEmpleados();
    }

    public static void apartado10() {
        Empresa empresa = new Empresa("LDIL");
        System.out.println("Empresa " + empresa.getNombre() + " creada");    
        
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
        empresa.mostrarEmpleados();

        System.out.println("\nDespués de despedir al de la posición 2:");
        empresa.despideEmpleado(2);
        empresa.mostrarEmpleados();

        System.out.println("\nDespués de despedir a Luis:");
        empresa.despideEmpleado("Luis");
        empresa.mostrarEmpleados();
    }

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
