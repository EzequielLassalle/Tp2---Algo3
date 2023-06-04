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


        Jugador jugador1 = new Jugador();

        Jugador jugador2 = new Jugador();

        assertTrue(jugador1.esIgual(jugador2));


    }

    @Test
    public void test02TiempoConstruccionDeDefensasEsElCorrespondienteYSonUtilizables() {

        TorreBlanca torreBlanca = new TorreBlanca(0,0);
        TorrePlateada torrePlateada = new TorrePlateada(0,0);

        torreBlanca.turno();
        torrePlateada.turno();
        torrePlateada.turno();

        Pasarela pasarela1 = new Pasarela(1,1);
        Pasarela pasarela2 = new Pasarela(1,1);

        Enemigo enemigo1 = new Hormiga();
        Enemigo enemigo2 = new Arania();

        pasarela1.establecerEnemigo(enemigo1);
        pasarela2.establecerEnemigo(enemigo2);

        assertEquals(1,torreBlanca.atacar2(pasarela1));
        assertEquals(2,torrePlateada.atacar2(pasarela2)); 



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

        Jugador jugador = new Jugador(100, 20);

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


        assertTrue(tierraBlanca.atacar(pasarela1, jugador));
        assertTrue(tierraPlateada.atacar(pasarela2, jugador));


    }

    @Test
    public void test06EnemigosRecibenElDanioEsperado() {

        Jugador jugador = new Jugador(100, 20);

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


        tierraBlanca.atacar(pasarela1, jugador);
        tierraPlateada.atacar(pasarela2, jugador);

        assertTrue(enemigo1.vida(0));
        assertTrue(enemigo2.vida(0)); 


    }

    @Test
    public void test07EnemigosSeMuevenSoloPorLaParcelaAutorizada() {

        Pasarela pasarela1 = new Pasarela(3,3);
        Pasarela pasarela2 = new Pasarela(4,4);
        Enemigo enemigo = new Hormiga();
		pasarela1.establecerSiguiente(pasarela2);
        pasarela1.establecerEnemigo(enemigo);

		pasarela1.moverEnemigos();
        assertTrue(pasarela1.vacio());
        assertTrue(pasarela2.ocupado());

    }

    @Test
    public void test08SeDestruyeUnidadEnemigaYJugadorCobraCreditosCorrespondientes() {

        Jugador jugador = new Jugador(100, 20);
        Tierra tierraBlanca = new Tierra(1,1);
        TorreBlanca torreBlanca = new TorreBlanca();
        Pasarela pasarela1 = new Pasarela(3,3);
        Enemigo enemigo1 = new Hormiga();
        tierraBlanca.establecerDefensa(torreBlanca);
        pasarela1.establecerEnemigo(enemigo1);
        tierraBlanca.atacar(pasarela1, jugador);
        assertTrue(jugador.creditosIgualA(101));
    }

    @Test
    public void test09PasaUnTurnoYSeVerificaQueLasUnidadesEnemigasSeHayanMovidoSegunVelocidad() {
		Hormiga enemigo1 = new Hormiga();
		Arania enemigo2 = new Arania();

		Pasarela pasarela1 = new Pasarela(0,0);
		Pasarela pasarela2 = new Pasarela(1,0);
		Pasarela pasarela3 = new Pasarela(2,0);

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
		Juego juego = new Juego();

		juego.construir(0,2,"Torre Plateada");

		juego.pasarTurno();

		assertTrue(juego.gano());
    }

    @Test
    public void test11NoSeEliminanLasUnidadesEnemigasYElJugadorNoMuereEntoncesGana(){

        Juego juego = new Juego();

		juego.pasarTurno();

        juego.pasarTurno();

		assertTrue(juego.gano());

    }

    @Test
    public void test12UnidadesEnemigasLleganALaMetaYMatanAlJugadorEntoncesPierde(){

    }
}


/*main(){
    Jugador jugador new;
    Juego juego new(jugador);

    Mapa mapa new(JSON);
    turno 1:
    jugador.construir(casillero, construccion);
    enemigos.aparecen(JSON);

    ----------------------------
    juego.pasarTurno()
    ----------------------------
    turno 2:



    turno 3:





}*/

