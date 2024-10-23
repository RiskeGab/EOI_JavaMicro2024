package com.example;

import java.util.Scanner;

import com.example.dao.CategoryDAO;
import com.example.dao.CategoryDAOMySql;
import com.example.entidades.Category;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner sc = new Scanner(System.in);
    private static CategoryDAO categoryDAO = new CategoryDAOMySql();

    public static void listarCategorias() {
        categoryDAO.getCategorias().forEach(categoria -> System.out.println(categoria));
    }

    public static void crearCategoria() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        
        Category nuevaCategoria = new Category(0, nombre);
        categoryDAO.insertCategoria(nuevaCategoria);
    }

    public static void borrarCategoria() {
        listarCategorias();
        
        System.out.print("Introduce el id de la categoría que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        categoryDAO.deleteCategoria(id);
    }

    public static void menuProductos() {
        String opcion = "";

        System.out.println("c: Crear Producto");
        System.out.println("r: Listar Productos");
        System.out.println("u: Actualizar Producto");
        System.out.println("d: Borrar Producto");
        System.out.print("Introduzca opción: ");
    
        opcion = sc.nextLine();

        switch (opcion.toLowerCase()) {
            case "c":
                //crearProducto();
                break;
            case "r":
                //listarProductos();
                break;
            case "u":
                //actualizarProducto();
                break;
            case "d":
                //borrarProducto();
                break;
            default:
                System.err.println("Opción no válida");
        }
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
                crearCategoria();
                break;
            case "r":
                listarCategorias();
                break;
            case "u":
                //actualizarCategoria();
                break;
            case "d":
                borrarCategoria();
                break;
            default:
                System.err.println("Opción no válida");
        }
    }

    public static void main(String[] args) {
        String opcion = "";

        do {
            System.out.println();
            System.out.println("CRUD BÁSICO PRODUCT MANAGER");
            System.out.println("p: Productos");
            System.out.println("c: Categorías");
            System.out.println("s: Salir");
            System.out.print("Introduzca opción: ");
    
            opcion = sc.nextLine();
    
            switch (opcion.toLowerCase()) {
                case "p":
                    menuProductos();
                    break;
                case "c":
                    menuCategorias();
                    break;
                case "s":
                    break;
                default:
                    System.err.println("Opción no válida");
            }

        } while(!opcion.toLowerCase().equals("e"));
    }
}
