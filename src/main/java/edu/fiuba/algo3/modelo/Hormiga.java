package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {

    
    public Hormiga(){
        this.credito = 1;
        this.vida = 1;
        this.danio = 1;

    }

	//@Override
	public Pasarela mover(Pasarela unaPasarela) {
		return unaPasarela.obtenerSiguiente();
	}


}
