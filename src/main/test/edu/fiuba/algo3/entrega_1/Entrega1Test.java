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

        Jugador jugador = new Jugador(100,20);

        assertTrue(jugador.creditoIgual(100));
       
        assertTrue(jugador.vidaIgual(20));


    }

    @Test
    public void test02TiempoConstruccionDeDefensasEsElCorrespondienteYSonUtilizables() {

        TorreBlanca torreBlanca = new TorreBlanca();
        TorrePlateada torrePlateada = new TorrePlateada();

        torreBlanca.turno();
        torrePlateada.turno();
        torrePlateada.turno();


        assertTrue(torreBlanca.operativa());
        assertTrue(torrePlateada.operativa());



    }

    @Test
    public void test03VerificacionCreditosParaConstruir() {

        Jugador jugador = new Jugador(100,20);


        jugador.construirTorreBlanca(10, new Tierra());
        jugador.construirTorrePlateada(20, new Tierra());

        assertTrue(jugador.creditoIgual(70));


    }

    @Test
    public void test04SeVerificaQueSoloSePuedeConstruirSobreTierra() {

        
        Jugador jugador = new Jugador(100,20);


        jugador.construirTorreBlanca(10, new Tierra());
        jugador.construirTorrePlateada(20, new Rocosa());

        assertTrue(jugador.creditoIgual(90));




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