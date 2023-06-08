package edu.fiuba.algo3.entrega_2;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test{
    @Test
    public void test13FormatoJSONdeEnemigosEsElCorrecto() throws ParseException, IOException, JSONVacio, FormatoJSONInvalido {
        

        EnemigosParser parser = new EnemigosParser("src/json/enemigos.json");

        assertDoesNotThrow(parser::formatoCorrecto);


    }
    @Test
    public void test14FormatoJSONdeMapaEsElCorrecto() {

        MapaParser parser = new MapaParser("src/json/mapa.json");

        assertDoesNotThrow(parser::formatoCorrecto);

    }
    @Test
    public void test15LecturaYconversionDeJSONdeEnemigos() throws IOException, ParseException {

        EnemigosParser parser = new EnemigosParser("src/json/enemigos.json");
        List<Enemigo> lista = parser.parsear(1);

        List<Enemigo> listaEsperada = new ArrayList<Enemigo>();
        listaEsperada.add(new Hormiga());

        assertEquals(listaEsperada.size(), lista.size());
        assertEquals(listaEsperada.get(0).esHormiga(), lista.get(0).esHormiga());
    }

    @Test
    public void test16LecturaYConversionDeJSONMapa() throws IOException, ParseException, FormatoJSONInvalido {

        MapaParser mapaParser = new MapaParser("src/json/mapa.json");

        Casillero[][] mapa = mapaParser.parsear();

        assertTrue(mapa[0][0].esIgual(new Rocosa(0, 0)));

        assertTrue(mapa[0][1].esIgual(new Pasarela(1, 0)));

        assertTrue(mapa[0][2].esIgual(new Tierra(2, 0)));

        assertTrue(mapa[0][3].esIgual(new Tierra(3, 0)));

        assertTrue(mapa[0][4].esIgual(new Tierra(4, 0)));

        assertTrue(mapa[0][5].esIgual(new Tierra(5, 0)));

    }

    @Test
    public void test17JuegoBienCreado()throws IOException, ParseException, FormatoJSONInvalido {

        EnemigosParser parser = new EnemigosParser("src/json/enemigos.json");
       
        List<Enemigo> lista = parser.parsear(1);

        MapaParser mapaParser = new MapaParser("src/json/mapa.json");

        Casillero[][] mapaParseado = mapaParser.parsear();

        Mapa mapa = new Mapa(mapaParseado);
        
        assertTrue(mapa.establecerEnemigos(lista));

        assertTrue(mapa.ocupado(0,1));

        assertTrue(mapaParseado[0][0].esIgual(new Rocosa(0, 0)));

        assertTrue(mapaParseado[10][4].esIgual(new Tierra(4,10)));

        assertTrue(mapaParseado[10][14].esIgual(new Pasarela(14, 10)));

        assertTrue(mapaParseado[14][4].esIgual(new Rocosa(4, 14)));

        assertTrue(mapaParseado[12][10].esIgual(new Tierra(10, 12)));
        
 

    }



    //////////////////// PREGUNTAR /////////////////////////////////////////////////////////////////

    
    public void test18JugadorJuegaYganaPartida()throws IOException, ParseException, FormatoJSONInvalido {

        int t = 1;

        EnemigosParser parser = new EnemigosParser("src/json/enemigos.json");

        MapaParser mapaParser = new MapaParser("src/json/mapa.json");

        Casillero[][] mapaParseado = mapaParser.parsear();

        Mapa mapa = new Mapa(mapaParseado);

        Jugador jugador = new Jugador();


        do{

            List<Enemigo> lista = parser.parsear(t);
            
            mapa.establecerEnemigos(lista);

            jugador.jugar(mapa);

            mapa.pasarTurno(jugador);

            t++;

        } while(jugador.gano(mapa) || jugador.muerto());

        assertTrue(jugador.gano(mapa));



    }
    
    public void test19JugadorJuegaYpierdePartida()throws IOException, ParseException, FormatoJSONInvalido {

            int t = 1;
    
            EnemigosParser parser = new EnemigosParser("src/json/enemigos.json");
    
            MapaParser mapaParser = new MapaParser("src/json/mapa.json");
    
            Casillero[][] mapaParseado = mapaParser.parsear();
    
            Mapa mapa = new Mapa(mapaParseado);
    
            Jugador jugador = new Jugador();
    
    
            do{
    
                List<Enemigo> lista = parser.parsear(t);
                
                mapa.establecerEnemigos(lista);
    
                mapa.pasarTurno(jugador);
    
                t++;
    
            } while(jugador.gano(mapa) || jugador.muerto());
    
            assertTrue(jugador.muerto());

 

    }

    public void test20VerificarSistemaLogParaEntrega3() {

 





    }



}

