package edu.fiuba.algo3.modelo;

public class Tierra extends Casillero{

    Torre defensa = null;

    public Tierra(int nuevax,int nuevay){

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

    public void pasarTurno(Casillero casillero, int posX, int posY, Jugador jugador) {
        if(defensa != null){
		defensa.atacar(casillero, posY, posX, jugador);
        }

        
	}
    
}
