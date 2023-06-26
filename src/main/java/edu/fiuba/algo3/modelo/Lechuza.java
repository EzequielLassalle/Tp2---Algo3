package edu.fiuba.algo3.modelo;

public class Lechuza extends Enemigo {
    int turno;

    

    public Lechuza(){
        this.credito = new Credito(5);
        this.vida = 5;
		this.danio = 0;
        this.turno = 1;

    }

    @Override
    public boolean equals(Object o){
        return o.getClass().equals(this.getClass());
    }

    

	public Casillero mover(Casillero unaPasarela) {
		

        if(vida > 3){
           if(turno == 4){

               unaPasarela =unaPasarela.obtenerAbajo().obtenerDerecha().obtenerDerecha().obtenerDerecha().obtenerDerecha();
           
            }else if(turno >4){
                unaPasarela = unaPasarela.obtenerDerecha().obtenerDerecha().obtenerDerecha().obtenerDerecha().obtenerDerecha();
            
            }else{
            unaPasarela = unaPasarela.obtenerAbajo().obtenerAbajo().obtenerAbajo().obtenerDerecha().obtenerDerecha();
           
        }
           

        }else{


            unaPasarela = unaPasarela.obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa().obtenerSiguienteHipotenusa();

        }
        
        this.turno = this.turno +1;
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
