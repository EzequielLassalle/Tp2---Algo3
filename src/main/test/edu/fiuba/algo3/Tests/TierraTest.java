package edu.fiuba.algo3.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;




public class TierraTest {

    @Test
    public void Tierra01SeEstableceSinDefensa(){

        Tierra tierra = new Tierra(1,1);

        assertTrue(!tierra.hayDefensa());

        assertTrue(tierra.vacio());



    }

    @Test
        public void Tierra02EstableceSinDefensaYataca(){

        Tierra tierra = new Tierra(1,1);

        tierra.establecerDefensa(new TorreBlanca());

        tierra.pasarTurno(new Casillero(0, 0));

        assertTrue(tierra.hayDefensa());

        tierra.eliminarDefensa();

        assertTrue(!tierra.hayDefensa());

    }


}

