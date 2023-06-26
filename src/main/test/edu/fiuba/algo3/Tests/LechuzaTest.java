package edu.fiuba.algo3.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Casillero;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.*;

public class LechuzaTest {

    @Test
    public void Lechuza01SeCreaBien() {

    Lechuza lechuza = new Lechuza();

    assertTrue(lechuza.equals(new Lechuza()));


    }

    @Test
    public void Lechuza02SeMueveBien() {

    Lechuza lechuza = new Lechuza();

    Casillero casillero1 = new Casillero(1,1);
    Casillero casillero2 = new Casillero(1,1);
    Casillero casillero3 = new Casillero(1,1);
    Casillero casillero4 = new Casillero(1,1);
    Casillero casillero5= new Casillero(1,1);
    Casillero casillero6 = new Casillero(1,1);

    casillero1.establecerAbajo(casillero2);
    casillero2.establecerAbajo(casillero3);
    casillero3.establecerAbajo(casillero4);
    casillero4.establecerDerecha(casillero5);
    casillero5.establecerDerecha(casillero6);

    assertTrue(lechuza.mover(casillero1) == casillero6);

    Casillero casillero7 = new Casillero(1,1);
    Casillero casillero8 = new Casillero(1,1);
    Casillero casillero9 = new Casillero(1,1);
    Casillero casillero10 = new Casillero(1,1);
    Casillero casillero11= new Casillero(1,1);

    casillero6.establecerAbajo(casillero7);
    casillero7.establecerAbajo(casillero8);
    casillero8.establecerAbajo(casillero9);
    casillero9.establecerDerecha(casillero10);
    casillero10.establecerDerecha(casillero11);

    assertTrue(lechuza.mover(casillero6) == casillero11);

    Casillero casillero12 = new Casillero(1,1);
    Casillero casillero13 = new Casillero(1,1);
    Casillero casillero14 = new Casillero(1,1);
    Casillero casillero15= new Casillero(1,1);
    Casillero casillero16 = new Casillero(1,1);

    casillero11.establecerAbajo(casillero12);
    casillero12.establecerAbajo(casillero13);
    casillero13.establecerAbajo(casillero14);
    casillero14.establecerDerecha(casillero15);
    casillero15.establecerDerecha(casillero16);

    assertTrue(lechuza.mover(casillero11) == casillero16);

    
    Casillero casillero17 = new Casillero(1,1);
    Casillero casillero18 = new Casillero(1,1);
    Casillero casillero19 = new Casillero(1,1);
    Casillero casillero20= new Casillero(1,1);
    Casillero casillero21 = new Casillero(1,1);

    casillero16.establecerAbajo(casillero17);
    casillero17.establecerDerecha(casillero18);
    casillero18.establecerDerecha(casillero19);
    casillero19.establecerDerecha(casillero20);
    casillero20.establecerDerecha(casillero21);


    assertTrue(lechuza.mover(casillero16) == casillero21);

    Casillero casillero22 = new Casillero(1,1);
    Casillero casillero23 = new Casillero(1,1);
    Casillero casillero24 = new Casillero(1,1);
    Casillero casillero25= new Casillero(1,1);
    Casillero casillero26 = new Casillero(1,1);

    casillero21.establecerDerecha(casillero22);
    casillero22.establecerDerecha(casillero23);
    casillero23.establecerDerecha(casillero24);
    casillero24.establecerDerecha(casillero25);
    casillero25.establecerDerecha(casillero26);


    assertTrue(lechuza.mover(casillero21) == casillero26);    


    }

    @Test
    public void Test03LechuzaAtacadaSeMueveBien() {

    Lechuza lechuza = new Lechuza();

    lechuza.Atacado(2);

    Casillero casillero1 = new Casillero(1,1);
    Casillero casillero2 = new Casillero(1,1);
    Casillero casillero3 = new Casillero(1,1);
    Casillero casillero4 = new Casillero(1,1);
    Casillero casillero5= new Casillero(1,1);
    Casillero casillero6 = new Casillero(1,1);

    casillero1.establecerHipotenusa(casillero2);
    casillero2.establecerHipotenusa(casillero3);
    casillero3.establecerHipotenusa(casillero4);
    casillero4.establecerHipotenusa(casillero5);
    casillero5.establecerHipotenusa(casillero6);

    assertTrue(lechuza.mover(casillero1) == casillero6);

   


    }
    
    


}

