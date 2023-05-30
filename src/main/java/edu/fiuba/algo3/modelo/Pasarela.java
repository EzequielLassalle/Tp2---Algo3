package edu.fiuba.algo3.modelo;

public class Pasarela extends Casillero {

    Enemigo enemigo;

    public Pasarela(int nuevay,int nuevax){

        this.x = nuevax;
        this.y = nuevay;


    }

    
    public void establecerEnemigo(Enemigo unEnemigo){

        this.enemigo = unEnemigo;
    }

    public void AtacadoPorTorreBlanca(){

        enemigo.AtacadoPorTorreBlanca();
    }

    public void AtacadoPorTorrePlateada(){

        enemigo.AtacadoPorTorrePlateada();
    }

    /////////////////En estos dos metodos se viola el encapsulamiento -> refactorizar ////////////////////

    public int obtenerx(){

        return this.x;
    }

    public int obtenery(){

        return this.y;
    }

    
    
}
