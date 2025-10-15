package com.accenture.juego;
import java.util.ArrayList;
import java.util.List;

import com.accenture.juego.guessgame.GuessGame;

public class Repositorio {
    private List <Gameable> listajuegos;

    public Repositorio() {
        listajuegos = new ArrayList<>();
        listajuegos.add(new GuessGame()); // el usuario y scanner se pasan en runtime
    }

    public void addjuego(Gameable juego){//posible implementación: si encuentro un nuevo Gameable, añadelo
        listajuegos.add(juego);
    }

    public List<Gameable> getJuegos() {
        return listajuegos;
    }
}


