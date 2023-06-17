package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {
	int velocidad;

    public Arania(){
        this.credito = new Credito(2);
        this.vida = 2;
		this.danio = 2;
		this.velocidad = 2;
		

    }

	public Pasarela mover(Pasarela unaPasarela) {
		
		for (int i = 0; i < velocidad; i += 1) {
			unaPasarela = unaPasarela.obtenerSiguiente();
		}
		return unaPasarela;
	}

	public Pasarela moverRelantizado(Pasarela unaPasarela){

		unaPasarela = unaPasarela.obtenerSiguiente();
		
		return unaPasarela;
	}
	

}
    
    
