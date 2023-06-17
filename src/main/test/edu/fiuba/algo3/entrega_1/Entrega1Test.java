package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.*;

public class Entrega1Test {
    @Test
    public void test01EmpiezaPartidaYJugadorTieneVidaYCreditosCorrespondientes() {

        Jugador jugador1 = new Jugador();

        Jugador jugador2 = new Jugador();

        assertTrue(jugador1.esIgual(jugador2));


    }

    @Test
    public void test02TiempoConstruccionDeDefensasEsElCorrespondienteYSonUtilizables() {

        TorreBlanca torreBlanca = new TorreBlanca(0, 0);
        TorrePlateada torrePlateada = new TorrePlateada(0, 0);

        torreBlanca.turno();
        torrePlateada.turno();
        torrePlateada.turno();

        Pasarela pasarela1 = new Pasarela(1, 1);
        Pasarela pasarela2 = new Pasarela(1, 1);

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();

        pasarela1.establecerEnemigo(enemigo1);
        pasarela2.establecerEnemigo(enemigo2);

		Credito creditoEsperadoHormiga = new Credito(1);
		Credito creditoEsperadoArania = new Credito(2);

        //assertEquals(new Credito(1),);
        //assertEquals(new Credito(1),torrePlateada.Atacar(pasarela2)); 

		assertTrue(creditoEsperadoHormiga.igual(torreBlanca.Atacar(pasarela1)));
		assertTrue(creditoEsperadoArania.igual(torrePlateada.Atacar(pasarela2)));

    }

    @Test
    public void test03VerificacionCreditosParaConstruir() {

        Jugador jugador = new Jugador();

        jugador.construirTorreBlanca(new Tierra(1, 2));

        jugador.construirTorrePlateada(new Tierra(1, 2));

		Credito creditoEsperado = new Credito(70);

        //assertEquals(70,jugador.credito().obtenerCreditoTotal());
		assertTrue(creditoEsperado.igual(jugador.credito()));
		
    }

    @Test
    public void test04SeVerificaQueSoloSePuedeConstruirSobreTierra() {

        Jugador jugador = new Jugador();

        jugador.construirTorreBlanca(new Tierra(1, 2));
       
        //////Agarrar excepcion///////
        jugador.construirTorrePlateada(new Rocosa(1, 4));

		Credito creditoEsperado = new Credito(90);

        //assertEquals(90,jugador.credito().obtenerCreditoTotal()); 
		assertTrue(creditoEsperado.igual(jugador.credito()));

    }

    @Test
    public void test05SeVerificaQueLasDefensasAtaquenDentroDelRangoEsperado() {

        Tierra tierraBlanca = new Tierra(1, 1);
        Tierra tierraPlateada = new Tierra(1, 1);

        TorreBlanca torreBlanca = new TorreBlanca(1, 1);
        TorrePlateada torrePlateada = new TorrePlateada(1, 1);

        Pasarela pasarela1 = new Pasarela(3, 3);
        Pasarela pasarela2 = new Pasarela(4, 4);

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();

        tierraBlanca.establecerDefensa(torreBlanca);
        tierraPlateada.establecerDefensa(torrePlateada);

        pasarela1.establecerEnemigo(enemigo1);
        pasarela2.establecerEnemigo(enemigo2);

		Credito creditoEsperadoHormiga = new Credito(1);
		Credito creditoEsperadoArania = new Credito(2);

        tierraBlanca.Atacar(pasarela1);

        tierraPlateada.Atacar(pasarela2);
        tierraPlateada.Atacar(pasarela2);


		assertTrue(creditoEsperadoHormiga.igual(tierraBlanca.Atacar(pasarela1)));
		assertTrue(creditoEsperadoArania.igual(tierraPlateada.Atacar(pasarela2)));

    }

    @Test
    public void test06EnemigosRecibenElDanioEsperado() {

        Tierra tierraBlanca = new Tierra(1, 1);
        Tierra tierraPlateada = new Tierra(1, 1);

        TorreBlanca torreBlanca = new TorreBlanca(1, 1);
        TorrePlateada torrePlateada = new TorrePlateada(1, 1);

        Pasarela pasarela1 = new Pasarela(3, 3);
        Pasarela pasarela2 = new Pasarela(4, 4);

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();

        tierraBlanca.establecerDefensa(torreBlanca);
        tierraPlateada.establecerDefensa(torrePlateada);

        pasarela1.establecerEnemigo(enemigo1);
        pasarela2.establecerEnemigo(enemigo2);


        tierraBlanca.Atacar(pasarela1);
        tierraBlanca.Atacar(pasarela1);

        tierraPlateada.Atacar(pasarela2);
        tierraPlateada.Atacar(pasarela2);
        tierraPlateada.Atacar(pasarela2);
    	//torreBlanca.Atacar(pasarela1);
        //torrePlateada.Atacar(pasarela2);

        assertTrue(enemigo1.muerto());
        assertTrue(enemigo2.muerto()); 


    }

    @Test
    public void test07EnemigosSeMuevenSoloPorLaParcelaAutorizada() {

        Pasarela pasarela1 = new Pasarela(3, 3);
        Pasarela pasarela2 = new Pasarela(4, 4);
        Enemigo enemigo = new Hormiga();
		pasarela1.establecerSiguiente(pasarela2);
        pasarela1.establecerEnemigo(enemigo);

		pasarela1.moverEnemigos();
        assertTrue(pasarela1.vacio());
        assertTrue(pasarela2.ocupado());

    }

