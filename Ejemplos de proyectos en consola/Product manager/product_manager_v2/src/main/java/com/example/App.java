package com.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.dao.CategoryDAO;
import com.example.dao.CategoryDAOHibernate;
import com.example.entidades.Category;

import com.example.dao.ProductDAO;
import com.example.dao.ProductDAOHibernate;
import com.example.entidades.Product;

/**
 * Hello world!
 *
 */
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static CategoryDAO categoryDAO = new CategoryDAOHibernate();
    private static ProductDAO productDAO = new ProductDAOHibernate();

    public static void listarCategorias() {
        categoryDAO.getCategorias().forEach(categoria -> System.out.println(categoria));
    }

    public static void listarProductos() {
        productDAO.getProductos().forEach(producto -> System.out.println(producto));
    }

    public static void listarProductosCategoria() {
        listarCategorias();
        System.out.print("Elige una categoría: ");
        int idCat = sc.nextInt();
        sc.nextLine();
        productDAO.getProdutosCategoria(idCat).forEach(producto -> System.out.println(producto));
    }

    public static void crearCategoria() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        
        Category nuevaCategoria = new Category(0, nombre);
        categoryDAO.insertCategoria(nuevaCategoria);
    }

    public static void crearProducto() {
        System.out.print("Introduce la referencia: ");
        String referencia = sc.nextLine();
    
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
    
        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();
    
        listarCategorias();
        System.out.print("Introduce la categoría: ");
        int categoria = sc.nextInt();
        sc.nextLine();

        Product nuevoProducto = new Product(0, referencia, nombre, precio, null);
        productDAO.insertProducto(nuevoProducto, categoria);
    }

    public static void borrarCategoria() {
        listarCategorias();
        
        System.out.print("Introduce el id de la categoría que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        categoryDAO.deleteCategoria(id);
    }

    public static void borrarProducto() {
        listarProductos();
        
        System.out.print("Introduce el id del producto que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        productDAO.deleteProducto(id);
    }

    public static void actualizarCategoria() {
        listarCategorias();

        System.out.print("Introduce el identificador de la categoría que quieres actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el nuevo nombre: ");
        String nombre = sc.nextLine().trim();

        Category categoria = new Category(id, nombre);
        categoryDAO.updateCategoria(categoria);
    }

    public static void actualizarProducto() {
        listarProductos();

        System.out.print("Introduce el identificador del producto que quieres actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce la referencia: ");
        String referencia = sc.nextLine();
    
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
    
        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();
    
        System.out.print("Introduce la categoría: ");
        int categoria = sc.nextInt();
        sc.nextLine();

        //Product producto = new Product(id, referencia, nombre, precio, categoria);
        //productDAO.updateProducto(producto);
    }

    public static void menuProductos() {
        String opcion = "";

        System.out.println("c: Crear Producto");
        System.out.println("r: Listar Productos");
        System.out.println("r2: Listar Productos por categoría");
        System.out.println("u: Actualizar Producto");
        System.out.println("d: Borrar Producto (no funciona bien todavía)");
        System.out.print("Introduzca opción: ");
    
        opcion = sc.nextLine();

        switch (opcion.toLowerCase()) {
            case "c":
                crearProducto();
                break;
            case "r":
                listarProductos();
                break;
            case "r2":
                listarProductosCategoria();
                break;
            case "u":
                actualizarProducto();
                break;
            case "d":
                borrarProducto();
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
                actualizarCategoria();
                break;
            case "d":
                borrarCategoria();
                break;
            default:
                System.err.println("Opción no válida");
        }
    }

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

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

        } while(!opcion.toLowerCase().equals("s"));
    }
}
