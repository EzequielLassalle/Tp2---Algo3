package edu.fiuba.algo3.modelo;

public class Casillero {

    int x;
    int y;

	public Casillero (int nuevaX, int nuevaY) {

		this.x = nuevaX;
		this.y = nuevaY;

	}

    public Boolean esTierra() {

		return false;

	}

    public Boolean esPasarela() {

		return false;

	}
	
    public void establecerDefensa(Torre unaTorre){}
	
    public void establecerEnemigo(Enemigo enemigo){}
	
	public void establecerSiguiente(Casillero unaPasarela) {}

	public Boolean vacio() {

		return true;
		
	}

	public Casillero obtenerSiguiente() {
		return null;
	}

	public void daniarJugador(Jugador jugador){}

	public void pasarTurno(Casillero casillero){}

	public int obtenerY() {
		return 0;
	}

	public int obtenerX() {
		return 0;
	}

	public void AtacadoPorTorreBlanca(Jugador jugador) {
	}

	public void AtacadoPorTorrePlateada(Jugador jugador) {
	}


	
	public Credito Atacado(int danio){

		return null;
	}

	public Credito Atacar(Pasarela unPasarela){

		return null;
	}


}
