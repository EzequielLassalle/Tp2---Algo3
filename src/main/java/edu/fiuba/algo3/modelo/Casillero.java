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
	Casillero siguienteHipotenusa;
	Pasarela pasarelaSiguiente;

	public Casillero (int nuevaX, int nuevaY) {

		this.x = nuevaX;
		this.y = nuevaY;
		this.trampaArenosa = null;
		this.casilleroAbajo = null;
		this.casilleroDerecha = null;
		this.pasarelaSiguiente = null;
		this.siguienteHipotenusa = null;

	}

	public void establecerSiguiente(Pasarela unaPasarela) {
		pasarelaSiguiente = unaPasarela;
	}

	
	public Casillero obtenerSiguiente() {
		if(pasarelaSiguiente != null){
			return pasarelaSiguiente;
		}

		return this;
	}

	public void establecerHipotenusa(Casillero unCasillero){
		this.siguienteHipotenusa = unCasillero;
	}


	public Casillero obtenerSiguienteHipotenusa(){
		if(siguienteHipotenusa != null){
			return siguienteHipotenusa;
		}
		return this;
	}

	public void establecerEnemigo(Enemigo unEnemigo){

        this.enemigos.add(unEnemigo);

    }

    public Boolean esTierra() {
		return false;
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
		if( casilleroAbajo != null){

		return casilleroAbajo;

		}

		return this;
	}

	public Casillero obtenerDerecha(){
		if(casilleroDerecha != null){

			return casilleroDerecha;
		}

		return this;
	}
	
    public void establecerDefensa(Torre unaTorre){}

	
	public void establecerSiguiente(Casillero unaPasarela) {}

	public Boolean vacio() {

		return true;
		
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

		for(Enemigo enemigo: enemigos){
			this.mover(enemigo);
		}

		enemigos.removeAll(enemigos);

    }


	///Implementar aca el corrector

	private void mover(Enemigo enemigo) {

		Casillero pasarelaDestino = null;

		if(trampaArenosa != null){
			if(trampaArenosa.operativa()){
				pasarelaDestino = enemigo.moverRelantizado(this);
				trampaArenosa.sumarTurno();
			}
		}else{
			pasarelaDestino = enemigo.mover(this);
		}

		/*if(pasarelaDestino == this){
			return;
		} */

		pasarelaDestino.establecerEnemigo(enemigo);
	}

	public boolean equals(Casillero c){
        return this.getClass() == c.getClass();
    }


	public Credito Atacado(int danio){
		Credito credito = new Credito(0);
		
		if(!enemigos.isEmpty()){
			credito.sumar(enemigos.get(0).Atacado(danio));
		
			if(enemigos.get(0).muerto()){
				enemigos.remove(0);
			}
		}

		return credito;

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

	public Credito Atacar(Casillero unPasarela){

		return new Credito(0);
	}

	public void establecerEnemigos(List<Enemigo> unaLista){

	}
	public void AtacarTorres(Jugador jugador,List<Casillero> torres){


	}

	
	public Enemigo enemigo(){
		return enemigos.get(0);
	}

	public Boolean hay_Lechuza(){
		
		for(Enemigo enemigo : enemigos){
			if(enemigo.soyLechuza())
			return true;
		}
		return false;
	}

	public Boolean hayEnemigos(){
		return !enemigos.isEmpty();
	}



	


}
