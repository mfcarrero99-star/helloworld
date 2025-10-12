package com.accenture.juego;

public class Users {
    private String nombre
    private Partida ultimaPartida

    public User(String nombre){ //constructor de usuario
        this.nombre = nombre
    }
    public String getUser(){ //getter de Usuario
        return nombre;
    }
    public Partida getUltimaPartida(){ //getter de la ultima partida del usuario 
        return ultimaPartida;
    }
    public Partida setUltimaPartida(){ //setter de la ultima partida del usuario, siempre por default a la partida actual 
        this.ultimaPartida = partida
    }
}
