package com.accenture.juego;
// en vez de usar una clase abstracta cambiamos a interfaz
//la razón es principalmente porque para que un juego tenga que ser jugable tengo que tener
//metodos, pero no es necesario que tenga por ejemplo una partida iniciada o en activo
//o que un user esté conectado. Luego crearemos una interfaz consola que funcione como flujo inicial
//para poder crear un repositorio de juegos, por eso estamos implementando getGameName
public interface Gameable {
    Users getUser();
    String getGamename();
    void startPartida();     
    void closePartida();
}
