package edu.fiuba.algo3.modelo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

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

	public void jugar()throws IOException, ParseException, FormatoJSONInvalido{

		this.turno = 1;

        EnemigosParser parser = new EnemigosParser("src/json/enemigos.json");

        MapaParser mapaParser = new MapaParser("src/json/mapa.json");

        Casillero[][] mapaParseado = mapaParser.parsear();

        this.mapa.establecerMapa(mapaParseado);

        do{

            List<Enemigo> lista = parser.parsear(this.turno);
            
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
