package edu.fiuba.algo3.modelo;

public class Vida {

    int vidaTotal;

    public Vida(int unaVida){

        this.vidaTotal = unaVida;

    }

    public Boolean igual(Vida unaVida){

        return(this.vidaTotal == unaVida.obtenerVidaTotal());
    }

    public int obtenerVidaTotal(){

        return (this.vidaTotal);
    
    }

    public void restar(Vida unaVida){

       this.vidaTotal -= unaVida.obtenerVidaTotal();
    }

	public Boolean menorIgualQue(Vida unaVida) {
		return (vidaTotal <= unaVida.obtenerVidaTotal());
	}
    
}
