package edu.fiuba.algo3.modelo;

public class Arania extends Enemigo {

    public Arania(){
        this.credito = new Credito(2);
        this.vida = 2;
		this.danio = 2;

    }

	public Pasarela mover(Pasarela unaPasarela) {
		
		for (int i = 0; i < 2; i += 1) {
			unaPasarela = unaPasarela.obtenerSiguiente();
		}
		return unaPasarela;
	}
    
    
}