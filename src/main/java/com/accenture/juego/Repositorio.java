package com.accenture.juego;
import java.util.ArrayList;
import java.util.List;
import org.reflections.Reflections;

import com.accenture.juego.guessgame.GuessGame;
/*
 * Clase que almacena todos los juegos disponibles, es decir, las clases que implementen
 * Gameable y que además las instancia para que el usuario pueda acceder a ellas. Como podemos
 * tener muchos objetos de tipo Gameable, para que la idea sea escalable usaremos la librería
 * Reflections. Para que no salte una excepción es clave que los objetos de tipo Gameable tengan
 * el constructor vacío. Recordemos que el usuario y el scanner se pasan en startMenu de Gameable, 
 * no en su constructor, luego en otros tipos de Gameables no debería de suponer un problema. 
 */


public class Repositorio {
    private List <Gameable> listajuegos;

    public Repositorio() {
        listajuegos = new ArrayList<>();
        listajuegos.add(new GuessGame()); // el usuario y scanner se pasan en runtime
    }


    public List<Gameable> getJuegos() {
        return listajuegos;
    }
}


