package com.accenture.juego;
import java.util.Random;
/*Clase partida muy sencilla. Necesitamos estados, porque sino nunca sabemos
cuando parar aunque ganemos. 
 */
public class Partida {
    private int numeroSecreto;
    private Estado estado;

    //constructor de la clase partida, el estado se pone automaticamente en juego 
    // porque hemos iniciado partida 
    public Partida(){
        this.numeroSecreto = generarNumeroSecreto();
        this.estado = Estado.FALLO;
    }
    // metodo de generar numero secreto, podría estar en el constructor pero 
    //lo ponemos a parte por principio de responsabilidad. 
    public int generarNumeroSecreto(){
        Random random = new Random();
       return random.nextInt(100);
    }

    public int getNumeroSecreto(){//getter del numero secreto
        return numeroSecreto;
    }

    public Estado getEstado(){//getter de estado
        return estado;
    }

    // en partida no vamos a validar, por lo que el estado solo cambia entre acierto
    // y en juego. 
    public Estado intentar(int intento){
        if (intento == numeroSecreto){
            estado = Estado.ACIERTO;
        }
        return estado;
    }
}