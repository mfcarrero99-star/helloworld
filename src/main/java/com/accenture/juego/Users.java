package com.accenture.juego;

public class Users {
    private String user
    private Partida ultimaPartida

    public User(String user){ //constructor de usuario
        this.user = user
    }
    public String getUser(){ //getter de Usuario
        return user;
    }
    public Partida getUltimaPartida(){ //getter de la ultima partida del usuario 
        return ultimaPartida;
    }
    public Partida setUltimaPartida(){ //setter de la ultima partida del usuario, siempre por default a la partida actual 
        this.ultimaPartida = partida
    }
}
