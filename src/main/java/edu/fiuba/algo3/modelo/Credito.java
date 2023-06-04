package edu.fiuba.algo3.modelo;

public class Credito {

    int credito;

    public Credito(int unCredito){

        this.credito = unCredito;


    }

    public Boolean igual(Credito unCredito){

        return(this.credito == unCredito.obtenerCreditoTotal());
    }

    public int obtenerCreditoTotal(){

        return (this.credito);
    
    }
    
}
