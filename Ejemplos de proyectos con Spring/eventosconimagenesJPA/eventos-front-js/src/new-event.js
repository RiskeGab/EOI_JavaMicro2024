import { EventosService } from "./clases/eventos-service";

const eventosService = new EventosService();

const imgPreview = document.getElementById("imgPreview");
const form = document.getElementById("formEvento");

const imgInput = form.imagen;
imgInput.addEventListener("change", () => {
  if (!imgInput.files?.length) return;

  const reader = new FileReader();
  reader.readAsDataURL(imgInput.files[0]);
  reader.addEventListener(
    "loadend",
    () => {
        imgPreview.classList.remove("d-none");
        imgPreview.src = reader.result;
    }
  );
});

form.addEventListener("submit", async e => {
    e.preventDefault();

    const evento = {
        titulo: form.titulo.value,
        descripcion: form.descripcion.value,
        precio: +form.precio.value,
        fecha: form.fecha.value,
        imagen: imgPreview.src
    }

    await eventosService.addEvento(evento);
    location.assign("index.html");
});
