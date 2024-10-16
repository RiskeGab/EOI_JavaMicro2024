import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Traductor_v1 {
    // Dos mapas para almacenar las traducciones: de inglés a español y de español a inglés
    private static Map<String, String> inglesEspanol = new HashMap<>();
    private static Map<String, String> espanolIngles = new HashMap<>();
    
    // Objeto Scanner para recibir la entrada del usuario por consola
    static Scanner scanner = new Scanner(System.in);

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        // Carga el corpus de traducciones usando archivos predeterminados
        cargarCorpus("en.txt", "es.txt");
        // Muestra el menú interactivo
        menu();
    }

    // Método para cargar las traducciones desde dos archivos de texto
    private static void cargarCorpus(String archivoIngles, String archivoEspanol) {
        try {
            // Lee las líneas de los archivos de texto en inglés y español
            List<String> lineasIngles = Files.readAllLines(Paths.get("traducciones/" + archivoIngles));
            List<String> lineasEspanol = Files.readAllLines(Paths.get("traducciones/" + archivoEspanol));

            // Recorre las líneas de ambos archivos y las guarda en los mapas
            for (int i=0; i < lineasIngles.size(); i++) {
                String fraseIngles = lineasIngles.get(i);  // Frase en inglés
                String fraseEspanol = lineasEspanol.get(i);  // Frase en español

                // Asocia las frases en ambos mapas para las traducciones en ambas direcciones
                inglesEspanol.put(fraseIngles, fraseEspanol);  // Traducción inglés -> español
                espanolIngles.put(fraseEspanol, fraseIngles);  // Traducción español -> inglés
            }
        }
        catch (Exception e) {
            System.out.println("Error al leer ficheros" + e.getMessage());
        }
    }

    // Método para traducir una frase de inglés a español
    // Obtiene la traducción del mapa y la imprime en la consola
    private static void traducirInglesEspanol(String frase) {

        String traduccion = inglesEspanol.get(frase);
        System.out.println(frase + " -> " + traduccion);
    }

    // Método para traducir una frase de español a inglés
    // Obtiene la traducción del mapa y la imprime en la consola
    private static void traducirEspanolIngles(String frase) {
        String traduccion = espanolIngles.get(frase);
        System.out.println(frase + " -> " + traduccion);
    }

    // Método que presenta el menú interactivo al usuario
    private static void menu() {
        while(true) {
            System.out.println("1. Traducir de inglés a español");
            System.out.println("2. Traducir de español a inglés");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            // Ejecuta la acción correspondiente según la opción elegida
            switch(opcion) {
                case "1":
                    // Traducción de inglés a español
                    System.out.print("Introduce algo: ");
                    String fraseIngles = scanner.nextLine();
                    traducirInglesEspanol(fraseIngles); 
                    break;
                case "2":
                    // Traducción de español a inglés
                    System.out.print("Introduce algo: ");
                    String fraseEspanol = scanner.nextLine();
                    traducirEspanolIngles(fraseEspanol); 
                    break;
                case "0":
                    // Sale del programa si el usuario elige 0
                    return;
            }
        }
    }
}
