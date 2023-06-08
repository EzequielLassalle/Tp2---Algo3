package edu.fiuba.algo3.modelo;


public abstract class Rango {
	
	public abstract Boolean calcularRango(Casillero unaPasarela, int x, int y);

    /* public Boolean CalcularRangoBlanca(Casillero unaPasarela,int y,int x){

        
        if(Math.pow((Math.pow(y-unaPasarela.obtenery(),2) + Math.pow(x - unaPasarela.obtenerx(),2)),1/2) <= 3 ){
            return true;
        }

        return false;

    }

    public Boolean CalcularRangoPlateada(Casillero unaPasarela,int y,int x){

        if(Math.pow((Math.pow(y-unaPasarela.obtenery(),2) + Math.pow(x - unaPasarela.obtenerx(),2)),1/2) <= 3 ){
            return true;
        }

        return false;

    } */


}
