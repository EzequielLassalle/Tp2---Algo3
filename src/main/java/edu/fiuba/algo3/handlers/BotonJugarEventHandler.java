package edu.fiuba.algo3.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;


public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

    private String u;
    private Label error;

    public BotonJugarEventHandler(String usuario, Label e){
        this.u = usuario.trim();
        this.error = e;

    }

    @Override
    public void handle(ActionEvent actionEvent){
        if(u.contains("!#$%&/()=")){
            this.error.setText("Usuario invalido, reintente");
        } else {
            this.error.setText("Podes jugar :D");
        }
    }
}
