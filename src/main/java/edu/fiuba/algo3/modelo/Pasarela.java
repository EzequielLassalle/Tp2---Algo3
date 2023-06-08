package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Pasarela extends Casillero {
    List<Enemigo> enemigos = new ArrayList<Enemigo>();
	Pasarela pasarelaSiguiente;

    public Pasarela(int nuevaX, int nuevaY){

		super(nuevaX, nuevaY);
		this.tipo = "Pasarela";
		this.pasarelaSiguiente = null;

    }

    @Override
    public Boolean esPasarela(){

        return true;
    }

	@Override
	public void establecerEnemigos( List<Enemigo> unaLista){
		enemigos = unaLista;
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
    public int obtenerX(){

        return this.x;
    }

	@Override
    public int obtenerY(){

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

	@Override
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

	@Override
	public void pasarTurno(List<Pasarela> camino) {
		moverEnemigos();
	}


	@Override
	public Credito Atacado(int danio){
		Credito credito = new Credito(0);
		
		credito.sumar(enemigos.get(0).Atacado(danio));
		
		if(enemigos.get(0).muerto()){
			enemigos.remove(0);
		}

		return credito;

	}

	@Override
	public void daniarJugador(Jugador jugador){

		int danio_total = 0;
		for (Enemigo enemigo : enemigos) {
			danio_total += enemigo.danio();
		}
		
		jugador.atacado(new Vida(danio_total));

	}

	public void atacarJugador(Jugador jugador){
		
		for (Enemigo enemigo : enemigos) {
			jugador.restarVida(new Vida(enemigo.danio()));
			
		}

	}

}
