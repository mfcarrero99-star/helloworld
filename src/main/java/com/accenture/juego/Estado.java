package com.accenture.juego;
/*
 * Uso de un enum para Estado. ¿Por qué un enum, y no otra cosa como una lista?
 * Porque un enum solo puedo instanciarlo desde la clase que lo implementa. De esta 
 * manera solo puedo tener un objeto de tipo Estado en Partida. Podría jugar con varios 
 * tipo de estados, por ejemplo, EstadodePartida y EstadodeJuego. 
 */
public enum Estado {
    EN_JUEGO,
    GANADA,
    ERROR,
    FALLO,
    TERMINADA,
}
