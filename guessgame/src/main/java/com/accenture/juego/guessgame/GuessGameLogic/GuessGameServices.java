package com.accenture.juego.guessgame.guessgamelogic;
//Clase GuessGame antigua, con Partida y Estado para controlar toda la lógica
public class GuessGameServices {

    public PartidaGuessGame nuevaPartida() {
        return new PartidaGuessGame();
    }
    
    public EstadoGuessGame procesarIntento(PartidaGuessGame partida, int intento)  {
        if (intento < 1 || intento > 100) return EstadoGuessGame.ERROR;
        if (intento == partida.getNumeroSecreto()) return EstadoGuessGame.ACIERTO;
        return EstadoGuessGame.FALLO;
    }
}
