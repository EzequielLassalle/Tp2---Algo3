package edu.fiuba.algo3.modelo;

public class Tierra extends Casillero{

    Torre defensa;

    public Tierra(int nuevay,int nuevax){

        this.x = nuevax;
        this.y = nuevay;
    }



    public Boolean esTierra(){

        return true;
    }


    public void establecerDefensa(Torre unaTorre){

        this.defensa = unaTorre;
    }

    public Boolean atacar(Pasarela unaPasarela, Jugador jugador){
        return defensa.atacar(unaPasarela,this.x,this.y, jugador);
    }

    
    
}
