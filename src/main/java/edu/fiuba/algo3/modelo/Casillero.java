package edu.fiuba.algo3.modelo;
import java.util.*;

public class Casillero {

	String tipo;
    int x;
    int y;
	Lechuza lechuza;

	public Casillero (int nuevaX, int nuevaY) {

		this.x = nuevaX;
		this.y = nuevaY;

	}

    public Boolean esTierra() {
		return null;
	}

	public boolean esIgual(Casillero c){
		boolean ok = true;
		ok &= c.tipo().equals(this.tipo());
		ok &= c.obtenerX() == this.x;
		ok &= c.obtenerY() == this.y;
		return ok;
	}

	public String tipo() {
		return this.tipo;
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

	public void pasarTurno(List<Pasarela> camino){}

	public void pasarTurno(Jugador jugador){}


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

	public Credito Atacar(Casillero unPasarela){

		return null;
	}

	public void establecerEnemigos(List<Enemigo> unaLista){

	}

	


}
