package com.accenture.juego;

import java.util.List;
import com.accenture.juego.io.Consola;

public class Main {

    public static void main(String[] args) {
        Consola consola = new Consola();

        // Pedir nombre de usuario
        consola.print("Ingrese su nombre:");
        String nombre = consola.read();
        User user = new User(nombre);

        Repositorio repo = new Repositorio();
        boolean seguir = true;

        while (seguir) {
            // Mostrar menú principal
            List<String> nombresJuegos = repo.getNombresJuegos();
            consola.print("\n--- MENÚ PRINCIPAL ---");
            for (int i = 0; i < nombresJuegos.size(); i++) {
                consola.print((i + 1) + ". " + nombresJuegos.get(i));
            }
            consola.print((nombresJuegos.size() + 1) + ". Salir");

            // Leer opción
            String opcionStr = consola.read();
            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                consola.print("Opción inválida.");
                continue;
            }

            if (opcion == nombresJuegos.size() + 1) {
                seguir = false;
                break;
            }

            if (opcion > 0 && opcion <= nombresJuegos.size()) {
                Class<? extends Gameable> claseJuego = repo.getlistajuego(opcion - 1);
                try {
                    // Instanciar el juego pasando consola como input y output
                    Gameable juego = claseJuego
                            .getDeclaredConstructor(User.class, Consola.class, Consola.class)
                            .newInstance(user, consola, consola);

                    juego.startGame();
                    juego.closeGame();

                    // Preguntar si desea volver al menú principal
                    consola.print("¿Deseas volver al menú principal? (s/n)");
                    String respuesta = consola.read();
                    if (!respuesta.equalsIgnoreCase("s") && !respuesta.equalsIgnoreCase("si")) {
                        seguir = false;
                    }

                } catch (Exception e) {
                    consola.print("Error al iniciar el juego: " + e.getMessage());
                }
            } else {
                consola.print("Opción inválida.");
            }
        }

        consola.print("¡Hasta la próxima!");
        consola.close(); // cerrar Scanner
    }
}

