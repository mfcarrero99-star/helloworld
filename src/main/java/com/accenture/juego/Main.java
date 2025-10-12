package com.accenture.juego;
import java.util.Scanner;

//clase Main para implementación de juego. No sé por qué no funciona el programa porque me está dando un error del tipo 
//mainclassnotfound. 
public class Main
{
    public static void main( String[] args )
    {Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego de adivinar el número.");
        System.out.print("Ingresa tu nombre de usuario: ");
        String user = scanner.nextLine();

        Users user = new Users(user);

        // ¿Quiere reanudar la partida anterior?
        System.out.print("¿Deseas reanudar tu última partida? (s/n): ");
        String respuesta = scanner.nextLine();

        Gameable juego;

        if (respuesta.equalsIgnoreCase("s") && usuario.getUltimaPartida() != null) {
            juego = new GuessGame(user, true);
        } else {
            juego = new GuessGame(user);
        }

        juego.startGame();
        juego.closeGame();
    };
    }
}
