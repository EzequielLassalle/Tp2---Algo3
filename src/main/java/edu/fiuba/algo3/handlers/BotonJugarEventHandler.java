package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.vistas.PantallaJuego;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

    private String u;
    private Label error;
    private Scene juego;

    Stage stage;

    public BotonJugarEventHandler(String usuario, Label e, Stage stage, Scene juego){
        this.u = usuario.trim();
        this.error = e;
        this.juego = juego;
        this.stage = stage;

    }

    @Override
    public void handle(ActionEvent actionEvent){
        stage.setScene(juego);
    }
}
