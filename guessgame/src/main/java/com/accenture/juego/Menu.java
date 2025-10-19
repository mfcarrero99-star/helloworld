package com.accenture.juego;
import com.accenture.juego.io.*;
/*
 * Clase abstracta Menú. Hace referencia a la pantalla o menú inicial que ve el usuario y
 * con el que interactua al entrar en un juego (Gameable). No solo permite iniciar el 
 * juego sino también parar, reanudar, ver historial si existe, etc. 
 */
public abstract class Menu {
    protected User user;
    protected Gameable juego;
    protected InputProvider input;
    protected OutputProvider output;
//constructor del Menú que asegura que sea menú de un juego. 
//Pasamos el usuario creado al identificarse en Main.
public Menu(User user, Gameable juego, InputProvider input, OutputProvider output) {
    this.user = user;
    this.juego = juego;
    this.input = input;
    this.output = output;
}


public void mostrarBienvenida() {
    output.print("Bienvenido" + user.getNombre() + " al juego " + juego.getGameName());
    }

public abstract void iniciar();

public boolean deseaVolverAlMenuPrincipal() {

    }
}




