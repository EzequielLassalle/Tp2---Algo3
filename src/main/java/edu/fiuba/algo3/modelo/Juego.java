package edu.fiuba.algo3.modelo;

public class Juego {
	Jugador jugador;
	Mapa mapa;
	int turno;

	public Juego() {
		jugador = new Jugador();
		mapa = new Mapa();
		turno = 0;
	}

	public boolean gano() {
		return (!mapa.hayEnemigos() && jugador.vida().obtenerVidaTotal() != 0);
	}

	public void pasarTurno() {
		mapa.pasarTurno(jugador);
		turno++;
	}
}
