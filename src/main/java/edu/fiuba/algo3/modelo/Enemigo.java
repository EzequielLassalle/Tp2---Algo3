package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    
    int vida;
    int danio;
    int energia;
    int credito;

    public void AtacadoPorTorreBlanca(Jugador jugador){

        this.vida = this.vida - 1;

        if(this.vida <= 0){
            jugador.cobrarCredito(credito);
        }

    }

    public int Atacado(int unDanio){

        this.vida = this.vida - unDanio;

        if(this.vida <= 0 ){
            return this.credito;
        }

        return 0;

    }

    public void AtacadoPorTorrePlateada(Jugador jugador){

        this.vida = this.vida - 2;

        if(this.vida <= 0){
            jugador.cobrarCredito(credito);
        }

    }

    public Boolean vida(int unaVida){

        return(unaVida == this.vida);

    }


	public abstract Pasarela mover(Pasarela unaPasarela);

    
    
}
