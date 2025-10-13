package com.accenture.juego;
import java.util.Scanner;
// Clase que va a ser la pantalla inicial que interactua con el usuario 
public class Menu {
    public static void main(String[] args){
    Repositorio repositorio = new Repositorio();
    Scanner scanner = new Scanner(System.in);    
    System.out.println("Hola, introduce tu nombre de usuario: ");
    String nombre = scanner.nextLine();
    User user = new User(nombre);
    System.out.println("Perfecto"+ user.getNombre() + "Aquí te enseño todos los posibles juegos. Marca una opción escribiendo el número:");
    repositorio.mostrar();
    try{
        int elección = Integer.parseInt(scanner.nextLine());
        if(elección == get)
    
}
}
