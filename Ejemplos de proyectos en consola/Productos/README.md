# Proyecto: Gestión de Productos en Java

## Descripción
Este proyecto implementa un sistema simple de gestión de productos utilizando **Java**. Permite agregar productos, borrar productos, consultar la lista de productos y actualizar productos realizando búsquedas basadas en el nombre de los productos. La información se almacena de manera persistente en formato de texto. El programa funciona en un entorno de consola y utiliza archivos para guardar y cargar los productos.

## Funcionalidades Requeridas

### 1. Añadir Productos
- El programa debe permitir al usuario añadir un producto, introduciendo su nombre y precio.
- Los productos se almacenarán en un archivo de texto, donde cada línea representa un producto con su nombre y su precio, separados por un punto y coma (`;`).
- El usuario debe poder introducir varios productos durante la ejecución del programa.

### 2. Consultar Lista de Productos
- El programa debe permitir la consulta de todos los productos almacenados en el archivo.
- Cada producto se mostrará en una nueva línea con su nombre y precio.

### 3. Búsqueda, Actualización y Borrado de Productos por Nombre
- El programa debe permitir al usuario buscar, actualizar y borrar productos por nombre.
  
### 4. Almacenamiento Persistente
- Todos los productos se guardarán en un archivo de texto que persiste entre ejecuciones del programa.
- El formato del archivo debe ser sencillo, con cada producto almacenado en una línea con su nombre y precio separados por un `;`.

### 5. Manejo de Errores
- El programa debe manejar errores relacionados con la lectura y escritura de archivos, asegurando que cualquier problema con el archivo sea gestionado correctamente, como falta de permisos o archivos no encontrados.

## Requisitos Técnicos
- **Lenguaje de Programación**: El proyecto debe estar implementado en **Java**.
- **Entrada/Salida de Archivos**: Utilizar las clases `FileWriter`, `PrintWriter` y `Scanner` para manejar archivos y entradas del usuario.
- **Estructura del Archivo**: Cada producto debe ser almacenado en una línea del archivo con el formato: `nombre;precio`.

## Ejemplo de Uso

1. **Agregar Producto**:
    ```
    Introduce el nombre del producto: Manzana
    Introduce el precio del producto: 0.75
    ```

2. **Resultado en el archivo**:
    ```
    Manzana;0.75
    ```

3. **Consultar Todos los Productos**:
    ```
    Lista de productos:
    Manzana;0.75
    Naranja;0.85
    ```

