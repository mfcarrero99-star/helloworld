package com.accenture.juego;
import java.util.Scanner;

public class GuessGame implements Gameable {
    private Users user;
    private final String gamename = "Adivina el número";
    private Partida partida;
    private Scanner input = new Scanner(System.in);
    //atributos de la clase, usuario, nombre del juego y partida. Inicializamos también el input
    
    public GuessGame(Users user) {//manera uno de iniciar el constructor, una partida nueva por defecto
        this.user = user;
        this.partida = new Partida();
        usuer.setUltimaPartida(partida); //guardado automático
    }

    //sobrecargamos el constructor para poder iniciar desde la última Partida.
    //si reanudar es verdadero, vamos al getter de la ultima partida, 
    // y sino, iniciamos de manera normal. 
    public GuessGame(Users user, boolean reanudar) {
        this.user = user;
        if (reanudar && user.getUltimaPartida() != null) {
            this.partida = user.getUltimaPartida();
            System.out.println("Reanudando tu última partida...");
        } else {
            this.partida = new Partida();
            user.setUltimaPartida(partida);
        }
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
       System.out.println("¡Empieza el juego! Adivina el número secreto entre 1 y 100.");

    while (partida.getEstado() == Estado.EN_JUEGO) {
        System.out.print("Tu intento: ");
        
        try {
            int intento = Integer.parseInt(input.nextLine());

            Estado resultado = partida.intentar(intento);

            if (resultado == Estado.ACIERTO) {
                System.out.println("¡Correcto! Has adivinado el número.");
                partida.setEstado(Estado.GUARDADO);
                usuario.setUltimaPartida(partida);
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
        System.out.println("Gracias por jugar" + "user.getNombre());
    }


}
