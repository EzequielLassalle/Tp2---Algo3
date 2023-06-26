package edu.fiuba.algo3.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.*;

public class TopoTest {

    @Test
    public void Topo01SeCreaBien() {

    Topo topo = new Topo();

    assertTrue(topo.equals(new Topo()));


    } 

    @Test
    public void Topo02TopoSeMueveBien1() {

        Topo topo = new Topo();


        Casillero casillero1 = new Casillero(1,2);
        Casillero casillero2 = new Casillero(1,2);



        casillero1.establecerSiguiente(casillero2);
        
        assertTrue(topo.moverConTurnoSeteado(0, casillero1) == casillero2);


    } 


    @Test
    public void Topo03TopoSeMueveBien2() {

        Topo topo = new Topo();


        Casillero casillero1 = new Casillero(1,2);
        Casillero casillero2 = new Casillero(1,2);
        Casillero casillero3 = new Casillero(1,2);



        casillero1.establecerSiguiente(casillero2);
        casillero2.establecerSiguiente(casillero3);

        topo.moverConTurnoSeteado(4, casillero1);
        
        assertTrue(topo.moverConTurnoSeteado(4, casillero1) == casillero3);


    } 

    @Test
    public void Topo04TopoSeMueveBien3() {

        Topo topo = new Topo();


        Casillero casillero1 = new Casillero(1,2);
        Casillero casillero2 = new Casillero(1,2);
        Casillero casillero3 = new Casillero(1,2);
        Casillero casillero4 = new Casillero(1,2);


        casillero1.establecerSiguiente(casillero2);
        casillero2.establecerSiguiente(casillero3);
        casillero3.establecerSiguiente(casillero4);

        topo.moverConTurnoSeteado(4, casillero1);
        
        assertTrue(topo.moverConTurnoSeteado(10, casillero1) == casillero4);


    } 

    @Test

    public void topo05Ataque(){

        Topo topo = new Topo();

        assertTrue(topo.danio() == 2);


    }

    @Test
    public void Topo06TopoRelantizadoSeMueveBien1() {

        Topo topo = new Topo();


        Casillero casillero1 = new Casillero(1,2);
    
        
        assertTrue(topo.moverConTurnoSeteado(0, casillero1) == casillero1);


    } 

        @Test
    public void Topo07TopoRelantizadoSeMueveBien2() {


        Topo topo = new Topo();


        Casillero casillero1 = new Casillero(1,2);
        Casillero casillero2 = new Casillero(1,2);



        casillero1.establecerSiguiente(casillero2);

        
        assertTrue(topo.moverRelantizadoConTurnoSeteado(4, casillero1) == casillero2);


    } 

    @Test
    public void Topo08TopoRelantizadoSeMueveBien3() {

        Topo topo = new Topo();


        Casillero casillero1 = new Casillero(1,2);
        Casillero casillero2 = new Casillero(1,2);
        Casillero casillero3 = new Casillero(1,2);


        casillero1.establecerSiguiente(casillero2);
        casillero2.establecerSiguiente(casillero3);

        topo.moverConTurnoSeteado(4, casillero1);
        
        assertTrue(topo.moverRelantizadoConTurnoSeteado(10, casillero1) == casillero3);


    } 


    
}
