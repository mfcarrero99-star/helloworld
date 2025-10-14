package com.accenture.juego;
import java.util.List;
import java.util.Scanner;
// Clase que va a ser la pantalla inicial que interactua con el usuario 
public class Main { public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine().trim();
        User user = new User(nombre);

        Repositorio repo = new Repositorio();

        boolean seguir = true;
        while (seguir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            List<Gameable> listajuegos = repo.getJuegos();
            for (int i = 0; i < listajuegos.size(); i++) {
                System.out.println((i + 1) + ". " + listajuegos.get(i).getGameName());
            }
            System.out.println((listajuegos.size() + 1) + ". Salir");

            System.out.print("Selecciona una opción: ");
            String input = scanner.nextLine();

            try {
                int opcion = Integer.parseInt(input);

                if (opcion == listajuegos.size() + 1) {
                    seguir = false;
                } else if (opcion > 0 && opcion <= listajuegos.size()) {
                    listajuegos.get(opcion - 1).startMenu(User user, Scanner scanner);
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

