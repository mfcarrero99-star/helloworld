package com.accenture.juego;
import java.util.Scanner;

public class GuessGame implements Gameable {
    private Users user;
    private final String gamename = "Adivina el número";
    private Partida partida;
    //atributos de la clase, usuario, nombre del juego y partida
    
    public GuessGame(Users user) {//manera uno de iniciar el constructor, una partida nueva por defecto
        this.user = user;
        this.partida = new Partida();
    }

    //sobrecargamos el constructor para poder iniciar desde una partida
    // DE MOMENTO ESTO NO TIENE SENTIDO PORQUE NO TENEMOS HISTORIAL DE PARTIDAS
    public GuessGame(Users user, Partida oldpartida) {
        this.user = user;
        this.partida = oldpartida;
    }

    @Override
    public String getGamename() {
        return gamename;
    }
    
    @Override 
    public Users getUser() {
        return user;
    }
/*
 * Aquí tiene que ir la lógica del juego. ¿Por qué no iria en partida? Porque
 * en principio una partida comprende el ESTADO del juego, no su lógica.
 */
    @Override
    public void startGame() {
        System.out.println("¡Comienza la partida" + getUser());
        System.out.println(" Adivina un número entre el 0 y el 99:");
        
        Scanner scanner = new Scanner(System.in);
        
        while(partida.sePuedeSeguir()) {
            System.out.println("Tu intento:");
            String entrada = scanner.nextLine();
            int intento;
        }
    }

    @Override
    public void closeGame() {
        System.out.println("Metodo dos");
    }


}
