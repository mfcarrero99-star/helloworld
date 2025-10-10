package com.accenture.juego;

public abstract class Game {
    private String gamename;
    protected User nombreusuario;
    protected Partida partida;
    
public void initScreen(){
    System.out.println("Estás en la pantalla de inicio, ¿te gustaria iniciar una partida?")
}

public String getgamename(){
    return gamename
}
}
