package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    
    int vida;
    int danio;
    int energia;
    Credito credito;

    public void AtacadoPorTorreBlanca(Jugador jugador){

        this.vida = this.vida - 1;

        if(this.vida <= 0){
            jugador.cobrarCredito(credito);
        }

    }

    public Credito Atacado(int unDanio){

        this.vida -= unDanio;

        if(this.vida <= 0){
            return this.credito;

       
    }

        return new Credito(0);

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

    public Boolean soyLechuza(){
        return false;
    }


	public abstract Casillero mover(Casillero unaPasarela);

    public  abstract Casillero moverRelantizado(Casillero unaPasarela);

    public int danio(){

        return this.danio;
    }

    public Boolean muerto(){

        return (this.vida<=0);
    }


    public boolean esHormiga() {
        return false;
    }


    
    public Casillero volar(Casillero unCasillero){

        return unCasillero;
    }

    
    public Casillero volarRelantizado(Casillero unCasillero){


        return unCasillero;
    }

 
}
