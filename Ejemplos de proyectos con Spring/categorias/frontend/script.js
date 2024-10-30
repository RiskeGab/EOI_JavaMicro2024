fetch(`http://localhost:8080/categories`)
.then(respuesta => respuesta.json())
.then(respuesta => console.log(respuesta));
