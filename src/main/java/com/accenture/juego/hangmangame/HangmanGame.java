package com.accenture.juego.hangmangame;

import com.accenture.juego.Gameable;
import com.accenture.juego.User;
import java.util.Scanner;


public class HangmanGame implements Gameable {
    private User user;
    private Scanner scanner;

    public HangmanGame() {

    }

    @Override
    public String getGameName(){
        return "Hangman";
    }

    @Override
    public void startMenu(User user, Scanner scanner){
        this.user = user;
        this.scanner = scanner;
        MenuHangmanGame menu = new MenuHangmanGame(user, scanner, this);
        menu.iniciar();
    }
     @Override
    public void startGame() {
        Partida partida = new Partida();
        System.out.println("¡Empieza el juego de Hangman!");

        while (!partida.isFinalizada()) {
            System.out.println("Palabra: " + partida.getPalabraActual());
            System.out.println("Intentos restantes: " + partida.getIntentosRestantes());
            System.out.print("Introduce una letra o la palabra completa (o FIN para terminar): ");
            String linea = scanner.nextLine().trim();

            if (linea.equalsIgnoreCase("FIN")) {
                System.out.println("Partida terminada.");
                break;
            }

            if (linea.length() == 1) {
                char letra = linea.toLowerCase().charAt(0);
                boolean acierto = partida.intentar(letra);

                if (acierto) {
                    System.out.println("¡Acertaste!");
                } else {
                    System.out.println("Letra incorrecta.");
                }
            } else {
                if (partida.intentarPalabra(linea.toLowerCase())) {
                    System.out.println("¡Correcto! Adivinaste la palabra completa.");
                    break;
                } else {
                    System.out.println("Palabra incorrecta.");
                }
            }
        }

        if (partida.isGanada()) {
            System.out.println("¡Felicidades, adivinaste la palabra: " + partida.getPalabraSecreta() + "!");
        } else if (!partida.isGanada()) {
            System.out.println("Fin del juego. La palabra era: " + partida.getPalabraSecreta());
        }
    }

    @Override
    public void closeGame() {
        System.out.println("Gracias por jugar, " + user.getNombre());
    }
}