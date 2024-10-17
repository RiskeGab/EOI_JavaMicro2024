# Proyecto: Traductor Bilingüe en Java

Este proyecto implementa un traductor bilingüe (Inglés - Español) utilizando **Java**, en tres versiones (v1, v2, v3), cada una con nuevas funcionalidades o mejoras progresivas. El traductor permite cargar diccionarios de traducciones, traducir frases en ambos idiomas, y buscar traducciones parciales o exactas.

## Versiones del Proyecto

### Versión 1: `Traductor_v1.java`

#### Funcionalidades
- **Carga de diccionarios**: Carga dos archivos de texto (uno con frases en inglés y otro con frases en español) que se utilizan para almacenar las traducciones.
- **Mapeo bilingüe**: Usa dos estructuras de datos tipo `Map` para almacenar las traducciones:
  - `inglesEspanol`: Traducción de inglés a español.
  - `espanolIngles`: Traducción de español a inglés.
- **Menú interactivo**: Presenta un menú que permite al usuario seleccionar entre varias opciones, como traducir de inglés a español, de español a inglés, o salir del programa.
- **Entrada del usuario**: El programa solicita frases en inglés o en español y devuelve la traducción exacta si existe en el diccionario.

#### Uso
1. **Cargar diccionario**: Los archivos de frases (por ejemplo, `en.txt` y `es.txt`) se cargan desde una carpeta local llamada `traducciones/`.
2. **Traducir frases**: Los usuarios pueden introducir una frase en inglés o español y recibir la traducción correspondiente.

---

### Versión 2: `Traductor_v2.java`

#### Funcionalidades Adicionales
- **Traducción exacta**: Los usuarios pueden seguir buscando traducciones exactas.
- **Traducción parcial**: Ahora el traductor permite buscar coincidencias parciales. Si la frase no está exactamente en el diccionario, intentará buscar frases que contengan las palabras clave ingresadas.

#### Uso
1. **Opciones de traducción**: El menú ahora incluye opciones para traducir exacta o parcialmente tanto de inglés a español como de español a inglés.
2. **Entrada de búsqueda parcial**: Si el usuario escribe una parte de una frase, el traductor devolverá todas las frases que contengan esa parte en el idioma solicitado.

---

### Versión 3: `Traductor_v3.java`

#### Funcionalidades Adicionales
- **Selección de diccionarios**: Esta versión permite al usuario cargar diferentes diccionarios en tiempo de ejecución. El usuario puede seleccionar un conjunto de archivos de traducción distintos de los predeterminados.
- **Vaciar y recargar diccionarios**: Los usuarios pueden vaciar los diccionarios cargados y cargar nuevos archivos de traducción sin necesidad de reiniciar el programa.
- **Estadísticas de traducción**: El programa ahora ofrece información sobre cuántas frases se han cargado en cada diccionario, proporcionando más control al usuario.

#### Uso
1. **Cargar varios diccionarios**: El usuario puede cargar en memoria varios archivos de diccionario, proporcionando más ejemplos de traducciones.
2. **Ver estadísticas**: El programa muestra cuántas frases están disponibles en cada diccionario, ayudando al usuario a evaluar el tamaño del corpus de traducción.
3. **Vaciar diccionarios**: Si es necesario, los diccionarios actuales se pueden vaciar para cargar otros nuevos.

---

## Requisitos Técnicos
- **Lenguaje de programación**: Java
- **Archivos de texto**: Los diccionarios de traducción están almacenados en archivos de texto, uno para cada idioma.
- **Estructura de los archivos de traducción**: Cada línea en los archivos de texto contiene una frase en el idioma correspondiente. Los archivos en inglés y en español deben tener el mismo número de líneas, cada una alineada para hacer la traducción.

## Ejemplo de Uso
1. **Versión 1**: 
    - Se carga el archivo `en.txt` (frases en inglés) y `es.txt` (frases en español) desde la carpeta `traducciones/`.
    - Se introduce una frase exacta y se obtiene la traducción.
    
2. **Versión 2**: 
    - Además de las traducciones exactas, el usuario puede buscar una traducción parcial. Si no encuentra la frase completa, el programa devolverá todas las frases que contengan las palabras clave introducidas.

3. **Versión 3**: 
    - El usuario puede seleccionar distintos diccionarios de traducción, vaciar los diccionarios actuales, recargar nuevos archivos y obtener estadísticas sobre el número de frases cargadas.

## Extensiones Futuras (Opcionales)
- Soporte para otros idiomas.
- Añadir la capacidad de editar, añadir y eliminar frases del diccionario durante la ejecución.

