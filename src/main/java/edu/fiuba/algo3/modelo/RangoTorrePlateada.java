package edu.fiuba.algo3.modelo;

public class RangoTorrePlateada extends Rango{

	public Boolean calcularRango(Casillero unaPasarela, int x, int y) {

		return(Math.sqrt(Math.pow(y - unaPasarela.obtenerY(), 2) + Math.pow(x - unaPasarela.obtenerX(), 2)) <= 5);

	}
	
}
