const urlUsuarios = 'http://localhost:8080/usuarios';
const urlEventos = 'http://localhost:8080/eventos';

const tablaUsuarios = document.querySelector('#tablaUsuarios tbody');
const tablaEventos = document.querySelector('#tablaEventos tbody');

function toggleFormulario(formularioId) {
    const formulario = document.getElementById(formularioId);
    formulario.style.display = formulario.style.display === 'none' || formulario.style.display === '' ? 'block' : 'none';
}

// Funciones para Usuarios
async function cargarUsuarios() {
    const response = await fetch(urlUsuarios);
    const usuarios = await response.json();
    tablaUsuarios.innerHTML = '';
    usuarios.forEach(addUsuario);
}

function addUsuario(usuario) {
    const row = document.createElement('tr');
        
    const idCell = document.createElement('td');
    idCell.textContent = usuario.id;
    
    const nombreCell = document.createElement('td');
    nombreCell.textContent = usuario.nombre;

    const correoCell = document.createElement('td');
    correoCell.textContent = usuario.correo;
    
    const actionsCell = document.createElement('td');
    const editIcon = document.createElement('i');
    editIcon.className = 'bi bi-pencil-square text-warning me-2';
    editIcon.style.cursor = 'pointer';
    editIcon.addEventListener('click', () => editarUsuario(usuario.id));

    const deleteIcon = document.createElement('i');
    deleteIcon.className = 'bi bi-trash text-danger';
    deleteIcon.style.cursor = 'pointer';
    deleteIcon.addEventListener('click', () => eliminarUsuario(usuario.id));

    actionsCell.appendChild(editIcon);
    actionsCell.appendChild(deleteIcon);

    row.appendChild(idCell);
    row.appendChild(nombreCell);
    row.appendChild(correoCell);
    row.appendChild(actionsCell);

    tablaUsuarios.appendChild(row);
}

function limpiarFormularioUsuario() {
    document.getElementById('usuarioId').value = '';
    document.getElementById('usuarioNombre').value = '';
    document.getElementById('usuarioCorreo').value = '';
}

async function guardarUsuario() {
    const id = document.getElementById('usuarioId').value;
    const nombre = document.getElementById('usuarioNombre').value;
    const correo = document.getElementById('usuarioCorreo').value;
    const usuario = { nombre, correo };
    let url = urlUsuarios;
    let method = 'POST';
    if (id) {
        url += `/${id}`;
        method = 'PUT';
    }
    await fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(usuario)
    });
    document.getElementById('formularioUsuario').style.display = 'none';
    limpiarFormularioUsuario();
    cargarUsuarios();
}

async function eliminarUsuario(id) {
    await fetch(`${urlUsuarios}/${id}`, { method: 'DELETE' });
    cargarUsuarios();
}

async function editarUsuario(id) {
    const response = await fetch(`${urlUsuarios}/${id}`);
    const usuario = await response.json();

    document.getElementById('usuarioId').value = usuario.id;
    document.getElementById('usuarioNombre').value = usuario.nombre;
    document.getElementById('usuarioCorreo').value = usuario.correo;

    document.getElementById('formularioUsuario').style.display = 'block';
}

// Funciones para Eventos
async function cargarEventos() {
    const response = await fetch(urlEventos);
    const eventos = await response.json();
    tablaEventos.innerHTML = '';
    eventos.forEach(addEvento);
}

function addEvento(evento) {
    const row = document.createElement('tr');
        
    const idCell = document.createElement('td');
    idCell.textContent = evento.id;

    const tituloCell = document.createElement('td');
    tituloCell.textContent = evento.titulo;

    const descripcionCell = document.createElement('td');
    descripcionCell.textContent = evento.descripcion;

    const precioCell = document.createElement('td');
    precioCell.textContent = evento.precio;

    const fechaCell = document.createElement('td');
    fechaCell.textContent = evento.fecha;

    const actionsCell = document.createElement('td');
    const editIcon = document.createElement('i');
    editIcon.className = 'bi bi-pencil-square text-warning me-2';
    editIcon.style.cursor = 'pointer';
    editIcon.addEventListener('click', () => editarEvento(evento.id));

    const deleteIcon = document.createElement('i');
    deleteIcon.className = 'bi bi-trash text-danger';
    deleteIcon.style.cursor = 'pointer';
    deleteIcon.addEventListener('click', () => eliminarEvento(evento.id));

    actionsCell.appendChild(editIcon);
    actionsCell.appendChild(deleteIcon);

    row.appendChild(idCell);
    row.appendChild(tituloCell);
    row.appendChild(descripcionCell);
    row.appendChild(precioCell);
    row.appendChild(fechaCell);
    row.appendChild(actionsCell);

    tablaEventos.appendChild(row);
}

function limpiarFormularioEvento() {
    document.getElementById('eventoId').value = '';
    document.getElementById('eventoTitulo').value = '';
    document.getElementById('eventoDescripcion').value = '';
    document.getElementById('eventoPrecio').value = '';
    document.getElementById('eventoFecha').value = '';
}

async function guardarEvento() {
    const id = document.getElementById('eventoId').value;
    const titulo = document.getElementById('eventoTitulo').value;
    const descripcion = document.getElementById('eventoDescripcion').value;
    const precio = document.getElementById('eventoPrecio').value;
    const fecha = document.getElementById('eventoFecha').value;
    const evento = { titulo, descripcion, precio, fecha };
    let url = urlEventos;
    let method = 'POST';
    if (id) {
        url += `/${id}`;
        method = 'PUT';
    }
    await fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(evento)
    });
    document.getElementById('formularioEvento').style.display = 'none';
    limpiarFormularioEvento();
    cargarEventos();
}

async function eliminarEvento(id) {
    await fetch(`${urlEventos}/${id}`, { method: 'DELETE' });
    cargarEventos();
}

async function editarEvento(id) {
    const response = await fetch(`${urlEventos}/${id}`);
    const evento = await response.json();

    document.getElementById('eventoId').value = evento.id;
    document.getElementById('eventoTitulo').value = evento.titulo;
    document.getElementById('eventoDescripcion').value = evento.descripcion;
    document.getElementById('eventoPrecio').value = evento.precio;
    document.getElementById('eventoFecha').value = evento.fecha;

    document.getElementById('formularioEvento').style.display = 'block';
}

// Inicialización
cargarUsuarios();
cargarEventos();

document.getElementById('btnAgregarUsuario').addEventListener('click', () => {
    limpiarFormularioUsuario();
    toggleFormulario('formularioUsuario');
});

document.getElementById('btnGuardarUsuario').addEventListener('click', guardarUsuario);

document.getElementById('btnAgregarEvento').addEventListener('click', () => {
    limpiarFormularioEvento();
    toggleFormulario('formularioEvento');
});

document.getElementById('btnGuardarEvento').addEventListener('click', guardarEvento);
