package com.accenture.juego;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego de adivinar el número.");
        System.out.print("Ingresa tu nombre de usuario: ");
        String nombreUsuario = scanner.nextLine().trim();
        Users user = new Users(nombreUsuario);

        boolean seguirJugando = true;

        while (seguirJugando) {
            GuessGame juego = new GuessGame(user);
            juego.startGame();

            System.out.print("¿Quieres jugar otra partida? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (!respuesta.equals("s") && !respuesta.equals("si")) {
                seguirJugando = false;
                System.out.println("¡Gracias por jugar!");
            }
        }

        scanner.close();
        
    }
}