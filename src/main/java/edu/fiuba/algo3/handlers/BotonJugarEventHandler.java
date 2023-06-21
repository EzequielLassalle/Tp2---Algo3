package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.App;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;



public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

    private String u;
    private Label error;

    public BotonJugarEventHandler(String usuario, Label e, Application App){
        this.u = usuario.trim();
        this.error = e;

    }

    @Override
    public void handle(ActionEvent actionEvent){
       /* if(this.u.equals("grupo11")){
            App.jugar();
        } else {
            this.error.setText("Usuario invalido, reintente");
        }*/
        App.jugar();
    }
}
