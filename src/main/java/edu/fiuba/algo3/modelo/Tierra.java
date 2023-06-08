package edu.fiuba.algo3.modelo;

public class Tierra extends Casillero{
    Torre defensa = null;

    public Tierra(int nuevax,int nuevay){
        this.tipo = "Tierra";
        this.x = nuevax;
        this.y = nuevay;
    }



    public Boolean esTierra(){

        return true;
    }

    
    public void establecerDefensa(Torre unaTorre){

        this.defensa = unaTorre;
        unaTorre.setCoordenadas(this.x,this.y);
    }

    ///////// metodo de prueba ////////////
    public Boolean atacar(Pasarela unaPasarela, Jugador jugador){
        return defensa.atacar(unaPasarela,this.x,this.y, jugador);
    }  

    ////Metodo de ataque real/////////
    
    public int Atacar(Pasarela unaPasarela){
        return defensa.Atacar(unaPasarela);
    }
    
    
    public void pasarTurno(Casillero casillero) {
        if(defensa != null){
        defensa.Atacar(casillero);
        }

        
	}
    
}
