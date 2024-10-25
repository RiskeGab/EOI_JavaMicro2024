package com.example;

import java.util.Locale.Category;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.dao.CategoriaDAOHibernate;
import com.example.dao.CategoryDAO;
import com.example.entidades.Categoria;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner sc = new Scanner(System.in);
    private static CategoryDAO categoriaDAO = new CategoriaDAOHibernate();

    public static void listarCategorias() {
        categoriaDAO.getCategorias().forEach(categoria -> System.out.println(categoria));
    }

    public static void crearCategoria() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        
        Category nuevaCategoria = new Categoria(0, nombre);
        categoriaDAO.insertCategoria(nuevaCategoria);
    }
 
    public static void borrarCategoria() {
        listarCategorias();
        
        System.out.print("Introduce el id de la categoría que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        categoryDAO.deleteCategoria(id);
    }    

    public static void actualizarCategoria() {
        listarCategorias();

        System.out.print("Introduce el identificador de la categoría que quieres actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el nuevo nombre: ");
        String nombre = sc.nextLine().trim();

        Category categoria = new Categoria(id, nombre);
        categoriaDAO.updateCategoria(categoria);
    }    

    public static void menuCategorias() {
        String opcion = "";

        System.out.println("c: Crear Categoría");
        System.out.println("r: Listar Categoría");
        System.out.println("u: Actualizar Categoría");
        System.out.println("d: Borrar Categoría");
        System.out.print("Introduzca opción: ");
    
        opcion = sc.nextLine();

        switch (opcion.toLowerCase()) {
            case "c":
                //crearCategoria();
                break;
            case "r":
                listarCategorias();
                break;
            case "u":
                //actualizarCategoria();
                break;
            case "d":
                //borrarCategoria();
                break;
            default:
                System.err.println("Opción no válida");
        }
    }

    public static void main( String[] args )
    {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        menuCategorias();
    }
}
