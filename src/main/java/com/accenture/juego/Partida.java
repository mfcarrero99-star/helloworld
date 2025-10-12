package com.accenture.juego;
import java.util.Random;
/*Clase partida muy sencilla. Necesitamos estados, porque sino nunca sabemos
cuando parar aunque ganemos. 
 */
public class Partida {
    private int numeroSecreto;
    private Estado estado;

    public Partida(){
        this.numeroSecreto = generarNumeroSecreto();
        this.estado = Estado.EN_JUEGO;
    }

    // generador de numero secreto. Puesto aparte por si luego queremos generarlo
    // de otra manera según nivel. 
    private int generarNumeroSecreto(){
        Random numero = new Random();
        return numero.nextInt(100);
    }

    //getter del numero secreto
    public int getNumeroSecreto(){
        return numeroSecreto;
    }

    //getter de estado
    public Estado getEstado(){
        return estado;
    }
}
