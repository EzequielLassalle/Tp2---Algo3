package edu.fiuba.algo3.modelo;

public class TrampaArenosa extends Torre {

	static Credito costo = new Credito(25);
    int turno;

     public TrampaArenosa(){

        this.operativa = true;
        this.enConstruccion = false;
        this.turno = 0;

    }
    

    public Credito Atacar(Casillero unPasarela){

        return new Credito(0);
    }

    public TrampaArenosa(int unX, int unY){

        this.operativa = true;
        this.enConstruccion = false;
        this.x = unX;
        this.y = unY;
        this.turno = 1;
        
    }

	public static Credito costo() {
		return costo;
	}

    public void vidaUtil(){
        if(this.turno > 3){
            this.operativa = false;
        }
    }

    @Override
    public void sumarTurno(){

        this.turno++;
        this.vidaUtil();
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





}
