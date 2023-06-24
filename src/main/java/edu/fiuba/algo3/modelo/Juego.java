package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.List;

public class Juego {
	Jugador jugador;
	Mapa mapa;
	private EnemyRepository enemyParser;
	private MapRepository mapParser;

	public Juego(EnemyRepository enemyParser, MapRepository mapParser) throws IOException, FormatoJSONInvalido {
		this.enemyParser = enemyParser;
		this.mapParser = mapParser;
		jugador = new Jugador();
		mapa = this.mapParser.parsear();
	}


	public boolean gano() {
		return (!mapa.hayEnemigos() && jugador.vida().obtenerVidaTotal() > 0);
	}

	public void pasarTurno() {
		mapa.pasarTurno(jugador);
	}

	public void jugar(int turno)throws IOException, FormatoJSONInvalido{

		/* hay que sacar el do while. Se hace el pasar turno con el handler del boton.*/


		List<Enemigo> lista = enemyParser.parsear(turno);

		this.mapa.establecerEnemigos(lista);

		//this.jugador.jugar(this.mapa);

		this.mapa.pasarTurno(this.jugador);

	}

	public Boolean perdio(){
		return (this.jugador.muerto());
	}


	public Mapa mapa() {
		return this.mapa;
	}
}
