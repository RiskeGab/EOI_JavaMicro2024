const inputIngles = document.getElementById("ingles");
const outputEspanol = document.getElementById("espanol");

inputIngles.addEventListener("input", () => {
    fetch(`http://localhost:8080/traducir?texto=${inputIngles.value}`)
    .then(respuesta => respuesta.text())
    .then(traduccion => outputEspanol.value = traduccion);
});