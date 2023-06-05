package edu.fiuba.algo3.modelo;
import java.util.*;

public class Pasarela extends Casillero {

    List<Enemigo> enemigos = new ArrayList<Enemigo>();
	Pasarela pasarelaSiguiente;

    public Pasarela(int nuevax,int nuevay){

        this.x = nuevax;
        this.y = nuevay;
		pasarelaSiguiente = null;

    }

    @Override
    public Boolean esPasarela(){

        return true;
    }

    
    public void establecerEnemigo(Enemigo unEnemigo){

        this.enemigos.add(unEnemigo);
    }

   /*  public void AtacadoPorTorreBlanca(Jugador jugador){

		for (Enemigo enemigo : enemigos) {
			enemigo.AtacadoPorTorreBlanca(jugador);
		}
    }

    public void AtacadoPorTorrePlateada(Jugador jugador){

		for (Enemigo enemigo : enemigos) {
			enemigo.AtacadoPorTorrePlateada(jugador);
		}
    } */

    /////////////////En estos dos metodos se viola el encapsulamiento -> refactorizar ////////////////////

	@Override
    public int obtenerx(){

        return this.x;
    }

	@Override
    public int obtenery(){

        return this.y;
    }

    //////// En el refactor Casillero de por si va a conocer si siguiente //////////////

    
    public void moverEnemigos() {

		for (Enemigo enemigo : enemigos) {
			this.mover(enemigo);
			//enemigo = null;
			//enemigos.remove(enemigo);
		}

		enemigos.removeAll(enemigos);

    }

	public Boolean ocupado() {
		return !enemigos.isEmpty();
	}
	
	public Boolean vacio() {
		return enemigos.isEmpty();
	}

	public void establecerSiguiente(Pasarela unaPasarela) {
		pasarelaSiguiente = unaPasarela;
	}

	public Pasarela obtenerSiguiente() {
		return pasarelaSiguiente;
	}

	private void mover(Enemigo enemigo) {
		Pasarela pasarelaDestino = enemigo.mover(this);
		pasarelaDestino.establecerEnemigo(enemigo);
	}

	public void pasarTurno(Jugador jugador) {
		moverEnemigos();
	}


	@Override

	public int Atacado(int danio){
		int credito = 0;
		
		for (Enemigo enemigo : enemigos) {
			credito = credito + enemigo.Atacado(danio);
		}

		return credito;

	}

	@Override
	public void DaniarJugador(Jugador jugador){

		int danio_total = 0;
		for (Enemigo enemigo : enemigos) {
			danio_total = danio_total + enemigo.danio();
		}
		
		jugador.atacado(danio_total);

	}

}
