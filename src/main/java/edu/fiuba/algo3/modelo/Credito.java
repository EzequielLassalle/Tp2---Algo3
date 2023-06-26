package edu.fiuba.algo3.modelo;

public class Credito {

    int credito;

    public Credito(int unCredito){

        this.credito = unCredito;


    }

    public void sumar(Credito unCredito){
        this.credito += unCredito.obtenerCreditoTotal();
    }

        @Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass());
    }

    public Boolean igual(Credito unCredito){

        return(this.credito == unCredito.obtenerCreditoTotal());
    }

	public Boolean mayorQue(Credito unCredito) {
		return (this.credito > unCredito.obtenerCreditoTotal());
	}

    public int obtenerCreditoTotal(){

        return (this.credito);
    
    }

    public void restar(Credito unCredito){

        this.credito -= unCredito.obtenerCreditoTotal();

    }
    
}
