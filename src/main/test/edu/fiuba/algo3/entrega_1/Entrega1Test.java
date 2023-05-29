package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.*;

public class Entrega1Test {
    @Test
    public void test01EmpiezaPartidaYJugadorTieneVidaYCreditosCorrespondientes() {

        Jugador jugador = new Jugador(new Credito(100),20);

        Credito creditoEsperado = new Credito(100);

        assertTrue(jugador.creditoIgual(creditoEsperado));
       
        assertTrue(jugador.vidaIgual(20));


    }

    @Test
    public void test02TiempoConstruccionDeDefensasEsElCorrespondienteYSonUtilizables() {

    }

    @Test
    public void test03VerificacionCreditosParaConstruir() {

    }

    @Test
    public void test04SeVerificaQueSoloSePuedeConstruirSobreTierra() {

    }

    @Test
    public void test05SeVerificaQueLasDefensasAtaquenDentroDelRangoEsperado() {

    }

    @Test
    public void test06EnemigosRecibenElDanioEsperado() {

    }

    @Test
    public void test07EnemigosSeMuevenSoloPorLaParcelaAutorizada() {

    }

    @Test
    public void test08SeDestruyeUnidadEnemigaYJugadorCobraCreditosCorrespondientes() {

    }

    @Test
    public void test09PasaUnTurnoYSeVerificaQueLasUnidadesEnemigasSeHayanMovidoSegunVelocidad() {

    }

    @Test
    public void test10SeEliminanTodosLosEnemigosYElJugadorGanaLaPartida() {

    }

    @Test
    public void test11NoSeEliminanLasUnidadesEnemigasYElJugadorNoMuereEntoncesGana(){

    }

    @Test
    public void test12UnidadesEnemigasLleganALaMetaYMatanAlJugadorEntoncesPierde(){

    }
}