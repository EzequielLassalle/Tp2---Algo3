package edu.fiuba.algo3.modelo;

public abstract class Enemigo {
    
    int vida;
    int danio;
    int energia;
    Credito credito;


    public Credito Atacado(int unDanio){

        this.vida = this.vida - unDanio;

        if(this.vida <= 0){
            return this.credito;

       
    }

        return new Credito(0);

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



    ///comentario ///
    public void Enemigoss(){
        int i = 1+1;
    }
    


 
}
