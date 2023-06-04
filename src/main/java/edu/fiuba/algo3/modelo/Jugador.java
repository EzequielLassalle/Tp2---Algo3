package edu.fiuba.algo3.modelo;


public class Jugador {

    int credito;
    int vida;
    Credito unCredito;
    Vida unaVida;


    public Jugador(){

        this.unCredito = new Credito(100);
        this.unaVida = new Vida(20);


    }

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
        
        if(this.unCredito.obtenerCreditoTotal() > creditoTorreBlanca && unCasillero.esTierra()){
            
            this.unCredito.restar(creditoTorreBlanca);
            this.credito = this.credito - creditoTorreBlanca;
            TorreBlanca torreNueva = new TorreBlanca();
            unCasillero.establecerDefensa(torreNueva);
            return (torreNueva);
            
        }

        return null;
    }


    public TorrePlateada construirTorrePlateada(int creditoTorrePlateada, Casillero unCasillero){

        if(this.unCredito.obtenerCreditoTotal() > creditoTorrePlateada && unCasillero.esTierra()){
            
            this.unCredito.restar(creditoTorrePlateada);
            this.credito = this.credito - creditoTorrePlateada;
            TorrePlateada torreNueva = new TorrePlateada();
            unCasillero.establecerDefensa(torreNueva);
            return (torreNueva);

        }

    
        return null;

    }

	public Torre construir(String torreString) {
		Torre torreNueva = null;
		if (torreString == "Torre Blanca") {
			torreNueva = new TorreBlanca();
			torreNueva.pagar(this);
		}
		if (torreString == "Torre Plateada") {
			torreNueva = new TorrePlateada();
			torreNueva.pagar(this);
		}

		return torreNueva;
	}


    public boolean creditosIgualA(int creditos) {
        return this.credito == creditos;
    }

    public void cobrar(int credito) {
        this.credito += credito;
    }

	public void pagar(int costo) {
		this.credito -= costo;
	}


    public Boolean esIgual(Jugador unJugador){

        return (this.unaVida.igual(unJugador.vida()) && this.unCredito.igual(unJugador.credito()));

    }

    public Vida vida(){

        return this.unaVida;
    }

    public Credito credito(){

        return this.unCredito;

    }


}
