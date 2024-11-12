import { SERVER } from "../constants";
import { Http } from "./http";

export class EventosService {
    #http = new Http();

    async getEventos() {
        const resp = await this.#http.get(`${SERVER}/eventos`); 
        return resp.eventos;
    }

    async addEvento(evento)  {
        const resp = await this.#http.post(`${SERVER}/eventos`, evento);
        return resp.evento;
    }

    deleteEvento(id) {
        return this.#http.delete(`${SERVER}/eventos/${id}`);
    }
}