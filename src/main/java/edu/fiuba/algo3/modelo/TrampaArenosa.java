package edu.fiuba.algo3.modelo;

public class TrampaArenosa extends Torre {

	public Credito costo = new Credito(25);
    int turno;

     public TrampaArenosa(){

        this.operativa = true;
        this.enConstruccion = false;
        this.turno = 1;

    }

    @Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass());
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

	public  Credito costo() {
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

    @Override
    public boolean operativa(){

		return this.operativa;
		
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
