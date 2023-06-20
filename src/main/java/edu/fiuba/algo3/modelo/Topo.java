package edu.fiuba.algo3.modelo;

public class Topo extends Enemigo {
    int turno;
    int relantizado;

    public Topo(){
        this.credito = new Credito(2);
        this.vida = 2;
		this.danio = 2;
        this.turno = 0;
        this.relantizado = 0;


    }

	public Casillero mover(Casillero unaPasarela) {
		
        this.turno = this.turno + 1;
        
        if(this.turno <5){
            return unaPasarela.obtenerSiguiente();
        }else if(this.turno < 11){
			return unaPasarela = unaPasarela.obtenerSiguiente().obtenerSiguiente();

		}else{
			return unaPasarela.obtenerSiguiente().obtenerSiguiente().obtenerSiguiente(); 
        } 



	
    }

    public Casillero moverRelantizado(Casillero unaPasarela){

        this.turno = this.turno+1;

        if(this.turno <5){
          
		this.relantizado = this.relantizado + 1;

        if(this.relantizado%2 == 0){
		    return unaPasarela.obtenerSiguiente();
         
        } else{
            return unaPasarela;
         }

        }else if(this.turno < 11){
            
			return unaPasarela = unaPasarela.obtenerSiguiente();

		}else{

			return unaPasarela.obtenerSiguiente().obtenerSiguiente(); 
        }  





    }

    @Override
    public int danio(){

        if(this.turno% 2 == 0){
            this.danio = 2;
            return this.danio;
        }

        this.danio = 5;
        return danio;
    }

    @Override
    public Credito Atacado(int unDanio){

        return new Credito(0);

    }

}


    

