package edu.fiuba.algo3.modelo;

public class TorrePlateada {
    
    Boolean operativa;
    Boolean enConstruccion;
    int tiempoDeConstruccion = 2;
    int tiempoConstruyendose;


    public TorrePlateada(){

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


    }
