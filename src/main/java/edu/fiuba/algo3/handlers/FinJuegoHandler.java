package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vistas.VistaGameOver;
import edu.fiuba.algo3.vistas.VistaGameWon;

public class FinJuegoHandler {
    public FinJuegoHandler(Juego juego){
        if (juego.gano()) {
            VistaGameWon vista = new VistaGameWon();
        } else if(juego.perdio()){
            VistaGameOver vista = new VistaGameOver();
        }
    }
}
