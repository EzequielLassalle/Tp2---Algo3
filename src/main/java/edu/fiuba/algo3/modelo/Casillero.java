package edu.fiuba.algo3.modelo;
import java.util.*;

public class Casillero {

	String tipo;
    int x;
    int y;
	Casillero casilleroAbajo;
	Casillero casilleroDerecha;
	List<Enemigo> enemigos = new ArrayList<Enemigo>();
	Torre trampaArenosa;

	public Casillero (int nuevaX, int nuevaY) {

		this.x = nuevaX;
		this.y = nuevaY;
		this.trampaArenosa = null;

	}

	public void establecerEnemigo(Enemigo unEnemigo){

        this.enemigos.add(unEnemigo);

    }

    public Boolean esTierra() {
		return null;
	}

	public void establecerAbajo(Casillero unCasillero){

		casilleroAbajo = unCasillero;
	}

	public void establecerDerecha(Casillero unCasillero){

		casilleroDerecha = unCasillero;
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

	public Casillero obtenerAbajo(){

		return casilleroAbajo;
	}

	public Casillero obtenerDerecha(){

		return casilleroDerecha;
	}
	
    public void establecerDefensa(Torre unaTorre){}

	
	public void establecerSiguiente(Casillero unaPasarela) {}

	public Boolean vacio() {

		return true;
		
	}

	public Casillero obtenerSiguiente() {
		return null;
	}

	public void eliminarDefensa(){

	}

	public void daniarJugador(Jugador jugador){}

	public void pasarTurno(List<Pasarela> camino){}

		public void pasarTurno(Jugador jugador) {
		if(!enemigos.isEmpty()){
			moverEnemigos();
		}
	}

	    public void moverEnemigos() {

		for (Enemigo enemigo : enemigos) {
			this.mover(enemigo);
			//enemigo = null;
			//enemigos.remove(enemigo);
		}

		enemigos.removeAll(enemigos);

    }

	private void mover(Enemigo enemigo) {

		if(trampaArenosa != null){
			if(trampaArenosa.operativa()){
			Casillero pasarelaDestino = enemigo.moverRelantizado(this);
			pasarelaDestino.establecerEnemigo(enemigo);
			trampaArenosa.sumarTurno();
			}

		}else{

			Casillero pasarelaDestino = enemigo.mover(this);
			pasarelaDestino.establecerEnemigo(enemigo);

		}
	}

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
	public void AtacarTorres(Jugador jugador,List<Casillero> torres){


	}



	


}
