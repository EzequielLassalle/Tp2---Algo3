package edu.fiuba.algo3.modelo;
import java.util.*;

public class Mapa {
	Casillero[][] mapa;
	List<Pasarela> camino = new ArrayList<Pasarela>();
	Casillero pasarelaInicial;
	Casillero pasarelaFinal;
	List<Casillero> torres = new ArrayList<Casillero>();

	public Mapa() {
		generarTerreno();
		generarEnemigos();
	}

	public Mapa(Casillero[][] unMapa){
		mapa = unMapa;
		establecerCamino();
	}

	public void establecerMapa(Casillero[][] unMapa){
		this.mapa = unMapa;
	}

	public Boolean establecerEnemigos(List<Enemigo> lista){

		this.pasarelaInicial.establecerEnemigos(lista);
		return true;
	}

	public Boolean ocupado(int y,int x){

		return !mapa[y][x].vacio();
	}

	public void generarTerreno() {
		//mapa = Parser.generarTerreno();
		mapa = new Casillero[2][3];
		mapa[0][0] = new Pasarela(0,0);
		mapa[0][1] = new Pasarela(0,1);
		mapa[0][2] = new Tierra(0,2);
		mapa[1][0] = new Rocosa(1,0);
		mapa[1][1] = new Pasarela(1,1);
		mapa[1][2] = new Pasarela(1,2);

		establecerCamino();
		establecerSiguiente();
	}

	public void establecerCamino() {

		Boolean primeraPasarela = false;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if (mapa[i][j].esPasarela()){
					if (i < mapa.length - 1 && mapa[i + 1][j].esPasarela()) {
						mapa[i][j].establecerSiguiente(mapa[i + 1][j]);
						pasarelaFinal = mapa[i + 1][j];
					}
					if (j < mapa[i].length - 1 && mapa[i][j + 1].esPasarela()) {
						mapa[i][j].establecerSiguiente(mapa[i][j + 1]);
						pasarelaFinal = mapa[i][j + 1];
					}
					if (!primeraPasarela){
						primeraPasarela = true;
						pasarelaInicial = mapa[i][j];
					}
				}
			}
		}
	}

	public void establecerSiguiente(){

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++){

				if(i < mapa.length){
					mapa[i][j].establecerAbajo(mapa[i+1][j]);
					
				}

				if(j < mapa[i].length){
					mapa[i][j].establecerDerecha(mapa[i][j+1]);
				}


			}
		}

	} 

	public void establecerHipotenusaAPasarela(){


		for(int i = 0; i < mapa.length; i++){
			for(int j = 0; j< mapa[i].length;j++){


				mapa[i][j].establecerHipotenusa(calcularDistanciaAMeta(mapa[i+1][j], mapa[i][j+1], mapa[i+1][j+1]));

			}

		}
	}
	public Casillero calcularDistanciaAMeta(Casillero casilleroAbajo,Casillero casilleroDerecha,Casillero casilleroDiagonal){

		Casillero seleccionado = null;

		double distanciaAbajo = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - casilleroAbajo.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - casilleroAbajo.obtenerX(), 2));

		double distanciaDerecha = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - casilleroDerecha.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - casilleroDerecha.obtenerX(), 2));

		double distanciaDiagonal = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - casilleroDiagonal.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - casilleroDiagonal.obtenerX(), 2));

		if(distanciaAbajo > distanciaDerecha && distanciaAbajo > distanciaDiagonal){
			seleccionado = casilleroAbajo;

		}else if( distanciaDerecha > distanciaAbajo && distanciaDerecha > distanciaDiagonal){
			
			seleccionado = casilleroDerecha;
		}else{
			
			seleccionado = casilleroDiagonal;
		}

		return seleccionado;


	}

	public void generarEnemigos() {
		pasarelaInicial.establecerEnemigo(new Hormiga());
		pasarelaInicial.establecerEnemigo(new Arania());
	}

	public Boolean hayEnemigos() {
		Casillero pasarela = pasarelaInicial;
		Boolean vacio = true;

		do {
			vacio = pasarela.vacio();
			pasarela = pasarela.obtenerSiguiente();
		} while (pasarela != null && vacio);

		return !vacio;
	}

	public void construir(int posX, int posY, Torre unaTorre) {
		mapa[posX][posY].establecerDefensa(unaTorre);
		torres.add(mapa[posX][posY]);
	}

	public void pasarTurno(Jugador jugador) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {

				this.AtacarEnemigos(mapa[i][j],jugador);

				this.moverEnemigos(mapa[i][j], jugador);

			
			}
		}

		this.atacarJugador(jugador);
		
	}

		
		public void AtacarEnemigos(Casillero casillero,Jugador jugador){
			
		if(casillero.esTierra()){
			for (int i = 0; i < mapa.length; i++) {
				for (int j = 0; j < mapa[i].length; j++) {
				
				jugador.cobrarCredito(casillero.Atacar(mapa[i][j]));


			
					}
				}
			}
		}

		public void moverEnemigos(Casillero casillero,Jugador jugador){

		
			casillero.pasarTurno(jugador);
			

			

		}


	public void atacarJugador(Jugador jugador){
		pasarelaFinal.daniarJugador(jugador);
		pasarelaFinal.AtacarTorres(jugador,torres);
	}

}
