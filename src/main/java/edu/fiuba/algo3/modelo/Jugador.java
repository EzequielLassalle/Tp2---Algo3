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

    public void jugar(Mapa mapa){

        System.out.println("ELEGI LAS SIGUIENTES OPCIONES:");
        System.out.println("1. Construir");;
        System.out.println("2. Pasar de turno");
        System.out.println("3. Rendirse");


        Scanner myObj = new Scanner(System.in);

        int eleccion =  myObj.nextInt();

        if(eleccion == 1){

            System.out.println("Elegi las coordenadas");

                int y = myObj.nextInt();

                int x = myObj.nextInt();


            System.out.println("Elegi que tipo de torre");
            System.out.println("1. Plateada");
            System.out.println("2. Blanca");

            int Torre =  myObj.nextInt();

            if(Torre == 1){

                mapa.construir(x, y, new TorrePlateada());

            } else if(Torre == 2){

                mapa.construir(x, y,new TorreBlanca());
            }

        }





        myObj.close();
    }
    

    public Boolean gano(Mapa mapa){

        return (!mapa.hayEnemigos());
    }


    

}
