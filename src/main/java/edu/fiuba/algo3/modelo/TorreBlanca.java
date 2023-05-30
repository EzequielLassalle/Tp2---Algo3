package edu.fiuba.algo3.modelo;

public class TorreBlanca extends Torre {

    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion = 1;
    int tiempoConstruyendose;
    
   
    


    public TorreBlanca(){

        this.operativa = false;
        this.enConstruccion = true;
        this.tiempoConstruyendose = 0;

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

public Boolean atacar(Pasarela unaPasarela,int y,int x){
    
    if(rango.CalcularRangoBlanca(unaPasarela,y,x)){
     unaPasarela.AtacadoPorTorreBlanca();
     return true;
    }
    return false;
}
    





    
}
