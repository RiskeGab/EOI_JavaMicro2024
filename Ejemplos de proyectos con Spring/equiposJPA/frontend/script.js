const urlEquipos = 'http://localhost:8080/equipos';
const urlJugadores = 'http://localhost:8080/jugadores';

const tablaEquipos = document.querySelector('#tablaEquipos tbody');
const tablaJugadores = document.querySelector('#tablaJugadores tbody');
const selectEquipo = document.getElementById('jugadorEquipo');

// Cargar lista de equipos en el select de jugadores
async function cargarEquiposEnSelect() {
    const response = await fetch(urlEquipos);
    const equipos = await response.json();
    selectEquipo.innerHTML = '<option value="">Seleccione un equipo</option>'; // Opción por defecto
    equipos.forEach(equipo => {
        const option = document.createElement('option');
        option.value = equipo.id;
        option.textContent = equipo.nombre;
        selectEquipo.appendChild(option);
    });
}

function toggleFormulario(formularioId) {
    const formulario = document.getElementById(formularioId);
    formulario.style.display = formulario.style.display === 'none' || formulario.style.display === '' ? 'block' : 'none';
}

// Funciones para Equipos
async function cargarEquipos() {
    const response = await fetch(urlEquipos);
    const equipos = await response.json();
    tablaEquipos.innerHTML = '';
    equipos.forEach(addEquipo);
}

function addEquipo(equipo) {
    const row = document.createElement('tr');
    
    const idCell = document.createElement('td');
    idCell.textContent = equipo.id;
    
    const nombreCell = document.createElement('td');
    nombreCell.textContent = equipo.nombre;

    const ciudadCell = document.createElement('td');
    ciudadCell.textContent = equipo.ciudad;

    const fechaCreacionCell = document.createElement('td');
    fechaCreacionCell.textContent = equipo.fechaCreacion;

    const actionsCell = document.createElement('td');
    const editIcon = document.createElement('i');
    editIcon.className = 'bi bi-pencil-square text-warning me-2';
    editIcon.style.cursor = 'pointer';
    editIcon.addEventListener('click', () => editarEquipo(equipo.id));

    const deleteIcon = document.createElement('i');
    deleteIcon.className = 'bi bi-trash text-danger';
    deleteIcon.style.cursor = 'pointer';
    deleteIcon.addEventListener('click', () => eliminarEquipo(equipo.id));

    actionsCell.appendChild(editIcon);
    actionsCell.appendChild(deleteIcon);

    row.appendChild(idCell);
    row.appendChild(nombreCell);
    row.appendChild(ciudadCell);
    row.appendChild(fechaCreacionCell);
    row.appendChild(actionsCell);

    tablaEquipos.appendChild(row);
}

function limpiarFormularioEquipo() {
    document.getElementById('equipoId').value = '';
    document.getElementById('equipoNombre').value = '';
    document.getElementById('equipoCiudad').value = '';
    document.getElementById('equipoFechaCreacion').value = '';
}

async function guardarEquipo() {
    const id = document.getElementById('equipoId').value;
    const nombre = document.getElementById('equipoNombre').value;
    const ciudad = document.getElementById('equipoCiudad').value;
    const fechaCreacion = document.getElementById('equipoFechaCreacion').value;
    const equipo = { nombre, ciudad, fechaCreacion };

    let url = urlEquipos;
    let method = 'POST';
    if (id) {
        url += `/${id}`;
        method = 'PUT';
    }
    await fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(equipo)
    });
    document.getElementById('formularioEquipo').style.display = 'none';
    limpiarFormularioEquipo();
    cargarEquipos();
}

async function eliminarEquipo(id) {
    await fetch(`${urlEquipos}/${id}`, { method: 'DELETE' });
    cargarEquipos();
}

async function editarEquipo(id) {
    const response = await fetch(`${urlEquipos}/${id}`);
    const equipo = await response.json();

    document.getElementById('equipoId').value = equipo.id;
    document.getElementById('equipoNombre').value = equipo.nombre;
    document.getElementById('equipoCiudad').value = equipo.ciudad;

    document.getElementById('formularioEquipo').style.display = 'block';
}

