package edu.fiuba.algo3.modelo;
import java.util.Scanner;


public class Jugador {

    int unCredito;
    int vida;
    Credito credito;
    Vida unaVida;


    public Jugador(){

        this.credito = new Credito(100);
        this.unaVida = new Vida(20);


    }

    //// estos metodos no se usan solo son usados en 2 pruebas del principio pero no fueeron borrados
    ////        para mostrar un error que tiraba en 2 pruebas 
    ////        no se usan porque no son polimorficos

    public TorreBlanca construirTorreBlanca(Casillero unCasillero){

		Credito costo = TorreBlanca.costo();
        
        if(this.credito.mayorQue(costo) && unCasillero.esTierra()){
            
            this.credito.restar(costo);
            TorreBlanca torreNueva = new TorreBlanca(unCasillero.obtenerX(), unCasillero.obtenerY());
            unCasillero.establecerDefensa(torreNueva);
            return (torreNueva);
            
        }

        return null;
    }


    public TorrePlateada construirTorrePlateada(Casillero unCasillero){

		Credito costo = TorrePlateada.costo();

        if(this.credito.mayorQue(costo) && unCasillero.esTierra()){
            
            this.credito.restar(TorrePlateada.costo());
            TorrePlateada torreNueva = new TorrePlateada(unCasillero.obtenerX(), unCasillero.obtenerY());
            unCasillero.establecerDefensa(torreNueva);
            return (torreNueva);

        }

        return null;

    }

    public boolean creditosIgualA(int creditos) {
        return this.unCredito == creditos;
    }

    public void cobrarCredito(Credito credito) {
        this.credito.sumar(credito);
    }

	public void pagar(Credito costo) {
		this.credito.restar(costo);
	}


    public Boolean esIgual(Jugador unJugador){

        return (this.unaVida.igual(unJugador.vida()) && this.credito.igual(unJugador.credito()));

    }

    public Vida vida(){

        return this.unaVida;
    }

    public Credito credito(){

        return this.credito;

    }

    public void atacado(Vida danio_total){

        this.unaVida.restar(danio_total);
    }

    public void restarVida(Vida danio){
        this.unaVida.restar(danio);
    }

	public Boolean muerto() {
		return (this.unaVida.menorIgualQue(new Vida(0)));
	}




    ///////////sistema log////////////////////////



    

}
