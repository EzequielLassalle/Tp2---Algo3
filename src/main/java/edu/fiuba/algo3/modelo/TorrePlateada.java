package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre {

	static Credito costo = new Credito(20);

     public TorrePlateada(){

        this.operativa = false;
        this.enConstruccion = true;
		this.tiempoDeConstruccion = 2;
        this.tiempoConstruyendose = 0;
		this.rango = new RangoTorrePlateada();
        this.danio = 2;

    } 

    public TorrePlateada(int unX, int unY){

        this.operativa = false;
        this.enConstruccion = true;
		this.tiempoDeConstruccion = 2;
        this.tiempoConstruyendose = 0;
		this.rango = new RangoTorrePlateada();
        this.x = unX;
        this.y = unY;
        this.danio = 2;

    }

	public static Credito costo() {
		return costo;
	}
    
    /* public void turno(){

        if (enConstruccion){

            this.tiempoConstruyendose++;

        }
    
        estado();

    }

    public void estado(){

        if(tiempoConstruyendose == tiempoDeConstruccion){

            this.enConstruccion = false;
            this.operativa = true;
            //this.tiempoConstruyendose = 0;

        }
        
    }

    public boolean operativa(){

        return this.operativa;
		
    } */

    @Override
    public Credito Atacar(Casillero unaPasarela){

        Credito credito = new Credito(0);

        if(rango.calcularRango(unaPasarela, this.x, this.y) && operativa() == true ){

            credito = unaPasarela.Atacado(this.danio);

            System.out.println("Torre Plateada ataco enemigos en Pasarela:" + unaPasarela.obtenerX() + " " + unaPasarela.obtenerY());

        } else if(operativa() == false){

			this.turno();

		}

        return credito;

    }

}


