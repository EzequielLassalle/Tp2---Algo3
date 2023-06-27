package edu.fiuba.algo3.modelo;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class Pasarela extends Casillero {
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
    public Boolean hayDefensa(){

       if(trampaArenosa == null){
		return false;
	   }
	   return true;

    }

	/*@Override
	public void establecerEnemigos( Stack<Enemigo> unaPila){
		enemigos = unaPila;
	}*/

    @Override
    public void establecerEnemigo(Enemigo unEnemigo){

        this.enemigos.add(unEnemigo);

    }

	@Override
	public void establecerDefensa(Torre unaTorre){

        this.trampaArenosa = unaTorre;
        unaTorre.setCoordenadas(this.x,this.y);

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

    


	public Boolean ocupado() {
		return !enemigos.isEmpty();
	}

	@Override
	public Boolean vacio() {
		return enemigos.isEmpty();
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

	@Override
	public void AtacarTorres(Jugador jugador,List<Casillero> torres){

		Casillero unaTorre;

		if(hay_Lechuza()){
			if(!torres.isEmpty()){
				unaTorre = torres.get(0);
				unaTorre.eliminarDefensa();
				torres.remove(0);
			}

		}

	}

	    @Override
    public Torre defensa(){

        return this.trampaArenosa;
    }




}
