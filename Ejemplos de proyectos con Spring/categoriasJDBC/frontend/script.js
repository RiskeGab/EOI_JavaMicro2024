const urlCategories = 'http://localhost:8080/categories';
const urlProducts = 'http://localhost:8080/products';

const tabla = document.querySelector('#tablaCategorias tbody');

// Funciones para Categorías
async function cargarCategorias() {
    const response = await fetch(urlCategories);
    const categorias = await response.json();
    tabla.innerHTML = '';
    categorias.forEach(addCategoria);
}

function addCategoria(cat) {
    const row = document.createElement('tr');
        
    const idCell = document.createElement('td');
    idCell.textContent = cat.id;
    
    const nameCell = document.createElement('td');
    nameCell.style.cursor = "pointer";
    nameCell.textContent = cat.name;

    nameCell.addEventListener("click", () => {
        cargarProductos(cat.id);
        document.querySelector(".selected")?.classList.remove("selected");
        row.classList.add("selected");
    });
    
    const actionsCell = document.createElement('td');
    const editIcon = document.createElement('i');
    editIcon.className = 'bi bi-pencil-square text-warning me-2';
    editIcon.style.cursor = 'pointer';
    editIcon.addEventListener('click', () => editarCategoria(cat.id, cat.name));
    
    const deleteIcon = document.createElement('i');
    deleteIcon.className = 'bi bi-trash text-danger';
    deleteIcon.style.cursor = 'pointer';
    deleteIcon.addEventListener('click', () => eliminarCategoria(cat.id ,row));

    actionsCell.appendChild(editIcon);
    actionsCell.appendChild(deleteIcon);
    
    row.appendChild(idCell);
    row.appendChild(nameCell);
    row.appendChild(actionsCell);
    
    tabla.appendChild(row);
}

function mostrarFormularioCategoria() {
    document.getElementById('formularioCategoria').style.display = 'block';
}

function limpiarFormularioCategoria() {
    document.getElementById('categoriaId').value = '';
    document.getElementById('categoriaNombre').value = '';
}

async function guardarCategoria() {
    const id = document.getElementById('categoriaId').value;
    const nombre = document.getElementById('categoriaNombre').value;
    const categoria = { name: nombre };
    let url = urlCategories;
    let method = 'POST';
    if (id) {
        url += `/${id}`;
        method = 'PUT';
    }
    const resp = await fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(categoria)
    });
    document.getElementById('formularioCategoria').style.display = 'none';
    limpiarFormularioCategoria();
    if(!id) {
        addCategoria(await resp.json());
    } else {
        cargarCategorias();
    }
}

async function eliminarCategoria(id, row) {
    await fetch(`${urlCategories}/${id}`, { method: 'DELETE' });
    row.remove();
}

function editarCategoria(id, nombre) {
    document.getElementById('categoriaId').value = id;
    document.getElementById('categoriaNombre').value = nombre;
    mostrarFormularioCategoria();
}

// Funciones para Productos
async function cargarProductos(category) {
    const urlParams = new URLSearchParams({ category });
    const response = await fetch(`${urlProducts}?${urlParams}`);
    const productos = await response.json();
    const tabla = document.querySelector('#tablaProductos tbody');
    tabla.innerHTML = '';
    productos.forEach(prod => {
        const row = document.createElement('tr');

        const idCell = document.createElement('td');
        idCell.textContent = prod.id;

        const refCell = document.createElement('td');
        refCell.textContent = prod.reference;

        const nameCell = document.createElement('td');
        nameCell.textContent = prod.name;

        const priceCell = document.createElement('td');
        priceCell.textContent = prod.price;

        const actionsCell = document.createElement('td');
        const editIcon = document.createElement('i');
        editIcon.className = 'bi bi-pencil-square text-warning me-2';
        editIcon.style.cursor = 'pointer';
        editIcon.addEventListener('click', () => editarProducto(prod.id));

        const deleteIcon = document.createElement('i');
        deleteIcon.className = 'bi bi-trash text-danger';
        deleteIcon.style.cursor = 'pointer';
        deleteIcon.addEventListener('click', () => eliminarProducto(prod.id));

        actionsCell.appendChild(editIcon);
        actionsCell.appendChild(deleteIcon);

        row.appendChild(idCell);
        row.appendChild(refCell);
        row.appendChild(nameCell);
        row.appendChild(priceCell);
        row.appendChild(actionsCell);

        tabla.appendChild(row);
    });
}

function mostrarFormularioProducto() {
    document.getElementById('formularioProducto').style.display = 'block';
}

function limpiarFormularioProducto() {
    document.getElementById('productoId').value = '';
    document.getElementById('productoReferencia').value = '';
    document.getElementById('productoNombre').value = '';
    document.getElementById('productoPrecio').value = '';
    document.getElementById('productoCategoria').value = '';
}

async function guardarProducto() {
    const id = document.getElementById('productoId').value;
    const referencia = document.getElementById('productoReferencia').value;
    const nombre = document.getElementById('productoNombre').value;
    const precio = document.getElementById('productoPrecio').value;
    const categoria = document.getElementById('productoCategoria').value;
    const producto = { reference: referencia, name: nombre, price: parseFloat(precio), idCategory: parseInt(categoria) };
    let url = urlProducts;
    let method = 'POST';
    if (id) {
        url += `/${id}`;
        method = 'PUT';
    }
    await fetch(url, {
        method,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(producto)
    });
    document.getElementById('formularioProducto').style.display = 'none';
    limpiarFormularioProducto();
    cargarProductos();
}

async function eliminarProducto(id) {
    await fetch(`${urlProducts}/${id}`, { method: 'DELETE' });
    cargarProductos();
}

async function editarProducto(id) {
    const response = await fetch(`${urlProducts}/${id}`);
    const producto = await response.json();

    document.getElementById('productoId').value = producto.id;
    document.getElementById('productoReferencia').value = producto.reference;
    document.getElementById('productoNombre').value = producto.name;
    document.getElementById('productoPrecio').value = producto.price;
    document.getElementById('productoCategoria').value = producto.category;

    mostrarFormularioProducto();
}

cargarCategorias();

document.getElementById('btnAgregarCategoria').addEventListener('click', () => {
    limpiarFormularioCategoria();
    mostrarFormularioCategoria();
});

document.getElementById('btnGuardarCategoria').addEventListener('click', guardarCategoria);

document.getElementById('btnAgregarProducto').addEventListener('click', () => {
    limpiarFormularioProducto();
    mostrarFormularioProducto();
});

document.getElementById('btnGuardarProducto').addEventListener('click', guardarProducto);


