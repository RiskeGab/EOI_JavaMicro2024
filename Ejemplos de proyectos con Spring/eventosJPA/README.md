# Gestión de Usuarios y Eventos

Este proyecto es una aplicación web que permite la gestión de usuarios y eventos mediante operaciones CRUD (Crear, Leer, Actualizar, Eliminar). Se ha desarrollado una interfaz intuitiva para la administración y edición de datos, mientras que el backend maneja la lógica y persistencia de datos.

## Tabla de Contenidos

1. [Características](#características)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [Descripción de la Base de Datos](#descripción-de-la-base-de-datos)
5. [Uso](#uso)
6. [API Endpoints](#api-endpoints)
7. [Pruebas](#pruebas)
8. [Consideraciones de Diseño](#consideraciones-de-diseño)

## Características

- Administración de usuarios y eventos.
- CRUD completo de ambas entidades.
- Alternancia de tema oscuro/claro.
- Funcionalidad asíncrona mediante JavaScript.
- API REST con Spring Boot y persistencia con JPA.

## Tecnologías Utilizadas

- **Backend**: Java con Spring Boot, Spring Data JPA.
- **Frontend**: HTML, CSS y JavaScript, con Bootstrap para estilos y Bootstrap Icons.
- **API**: Comunicación asincrónica a través de Fetch API.

## Estructura del Proyecto

```plaintext
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/example/eventos
│   │   │       ├── eventos
│   │   │       │   ├── proyecciones
│   │   │       │   │   └── EventosSinUsuarios.java
│   │   │       │   ├── Evento.java
│   │   │       │   ├── EventosController.java
│   │   │       │   ├── EventosRespository.java
│   │   │       │   └── EventosService.java
│   │   │       ├── usuarios
│   │   │       │   ├── proyecciones
│   │   │       │   │   └── UsuarioSinEventos.java
│   │   │       │   ├── Usuario.java
│   │   │       │   ├── UsuariosController.java
│   │   │       │   ├── UsuariosRepository.java
│   │   │       │   └── UsuariosService.java
│   │   │       └── EventosApplication.java
│   ├── resources
│   │   ├── static
│   │   ├── templates
│   │   └── application.yaml
├── public
│   ├── index.html
│   └── script.js
└── README.md
```

## Descripción de la Base de Datos

La base de datos cuenta con dos tablas principales: `Usuario` y `Evento`, relacionadas de manera `muchos a muchos` a través de una tabla intermedia `usuario_asiste_evento`.

### Estructura de las Tablas

1. **Tabla `Usuario`**  
   - **Campos**:
     - `id`: Identificador único del usuario (auto-incremental).
     - `nombre`: Nombre del usuario.
     - `correo`: Correo electrónico del usuario.
   - **Relación**: Muchos usuarios pueden asistir a múltiples eventos a través de la relación `usuario_asiste_evento`.

2. **Tabla `Evento`**  
   - **Campos**:
     - `id`: Identificador único del evento (auto-incremental).
     - `titulo`: Título del evento.
     - `descripcion`: Descripción del evento.
     - `precio`: Precio del evento.
     - `fecha`: Fecha del evento.
   - **Relación**: Múltiples eventos pueden tener muchos asistentes.

3. **Tabla `usuario_asiste_evento` (Tabla intermedia)**  
   - Esta tabla une la relación `muchos a muchos` entre `Usuario` y `Evento`:
     - `usuario`: ID del usuario (clave ajena).
     - `evento`: ID del evento (clave ajena).

La configuración de esta base de datos facilita que un usuario pueda inscribirse en múltiples eventos y un evento pueda tener varios usuarios inscritos.

## Uso

### Interfaz de Usuario

1. **Gestión de Usuarios**: Añadir, editar y eliminar usuarios con campos para nombre y correo electrónico.
2. **Gestión de Eventos**: Administrar eventos con información detallada, incluyendo título, descripción, precio y fecha.
3. **Alternancia de Tema**: Cambia entre temas claro y oscuro mediante un botón en la esquina superior derecha.

### Funcionalidad Asíncrona

Las operaciones de añadir, editar y eliminar usuarios o eventos se realizan sin necesidad de recargar la página, gracias a Fetch API en `script.js`.

## API Endpoints

La API REST incluye los siguientes endpoints:

### Usuarios

- **GET** `/usuarios` - Listado de usuarios.
- **GET** `/usuarios/{id}` - Información de un usuario específico.
- **POST** `/usuarios` - Crear un usuario nuevo.
- **PUT** `/usuarios/{id}` - Actualizar un usuario existente.
- **DELETE** `/usuarios/{id}` - Eliminar un usuario.

### Eventos

- **GET** `/eventos` - Listado de eventos.
- **GET** `/eventos/{id}` - Información de un evento específico.
- **POST** `/eventos` - Crear un evento nuevo.
- **PUT** `/eventos/{id}` - Actualizar un evento existente.
- **DELETE** `/eventos/{id}` - Eliminar un evento.

## Pruebas

### Pruebas con Postman

Se han realizado pruebas exhaustivas de la API utilizando **Postman** para validar el correcto funcionamiento de cada endpoint. Estas pruebas se ejecutaron en la aplicación externa de Postman, probando las operaciones de CRUD para usuarios y eventos, así como la correcta respuesta y formato de datos.

Además, se utilizó la extensión de **Postman en VS Code** para facilitar las pruebas directamente desde el entorno de desarrollo. Esto permitió iterar rápidamente en los casos de prueba y verificar la funcionalidad de la API sin cambiar de aplicación.

## Consideraciones de Diseño

### Backend

- **Persistencia con JPA**: Las entidades `Usuario` y `Evento` se mapean en tablas de la base de datos y sus operaciones se manejan a través de `UsuariosRepository` y `EventosRepository`.
- **Proyecciones**: El uso de `UsuarioSinEventos` y `EventoSinUsuarios` en los paquetes `proyecciones` permite optimizar ciertas consultas excluyendo datos innecesarios de la relación.

### Frontend

- **Interactividad**: El archivo `script.js` maneja la interacción en la interfaz, incluyendo la carga inicial y el manejo de eventos de usuario.
- **Estilo y Responsividad**: Uso de Bootstrap para un diseño responsivo.
- **Tema Oscuro/Claro**: El tema puede alternarse dinámicamente.
