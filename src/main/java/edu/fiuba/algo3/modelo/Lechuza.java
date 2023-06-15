package edu.fiuba.algo3.modelo;

public class Lechuza extends Enemigo {
    

    public Lechuza(){
        this.credito = new Credito(5);
        this.vida = 2;
		this.danio = 2;
        

    }

	public Pasarela mover(Pasarela unaPasarela) {
		
        Pasarela pasarelaDestino = unaPasarela;

        for(int i = 0;i<5;i++){
		    pasarelaDestino = unaPasarela.obtenerSiguiente(); 
        }

        return pasarelaDestino;

        } 

    public Pasarela moverRelantizado(Pasarela unPasarela){

        return unPasarela;
    }


	



    
}
