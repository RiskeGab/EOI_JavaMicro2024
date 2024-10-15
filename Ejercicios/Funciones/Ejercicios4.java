import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicios4 {

    // Scanner a nivel de clase para reutilizarlo en todos los apartados
    private static Scanner sc = new Scanner(System.in); 

    // Formatea una fecha para devolverla en formato "Día, de Mes de Año"
    public static String obtenerFechaApartado14(LocalDate fecha) {
        String[] dias = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        int dia = fecha.getDayOfMonth();  // Obtiene el día del mes
        int mes = fecha.getMonthValue();  // Obtiene el valor numérico del mes
        int anyo = fecha.getYear();  // Obtiene el año

        // Devuelve la fecha en formato "Día, de Mes de Año"
        return dias[dia] + ", de " + meses[mes - 1] + " de " + anyo;
    }

    // Lee una fecha específica y la formatea utilizando obtenerFechaApartado14
    public static void apartado14() {
        // Convierte la cadena a un objeto LocalDate en el formato día/mes/año
        LocalDate fecha = LocalDate.parse("04/07/2019", DateTimeFormatter.ofPattern("d/M/y"));
        System.out.println(fecha.toString());  // Imprime la fecha en formato ISO (por defecto)

        System.out.println(obtenerFechaApartado14(fecha));  // Imprime la fecha formateada
    }

    // Modifica una fecha agregando días, meses y años, utilizando substrings y DateTimeFormatter
    public static String obtenerFechaApartado15(String fechaString) {
        // Extrae el día, mes y año utilizando substrings
        int dia = Integer.parseInt(fechaString.substring(0, 2));
        int mes = Integer.parseInt(fechaString.substring(3, 5));
        int anyo = Integer.parseInt(fechaString.substring(6, 10));
        
        // Crea un objeto LocalDate a partir del día, mes y año extraídos
        LocalDate fecha = LocalDate.of(anyo, mes, dia);

        // Suma 5 días, 3 meses y 2 años a la fecha
        fecha = fecha.plusDays(5);
        fecha = fecha.plusMonths(3);
        fecha = fecha.plusYears(2);
        
        // Alternativa: parsea la fecha utilizando DateTimeFormatter
        LocalDate fecha2 = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd-MM-yyyy")); 

        // Suma 5 días, 3 meses y 2 años a la fecha
        fecha2 = fecha2.plusDays(5);
        fecha2 = fecha2.plusMonths(3);
        fecha2 = fecha2.plusYears(2);

        // Devuelve las fechas modificadas, utilizando dos métodos diferentes
        return "Fecha utilizando substrings:\n" + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+ 
               "\nFecha utilizando DateTimeFormatter:\n" + fecha2.format(DateTimeFormatter.ofPattern("dd/MM/yyyy\n"));
    }

    // Muestra el resultado de obtenerFechaApartado15 con una fecha específica
    public static void apartado15() {
        System.out.println(obtenerFechaApartado15("11-10-2024"));
    }

    // Método principal que muestra un menú para seleccionar y ejecutar apartados
    public static void main(String[] args) {
        boolean ejecutando = true;  // Variable que controla si el bucle sigue ejecutándose

        // Mostrar un menú al usuario
        while (ejecutando) {
            System.out.print("\nSeleccione el apartado a ejecutar (14-15) o 0 para salir: ");
            int opcion = sc.nextInt();  // Leer la opción del usuario
            sc.nextLine();  // Limpiar el buffer (quitar salto de línea sobrante)

            if (opcion == 0) {
                System.out.println("¡Hasta luego!");
                ejecutando = false;  // Terminar el bucle
            } else {
                try {
                    // Llamar al método correspondiente según la opción seleccionada
                    Ejercicios4.class.getMethod("apartado" + opcion).invoke(null);
                } catch (Exception e) {
                    System.out.println("Error: No se encontró el apartado o se produjo otro problema.");
                }
            }
        }

        sc.close();  // Cerrar el Scanner al finalizar
    }
}
