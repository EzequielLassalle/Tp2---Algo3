package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Torre {

    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion = 1;
    int tiempoConstruyendose;
    int y;
    int x;
    int danio;
    
   
    


    public TorreBlanca(){

        this.operativa = false;
        this.enConstruccion = true;
        this.tiempoConstruyendose = 0;
		this.creditos = 10;

    }

    
    public TorreBlanca(int unx,int uny){

        this.operativa = false;
        this.enConstruccion = true;
        this.tiempoConstruyendose = 0;
		this.creditos = 10;
        this.y = uny;
        this.x = unx;
        this.danio = 1;

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
    
    if(rango.CalcularRangoBlanca(unaPasarela,y,x)){

    	unaPasarela.AtacadoPorTorreBlanca(jugador);
    	return true;

    }

    return false;

}



    public int atacar2(Casillero unaPasarela){

        int credito = 0;

        if(rango.CalcularRangoBlanca(unaPasarela,this.y, this.x) ){
            credito = unaPasarela.Atacado(this.danio);

        }

        return credito;

    }

}
    

    

