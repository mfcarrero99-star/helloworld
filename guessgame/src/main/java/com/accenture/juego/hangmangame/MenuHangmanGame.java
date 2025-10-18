package com.accenture.juego.hangmangame;

import com.accenture.juego.Menu;
import com.accenture.juego.User;
import java.util.Scanner;
import com.accenture.juego.Gameable;

public class MenuHangmanGame extends Menu{
    public MenuHangmanGame(User user, Scanner scanner, Gameable juego) {
        super(user, scanner, juego);
    }

    @Override
    public void iniciar() {
    mostrarBienvenida();
    boolean jugar = true;

    while (jugar) {
        juego.startGame();
        juego.closeGame();

        System.out.print("¿Quieres jugar otra partida? (s/n): ");
        String res = scanner.nextLine().trim().toLowerCase();
        jugar = res.equals("s") || res.equals("si");
    }
}


}

