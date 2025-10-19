package com.accenture.juego.guessgame;

import com.accenture.juego.Gameable;
import com.accenture.juego.User;
import com.accenture.juego.io.InputProvider;
import com.accenture.juego.io.OutputProvider;
import com.accenture.juego.guessgame.guessgamelogic.*;

public class GuessGameController implements Gameable {

    private final User user;
    private final InputProvider input;
    private final OutputProvider output;
    private final GuessGameServices services;

    private PartidaGuessGame partida;

    public GuessGameController(User user, InputProvider input, OutputProvider output) {
        this.user = user;
        this.input = input;
        this.output = output;
        this.services = new GuessGameServices();
    }

    @Override
    public String getGameName() {
        return "Guess Game";
    }

    // Ahora iniciar == startGame
    @Override
    public void startGame() {
        output.print("Bienvenido " + user.getNombre() + " al " + getGameName() + "!");
        boolean seguir = true;

        while (seguir) {
            partida = services.nuevaPartida();
            output.print("He pensado un número entre 1 y 100. ¡Adivínalo!");

            boolean partidaActiva = true;
            while (partidaActiva) {
                output.print("Introduce un número entre el 1 y el 100 o teclea FIN para salir de la partida.");
                String entrada = input.read();
                if (entrada.equalsIgnoreCase("FIN")) {
                    output.print("Has salido de la partida.");
                    break;
                }

                try {
                    int intento = Integer.parseInt(entrada);
                    EstadoGuessGame estado = services.procesarIntento(partida, intento);

                    switch (estado) {
                        case ACIERTO -> {
                            output.print("¡Correcto! El número era " + partida.getNumeroSecreto());
                            partidaActiva = false;
                        }:
                        case FALLO -> output.print("Incorrecto. Intenta otra vez."):
                        case ERROR -> output.print("Entero fuera de rango. Introduce un entero entre 1 y 100."):
                    }
                } catch (NumberFormatException e) {
                    output.print("Entrada inválida. Escribe un número o FIN.");
                }
            }

            String respuesta = input.read("¿Quieres jugar otra partida? (s/n)");
            seguir = respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si");
        }
    }

    @Override
    public void closeGame() {
        output.print("Gracias por jugar, " + user.getNombre());
    }
}
