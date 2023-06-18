package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.List;

public class Juego {
	Jugador jugador;
	Mapa mapa;
	int turno;
	private EnemyRepository enemyParser;
	private MapRepository mapParser;

	public Juego(EnemyRepository enemyParser, MapRepository mapParser) {
		this.enemyParser = enemyParser;
		this.mapParser = mapParser;
		jugador = new Jugador();
		mapa = new Mapa();
		turno = 0;
	}


	public boolean gano() {
		return (!mapa.hayEnemigos() && jugador.vida().obtenerVidaTotal() > 0);
	}

	public void pasarTurno() {
		mapa.pasarTurno(jugador);
		turno++;
	}

	public void jugar()throws IOException, FormatoJSONInvalido{

		this.turno = 1;

        Casillero[][] mapaParseado = mapParser.parsear();

        this.mapa.establecerMapa(mapaParseado);

        do{

            List<Enemigo> lista = enemyParser.parsear(this.turno);
            
            this.mapa.establecerEnemigos(lista);

            this.jugador.jugar(this.mapa);

            this.mapa.pasarTurno(this.jugador);

            this.turno++;

        } while(this.gano() || this.perdio());


	}

	public Boolean perdio(){
		return (this.jugador.muerto());
	}


}
