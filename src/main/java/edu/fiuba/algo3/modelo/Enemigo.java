package edu.fiuba.algo3.modelo;

public class Enemigo {
    
    int vida;
    int danio;
    int energia;
    int credito;

    public void AtacadoPorTorreBlanca(){

        this.vida = this.vida - 1;

    }

    public void AtacadoPorTorrePlateada(){

        this.vida = this.vida - 2;

    }

    
    
}
