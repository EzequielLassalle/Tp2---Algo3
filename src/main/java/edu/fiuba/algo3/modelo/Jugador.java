package edu.fiuba.algo3.modelo;


public class Jugador {

    int credito;
    int vida;

    public Jugador(int nuevoCredito,int nuevaVida){

        this.credito = nuevoCredito;
        this.vida = nuevaVida;

    }

    public Boolean creditoIgual(int unCredito){

        return this.credito == unCredito;

    }

    public Boolean vidaIgual(int unaVida){

        return (this.vida == unaVida);

    }

    public TorreBlanca construirTorreBlanca(int creditoTorreBlanca, Casillero unCasillero){
        
        if(this.credito > creditoTorreBlanca && unCasillero.esTierra()){
            
            this.credito = this.credito - creditoTorreBlanca;
            TorreBlanca torreNueva = new TorreBlanca();
            unCasillero.establecerDefensa(torreNueva);
            return (torreNueva);
            
        }

        return null;
    }


    public TorrePlateada construirTorrePlateada(int creditoTorrePlateada, Casillero unCasillero){

        if(this.credito > creditoTorrePlateada && unCasillero.esTierra()){
            
            this.credito = this.credito - creditoTorrePlateada;
            TorrePlateada torreNueva = new TorrePlateada();
            unCasillero.establecerDefensa(torreNueva);
            return (torreNueva);

        }

    
        return null;

    }


    public boolean creditosIgualA(int creditos) {
        return this.credito == creditos;
    }

    public void cobrar(int credito) {
        this.credito += credito;
    }
}
