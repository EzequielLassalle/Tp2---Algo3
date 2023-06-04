package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre {
    
    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion = 2;
    int tiempoConstruyendose;
    int x;
    int y;
    int danio;
    


    public TorrePlateada(){

        this.operativa = false;
        this.enConstruccion = true;
        this.tiempoConstruyendose = 0;
		this.creditos = 20;

    }

    public TorrePlateada(int unx,int uny){

        this.operativa = false;
        this.enConstruccion = true;
        this.tiempoConstruyendose = 0;
		this.creditos = 10;
        this.y = uny;
        this.x = unx;
        this.danio = 2;

    }

    
    public void turno(){
        if (enConstruccion == true){
            this.tiempoConstruyendose = this.tiempoConstruyendose+1;
        }
    
        estado();

    }


    public void estado(){
        if(tiempoConstruyendose == tiempoDeConstruccion){
            this.enConstruccion = false;
            this.operativa = true;
            this.tiempoConstruyendose = 0;
         return;
        }
        


        }

    public boolean operativa(){

            return this.operativa;
        }


    
    @Override
    public Boolean atacar(Casillero unaPasarela,int y,int x, Jugador jugador){

        if(rango.CalcularRangoPlateada(unaPasarela,y,x)){

			unaPasarela.AtacadoPorTorrePlateada(jugador);
			return true;

        }
        
        return false;

    }

    public int Atacar(Casillero unaPasarela){

        int credito = 0;

        if(rango.CalcularRangoPlateada(unaPasarela,this.y, this.x) ){
            credito = unaPasarela.Atacado(this.danio);

        }

        return credito;

    }

}


