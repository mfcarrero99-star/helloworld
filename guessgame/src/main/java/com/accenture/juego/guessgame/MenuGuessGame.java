package com.accenture.juego.guessgame;
import java.util.Scanner;
/*este metodo principal parece casi una clase abstracta o interfaz así 
 * que vamos a ponerlo así y que el constructor pase un Gameable, asi lo que pongo en 
 * el repositorio será los menus de Gameable 
 */

import com.accenture.juego.User;
import com.accenture.juego.Menu;
import com.accenture.juego.Gameable;

/*
 * Método principal para el juego de adivinar un número. Tomamos el input 
 * en consola para generar un usuario y se inicia el programa de manera automática 
 * llamando a GuessGame. En cada iteración, del bucle se instancia un nuevo juego 
 * y una vez se ha acertado se permite reiniciar partida o cerrar el juego. 
 */

public class MenuGuessGame extends Menu {  
    //metodo para llamar al menú de GuessGame
    public MenuGuessGame(User user, Scanner scanner, Gameable juego) {
        super(user, scanner, juego);
    }
    
    @Override
    public void iniciar(){
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
