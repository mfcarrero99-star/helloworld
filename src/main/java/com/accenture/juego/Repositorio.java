package com.accenture.juego;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    List <Gameable> listajuegos = new ArrayList<>();
    
    public void addJuego(Gameable juego) {
        listajuegos.add(juego);
    }

    public void mostrar(){

    }
    public void deleteJuego(Gameable juego) {
    }
}
