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


        jugador.construirTorreBlanca(10, new Tierra(1,2));
        jugador.construirTorrePlateada(20, new Tierra(1,2));

        assertTrue(jugador.creditoIgual(70));


    }

    @Test
    public void test04SeVerificaQueSoloSePuedeConstruirSobreTierra() {

        
        Jugador jugador = new Jugador(100,20);


        jugador.construirTorreBlanca(10, new Tierra(1,2));
        jugador.construirTorrePlateada(20, new Rocosa(1,4));

        assertTrue(jugador.creditoIgual(90));


    }

    @Test
    public void test05SeVerificaQueLasDefensasAtaquenDentroDelRangoEsperado() {

        Tierra tierraBlanca = new Tierra(1,1);
        Tierra tierraPlateada = new Tierra(1,1);

        TorreBlanca torreBlanca = new TorreBlanca();
        TorrePlateada torrePlateada = new TorrePlateada();

        Pasarela pasarela1 = new Pasarela(3,3);
        Pasarela pasarela2 = new Pasarela(5,5);

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();

        tierraBlanca.establecerDefensa(torreBlanca);
        tierraPlateada.establecerDefensa(torrePlateada);

        pasarela1.establecerEnemigo(enemigo1);
        pasarela2.establecerEnemigo(enemigo2);


        assertTrue(tierraBlanca.atacar(pasarela1));
        assertTrue(tierraPlateada.atacar(pasarela2));


    }

    @Test
    public void test06EnemigosRecibenElDanioEsperado() {

        Tierra tierraBlanca = new Tierra(1,1);
        Tierra tierraPlateada = new Tierra(1,1);

        TorreBlanca torreBlanca = new TorreBlanca();
        TorrePlateada torrePlateada = new TorrePlateada();

        Pasarela pasarela1 = new Pasarela(3,3);
        Pasarela pasarela2 = new Pasarela(5,5);

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();

        tierraBlanca.establecerDefensa(torreBlanca);
        tierraPlateada.establecerDefensa(torrePlateada);

        pasarela1.establecerEnemigo(enemigo1);
        pasarela2.establecerEnemigo(enemigo2);


        tierraBlanca.atacar(pasarela1);
        tierraPlateada.atacar(pasarela2);

        assertTrue(enemigo1.vida(0));
        assertTrue(enemigo2.vida(0)); 


    }

    @Test
    public void test07EnemigosSeMuevenSoloPorLaParcelaAutorizada() {

    Pasarela pasarela1 = new Pasarela(3,3);

    Enemigo enemigo = new Hormiga();

    pasarela1.establecerEnemigo(enemigo);

    
    Pasarela pasarela2 = new Pasarela(4,4);

    assertTrue(pasarela1.moverEnemigo(pasarela2));



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