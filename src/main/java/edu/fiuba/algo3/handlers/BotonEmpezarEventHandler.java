package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.io.IOException;

public class BotonEmpezarEventHandler implements EventHandler<ActionEvent> {

    private VistaMapa mapa;
    private Button boton;


    public BotonEmpezarEventHandler(Button boton, VistaMapa mapa){
        this.mapa = mapa;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        boton.setText("PASAR TURNO");
        try {
            this.mapa.pasarTurno();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FormatoJSONInvalido e) {
            throw new RuntimeException(e);
        }
    }
}
