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
        
        //MapaParser parser = new MapaParser("src/json/mapa.json");
        //parser.parsearMapa();
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


    public void test16LecturaYconversiondeJSONMapa() {



    }

    public void test17JuegoBienCreado() {

 

    }

    public void test18JugadorJuegaYganaPartida() {

 

    }
    
    public void test19JugadorJuegaYpierdePartida() {

 

    }

    public void test20VerificarSistemaLogParaEntrega3() {

 

    }



}

