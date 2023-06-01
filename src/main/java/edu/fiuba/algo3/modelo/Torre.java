package edu.fiuba.algo3.modelo;

public class Torre {
    
    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion;
    int tiempoConstruyendose;
    Rango rango = new Rango();
	int creditos;
    

    public Torre(){

    }

    public void turno(){

    
    }
    
    public void estado(){

    }


    public Boolean atacar(Casillero unaPasarela,int y,int x, Jugador jugador){

        return false;

    }


    public void pagar(Jugador unJugador) {
		unJugador.pagar(creditos);
	}



}
