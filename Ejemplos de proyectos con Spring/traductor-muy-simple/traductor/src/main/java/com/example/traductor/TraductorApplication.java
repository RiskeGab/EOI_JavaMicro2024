package com.example.traductor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
@SpringBootApplication
public class TraductorApplication {
    // Dos mapas para almacenar las traducciones: de inglés a español y de español a inglés y de inglés a italiano
    private static Map<String, String> inglesEspanol = new HashMap<>();
    private static Map<String, String> espanolIngles = new HashMap<>();
    private static Map<String, String> inglesItaliano = new HashMap<>();

	    // Método para cargar las traducciones desde dos archivos de texto
    private static void cargarCorpus(String archivoIngles, String archivoEspanol, String archivoItaliano) {
        try {
            // Lee las líneas de los archivos de texto en inglés y español e italiano
            List<String> lineasIngles = Files.readAllLines(Paths.get("traducciones/" + archivoIngles));
            List<String> lineasEspanol = Files.readAllLines(Paths.get("traducciones/" + archivoEspanol));
            List<String> lineasItaliano = Files.readAllLines(Paths.get("traducciones/" + archivoItaliano));

            // Recorre las líneas de ambos archivos y las guarda en los mapas
            for (int i=0; i < lineasIngles.size(); i++) {
                String fraseIngles = lineasIngles.get(i);  // Frase en inglés
                String fraseEspanol = lineasEspanol.get(i);  // Frase en español
                String fraseItaliano = lineasItaliano.get(i);  // Frase en italiano

                // Asocia las frases en ambos mapas para las traducciones en ambas direcciones
                inglesEspanol.put(fraseIngles, fraseEspanol);  // Traducción inglés -> español
                espanolIngles.put(fraseEspanol, fraseIngles);  // Traducción español -> inglés
                inglesItaliano.put(fraseIngles, fraseItaliano);  // Traducción ingles -> italiano
            }
        }
        catch (Exception e) {
            System.out.println("Error al leer ficheros" + e.getMessage());
        }
    }

	public static void main(String[] args) {
		cargarCorpus("informatica.en", "informatica.es", "informatica.it");
		SpringApplication.run(TraductorApplication.class, args);
	}

	@GetMapping("/traducir")
	public String traducir(@RequestParam String texto) {
        String traduccion = inglesEspanol.get(texto);
        if (traduccion != null) {
            traduccion += " / " + inglesItaliano.get(texto);
        }
        else {
            traduccion = espanolIngles.get(texto);
            if (traduccion != null) {
                traduccion += " / " + inglesItaliano.get(traduccion);
            }
        }

		return traduccion == null ? "" : traduccion;
	}

}
