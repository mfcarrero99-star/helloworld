package com.accenture.juego;
import java.util.Scanner;
//interfaz para implementar un juego que obliga a usar metodos de abrir y cerrar juego. 
public interface Gameable{
   void startGame();
   void closeGame();
   String getGameName();
}
