package edu.fiuba.algo3.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;

public class AraniaTest {

    @Test
    public void test01AraniaSeCreaBien() {

        Arania arania = new Arania();

        assertEquals(arania, new Arania());


    }    

    @Test
    public void test02AraniaSeMueveBien(){

        Arania arania = new Arania();

        Pasarela pasarela1 = new Pasarela(0, 0);
        Pasarela pasarela2 = new Pasarela(1,0);
        Pasarela pasararela3 = new Pasarela(2,0);


        pasarela1.establecerSiguiente(pasarela2);
        pasarela2.establecerSiguiente(pasararela3);

        assertTrue(arania.mover(pasarela1) == pasararela3);



    }

    @Test
    
    public void test03AraniaRelantizadaSeMueveBien(){

        Arania arania = new Arania();

        Pasarela pasarela1 = new Pasarela(0, 0);
        Pasarela pasarela2 = new Pasarela(1,0);
    


        pasarela1.establecerSiguiente(pasarela2);
        

        assertTrue(arania.moverRelantizado(pasarela1) == pasarela2);



    }


    
}
