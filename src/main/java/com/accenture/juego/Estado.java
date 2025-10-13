package com.accenture.juego;
/*
 * Uso de un enum para Estado. ¿Por qué un enum, y no otra cosa como una lista?
 * Porque un enum solo puedo instanciarlo desde la clase que lo implementa. De esta 
 * manera solo puedo tener un objeto de tipo Estado en Partida. No implementamos persistencia
 * ni historial de partidas de momento, así que eliminamos el GUARDADO
 */
public enum Estado {
    ACIERTO,
    ERROR,
    FALLO,
}
