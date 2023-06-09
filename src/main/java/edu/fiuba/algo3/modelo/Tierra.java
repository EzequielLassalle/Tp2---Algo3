package edu.fiuba.algo3.modelo;
import java.util.List;

public class Tierra extends Casillero{
    Torre defensa = null;

    public Tierra(int nuevaX,int nuevaY){

        super(nuevaX, nuevaY);
        this.tipo = "Tierra";
        this.pasarelaSiguiente = null;

    }

	@Override
    public Boolean esTierra(){

        return true;

    }

    @Override
    public void eliminarDefensa(){
		defensa = null;
	}

    @Override
    public void establecerDefensa(Torre unaTorre){

        if(!unaTorre.equals(new TrampaArenosa())){

            this.defensa = unaTorre;
            unaTorre.setCoordenadas(this.x,this.y);
        }

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
    public Torre defensa(){
        return this.defensa;
    }

    @Override
    public int obtenerX(){

        return this.x;
    }

	@Override
    public int obtenerY(){

        return this.y;
    }



    @Override
    public Boolean vacio(){
        return (this.enemigos.isEmpty() && this.defensa == null);
    }

    @Override
    public Boolean hayDefensa(){

        if(this.defensa == null){
            return false;
        }

        return true;

    }


    
}
