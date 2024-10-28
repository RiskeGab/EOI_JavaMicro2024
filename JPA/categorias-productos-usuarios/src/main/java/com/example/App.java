package com.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.dao.CategoriaDAOHibernate;
import com.example.dao.CategoriaDAO;
import com.example.entidades.Categoria;

import com.example.dao.ProductoDAOHibernate;
import com.example.dao.ProductoDAO;
import com.example.entidades.Producto;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner sc = new Scanner(System.in);
    private static CategoriaDAO categoriaDAO = new CategoriaDAOHibernate();
    private static ProductoDAO productoDAO = new ProductoDAOHibernate();

    public static void listarCategorias() {
        categoriaDAO.getCategorias().forEach(categoria -> System.out.println(categoria));
    }

    public static void crearCategoria() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        
        Categoria nuevaCategoria = new Categoria(0, nombre);
        categoriaDAO.insertCategoria(nuevaCategoria);
    }
 
    public static void borrarCategoria() {
        listarCategorias();
        
        System.out.print("Introduce el id de la categoría que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        categoriaDAO.deleteCategoria(id);
    }    

    public static void actualizarCategoria() {
        listarCategorias();

        System.out.print("Introduce el identificador de la categoría que quieres actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el nuevo nombre: ");
        String nombre = sc.nextLine().trim();

        Categoria categoria = new Categoria(id, nombre);
        categoriaDAO.updateCategoria(categoria);
    }    

    public static void menuCategorias() {
        String opcion = "";

        System.out.println("c: Crear Categoría");
        System.out.println("r: Listar Categorías");
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

    public static void listarProductos() {
        productoDAO.getProductos().forEach(producto -> System.out.println(producto));
    }

    public static void crearProducto() {
        System.out.print("Introduce la referencia: ");
        String referencia = sc.nextLine();
        System.out.print("Introduce el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();
        System.out.print("Introduce la categoría: ");
        int categoria = sc.nextInt();
        sc.nextLine();
        
        Producto nuevoProducto = new Producto(referencia, nombre, precio, null);
        productoDAO.insertProducto(nuevoProducto, categoria);
    }
 
    public static void borrarProducto() {
        listarProductos();
        
        System.out.print("Introduce el id del producto que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        productoDAO.deleteProducto(id);
    }    

    public static void actualizarProducto() {
        System.out.print("Introduce el id del produto a actualizar: ");
        int idProducto = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce la referencia: ");
        String referencia = sc.nextLine();
        System.out.print("Introduce el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();
        System.out.print("Introduce la categoría: ");
        int categoria = sc.nextInt();
        sc.nextLine();
        
        Producto nuevoProducto = new Producto(idProducto, referencia, nombre, precio, null);
        productoDAO.updateProducto(nuevoProducto, categoria);
    }  

    public static void menuProductos() {
        String opcion = "";

        System.out.println("c: Crear Prodcuto");
        System.out.println("r: Listar Productos");
        System.out.println("u: Actualizar Producto");
        System.out.println("d: Borrar Producto");
        System.out.print("Introduzca opción: ");
    
        opcion = sc.nextLine();

        switch (opcion.toLowerCase()) {
            case "c":
                crearProducto();
                break;
            case "r":
                listarProductos();
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
    
    public static void main( String[] args )
    {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        String opcion = "";

        do {
            System.out.println("\nMenú principal");
            System.out.println("c. Categorías");
            System.out.println("p. Productos");
            System.out.println("s. Salir");
            System.out.print("Introduce una opción: ");
            
            opcion = sc.nextLine();

            switch(opcion) {
                case "c":
                    menuCategorias();
                    break;
                case "p":
                    menuProductos();
                    break;
                case "s":
                    break;
            }
        } while(!opcion.equals("s"));

        sc.close();
    }
}
