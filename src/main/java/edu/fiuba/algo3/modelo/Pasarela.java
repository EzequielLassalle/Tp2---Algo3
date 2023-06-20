package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;

public class Pasarela extends Casillero {
    List<Enemigo> enemigos = new ArrayList<Enemigo>();
	Pasarela pasarelaSiguiente;
	Torre trampaArenosa;

    public Pasarela(int nuevaX, int nuevaY){

		super(nuevaX, nuevaY);
		this.tipo = "Pasarela";
		this.pasarelaSiguiente = null;
		this.trampaArenosa = null;

    }

    @Override
    public Boolean esPasarela(){

        return true;
    }

	@Override
	public void establecerEnemigos( List<Enemigo> unaLista){
		enemigos = unaLista;
	}

    @Override
    public void establecerEnemigo(Enemigo unEnemigo){

        this.enemigos.add(unEnemigo);

    }

	public void establecerDefensa(Torre unaTorre){

        this.trampaArenosa = unaTorre;
        unaTorre.setCoordenadas(this.x,this.y);

		System.out.println("Torre construida exitosamente");

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

	@Override
	public Pasarela obtenerSiguiente() {
		if(pasarelaSiguiente != null){
			return pasarelaSiguiente;
		}
		return this;
	}

	private void mover(Enemigo enemigo) {

	if(trampaArenosa != null){
		if(trampaArenosa.operativa()){
		Casillero pasarelaDestino = enemigo.moverRelantizado(this);
		pasarelaDestino.establecerEnemigo(enemigo);
		trampaArenosa.sumarTurno();
		}

	}else{

		Casillero pasarelaDestino = enemigo.mover(this);
		pasarelaDestino.establecerEnemigo(enemigo);

		}
	}


	@Override
	public void pasarTurno(Jugador jugador) {
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
