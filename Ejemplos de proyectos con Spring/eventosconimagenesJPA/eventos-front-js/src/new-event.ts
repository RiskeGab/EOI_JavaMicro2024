import { EventosService } from "./clases/eventos-service";
import { Evento } from "./interfaces/evento";

const eventosService = new EventosService();

const imgPreview = document.getElementById("imgPreview") as HTMLImageElement;
const form = document.getElementById("formEvento") as HTMLFormElement;

const imgInput = form.imagen as HTMLInputElement;
imgInput.addEventListener("change", () => {
  if (!imgInput.files?.length) return;

  const reader = new FileReader();
  reader.readAsDataURL(imgInput.files[0]);
  reader.addEventListener(
    "loadend",
    () => {
        imgPreview.classList.remove("d-none");
        imgPreview.src = reader.result as string;
    }
  );
});

form.addEventListener("submit", async e => {
    e.preventDefault();

    const evento: Evento = {
        titulo: form.titulo.value,
        descripcion: form.descripcion.value,
        precio: +form.precio.value,
        fecha: form.fecha.value,
        imagen: imgPreview.src
    }

    await eventosService.addEvento(evento);
    location.assign("index.html");
});
