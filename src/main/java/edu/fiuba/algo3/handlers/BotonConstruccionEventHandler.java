package edu.fiuba.algo3.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.vistas.VistaConstrucciones;
import javafx.scene.input.MouseEvent;

public class BotonConstruccionEventHandler implements EventHandler<MouseEvent> {

    private Casillero casillero; 

    public BotonConstruccionEventHandler(Casillero c){
        casillero = c;
    }

    @Override
    public void handle(MouseEvent event){
        VistaConstrucciones vista = new VistaConstrucciones(casillero);
    }
}
