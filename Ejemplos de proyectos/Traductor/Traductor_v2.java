import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Traductor_v2 {
    private static Map<String, String> inglesEspanol = new HashMap<>();
    private static Map<String, String> espanolIngles = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        cargarCorpus("Books.en-es.en", "Books.en-es.es");
        menu();
    }

    private static void cargarCorpus(String archivoIngles, String archivoEspanol) {
        try {
            List<String> lineasIngles = Files.readAllLines(Paths.get("traducciones/" + archivoIngles));
            List<String> lineasEspanol = Files.readAllLines(Paths.get("traducciones/" + archivoEspanol));

            for (int i=0; i < lineasIngles.size(); i++) {
                String fraseIngles = lineasIngles.get(i);
                String fraseEspanol = lineasEspanol.get(i);

                inglesEspanol.put(fraseIngles, fraseEspanol);
                espanolIngles.put(fraseEspanol, fraseIngles);
            }
        }
        catch (Exception e) {
            System.out.println("Error al leer ficheros" + e.getMessage());
        }
    }

    private static void traducirInglesEspanol(String frase) {
        String traduccion = inglesEspanol.get(frase);
        System.out.println(frase + " -> " + traduccion);
    }

    private static void traducirEspanolIngles(String frase) {
        String traduccion = espanolIngles.get(frase);
        System.out.println(frase + " -> " + traduccion);
    }

    private static void menu() {
        while(true) {
            System.out.println("1. Traducir de inglés a español");
            System.out.println("2. Traducir de espanol a inglés");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch(opcion) {
                case "1":
                    System.out.print("Introduce algo: ");
                    String fraseIngles = scanner.nextLine();
                    traducirInglesEspanol(fraseIngles);
                    break;
                case "2":
                    System.out.print("Introduce algo: ");
                    String fraseEspanol = scanner.nextLine();
                    traducirEspanolIngles(fraseEspanol);
                    break;
                case "0":
                    return;
            }
        }
    }
}
