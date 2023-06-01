package edu.fiuba.algo3.modelo;

public class TorrePlateada extends Torre {
    
    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion = 2;
    int tiempoConstruyendose;
    


    public TorrePlateada(){

        this.operativa = false;
        this.enConstruccion = true;
        this.tiempoConstruyendose = 0;
		this.creditos = 20;

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

}


