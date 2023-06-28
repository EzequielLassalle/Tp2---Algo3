package edu.fiuba.algo3.modelo;

public  class Torre {
    
    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion;
    int tiempoConstruyendose;
    Rango rango;
	static Credito costo;
    int x;
    int y;
    int danio;

    public void turno(){

		  if (operativa() == false){

			  this.tiempoConstruyendose++;

		  }

		estado();
    
    }
    
    public void estado(){

		  if(tiempoConstruyendose == tiempoDeConstruccion){

			  this.enConstruccion = false;
			  this.operativa = true;

			//this.tiempoConstruyendose = 0;

		  }

    }

    public Credito costo(){
        return this.costo;
    }

	public boolean operativa(){

		return this.operativa;
		
	}

    public void pagar(Jugador unJugador) {

		  unJugador.pagar(costo);

	}


    public Credito Atacar(Casillero unPasarela){
        return (new Credito(0));
    }

    public void setCoordenadas(int unX, int unY){

        this.x = unX;
        this.y = unY;

    }

    public void relantizar(){


    }

    public void sumarTurno(){
      
    }



}
