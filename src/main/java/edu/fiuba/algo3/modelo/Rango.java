package edu.fiuba.algo3.modelo;


public class Rango {
    

    public Boolean CalcularRangoBlanca(Pasarela unaPasarela,int y,int x){

        
        if(Math.pow((Math.pow(y-unaPasarela.obtenery(),2) + Math.pow(x - unaPasarela.obtenerx(),2)),1/2) <= 3 ){
            return true;
        }

        return false;

    }

    public Boolean CalcularRangoPlateada(Pasarela unaPasarela,int y,int x){

        if(Math.pow((Math.pow(y-unaPasarela.obtenery(),2) + Math.pow(x - unaPasarela.obtenerx(),2)),1/2) <= 3 ){
            return true;
        }

        return false;



    }

    



}
