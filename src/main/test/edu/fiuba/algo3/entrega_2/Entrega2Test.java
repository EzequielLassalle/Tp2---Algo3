package edu.fiuba.algo3.entrega_2;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega2Test{
    @Test
    public void test13FormatoJSONdeEnemigosEsElCorrecto() throws ParseException, IOException, JSONVacio, FormatoJSONInvalido {
        
        //MapaParser parser = new MapaParser("src/json/mapa.json");
        //parser.parsearMapa();
        EnemigosParser parser = new EnemigosParser("src/json/enemigos.json");
        assertDoesNotThrow(parser::formatoCorrecto);


    }

    public void test14FormatoJSONdeMapaEsElCorrecto() {

 

    }

    public void test15LecturaYconversionDeJSONdeEnemigos() {

 

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

