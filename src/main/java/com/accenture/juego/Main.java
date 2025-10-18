package com.accenture.juego;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine().trim();
        User user = new User(nombre);

        Repositorio repo = new Repositorio();

        boolean seguir = true;
        while (seguir) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            List<String> nombresJuegos = repo.getNombresJuegos();
            for (int i = 0; i < nombresJuegos.size(); i++) {
                System.out.println((i + 1) + ". " + nombresJuegos.get(i));
            }
            System.out.println((nombresJuegos.size() + 1) + ". Salir");

            System.out.print("Selecciona una opción: ");
            String input = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(input);

                if (opcion == nombresJuegos.size() + 1) {
                    seguir = false;
                } else if (opcion > 0 && opcion <= nombresJuegos.size()) {
                    Class<? extends Gameable> claseJuego = repo.getlistajuego(opcion - 1);
                    if (claseJuego != null) {
                        try {
                            Gameable juego = claseJuego.getDeclaredConstructor().newInstance();
                            juego.startMenu(user, scanner);
                        } catch (Exception e) {
                            System.out.println("Error al instanciar el juego: " + e.getMessage());
                        }
                    }
                } else {
                    System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }

        System.out.println("¡Hasta la próxima!");
        scanner.close();
    }
}
