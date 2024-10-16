import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Traductor_v2 {
    // Dos diccionarios para las traducciones: inglés -> español y español -> inglés
    private static Map<String, String> inglesEspanol = new HashMap<>();
    private static Map<String, String> espanolIngles = new HashMap<>();
    
    // Scanner para la entrada de datos del usuario
    static Scanner scanner = new Scanner(System.in);

    // Método principal que llama al menú de opciones
    public static void main(String[] args) {
        menu();
    }

    // Método para cargar el corpus de traducciones desde dos archivos de texto
    private static void cargarCorpus(String archivoIngles, String archivoEspanol) {
        try {
            // Lee todas las líneas de los archivos especificados en inglés y español
            List<String> lineasIngles = Files.readAllLines(Paths.get("traducciones/" + archivoIngles));
            List<String> lineasEspanol = Files.readAllLines(Paths.get("traducciones/" + archivoEspanol));

            // Recorre las líneas de los archivos y llena los diccionarios con las traducciones
            for (int i=0; i < lineasIngles.size(); i++) {
                String fraseIngles = lineasIngles.get(i);  // Frase en inglés
                String fraseEspanol = lineasEspanol.get(i);  // Traducción en español

                // Almacena en ambos mapas para traducción en ambas direcciones
                inglesEspanol.put(fraseIngles, fraseEspanol);
                espanolIngles.put(fraseEspanol, fraseIngles);
            }
        }
        catch (Exception e) {
            System.out.println("\nError al leer ficheros" + e.getMessage());
        }
    }

    // Método para traducir de inglés a español, con coincidencia exacta
    private static void traducirInglesEspanol(String frase) {
        String traduccion = inglesEspanol.get(frase);
        System.out.println(frase + " -> " + traduccion);
    }

    // Método para traducir de español a inglés, similar al anterior pero en dirección inversa
    private static void traducirEspanolIngles(String frase) {
        String traduccion = espanolIngles.get(frase);
        System.out.println(frase + " -> " + traduccion);
    }

    // Método que permite seleccionar el diccionario a cargar
    private static void seleccionarDiccionario() {
        System.out.println("1. Books");
        System.out.println("2. Mi propio diccionario");
        System.out.print("Elige el diccionario: ");

        String opcion = scanner.nextLine();

        String archivoIngles = ""; 
        String archivoEspanol = "";

        // Selecciona los archivos según la opción elegida
        switch(opcion) {
            case "1":
                archivoIngles = "Books.en-es.en"; 
                archivoEspanol = "Books.en-es.es";
                break;
            case "2":
                archivoIngles = "en.txt";
                archivoEspanol = "es.txt";
                break;
        }

        // Limpia los diccionarios antes de cargar nuevos datos
        inglesEspanol.clear();
        espanolIngles.clear();

        // Carga el corpus de traducciones usando los archivos seleccionados
        cargarCorpus(archivoIngles, archivoEspanol);
        System.out.println("\nFicheros '" + archivoIngles + "' y '" + archivoEspanol + "' cargados correctamente.");
    }

    // Método que muestra el menú de opciones para el usuario
    private static void menu() {
        while(true) {
            System.out.println("");
            System.out.println("1. Cargar corpus");
            System.out.println("2. Traducir de inglés a español");
            System.out.println("3. Traducir de español a inglés");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();
            System.out.println("");

            String fraseIngles = ""; 
            String fraseEspanol = "";

            // Ejecuta acciones según la opción seleccionada
            switch(opcion) {
                case "1":
                    seleccionarDiccionario();  // Carga un diccionario
                    break;
                case "2":
                    System.out.print("Escribe algo en inglés: ");
                    fraseIngles = scanner.nextLine();
                    traducirInglesEspanol(fraseIngles);  // Traducción exacta inglés -> español
                    break;
                case "3":
                    System.out.print("Escribe algo en español: ");
                    fraseEspanol = scanner.nextLine();
                    traducirEspanolIngles(fraseEspanol);  // Traducción exacta español -> inglés
                    break;
                case "0":
                    return;  // Sale del programa
            }
        }
    }
}
