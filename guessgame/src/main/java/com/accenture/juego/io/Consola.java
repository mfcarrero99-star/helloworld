package com.accenture.juego.io;

import java.util.Scanner;

public class Consola implements InputProvider, OutputProvider {

    private final Scanner scanner;

    public Consola() {
        this.scanner = new Scanner(System.in);
    }

    // InputProvider
    @Override
    public String read() {
        return scanner.nextLine().trim();
    }

    // OutputProvider
    @Override
    public void print(String mensaje) {
        System.out.println(mensaje);
    }

    // Para cerrar el scanner al finalizar
    public void close() {
        scanner.close();
    }
}

