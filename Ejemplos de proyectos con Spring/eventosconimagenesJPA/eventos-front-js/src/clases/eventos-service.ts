import { SERVER } from "../constants";
import { Evento } from "../interfaces/evento";
import { EventoResponse, EventosResponse } from "../interfaces/responses";
import { Http } from "./http";

export class EventosService {
    #http: Http = new Http();

    async getEventos(): Promise<Evento[]> {
        const resp = await this.#http.get<EventosResponse>(`${SERVER}/eventos`); 
        return resp.eventos;
    }

    async addEvento(evento: Evento): Promise<Evento>  {
        const resp = await this.#http.post<EventoResponse, Evento>(`${SERVER}/eventos`, evento);
        return resp.evento;
    }

    deleteEvento(id: number): Promise<void> {
        return this.#http.delete<void>(`${SERVER}/eventos/${id}`);
    }
}