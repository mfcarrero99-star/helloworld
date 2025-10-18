package com.accenture.juego;
//dejamos esta clase fuera de la carpeta guessgame porque para entrar a la consola tengo que ser usuario.
public class User {
    private String nombre;

    public User(String nombre){ //constructor de usuario
        this.nombre = nombre;
    }
    public String getNombre(){ //getter de Usuario
        return nombre;
    }

}
