package edu.fiuba.algo3.modelo;
import java.util.*;

public class Mapa {
	Casillero mapa[][];
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

				this.AtacarEnemigos(mapa[i][j],jugador);

				this.moverEnemigos(mapa[i][j], jugador);

			
			}
		}

		this.atacarJugador(jugador);
		
	}

		/* Esta implementado asi porque es necesario saber que Casillero es Tierra y cual es Pasarela
			para controlar los tiempos en que se mueven y se ataca a los enemigos */
		
		public void AtacarEnemigos(Casillero casillero,Jugador jugador){
			
		if(casillero.esTierra()){

		for(int z  = 0;  z < camino.size();z++){
				int x = camino.get(z).obtenerX();
				int y = camino.get(z).obtenerY();
				jugador.cobrarCredito(casillero.Atacar(mapa[x][y]));


			} 
		}

		}

		public void moverEnemigos(Casillero casillero,Jugador jugador){

			if(casillero.esPasarela()){
				casillero.pasarTurno(jugador);

			}

		}


	public void atacarJugador(Jugador jugador){
		pasarelaFinal.daniarJugador(jugador);
	}

}
