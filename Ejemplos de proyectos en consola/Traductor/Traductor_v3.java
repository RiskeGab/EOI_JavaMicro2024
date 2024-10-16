import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Traductor_v3 {
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

    // Método para traducir de inglés a español, con opción de coincidencia exacta o parcial (contains)
    private static void traducirInglesEspanol(String frase, boolean coincidenciaExacta) {
        if (coincidenciaExacta) {
            // Traducción exacta usando el diccionario inglés -> español
            String traduccion = inglesEspanol.get(frase);
            System.out.println(frase + " -> " + traduccion);
        } else {
            // Si no es coincidencia exacta, busca coincidencias parciales (usando contains)
            boolean encontrado = false;
            for (Map.Entry<String, String> entry : inglesEspanol.entrySet()) {
                if (entry.getKey().contains(frase)) {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println(frase + " -> null");
            }
        }
    }

    // Método para traducir de español a inglés, similar al anterior pero en dirección inversa
    private static void traducirEspanolIngles(String frase, boolean coincidenciaExacta) {
        if (coincidenciaExacta) {
            // Traducción exacta usando el diccionario español -> inglés
            String traduccion = espanolIngles.get(frase);
            System.out.println(frase + " -> " + traduccion);
        } else {
            // Búsqueda de coincidencias parciales usando 'contains'
            boolean encontrado = false;
            for (Map.Entry<String, String> entry : espanolIngles.entrySet()) {
                if (entry.getKey().contains(frase)) {
                    System.out.println(entry.getKey() + " -> " + entry.getValue());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println(frase + " -> null");
            }
        }
    }

    // Método que permite seleccionar el diccionario a cargar
    private static void seleccionarDiccionario() {
        // Presenta las opciones de diccionarios
        System.out.println("1. Mi propio diccionario");
        System.out.println("2. Comida y bebida");
        System.out.println("3. Naturaleza");
        System.out.println("4. Medicina y salud");
        System.out.println("5. Informática");
        System.out.println("6. Geografía e Historia");
        System.out.println("7. Deportes");
        System.out.println("8. Emojis");
        System.out.println("9. Miscelanea");
        System.out.println("10. Google material");
        System.out.println("11. Books");
        System.out.print("Elige el diccionario: ");

        String opcion = scanner.nextLine();

        String archivoIngles = ""; 
        String archivoEspanol = "";

        // Selecciona los archivos según la opción elegida
        switch(opcion) {
            case "1":
                archivoIngles = "en.txt";
                archivoEspanol = "es.txt";
                break;
            case "2":
                archivoIngles = "comida_y_bebida.en"; 
                archivoEspanol = "comida_y_bebida.es";
                break;
            case "3":
                archivoIngles = "naturaleza.en"; 
                archivoEspanol = "naturaleza.es";
                break;
            case "4":
                archivoIngles = "medicina_y_salud.en"; 
                archivoEspanol = "medicina_y_salud.es";
                break;
            case "5":
                archivoIngles = "informatica.en"; 
                archivoEspanol = "informatica.es";
                break;
            case "6":
                archivoIngles = "geografia_e_historia.en"; 
                archivoEspanol = "geografia_e_historia.es";
                break;
            case "7":
                archivoIngles = "deportes.en"; 
                archivoEspanol = "deportes.es";
                break;
            case "8":
                archivoIngles = "emojis.en"; 
                archivoEspanol = "emojis.es";
                break;
            case "9":
                archivoIngles = "miscelanea.en"; 
                archivoEspanol = "miscelanea.es";
                break;
            case "10":
                archivoIngles = "google_material.en"; 
                archivoEspanol = "google_material.es";
                break;
            case "11":
                archivoIngles = "Books.en-es.en"; 
                archivoEspanol = "Books.en-es.es";
                break;
        }

        // Carga el corpus de traducciones usando los archivos seleccionados
        cargarCorpus(archivoIngles, archivoEspanol);
        System.out.println("\nFicheros '" + archivoIngles + "' y '" + archivoEspanol + "' cargados correctamente.");
    }

    // Limpia los diccionarios para cargar nuevos datos
    private static void vaciarDiccionarios() {
        inglesEspanol.clear();
        espanolIngles.clear();
    }

    // Método que muestra el menú de opciones para el usuario
    private static void menu() {
        while(true) {
            System.out.println("");
            System.out.println("1. Cargar diccionario");
            System.out.println("2. Traducir de inglés a español (coincidencia exacta)");
            System.out.println("3. Traducir de español a inglés (coincidencia exacta)");
            System.out.println("4. Traducir de inglés a español (usando 'contains')");
            System.out.println("5. Traducir de español a inglés (usando 'contains')");
            System.out.println("6. Limpiar diccionarios cargados en memoria");
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
                    traducirInglesEspanol(fraseIngles, true);  // Traducción exacta inglés -> español
                    break;
                case "3":
                    System.out.print("Escribe algo en español: ");
                    fraseEspanol = scanner.nextLine();
                    traducirEspanolIngles(fraseEspanol, true);  // Traducción exacta español -> inglés
                    break;
                case "4":
                    System.out.print("Escribe algo en inglés: ");
                    fraseIngles = scanner.nextLine();
                    traducirInglesEspanol(fraseIngles, false);  // Traducción parcial inglés -> español
                    break;
                case "5":
                    System.out.print("Escribe algo en español: ");
                    fraseEspanol = scanner.nextLine();
                    traducirEspanolIngles(fraseEspanol, false);  // Traducción parcial español -> inglés
                    break;
                case "6":
                    vaciarDiccionarios();  // Carga un diccionario
                    break;
                case "0":
                    return;  // Sale del programa
            }
        }
    }
}
