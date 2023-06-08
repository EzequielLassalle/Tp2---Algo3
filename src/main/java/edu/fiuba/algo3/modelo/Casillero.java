package edu.fiuba.algo3.modelo;
import java.util.*;

public class Casillero {
	String tipo;
    int y;
    int x;
    
    

    public Boolean esTierra(){

        return null;

    }

	public boolean esIgual(Casillero c){
		boolean ok = true;
		ok &= c.tipo().equals(this.tipo());
		ok &= c.obtenerx() == this.x;
		ok &= c.obtenery() == this.y;
		return ok;
	}

	public String tipo() {
		return this.tipo;
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

	public void DaniarJugador(Jugador jugador){}

	public void pasarTurno(Casillero casillero){}

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


	
	public int Atacado(int danio){

		return 0;
	}

	public int Atacar(Pasarela unPasarela){

		return 0;
	}

	public void establecerEnemigos(List<Enemigo> unaLista){

	}


}
