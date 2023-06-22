package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test{
    @Test
    public void test13FormatoJSONdeEnemigosEsElCorrecto() throws ParseException, IOException, JSONVacio, FormatoJSONInvalido {
        

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");

        assertDoesNotThrow(parser::formatoCorrecto);


    }
    @Test
    public void test14FormatoJSONdeMapaEsElCorrecto() {

        JsonMapRepository parser = new JsonMapRepository("src/json/mapa.json");

        assertDoesNotThrow(parser::formatoCorrecto);

    }
    @Test
    public void test15LecturaYconversionDeJSONdeEnemigos() throws IOException, ParseException {

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        List<Enemigo> lista = parser.parsear(1);

        List<Enemigo> listaEsperada = new ArrayList<Enemigo>();
        listaEsperada.add(new Hormiga());

        assertEquals(listaEsperada.size(), lista.size());
        assertEquals(listaEsperada.get(0).esHormiga(), lista.get(0).esHormiga());
    }

    @Test
    public void test16LecturaYConversionDeJSONMapa() throws IOException, ParseException, FormatoJSONInvalido {

        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Mapa mapa = mapaParser.parsear();

        assertTrue(mapa.posicion(0, 0).esIgual(new Rocosa(0, 0)));

        assertTrue(mapa.posicion(0, 1).esIgual(new Pasarela(1, 0)));

        assertTrue(mapa.posicion(0,2).esIgual(new Tierra(2, 0)));

        assertTrue(mapa.posicion(0, 3).esIgual(new Tierra(3, 0)));

        assertTrue(mapa.posicion(0,4).esIgual(new Tierra(4, 0)));

        assertTrue(mapa.posicion(0,5).esIgual(new Tierra(5, 0)));

    }

    @Test
    public void test17JuegoBienCreado()throws IOException, ParseException, FormatoJSONInvalido {

        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
       
        List<Enemigo> lista = parser.parsear(1);

        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Mapa mapa = mapaParser.parsear();

        
        assertTrue(mapa.establecerEnemigos(lista));

        assertTrue(mapa.ocupado(0,1));

        assertTrue(mapa.posicion(0, 0).esIgual(new Rocosa(0, 0)));

        assertTrue(mapa.posicion(10, 4).esIgual(new Tierra(4,10)));

        assertTrue(mapa.posicion(10,14).esIgual(new Pasarela(14, 10)));

        assertTrue(mapa.posicion(14, 4).esIgual(new Rocosa(4, 14)));

        assertTrue(mapa.posicion(12, 10).esIgual(new Tierra(10, 12)));
        
 

    }



    //////////////////// PREGUNTAR /////////////////////////////////////////////////////////////////

    
    public void test18JugadorJuegaYganaPartida()throws IOException, ParseException, FormatoJSONInvalido {
        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Juego juego = new Juego(parser, mapaParser);

        juego.jugar();

        assertTrue(juego.gano());



    }
    
    public void test19JugadorJuegaYpierdePartida()throws IOException, ParseException, FormatoJSONInvalido {
        JsonEnemyRepository parser = new JsonEnemyRepository("src/json/enemigos.json");
        JsonMapRepository mapaParser = new JsonMapRepository("src/json/mapa.json");

        Juego juego = new Juego(parser, mapaParser);

        ////juego.jugar();
    
        assertTrue(juego.perdio());

 

    }

    public void test20VerificarSistemaLogParaEntrega3() {

 





    }



}

