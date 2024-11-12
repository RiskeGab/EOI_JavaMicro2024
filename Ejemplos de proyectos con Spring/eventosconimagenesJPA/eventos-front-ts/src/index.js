import { EventosService } from "./clases/eventos-service";

const eventosService = new EventosService();

const eventoTemplate = document.getElementById("eventoTemplate")
const cardContainer = document.getElementById("cardContainer");

async function cargarEventos() {
  const eventos = await eventosService.getEventos();
  eventos.forEach(addEvento);
}

function addEvento(evento) {
  const clone = eventoTemplate.content.cloneNode(true);
  const img = clone.querySelector(".card-img-top");
  img.src = evento.imagen;
  clone.querySelector(".card-title").textContent = evento.titulo;
  clone.querySelector(".card-text").textContent = evento.descripcion;

  clone.querySelector(".fecha").textContent = new Intl.DateTimeFormat(
    "es-ES",
    { dateStyle: "medium" }
  ).format(new Date(evento.fecha));

  clone.querySelector(".precio").textContent = new Intl.NumberFormat("es-ES", {
    style: "currency", currency: "EUR"
  }).format(evento.precio);

  const col = clone.firstElementChild; // Obtenemos la referencia al div.col antes de insertar el template
  clone.querySelector("button.delete").addEventListener("click", async () => {
    await eventosService.deleteEvento(evento.id);
    col.remove(); // Borramos el div.col
  });

  cardContainer.append(clone);
}

/* MAIN */
cargarEventos();
