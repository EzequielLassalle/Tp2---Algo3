package edu.fiuba.algo3.modelo;

public class Juego {
	Jugador jugador;
	Mapa mapa;
	int turno;

	public Juego() {
		jugador = new Jugador(100, 20);
		mapa = new Mapa();
		turno = 0;
	}

	public boolean gano() {
		return (!mapa.hayEnemigos() && jugador.vida().obtenerVidaTotal() != 0);
	}

	public void construir(int posX, int posY, String torreString) {
		Torre torre = jugador.construir(torreString);
		mapa.construir(posX, posY, torre);
	}

	public void pasarTurno() {
		mapa.pasarTurno(jugador);
		turno++;
	}
}
