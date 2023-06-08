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

    
    public void establecerDefensa(Torre unaTorre){

        this.defensa = unaTorre;
        unaTorre.setCoordenadas(this.x,this.y);

    }

    ////Metodo de ataque real/////////
    
    public Credito Atacar(Pasarela unaPasarela){

        return defensa.Atacar(unaPasarela);
		
    }
    
    @Override
    public void pasarTurno(List<Pasarela> camino) {
        if(defensa != null){
			for (Pasarela pasarela : camino) {
				defensa.Atacar(pasarela);
			}
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
