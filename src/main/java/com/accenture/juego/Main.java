package com.accenture.juego;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args ){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego de adivinar el número.");
        System.out.print("Ingresa tu nombre de usuario: ");
        String nombre = scanner.nextLine().trim();
        Users user = new Users(nombre);

        /* 
         * Hemos puesto dos escáneres, la razón es porque tenemos la interfaz Gameable. Habría que 
         * tener cuidado con esto y habría que cambiarlo o ver si puedo usar un patrón de diseño para 
         * solo usar un scanner
        */
        boolean seguirJugando = true;

        while (seguirJugando) {
            GuessGame juego = new GuessGame(user);
            juego.startGame();
            juego.closeGame();

            System.out.print("¿Quieres jugar otra partida? (s/n): "); //excepción solucionada
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (!respuesta.equals("s") && !respuesta.equals("si")) {
                seguirJugando = false;
                System.out.println("¡Gracias por jugar!");
            }
        }
    
        scanner.close();
        
    }
}