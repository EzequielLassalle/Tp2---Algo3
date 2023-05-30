package edu.fiuba.algo3.modelo;


public class Jugador {

    public Credito credito;
    int vida;

    public Jugador(Credito nuevoCredito,int nuevaVida){

        this.credito = nuevoCredito;
        this.vida = nuevaVida;

    }

    public Boolean creditoIgual(Credito unCredito){

        return this.credito.esIgual(unCredito);

    }

    public Boolean vidaIgual(int unaVida){

        return (this.vida == unaVida);

    }



}
