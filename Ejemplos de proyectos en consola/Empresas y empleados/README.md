# Proyecto: Gestión de Empresas y Empleados en Java

## Descripción

Este proyecto consiste en desarrollar un sistema de gestión de empresas y empleados utilizando el lenguaje de programación **Java**. El objetivo principal es permitir almacenar y gestionar información sobre varias empresas, sus respectivas direcciones, y los empleados que trabajan en cada una de ellas. Los datos se gestionan en un formato estructurado y se proporciona funcionalidad para visualizar la información relevante.

## Funcionalidades Requeridas

### 1. Gestión de Empresas
- El sistema almacena información sobre diferentes empresas. Cada empresa tiene asociada una dirección y una lista de empleados.
- La información de cada empresa incluye:
  - Nombre de la empresa.
  - Dirección (calle y número).
  - Lista de empleados con sus respectivos nombres y salarios.

### 2. Gestión de Empleados
- Para cada empresa, se pueden gestionar varios empleados. Cada empleado tiene:
  - Nombre.
  - Salario.

### 3. Visualización de la Información
- El sistema permite consultar la información de cada empresa, mostrando sus empleados y sus respectivos salarios.
- Se podrá visualizar tanto la información de las empresas como de los empleados asociados a cada una de ellas.

## Formato de Datos

El fichero de datos tiene el siguiente formato:

```
[Nombre de la Empresa];[Dirección];[Número de Dirección]
EMP;[Nombre del Empleado];[Salario]
```

### Ejemplo de Datos
```
ConstruccionesModernas;Calle Obrera;89
EMP;Alberto;45000
EMP;Elena;47000
EMP;Pablo;43000
EMP;Sara;46000
SoftTech;Avenida Central;101
EMP;Carlos;50000
EMP;Ana;52000
EMP;Luis;48000
EMP;David;35000
```

## Requisitos Técnicos

- El proyecto está implementado en **Java** y sigue el paradigma de programación orientada a objetos (POO).
- Las principales clases implementadas son:
  - `Empresa`: Representa una empresa que contiene un nombre, una dirección y una lista de empleados.
  - `Empleado`: Representa a un empleado con su nombre y salario.
  - `Direccion`: Modela la dirección de una empresa.
- Se utiliza la entrada/salida de archivos para gestionar los datos de las empresas y empleados.
- El sistema permite cargar los datos desde un archivo estructurado con el formato mencionado anteriormente.

## Ejemplo de Uso

1. **Carga de Datos**:
    El sistema carga la información de las empresas y sus empleados desde un archivo.
    
2. **Visualización de la Información**:
    El sistema permite listar las empresas y sus empleados. Por ejemplo:

    ```
    Empresa: ConstruccionesModernas
    Dirección: Calle Obrera, 89
    Empleados:
        - Alberto, Salario: 45000
        - Elena, Salario: 47000
        - Pablo, Salario: 43000
        - Sara, Salario: 46000
    ```

## Clases Implementadas

### 1. `Empresa.java`
Contiene los detalles sobre la clase `Empresa`, que gestiona los atributos relacionados con el nombre de la empresa, su dirección y la lista de empleados.

### 2. `Empleado.java`
Define los empleados de la empresa, sus atributos como el nombre y el salario.

### 3. `Direccion.java`
Representa las direcciones de las empresas, incluyendo atributos como la calle y el número.

## Opcional

- Agregar funcionalidad para editar o eliminar empleados.
- Añadir soporte para diferentes tipos de consultas, como por ejemplo, buscar empleados con salarios mayores a un valor específico.
- Incorporar persistencia de datos usando una base de datos en lugar de archivos.
