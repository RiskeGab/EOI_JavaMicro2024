# Proyecto: Horóscopo Zodiacal en Java

## Descripción
El objetivo de este proyecto es desarrollar un programa en **Java** que permita al usuario introducir su fecha de nacimiento (día y mes) y que, a partir de esa información, el programa le devuelva su signo zodiacal junto con una breve descripción de las características asociadas a dicho signo. El programa funcionará en un entorno de consola.

## Funcionalidades Requeridas

### 1. Menú Principal
- El programa debe mostrar un menú principal con dos opciones:
  1. Introducir fecha de nacimiento.
  2. Salir del programa.
- La opción de introducir la fecha permitirá al usuario introducir su día y mes de nacimiento para determinar su signo zodiacal.
- La opción de salir debe finalizar la ejecución de la aplicación.

### 2. Introducción de Datos
- La aplicación solicitará al usuario que introduzca dos datos:
  - Día de nacimiento (número entero entre 1 y el número máximo de días del mes correspondiente).
  - Mes de nacimiento (número entero entre 1 y 12).

### 3. Validación de Fechas
- El programa debe validar que la fecha ingresada sea válida:
  - El mes debe estar dentro del rango permitido (1-12).
  - El día debe estar dentro del rango válido según el mes (por ejemplo, febrero no puede tener más de 29 días y abril no puede tener más de 30 días).
- Si la fecha no es válida, la aplicación debe mostrar un mensaje de error y permitir que el usuario lo intente de nuevo.

### 4. Cálculo del Signo Zodiacal
- La aplicación debe identificar el signo zodiacal del usuario según la fecha de nacimiento introducida, basándose en el rango de fechas de cada signo. Los signos zodiacales y sus fechas aproximadas son:

  - Aries: 21 de marzo - 20 de abril
  - Tauro: 21 de abril - 21 de mayo
  - Géminis: 22 de mayo - 21 de junio
  - Cáncer: 22 de junio - 23 de julio
  - Leo: 24 de julio - 23 de agosto
  - Virgo: 24 de agosto - 23 de septiembre
  - Libra: 24 de septiembre - 23 de octubre
  - Escorpio: 24 de octubre - 22 de noviembre
  - Sagitario: 23 de noviembre - 21 de diciembre
  - Capricornio: 22 de diciembre - 20 de enero
  - Acuario: 21 de enero - 19 de febrero
  - Piscis: 20 de febrero - 20 de marzo

- Si la fecha de nacimiento es válida, el programa debe devolver el nombre del signo zodiacal correspondiente. Si no lo es, debe mostrar un mensaje de error.

### 5. Descripción del Signo Zodiacal
- Junto con el signo zodiacal, el programa debe mostrar una breve descripción de las características típicas de ese signo. La descripción debe ser una cadena de texto que resuma algunos rasgos de personalidad típicos de los nativos de ese signo.

### 6. Finalización del Programa
- El programa debe permitir al usuario finalizar en cualquier momento seleccionando la opción "Salir" en el menú principal.
- Al finalizar, el programa debe cerrar el objeto `Scanner` utilizado para la entrada de datos.

## Requisitos Técnicos
- El programa debe estar implementado en el lenguaje de programación **Java**.
- Debe utilizar estructuras de control como bucles (`while` o `for`), estructuras condicionales (`if-else` o `switch`), y al menos una función para dividir la lógica (además del método `main`).
- El programa debe controlar las posibles entradas incorrectas del usuario, como un número fuera de los límites permitidos para el día o el mes.

## Ejemplo de Uso

1. **Menú**:
    ```
    1. Introducir fecha de nacimiento
    2. Salir
    ```

2. **Introducción de la fecha**:
    ```
    Introduce tu día de nacimiento: 15
    Introduce tu mes de nacimiento (1-12): 8
    ```

3. **Resultado**:
    ```
    Tu signo zodiacal es: Leo
    Descripción: Los Leo son seguros, generosos y apasionados.
    ```

4. **Mensaje de error por fecha incorrecta**:
    ```
    Introduce tu día de nacimiento: 31
    Introduce tu mes de nacimiento (1-12): 2
    Fecha incorrecta. Inténtalo de nuevo.
    ```

## Opcional
- Añadir la capacidad de controlar años bisiestos, donde febrero puede tener 29 días.
- Incluir más información sobre cada signo, como compatibilidades con otros signos, números de la suerte, etc.
- Permitir que el usuario introduzca su nombre y personalizar el mensaje de salida, por ejemplo: "¡Hasta luego, Juan!"

