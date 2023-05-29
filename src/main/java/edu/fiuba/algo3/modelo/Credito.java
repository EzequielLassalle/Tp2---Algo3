package edu.fiuba.algo3.modelo;

public class Credito {

    public int credito;
    
    public Credito(int nuevoCredito){

        this.credito = nuevoCredito;

    }

    
    public Boolean esIgual(Credito unCredito){

        return (this.credito == unCredito.getCredito());


    }

    public int getCredito(){

        return credito;
    }


}
