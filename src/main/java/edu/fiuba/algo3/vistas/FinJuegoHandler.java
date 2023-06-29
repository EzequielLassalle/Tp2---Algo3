package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Juego;
import javafx.stage.Stage;

public class FinJuegoHandler {
    public FinJuegoHandler(Juego juego, Stage stage){
        if (juego.gano()) {
            VistaGameWon vista = new VistaGameWon(stage);
        } else if(juego.perdio()){
            VistaGameOver vista = new VistaGameOver(stage);
        }
    }
}
