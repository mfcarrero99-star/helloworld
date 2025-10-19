package com.accenture.juego.guessgame.guessgamelogic;
import java.util.Random;

public class PartidaGuessGame {
    private int numeroSecreto;

    public PartidaGuessGame() {
        this.numeroSecreto = generarNumeroSecreto();
    }
    
    private int generarNumeroSecreto() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public int getNumeroSecreto() {
        return numeroSecreto;
    }
    
}
