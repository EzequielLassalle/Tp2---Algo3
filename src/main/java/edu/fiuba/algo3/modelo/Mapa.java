package edu.fiuba.algo3.modelo;
import java.util.*;

public class Mapa {
	Casillero[][] mapa;
	List<Pasarela> camino = new ArrayList<Pasarela>();
	Casillero pasarelaInicial;
	Casillero pasarelaFinal;
	List<Casillero> torres = new ArrayList<Casillero>();

	public Mapa() {
		
	}

	public Casillero posicion(int x, int y){
        return mapa[x][y];
    }

	public Mapa(Casillero[][] unMapa){
		mapa = unMapa;
		establecerCamino();
		establecerSiguiente();
		establecerHipotenusaAPasarela();
	}

	public void establecerMapa(Casillero[][] unMapa){
		this.mapa = unMapa;
	}

	public Boolean establecerEnemigos(List<Enemigo> lista){

		this.pasarelaInicial.establecerEnemigos(lista);
		return true;
	}

	public Boolean ocupado(int y,int x){

		return !mapa[y][x].vacio();
	}

	public void establecerCamino() {

		Boolean primeraPasarela = false;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if (mapa[i][j].esPasarela()){
					if (i < mapa.length - 1 && mapa[i + 1][j].esPasarela()) {
						mapa[i][j].establecerSiguiente(mapa[i + 1][j]);
						pasarelaFinal = mapa[i + 1][j];
					}
					if (j < mapa[i].length - 1 && mapa[i][j + 1].esPasarela()) {
						mapa[i][j].establecerSiguiente(mapa[i][j + 1]);
						pasarelaFinal = mapa[i][j + 1];
					}
					if (!primeraPasarela){
						primeraPasarela = true;
						pasarelaInicial = mapa[i][j];
					}
				}
			}
		}
	}

	public void establecerSiguiente(){

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++){

				if(i < mapa.length - 1){
					mapa[i][j].establecerAbajo(mapa[i+1][j]);
					
				}

				if(j < mapa[i].length - 1){
					mapa[i][j].establecerDerecha(mapa[i][j+1]);
				}


			}
		}

	} 

	public void establecerHipotenusaAPasarela(){


		for(int i = 0; i < mapa.length; i++){
			for(int j = 0; j< mapa[i].length;j++){

				if( i < mapa.length - 1 && j < mapa[i].length -1 && i >0 && j>0){
				mapa[i][j].establecerHipotenusa(calcularDistanciaAMeta(mapa[i-1][j], mapa[i+1][j], mapa[i][j+1], mapa[i+1][j+1],mapa[i-1][j-1]));
				}
			}
			
			
		}	

	}
	public Casillero calcularDistanciaAMeta(Casillero casilleroArriba,Casillero casilleroAbajo,Casillero casilleroDerecha,Casillero casilleroDiagonal,Casillero CasilleroDiagonalArriba){

		Casillero seleccionado = null; 

		double distanciaArriba = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - casilleroArriba.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - casilleroArriba.obtenerX(), 2));

		double distanciaAbajo = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - casilleroAbajo.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - casilleroAbajo.obtenerX(), 2));

		double distanciaDerecha = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - casilleroDerecha.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - casilleroDerecha.obtenerX(), 2));

		double distanciaDiagonal = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - casilleroDiagonal.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - casilleroDiagonal.obtenerX(), 2));

		double distanciaDiagonalArriba = Math.sqrt(Math.pow(pasarelaFinal.obtenerY() - CasilleroDiagonalArriba.obtenerY(), 2) + Math.pow(pasarelaFinal.obtenerX() - CasilleroDiagonalArriba.obtenerX(), 2));



		if(distanciaAbajo <= distanciaArriba && distanciaAbajo <= distanciaDerecha && distanciaAbajo <= distanciaDiagonal && distanciaAbajo <= distanciaDiagonalArriba){
			
			seleccionado = casilleroAbajo;

		}else if(distanciaDerecha <= distanciaArriba && distanciaDerecha <= distanciaAbajo && distanciaDerecha <= distanciaDiagonal && distanciaDerecha <= distanciaDiagonalArriba){
			
			seleccionado = casilleroDerecha;

		}else if(distanciaDiagonalArriba <= distanciaArriba && distanciaDiagonalArriba <= distanciaAbajo && distanciaDiagonalArriba<=distanciaDiagonal && distanciaDiagonalArriba <= distanciaDerecha ){
		
			seleccionado = CasilleroDiagonalArriba;

		}else if(distanciaArriba <= distanciaDiagonalArriba && distanciaArriba <= distanciaAbajo && distanciaArriba<= distanciaDerecha && distanciaArriba <= distanciaDiagonal ){

			seleccionado = casilleroArriba;

		}else if(distanciaDiagonal <= distanciaDiagonalArriba && distanciaDiagonal <= distanciaArriba && distanciaDiagonal<= distanciaDerecha && distanciaDiagonal <= distanciaAbajo ){

			seleccionado = casilleroDiagonal;

		}

		return seleccionado;


	}


	public Boolean hayEnemigos() {
		Casillero pasarela = pasarelaInicial;
		Boolean vacio = true;

		do {
			vacio = pasarela.vacio();
			pasarela = pasarela.obtenerSiguiente();
		} while (pasarela != null && vacio);

		return !vacio;
	}

	public void construir(int posX, int posY, Torre unaTorre) {
		mapa[posX][posY].establecerDefensa(unaTorre);
		torres.add(mapa[posX][posY]);
	}

	public void pasarTurno(Jugador jugador) {

		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {

				this.AtacarEnemigos(mapa[i][j],jugador);

			}
		}

		for(int i = mapa.length-1; i > -1 ; i--){
			for(int j = mapa[i].length-1; j>-1 ; j-- ){

				this.moverEnemigos(mapa[i][j], jugador);
			}
		}

		this.atacarJugador(jugador);
		
	}

		
		public void AtacarEnemigos(Casillero casillero,Jugador jugador){
			
			if(casillero.esTierra() && casillero.defensa() != null){
				for (int i = 0; i < mapa.length; i++) {
					for (int j = 0; j < mapa[i].length; j++) {
						jugador.cobrarCredito(casillero.Atacar(mapa[i][j]));
						
					}
				}
				casillero.defensa().turno();
			}
		}

		public void moverEnemigos(Casillero casillero,Jugador jugador){

		
			casillero.pasarTurno(jugador);
			

			

		}


	public void atacarJugador(Jugador jugador){
		pasarelaFinal.daniarJugador(jugador);
		pasarelaFinal.AtacarTorres(jugador,torres);
	}

}






		

	/*public void javafxCreador(Mapa mapa){


		for(int x = 0,x< mapa.length,x++){
			for(int y = 0; y< mapa.length,y++){

				if(mapa[x][y].equals(PASARELA)){
					layout.getChildren.add()
				}if(mapa[x][y].equals(TIERRA)){
					tierra
				}
				torres

				hayEnemigos


			}
		}

		[] [ ] [] [] [] [] []
		[] [] 

	} */

 			