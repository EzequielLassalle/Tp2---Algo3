package edu.fiuba.algo3.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;

public class PasarelaTest {

    @Test
    public void PasarelaSeCreaBien(){

        Pasarela pasarela = new Pasarela(0, 0);

        assertTrue(pasarela.equals(new Pasarela(0, 0)));

    }
}
