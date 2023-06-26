package edu.fiuba.algo3.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import edu.fiuba.algo3.modelo.*;

public class JuegoTest {

    @Test
    public void JuegoSeCreaBien01() throws IOException, FormatoJSONInvalido {

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Juego juego = new Juego(parser, mapaParser);

        juego.establecerEnemigos();

        Mapa mapa = juego.mapa();

        assertTrue(mapa.posicion(0, 1).enemigo().equals(new Hormiga()));

    }

    @Test
    public void JuegoMueveBienEnemigos02() throws IOException, FormatoJSONInvalido {

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Juego juego = new Juego(parser, mapaParser);

        juego.establecerEnemigos();

        juego.pasarTurno();

        assertTrue(juego.mapa().posicion(1, 1).enemigo().equals(new Hormiga()));

    }

    @Test
    public void JuegoSeCreaBien() throws IOException, FormatoJSONInvalido {

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Juego juego = new Juego(parser, mapaParser);


        assertTrue(juego.equals(new Juego(parser,mapaParser)));

    }
}