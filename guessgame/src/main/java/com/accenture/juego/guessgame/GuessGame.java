package com.accenture.juego.guessgame;
import java.util.Scanner;

import com.accenture.juego.Gameable;
import com.accenture.juego.User;

public class GuessGame implements Gameable {
    private User user;
    private Scanner scanner;

    public GuessGame() {

    }

    @Override
    public String getGameName(){
        return "Guess Game";
    }

    @Override
    public void startMenu(User user, Scanner scanner){
        this.user = user;
        this.scanner = scanner;
        MenuGuessGame menu = new MenuGuessGame(user, scanner, this);
        menu.iniciar();
    }
    //lógica del juego, de momento muy simple. Simplemente empiezo con un estado en fallo, 
    //leo el input. Si es igual que numeroSecreto, 
    @Override
    public void startGame() {
        if (scanner == null) {
            throw new IllegalStateException("Scanner no inicializado en GuessGame. Se debe llamar a startMenu(user, scanner) antes de startGame().");
        }
        System.out.println("¡Empieza el juego! Adivina el número secreto entre 1 y 100. Recuerda que puedas finalizar la partida tecleando FIN");
        Partida partida = new Partida();

        while (partida.getEstado() == Estado.FALLO) {
            System.out.print("Tu intento: ");
            String input = scanner.nextLine().trim();   
            if (input.equalsIgnoreCase("FIN")) {

            System.out.println("Has decidido terminar la partida. Volviendo al menú del juego...");

            return; // Sale del método y vuelve a MenuGuessGame.iniciar()
            }

            try {
                int intento = Integer.parseInt(input); // si no eres FIN te intento leer como entero
                if (intento < 1 || intento > 100) {
                    System.out.println("Número fuera de rango. Intenta entre 1 y 100.");
                    continue; //nota si es un entero fuera de rango
                }

                Estado resultado = partida.intentar(intento); //hago un update del estado

                if (resultado == Estado.ACIERTO) {
                    System.out.println("¡Correcto! Has adivinado el número.");
                    break; //salgo del bucle porque ya he acertado 
                } else {
                    System.out.println("Incorrecto. Intenta de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero o teclea FIN si quieres salir de la partida.");
            }
        }
    }

    @Override
    public void closeGame() {
        System.out.println("Gracias por jugar, " + user.getNombre() + ".");
    }
}
