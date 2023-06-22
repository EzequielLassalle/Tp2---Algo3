package edu.fiuba.algo3.modelo;
import java.util.List;

public class Tierra extends Casillero{
    Torre defensa = null;

    public Tierra(int nuevaX,int nuevaY){

        super(nuevaX, nuevaY);
        this.tipo = "Tierra";

    }

	@Override
    public Boolean esTierra(){

        return true;

    }

    @Override
    public void eliminarDefensa(){
		defensa = null;
	}

    
    public void establecerDefensa(Torre unaTorre){

        this.defensa = unaTorre;
        unaTorre.setCoordenadas(this.x,this.y);

    }

    ////Metodo de ataque real/////////
    
    public Credito Atacar(Casillero unaPasarela){

            if(defensa != null){

             return defensa.Atacar(unaPasarela);
           
            }

            return new Credito(0);
        
		
    }
    
    
    public void pasarTurno(Casillero casillero) {
        if(defensa != null){

            defensa.Atacar(casillero);

        }
	}

    @Override
    public int obtenerX(){

        return this.x;
    }

	@Override
    public int obtenerY(){

        return this.y;
    }

    
}
