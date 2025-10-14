package com.accenture.juego.guessgame;
import java.util.Scanner;

import com.accenture.juego.Gameable;
import com.accenture.juego.User;

public class GuessGame implements Gameable {

    private User user;
    private Scanner scanner; //pasamos el scanner del main para que startgame no tenga uno dentro

    
    public GuessGame(User user, Scanner scanner) {
        this.user = user;
        this.scanner = scanner;
    }

    @Override
    public String getGameName(){
        return "Guess Game";
    }

    public void startMenu(User user, Scanner scanner){
        
    }
    //lógica del juego, de momento muy simple. Simplemente empiezo con un estado en fallo, 
    //leo el input. Si es igual que numeroSecreto, 
    @Override
    public void startGame() {
        System.out.println("¡Empieza el juego! Adivina el número secreto entre 0 y 99.");

        while (partida.getEstado() == Estado.FALLO) {
            System.out.print("Tu intento: ");

            try {
                int intento = Integer.parseInt(scanner.nextLine()); //guardo el input del scanner en intento que tiene que ser un entero

                if (intento < 1 || intento > 100) {
                    System.out.println("Número fuera de rango. Intenta entre 0 y 99.");
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
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
            }
        }
    }

    @Override
    public void closeGame() {
        System.out.println("Gracias por jugar, " + user.getNombre() + ".");
    }
}
