const input = document.getElementById("input");
const output = document.getElementById("output");

input.addEventListener("input", () => {
    fetch(`http://localhost:8080/traducir?texto=${input.value}`)
    .then(respuesta => respuesta.text())
    .then(traduccion => output.innerText = traduccion);
});