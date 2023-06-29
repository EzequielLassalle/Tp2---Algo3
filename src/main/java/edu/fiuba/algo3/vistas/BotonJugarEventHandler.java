package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class BotonJugarEventHandler implements EventHandler<ActionEvent>{

    private TextField u;
    private Label error;

    private VistaMapa mapa;

    private Juego juego;

    private Scene escenaJuego;

    Stage stage;

    public BotonJugarEventHandler(TextField usuario, Label e, Stage stage, PantallaJuego pantallaJuego){
        this.u = usuario;
        this.error = e;
        this.stage = stage;
        escenaJuego = new Scene(pantallaJuego, 600, 750);


    }

    @Override
    public void handle(ActionEvent actionEvent){
        String ingreso = u.getText().trim();
        if(ingreso.length() < 6){
            error.setText("ERROR: Usuario invalido.");
        } else{
            stage.setScene(escenaJuego);
        }
    }
}