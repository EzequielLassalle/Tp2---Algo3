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

    
    

    
}
