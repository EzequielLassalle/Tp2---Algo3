package edu.fiuba.algo3.modelo;

public class Lechuza extends Enemigo {
    

    public Lechuza(){
        this.credito = new Credito(5);
        this.vida = 5;
		this.danio = 0;

    }

	public Casillero mover(Casillero unaPasarela) {
		

        if(vida > 3){

            unaPasarela = unaPasarela.obtenerAbajo().obtenerAbajo().obtenerAbajo().obtenerDerecha().obtenerDerecha();
       
        }else{


            unaPasarela = unaPasarela.obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa();

        }
        

        return unaPasarela;

    }


    /////implementacion se queda asi por si en el futuro se quiere relantizar a la lechuza de alguna forma ////

    	public Casillero moverRelantizado(Casillero unaPasarela) {
		

        if(vida > 3){

            unaPasarela = unaPasarela.obtenerAbajo().obtenerAbajo().obtenerAbajo().obtenerDerecha().obtenerDerecha();
       
        }else{


            unaPasarela = unaPasarela.obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa();
        }
        

        return unaPasarela;

    }

    @Override
    public Boolean soyLechuza(){

        return true;
    }

	



    
}
