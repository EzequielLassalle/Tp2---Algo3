package edu.fiuba.algo3.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.*;

import edu.fiuba.algo3.modelo.*;

public class TrampaArenosaTest {

    @Test
    public void TrampaArenosaSeCreaBien01() {

    TrampaArenosa arenosa = new TrampaArenosa(1,2);

    assertTrue(arenosa.equals(new TrampaArenosa()));

    }

    @Test
    public void TrampaArenosaNoAtaca02() {

    TrampaArenosa arenosa = new TrampaArenosa();

    assertTrue(arenosa.Atacar(new Casillero(0,0)).equals(new Credito(0)));

    }

    @Test
    public void TrampaArenosaPrecio03() {

    TrampaArenosa arenosa = new TrampaArenosa();

    assertTrue(arenosa.costo().igual(new Credito(25)));

    }

     @Test
    public void TrampaArenosaFuncionaBien() {

    TrampaArenosa arenosa = new TrampaArenosa();


    arenosa.sumarTurno();
    arenosa.sumarTurno();
    arenosa.sumarTurno();

    assertFalse(arenosa.operativa());

    }

   



}