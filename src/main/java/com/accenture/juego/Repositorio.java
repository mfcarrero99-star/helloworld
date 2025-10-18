package com.accenture.juego;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import com.accenture.juego.hangmangame.HangmanGame;


public class Repositorio {
    private List <Class<?extends Gameable>> listajuegos;

    public Repositorio() {
        listajuegos = new ArrayList<>();
        buscarJuegos();
    }

    public void buscarJuegos(){
        Reflections reflections = new Reflections("com.accenture.juego"); // paquete base
        Set<Class<? extends Gameable>> subTypes = reflections.getSubTypesOf(Gameable.class);

        for (Class<? extends Gameable> juegoClass : subTypes) {
            if (!java.lang.reflect.Modifier.isAbstract(juegoClass.getModifiers())) {
                listajuegos.add(juegoClass);
            }
        }

    }

    public List<String> getNombresJuegos() {
         List<String> nombres = new ArrayList<>();
        for (Class<? extends Gameable> c : listajuegos) {
            try {
                Gameable juego = c.getDeclaredConstructor().newInstance(); // solo para obtener getGameName
                nombres.add(juego.getGameName());
            } catch (Exception e) {
                nombres.add("Error al crear juego: " + c.getSimpleName());
            }
        }
        return nombres;
    }
 public Class<? extends Gameable> getlistajuego(int index) {
        if (index < 0 || index >= listajuegos.size()) return null;
        return listajuegos.get(index);
    }

    public int cantidadJuegos() {
        return listajuegos.size();
    }
}



