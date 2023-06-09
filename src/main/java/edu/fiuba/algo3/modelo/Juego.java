package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.List;

public class Juego {
	public Jugador jugador;
	public Mapa mapa;
	public EnemyRepository enemyParser;
	public MapRepository mapParser;
	int turno;

	public Juego(EnemyRepository enemyParser, MapRepository mapParser) throws IOException, FormatoJSONInvalido {
		this.enemyParser = enemyParser;
		this.mapParser = mapParser;
		jugador = new Jugador();
		mapa = this.mapParser.parsear();
		turno = 1;
	}

	public Jugador jugador(){
		return this.jugador;
	}


	public boolean gano() {
		return (jugador.vida().obtenerVidaTotal() > 0 && turno>26);
	}

	public void pasarTurno() {
		mapa.pasarTurno(jugador);
	}

	public void establecerEnemigos()throws IOException, FormatoJSONInvalido{
		List<Enemigo> lista = enemyParser.parsear(this.turno);

		this.mapa.establecerEnemigos(lista);
		this.turno++;

	}

	public void jugar()throws IOException, FormatoJSONInvalido{

		/* hay que sacar el do while. Se hace el pasar turno con el handler del boton.*/

		//this.jugador.jugar(this.mapa);

		this.mapa.pasarTurno(this.jugador);


	}

	public Boolean perdio(){
		return (this.jugador.muerto());
	}


	public Mapa mapa() {
		return this.mapa;
	}

	@Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass());
    }
}
