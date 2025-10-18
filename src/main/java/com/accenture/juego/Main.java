package com.accenture.juego;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
// Clase que va a ser la pantalla inicial que interactua con el usuario 
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine().trim();
        User user = new User(nombre);

        Repositorio repo = new Repositorio();

        boolean seguir = true;

        while (seguir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");

            List<Gameable> listaJuegos = repo.getJuegos();

            if (listaJuegos.isEmpty()) {
                System.out.println("No hay juegos disponibles actualmente.");
            } else {
                for (int i = 0; i < listaJuegos.size(); i++) {
                    System.out.println((i + 1) + ". " + listaJuegos.get(i).getGameName());
                }
            }
            System.out.println((listaJuegos.size() + 1) + ". Salir");

            System.out.print("Selecciona una opción: ");
            String input = scanner.nextLine().trim();

            try {
                int opcion = Integer.parseInt(input);

                if (opcion == listaJuegos.size() + 1) {
                    seguir = false;
                }
                else if (opcion > 0 && opcion <= listaJuegos.size()) {
                    Gameable juegoSeleccionado = listaJuegos.get(opcion - 1);
                    System.out.println("\n🎮 Has seleccionado: " + juegoSeleccionado.getGameName());
                    juegoSeleccionado.startMenu(user, scanner);
                } 
                else {
                    System.out.println("Opción inválida. Intenta nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
            }
        }

        System.out.println("¡Hasta la próxima, " + user.getNombre() + "!");
        scanner.close();
    }
}