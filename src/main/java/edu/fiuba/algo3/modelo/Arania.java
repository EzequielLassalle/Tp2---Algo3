package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {
	int velocidad;

    public Arania(){
        this.credito = new Credito(2);
        this.vida = 2;
		this.danio = 2;
		this.velocidad = 2;
		

    }

	public Casillero mover(Casillero unaPasarela) {
		
		for (int i = 0; i < velocidad; i += 1) {
			unaPasarela = unaPasarela.obtenerSiguiente();
		}
		return unaPasarela;
	}

	public Casillero moverRelantizado(Casillero unaPasarela){

		unaPasarela = unaPasarela.obtenerSiguiente();
		
		return unaPasarela;
	}
	

}
    
    