// Funciones para Jugadores
async function cargarJugadores() {
    const response = await fetch(urlJugadores);
    const jugadores = await response.json();
    tablaJugadores.innerHTML = '';
    jugadores.forEach(addJugador);
}

function addJugador(jugador) {
    const row = document.createElement('tr');
        
    const idCell = document.createElement('td');
    idCell.textContent = jugador.id;

    const nombreCell = document.createElement('td');
    nombreCell.textContent = jugador.nombre;

    const posicionCell = document.createElement('td');
    posicionCell.textContent = jugador.posicion;

    const equipoCell = document.createElement('td');
    equipoCell.textContent = jugador.equipo.nombre;

    const actionsCell = document.createElement('td');
    const editIcon = document.createElement('i');
    editIcon.className = 'bi bi-pencil-square text-warning me-2';
    editIcon.style.cursor = 'pointer';
    editIcon.addEventListener('click', () => editarJugador(jugador.id));

    const deleteIcon = document.createElement('i');
    deleteIcon.className = 'bi bi-trash text-danger';
    deleteIcon.style.cursor = 'pointer';
    deleteIcon.addEventListener('click', () => eliminarJugador(jugador.id));

    actionsCell.appendChild(editIcon);
    actionsCell.appendChild(deleteIcon);

    row.appendChild(idCell);
    row.appendChild(nombreCell);
    row.appendChild(posicionCell);
    row.appendChild(equipoCell);
    row.appendChild(actionsCell);

    tablaJugadores.appendChild(row);
}

function limpiarFormularioJugador() {
    document.getElementById('jugadorId').value = '';
    document.getElementById('jugadorNombre').value = '';
    document.getElementById('jugadorPosicion').value = '';
    document.getElementById('jugadorEquipo').value = '';
}

async function guardarJugador() {
    const id = document.getElementById('jugadorId').value;
    const nombre = document.getElementById('jugadorNombre').value;
    const posicion = document.getElementById('jugadorPosicion').value;
    const equipo = document.getElementById('jugadorEquipo').value;
    const jugador = { nombre, posicion, equipo: { id: equipo } };
    let url = urlJugadores;
    let method = 'POST';
    if (id) {
        url += `/${id}`;
        method = 'PUT';
    }
    await fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(jugador)
    });
    document.getElementById('formularioJugador').style.display = 'none';
    limpiarFormularioJugador();
    cargarJugadores();
}

async function eliminarJugador(id) {
    await fetch(`${urlJugadores}/${id}`, { method: 'DELETE' });
    cargarJugadores();
}

async function editarJugador(id) {
    const response = await fetch(`${urlJugadores}/${id}`);
    const jugador = await response.json();

    document.getElementById('jugadorId').value = jugador.id;
    document.getElementById('jugadorNombre').value = jugador.nombre;
    document.getElementById('jugadorPosicion').value = jugador.posicion;
    document.getElementById('jugadorEquipo').value = jugador.equipo.nombre;

    document.getElementById('formularioJugador').style.display = 'block';
}

// Inicialización
cargarEquipos();
cargarJugadores();
cargarEquiposEnSelect();

document.getElementById('btnAgregarEquipo').addEventListener('click', () => {
    limpiarFormularioEquipo();
    toggleFormulario('formularioEquipo');
});

document.getElementById('btnGuardarEquipo').addEventListener('click', guardarEquipo);

document.getElementById('btnAgregarJugador').addEventListener('click', () => {
    limpiarFormularioJugador();
    toggleFormulario('formularioJugador');
});

document.getElementById('btnGuardarJugador').addEventListener('click', guardarJugador);

document.getElementById('toggleTheme').addEventListener('click', () => {
    const body = document.body;
    const themeIcon = document.getElementById('themeIcon');
    
    if (body.getAttribute('data-bs-theme') === 'dark') {
        body.setAttribute('data-bs-theme', 'light');
        themeIcon.classList.replace('bi-moon-fill', 'bi-sun-fill'); 
    } else {
        body.setAttribute('data-bs-theme', 'dark');
        themeIcon.classList.replace('bi-sun-fill', 'bi-moon-fill');
    }
});
