package edu.fiuba.algo3.modelo;

public class Rocosa extends Casillero {

    public Rocosa (int nuevaX, int nuevaY) {

		super(nuevaX, nuevaY);
        this.tipo = "Rocosa";

    }

    
    public Boolean esTierra(){

        return false;
		
    }

    @Override
    public int obtenerX(){

        return this.x;
    }

	@Override
    public int obtenerY(){

        return this.y;
    }

    
}
