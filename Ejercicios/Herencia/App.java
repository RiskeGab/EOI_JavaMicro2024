import java.util.Scanner;

public class App {
    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in);

    /**
     * Crea una clase llamada Tienda con un método llamado bienvenida que imprima por consola “¡Bienvenido a nuestra tienda!”. 
     * Crea otra clase llamada TiendaLicores que herede de Tienda. 
     * Crea un objeto del tipo TiendaLicores y llama al método bienvenida.
     */
    public static void apartado1() {
        TiendaLicores tiendaLicores = new TiendaLicores();
        tiendaLicores.bienvenida();
    }

    /**
     * Sobrescribe el método bienvenida en la clase TiendaLicores. 
     * Deberá hacer lo mismo que la clase base y añadir el mensaje “Si eres menor de 18 años, fuera de aquí”
     */
    public static void apartado2() {
        apartado1();
    }

    public static void apartado3() {
		Persona p1 = new Persona("43526346T", "Peter", 47);
		Persona p2 = new Persona("32745786Y", "Elena", 37);
		Persona p3 = new Persona("38365895G", "Juan", 17);
		Persona p4 = new Persona("26374854N", "Azucena", 26);
	    Persona[] personas = {p1, p2, p3, p4};
	    
	    Persona copia = new Persona(p3);
	    copia.setNombre("Marta");
	    
	    for(int i = 0; i < personas.length; i++) {
	    	if(personas[i].equals(copia)) {
	    		System.out.println("Persona encontrada en la posición " + i);
	    		System.out.println(personas[i]);
	    		System.out.println(copia);
	    	}
	    }
    }

    public static void apartado4() {
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

    /**
     * Crea una clase llamada Figura. Esta clase será abstracta y tendrá los
     * métodos getPerimetro y getArea como abstractos también. Crea la clase
     * Cuadrado y Circulo que hereden de Figura e implementa dichos métodos
     * junto a los atributos que necesites: lado para el cuadrado y radio para el círculo.
     */
    public static void apartado5() {
        Cuadrado cua = new Cuadrado(4.5);
        Circulo cir = new Circulo(4);

        System.out.printf("Cuadrado. Área: %.2f, Perímetro: %.2f\n", cua.getArea(), cua.getPerimetro());
        System.out.printf("Círculo. Área: %.2f, Perímetro: %.2f\n", cir.getArea(), cir.getPerimetro());
    }

    /**
     * Lo mismo que el apartado 5 pero implementando la interfaz IFigura
     */
    public static void apartado6() {
        apartado6();
    }

    public static void apartado7() {
        IFigura[] figuras = {
			new Circulo(4),
			new Cuadrado(6.5),
			new Circulo(6.2),
			new Cuadrado(12),
			new Circulo(3),
			new Cuadrado(8.7)
		};
		
		for(IFigura figura: figuras) {
			System.out.printf("Área: %.2f. Perímetro: %.2f\n", figura.getArea(), figura.getPerimetro());
		}
    }

    public static void apartado8() {
        IFigura[] figuras = {
			new Circulo(4),
			new Cuadrado(6.5),
			new Circulo(6.2),
			new Cuadrado(12),
			new Circulo(3),
			new Cuadrado(8.7)
		};
		
		for(IFigura figura: figuras) {
			if(figura instanceof Circulo) {
			 	System.out.println("*** Círculo – Radio: " + ((Circulo)figura).getRadio() + " ***");
			} else if(figura instanceof Cuadrado) {
			 	System.out.println("*** Cuadrado – Lado: " + ((Cuadrado)figura).getLado() + " ***");
			}
			System.out.printf("Área: %.2f. Perímetro: %.2f\n\n", figura.getArea(), figura.getPerimetro());
		}
    }

    // Método principal que ejecuta los apartados según la selección del usuario
    public static void main(String[] args) throws Exception {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (1-8) o 0 para salir: ");
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
