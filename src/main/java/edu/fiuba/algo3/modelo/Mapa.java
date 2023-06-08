package edu.fiuba.algo3.modelo;
import java.util.*;

public class Mapa {
	Casillero[][] mapa;
	List<Pasarela> camino = new ArrayList<Pasarela>();
	Casillero pasarelaInicial;
	Casillero pasarelaFinal;

	public Mapa() {
		generarTerreno();
		generarEnemigos();
	}

	public Mapa(Casillero[][] unMapa){
		mapa = unMapa;
		establecerCamino();
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

		return vacio;
	}

	public void construir(int posX, int posY, Torre unaTorre) {
		mapa[posX][posY].establecerDefensa(unaTorre);
	}

	public void pasarTurno(Jugador jugador) {
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				mapa[i][j].pasarTurno(camino);
			}
		}

		////Atacar Enemeigos
		////enemigos se mueven
		this.atacarJugador(jugador);
		
	}


	public void atacarJugador(Jugador jugador){
		pasarelaFinal.daniarJugador(jugador);
	}

}
