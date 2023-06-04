package edu.fiuba.algo3.modelo;

public class Torre {
    
    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion;
    int tiempoConstruyendose;
    Rango rango = new Rango();
	int creditos;
    int x;
    int y;
    

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


    public int Atacar(Casillero unPasarela){
        return 0;
    }

    public void setCoordenadas(int unX,int unY){
        this.x = unX;
        this.y = unY;

    }



}
