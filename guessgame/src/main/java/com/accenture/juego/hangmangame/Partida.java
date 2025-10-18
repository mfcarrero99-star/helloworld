package com.accenture.juego.hangmangame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Partida {
        private static final String[] DICCIONARIO = {
        "java", "programacion", "consola", "juego", "acertijo", "adivinanza"
    };

    private String palabraSecreta;
    private Set<Character> letrasAcertadas;
    private Set<Character> letrasIntentadas;
    private int intentosRestantes;

    public Partida() {
        this.palabraSecreta = elegirPalabra();
        this.letrasAcertadas = new HashSet<>();
        this.letrasIntentadas = new HashSet<>();
        this.intentosRestantes = 6;
    }

    private String elegirPalabra() {
        Random random = new Random();
        return DICCIONARIO[random.nextInt(DICCIONARIO.length)];
    }

   public boolean intentar(char letra) {
    if (letrasIntentadas.contains(letra)) return true; // no penaliza letras repetidas
    letrasIntentadas.add(letra);

    if (palabraSecreta.indexOf(letra) >= 0) {
        letrasAcertadas.add(letra);
        return true;
    } else {
        intentosRestantes--; // solo aquí se reduce el intento
        return false;
    }
}

public boolean intentarPalabra(String intento) {
    if (intento.equals(palabraSecreta)) {
        for (char c : palabraSecreta.toCharArray()) {
            letrasAcertadas.add(c);
        }
        return true;
    } else {
        intentosRestantes--; // solo aquí se reduce el intento por palabra incorrecta
        return false;
    }
}


    public String getPalabraActual() {
        StringBuilder sb = new StringBuilder();
        for (char c : palabraSecreta.toCharArray()) {
            sb.append(letrasAcertadas.contains(c) ? c : "_").append(" ");
        }
        return sb.toString().trim();
    }

    public boolean isGanada() {
        for (char c : palabraSecreta.toCharArray()) {
            if (!letrasAcertadas.contains(c)) return false;
        }
        return true;
    }

    public boolean isFinalizada() {
        return intentosRestantes <= 0 || isGanada();
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}

