package edu.fiuba.algo3.modelo;

public class Hormiga extends Enemigo {

    
    public Hormiga(){
        this.credito = new Credito(1);
        this.vida = 1;
        this.danio = 1;

    }

	//@Override
	public Pasarela mover(Pasarela unaPasarela) {
		return unaPasarela.obtenerSiguiente();
	}

    @Override
    public boolean esHormiga() {
        return true;
    }

    @Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass());
    }

}
