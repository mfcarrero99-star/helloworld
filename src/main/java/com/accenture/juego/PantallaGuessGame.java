package com.accenture.juego;
import java.util.Scanner;

import javax.management.monitor.GaugeMonitorMBean;

/*
 * Método principal para el juego de adivinar un número. Tomamos el input 
 * en consola para generar un usuario y se inicia el programa de manera automática 
 * llamando a GuessGame. En cada iteración, del bucle se instancia un nuevo juego 
 * y una vez se ha acertado se permite reiniciar partida o cerrar el juego. 
 */

public class PantallaGuessGame{  
    //metodo para llamar al menú de GuessGame
    public void mostrar(){
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al juego de adivinar el número.");
        System.out.print("Ingresa tu nombre de usuario: ");
        String nombre = scanner.nextLine().trim();
        // Se crea una instancia nueva de usuario
        Users user = new Users(nombre);

        /* Se crea una variable booleana seguirJugando, que nos obliga a seguir jugando hasta
        acertar, así como iniciar una partida nueva si queremos. Posible modificación: poder salir
        del juego cuando queramos. 
        */
        boolean seguirJugando = true;

        while (seguirJugando) { 
            //Comienzo del bucle creando una nueva instancia de GuessGame. 
            GuessGame juego = new GuessGame(user, scanner);
            juego.startGame();
            /*llamamos al método de GuessGame startGame. Hasta que el Estado no cambie a Acierto, startGame
            no termina, por lo que cerramos el juego solo una vez acertado. 
            */ 
            juego.closeGame();

            System.out.print("¿Quieres jugar otra partida? (s/n): "); 
            //Posibilidad de iniciar una nueva partida.
            String respuesta = scanner.nextLine().trim().toLowerCase();

            //Si escribimos sí se reinicia una nueva Partida, sino, salimos del bucle
            // y cerramos efectivamente el juego.

            if (!respuesta.equals("s") && !respuesta.equals("si")) {
                seguirJugando = false;
                System.out.println("¡Gracias por jugar!");
            }
        }
    
        scanner.close();
        
 }
}