    @Test
    public void test08SeDestruyeUnidadEnemigaYJugadorCobraCreditosCorrespondientes() {

        Jugador jugador = new Jugador();

        Tierra tierraBlanca = new Tierra(1, 1);
        TorreBlanca torreBlanca = new TorreBlanca(1, 1);

        Pasarela pasarela1 = new Pasarela(3, 3);
        Enemigo enemigo1 = new Hormiga();

        tierraBlanca.establecerDefensa(torreBlanca);
        pasarela1.establecerEnemigo(enemigo1);

        Credito credito = tierraBlanca.Atacar(pasarela1);
        /// por el turno de construccion ///
        credito = tierraBlanca.Atacar(pasarela1);

        jugador.cobrarCredito(credito);

		Credito creditoEsperado = new Credito(101);

        //assertEquals(101,jugador.credito().obtenerCreditoTotal());
		assertTrue(creditoEsperado.igual(jugador.credito()));
    }

    @Test
    public void test09PasaUnTurnoYSeVerificaQueLasUnidadesEnemigasSeHayanMovidoSegunVelocidad() {
		Hormiga enemigo1 = new Hormiga();
		Arania enemigo2 = new Arania();

		Pasarela pasarela1 = new Pasarela(0, 0);
		Pasarela pasarela2 = new Pasarela(1, 0);
		Pasarela pasarela3 = new Pasarela(2, 0);

		pasarela1.establecerSiguiente(pasarela2);
		pasarela2.establecerSiguiente(pasarela3);

		pasarela1.establecerEnemigo(enemigo1);
		pasarela1.establecerEnemigo(enemigo2);

		pasarela1.moverEnemigos();

		assertTrue(pasarela1.vacio());
		assertTrue(pasarela2.ocupado());
		assertTrue(pasarela3.ocupado());

    }

    @Test
    public void test10SeEliminanTodosLosEnemigosYElJugadorGanaLaPartida() {

        Tierra tierraBlanca = new Tierra(1, 1);
        Tierra tierraPlateada = new Tierra(1, 2);

        TorreBlanca torreBlanca = new TorreBlanca(1, 1);
        TorrePlateada torrePlateada = new TorrePlateada(1, 2);

        Pasarela pasarela = new Pasarela(0, 0);
        

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();

        tierraBlanca.establecerDefensa(torreBlanca);
        tierraPlateada.establecerDefensa(torrePlateada);

        pasarela.establecerEnemigo(enemigo1);
        pasarela.establecerEnemigo(enemigo2);


        /////Por los turnos en construccion los primeros Atacar no ataca ///
        tierraBlanca.Atacar(pasarela);
        tierraBlanca.Atacar(pasarela);

        tierraPlateada.Atacar(pasarela);
        tierraPlateada.Atacar(pasarela);
        tierraPlateada.Atacar(pasarela);

        assertTrue(pasarela.vacio());
        
    }

    @Test
    public void test11NoSeEliminanLasUnidadesEnemigasYElJugadorNoMuereEntoncesGana(){

        Jugador jugador = new Jugador();

        Tierra tierraBlanca = new Tierra(1, 1);
        Tierra tierraPlateada = new Tierra(1, 2);

        TorreBlanca torreBlanca = new TorreBlanca(1, 1);
        TorrePlateada torrePlateada = new TorrePlateada(1, 2);

        Pasarela pasarela1 = new Pasarela(0, 0);
        Pasarela pasarela2 = new Pasarela(1, 0);

        pasarela1.establecerSiguiente(pasarela2);

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();
        Enemigo enemigo3 = new Hormiga();

        tierraBlanca.establecerDefensa(torreBlanca);
        tierraPlateada.establecerDefensa(torrePlateada);

        pasarela1.establecerEnemigo(enemigo1);
        pasarela1.establecerEnemigo(enemigo2);
        pasarela1.establecerEnemigo(enemigo3);

        tierraBlanca.Atacar(pasarela1);
        tierraBlanca.Atacar(pasarela1);

        tierraPlateada.Atacar(pasarela1);
        tierraPlateada.Atacar(pasarela1);
        tierraPlateada.Atacar(pasarela1);

        pasarela1.moverEnemigos();

        pasarela2.atacarJugador(jugador);

		Vida vidaEsperada = new Vida(19);

		assertTrue(vidaEsperada.igual(jugador.vida()));

    }

    @Test
    public void test12UnidadesEnemigasLleganALaMetaYMatanAlJugadorEntoncesPierde(){

        Jugador jugador = new Jugador();

        Pasarela pasarela1 = new Pasarela(0, 0);
        Pasarela pasarela2 = new Pasarela(1, 0);
        Pasarela pasarela3 = new Pasarela(2, 0);

        pasarela1.establecerSiguiente(pasarela2);
        pasarela2.establecerSiguiente(pasarela3);

        Enemigo enemigo1 = new Arania();
        Enemigo enemigo2 = new Arania();

        pasarela1.establecerEnemigo(enemigo1);
        pasarela1.establecerEnemigo(enemigo2);


        pasarela1.moverEnemigos();

        pasarela3.atacarJugador(jugador);
        pasarela3.atacarJugador(jugador);
        pasarela3.atacarJugador(jugador);
        pasarela3.atacarJugador(jugador);
        pasarela3.atacarJugador(jugador);

        assertTrue(jugador.muerto());

    }
    
}



