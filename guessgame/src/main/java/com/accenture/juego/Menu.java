package com.accenture.juego;
import  java.util.Scanner;
/*
 * Clase abstracta Menú. Hace referencia a la pantalla o menú inicial que ve el usuario y
 * con el que interactua al entrar en un juego (Gameable). No solo permite iniciar el 
 * juego sino también parar, reanudar, ver historial si existe, etc. 
 */
public abstract class Menu {
    protected User user;
    protected Scanner scanner; //paso el scanner del main
    protected Gameable juego;
//constructor del Menú que asegura que sea menú de un juego. 
//Pasamos el usuario creado al identificarse en Main.
public Menu(User user, Scanner scanner, Gameable juego) {
    this.user = user;
    this.scanner = scanner;
    this.juego = juego;
}


public void mostrarBienvenida() {
    System.out.println("Bienvenido" + user.getNombre() + "al juego" + juego.getGameName());
    }

public abstract void iniciar();

public boolean deseaVolverAlMenuPrincipal() {
    System.out.println("¿Deseas volver al menú principal? (s/n)");
    String respuesta = scanner.nextLine().trim().toLowerCase();
    return respuesta.equals("s") || respuesta.equals("si");
    }
}




