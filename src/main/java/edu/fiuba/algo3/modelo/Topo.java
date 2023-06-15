package edu.fiuba.algo3.modelo;

public class Topo extends Enemigo {
    int turno;

    public Topo(){
        this.credito = new Credito(2);
        this.vida = 2;
		this.danio = 2;
        this.turno = 1;


    }

	public Pasarela mover(Pasarela unaPasarela) {
		
        if(this.turno <5){
            this.turno = this.turno + 1;
           return unaPasarela.obtenerSiguiente();

        }else if(this.turno < 11){
            this.turno = this.turno+1;
			return unaPasarela = unaPasarela.obtenerSiguiente().obtenerSiguiente();

		}else{
            this.turno = this.turno +1;
			return unaPasarela.obtenerSiguiente().obtenerSiguiente().obtenerSiguiente(); 
        } 


	
    }

}


    

