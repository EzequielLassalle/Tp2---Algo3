package edu.fiuba.algo3.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.*;


public class CasilleroTest {


    @Test
    public void Casillero01casilleroSeCreaBien() {

        Casillero casillero= new Casillero(1,2);

        assertEquals(casillero, new Casillero(1,1));


    } 

    @Test
    public void Casillero02abajoSeEstableceBien() {

        Casillero casillero= new Casillero(1,2);

        Casillero casilleroSiguiente = new Casillero(2,2);

        casillero.establecerAbajo(casilleroSiguiente);

        assertTrue(casillero.obtenerAbajo() == casilleroSiguiente);


    } 

    @Test
    public void Casillero03derechaSeEstableceBien() {

        Casillero casillero= new Casillero(1,2);

        Casillero casilleroSiguiente = new Casillero(2,2);

        casillero.establecerDerecha(casilleroSiguiente);

        assertTrue(casillero.obtenerDerecha() == casilleroSiguiente);


    } 

    @Test
    public void Casillero04hipotenusaSeEstableceBien() {

        Casillero casillero= new Casillero(1,2);

        Casillero casilleroSiguiente = new Casillero(2,2);

        casillero.establecerHipotenusa(casilleroSiguiente);

        assertTrue(casillero.obtenerSiguienteHipotenusa() == casilleroSiguiente);


    } 

    @Test
    public void Casillero05NoEsTierra() {

        Casillero casillero= new Casillero(1,2);

        assertFalse(casillero.esTierra());


    } 

    
    @Test
    public void Casillero06enemigoSeEstableceBien() {

        Casillero casillero= new Casillero(1,2);

        Hormiga hormiga = new Hormiga();

        casillero.establecerEnemigo(hormiga);

        assertTrue(casillero.enemigo().equals(new Hormiga()));


    } 

    @Test
    public void Casillero07esPasarelaFunciona(){

        Casillero casillero = new Casillero(1,2);

        assertFalse(casillero.esPasarela());

    }

        @Test
    public void Casillero08VacioFuncionaBien(){

        Casillero casillero = new Casillero(1,2);

        assertTrue(casillero.vacio());

    }


    @Test
    public void Casillero09devuelveElTipobien(){

        Tierra tierra= new Tierra(0,0);

        assertTrue(tierra.tipo() == "Tierra");

    }

    @Test 
    public void casillero10EsAtacadoBien(){

        Casillero casillero = new Casillero(1,2);

        Hormiga hormiga = new Hormiga();

        casillero.establecerEnemigo(hormiga);


        assertTrue(casillero.enemigo().equals(new Hormiga()));

        casillero.Atacado(100);

        assertTrue(casillero.enemigo() == null);

    }

    @Test
    public void Casillero10casilleroNoAtaca(){

        Casillero casillero = new Casillero(0,0);

        assertTrue(casillero.Atacar(new Casillero(0,0)).equals(new Credito(0)));

    }

    @Test
    public void Casillero11ElCasilleroDetectaBienSiTieneUnaLechuza(){

        Casillero casillero = new Casillero(0,0);

        casillero.establecerEnemigo(new Lechuza());

        assertTrue(casillero.hay_Lechuza());


    }

    @Test
    public void Casillero12CasilleroNuncaTieneUnaDefensaSusHijasSi(){

        Casillero casillero = new Casillero(0, 0);

        casillero.establecerDefensa(new TorreBlanca(0,0));

        assertFalse(casillero.hayDefensa());



    }

    @Test
    public void Casillero13CasilleroMueveBien(){

        Pasarela pasarela = new Pasarela(0, 0);

        pasarela.establecerEnemigo(new Hormiga());
        pasarela.establecerDefensa(new TrampaArenosa());

        Pasarela pasarela2 = new Pasarela(0,1);

        pasarela.establecerSiguiente(pasarela2);

        pasarela.moverEnemigos();

        assertTrue(pasarela.enemigo().equals(new Hormiga()));

        pasarela.moverEnemigos();

        assertTrue(pasarela2.enemigo().equals(new Hormiga()));

    }



    
    

    
}
