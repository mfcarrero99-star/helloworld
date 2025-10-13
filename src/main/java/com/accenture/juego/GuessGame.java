package com.accenture.juego;
import java.util.Scanner;

public class GuessGame implements Gameable {

    private final String gamename = "GuessGame";
    private Users user;
    private Partida partida;

    //Constructor simple, solo podemos empezar nueva partida y lo haremos cada vez que ingresemos
    //usuario
    public GuessGame(Users user) {
        this.user = user;
        this.partida = new Partida();
    }

    @Override
    public String getGamename() {
        return gamename;
    }

    @Override 
    public Users getUsers() {
        return user;
    }

    //lógica del juego, de momento muy simple. Simplemente empiezo con un estado en fallo, 
    //leo el input. Si es igual que numeroSecreto, 
    @Override
    public void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("¡Empieza el juego! Adivina el número secreto entre 0 y 99.");

        while (partida.getEstado() == Estado.FALLO) {
            System.out.print("Tu intento: ");

            try {
                int intento = Integer.parseInt(input.nextLine()); //leo el input y compruebo que es un entero

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

        input.close();
    }

    @Override
    public void closeGame() {
        System.out.println("Gracias por jugar, " + user.getUsers() + ".");
    }
}
