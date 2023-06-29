package edu.fiuba.algo3.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;

public class MapaTest {

    @Test
    public void test01MapaBuscaEnemigosBien()throws IOException, FormatoJSONInvalido {

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Juego juego = new Juego(parser, mapaParser);

        juego.establecerEnemigos();

        Mapa mapa = juego.mapa();

        assertTrue(mapa.hayEnemigos());
    }    


     @Test

     public void test02MapaConstruyeBien()throws IOException, FormatoJSONInvalido{

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Juego juego = new Juego(parser, mapaParser);

        juego.establecerEnemigos();

        Mapa mapa = juego.mapa();

        mapa.construir(1, 0,new TorreBlanca(), juego.jugador());

        assertTrue(mapa.posicion(1, 0).defensa().equals(new TorreBlanca()));



     }

}



