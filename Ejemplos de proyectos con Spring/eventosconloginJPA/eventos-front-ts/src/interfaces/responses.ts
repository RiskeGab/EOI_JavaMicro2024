import { Evento } from "./evento";

export interface EventosResponse {
    eventos: Evento[];
}

export interface EventoResponse {
    evento: Evento;
}

export interface LoginResponse {
    accessToken: string;
}