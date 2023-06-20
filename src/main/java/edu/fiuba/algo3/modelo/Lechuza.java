package edu.fiuba.algo3.modelo;

public class Lechuza extends Enemigo {
    

    public Lechuza(){
        this.credito = new Credito(5);
        this.vida = 5;
		this.danio = 0;
        

    }

	public Casillero mover(Casillero unaPasarela) {
		

        if(vida > 3){

            unaPasarela = unaPasarela.obtenerAbajo().obtenerAbajo().obtenerAbajo().obtenerDerecha().obtenerDerecha();
       
        }else{

        }
        

        return unaPasarela;

    }

    	public Casillero moverRelantizado(Casillero unaPasarela) {
		

        if(vida > 3){

            unaPasarela = unaPasarela.obtenerAbajo().obtenerAbajo().obtenerAbajo().obtenerDerecha().obtenerDerecha();
       
        }else{

        }
        

        return unaPasarela;

    }

	



    
}
