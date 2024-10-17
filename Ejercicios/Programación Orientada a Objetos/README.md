# Ejercicios de Introducción a la POO

Este directorio contiene una serie de ejercicios enfocados en la Programación Orientada a Objetos (POO) en Java. Cada uno de los ejercicios está implementado en las clases correspondientes.

## Enunciados

### 1. Clase `Persona`
- Crea una clase llamada `Persona` con dos propiedades: `nombre` y `edad`.
- Implementa los setters y getters, verificando que la edad no sea negativa.
- Crea un constructor que reciba `nombre` y `edad`.
- Prueba a crear un objeto `Persona` e intenta asignarle una edad negativa, comprobando que no cambia.
- Muestra un mensaje en consola con el formato: `Pepito tiene 16 años`.

### 2. Método `saluda`
- Crea un método `saluda` en la clase `Persona` que no reciba ni devuelva nada.
- El método debe mostrar el mismo mensaje del ejercicio anterior.
- Modifica el `main` para llamar a este método.

### 3. Constructor de copia
- Añade un constructor de copia en la clase `Persona`.
- Crea una nueva persona a partir de un objeto existente y modifica su `nombre` y `edad`, comprobando que no afecta al objeto original.
- Prueba primero con una asignación directa (`Persona p2 = p1;`) para ver cómo no estás copiando el objeto.

### 4. Array de Personas
- Crea un array de 4 personas y recórrelo, llamando al método `saluda` de cada una.

### 5. Método estático `copiaArray`
- Crea un método estático `copiaArray` que reciba un array de personas y devuelva otro array con copias de los objetos.
- En el `main`, crea una copia del array del ejercicio anterior, modifica las propiedades de una persona en el array copiado, y verifica que el array original no ha sido modificado.

### 6. Manejo de posiciones `null` en el array
- Introduce posiciones `null` en el array de personas.
- Modifica el método `copiaArray` para manejar correctamente los valores `null`, copiando solo las posiciones que no sean `null`.

### 7. Método `estoyEnArray`
- Crea un método `estoyEnArray` en la clase `Persona` que reciba un array de personas y devuelva un booleano indicando si el objeto actual (`this`) está en el array.
- Guarda personas en variables y añádelas al array para probar el método. Muestra un mensaje que indique si la persona se encuentra o no en el array.

### 8. Clase `Empresa`
- Crea una clase `Empresa` con las propiedades `nombre` y `empleados` (array de `Persona`).
- Agrega la propiedad `numEmpleados` para llevar la cuenta de cuántos empleados tiene la empresa.
- Crea un constructor que reciba el `nombre` de la empresa e inicialice el array de empleados con 100 posiciones, asignando `numEmpleados` a 0.
- Muestra el mensaje: `He creado la empresa (nombre de la empresa)`.

### 9. Método `contrataEmpleado`
- Crea el método `contrataEmpleado` en la clase `Empresa` para añadir un empleado al final del array.
- Contrata 3 empleados en la empresa y recorre el array mostrando los datos de los empleados.

### 10. Métodos `despideEmpleado`
- Crea dos métodos `despideEmpleado` en la clase `Empresa`:
  - El primero recibe la posición del array de empleados a eliminar.
  - El segundo recibe el nombre del empleado a eliminar (sobrecarga del método).
- Prueba ambos métodos, contratando varios empleados, eliminando algunos por posición y otros por nombre, y mostrando el estado del array de empleados tras las eliminaciones.
