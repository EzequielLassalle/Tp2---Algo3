package edu.fiuba.algo3.modelo;

public class Lechuza extends Enemigo {
    

    public Lechuza(){
        this.credito = new Credito(5);
        this.vida = 2;
		this.danio = 2;
        

    }

	public Casillero mover(Casillero unaPasarela) {
		
        
        return unaPasarela;

    } 




    public Casillero moverRelantizado(Casillero unPasarela){

        return unPasarela;
    }


	



    
}
