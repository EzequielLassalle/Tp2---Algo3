package edu.fiuba.algo3.modelo;

public class Casillero {

    int y;
    int x;
    
    

    public Boolean esTierra(){

        return null;

    }

    public void  establecerDefensa(Torre unaTorre){}

    public void establecerEnemigo(Enemigo enemigo){}

	public void establecerSiguiente(Casillero unaPasarela) {}

    public Boolean esPasarela(){

        return false;
    }

	public Boolean vacio() {
		return true;
	}

	public Casillero obtenerSiguiente() {
		return null;
	}

	public void pasarTurno(Casillero casillero, int posX, int posY, Jugador jugador){}

	public int obtenery() {
		return 0;
	}

	public int obtenerx() {
		return 0;
	}

	public void AtacadoPorTorreBlanca(Jugador jugador) {
	}

	public void AtacadoPorTorrePlateada(Jugador jugador) {
	}


}
