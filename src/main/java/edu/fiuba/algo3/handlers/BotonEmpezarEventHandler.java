package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.handlers.*;

import java.io.IOException;

public class BotonEmpezarEventHandler implements EventHandler<ActionEvent> {

    private VistaMapa mapa;
    private Button boton;
    private Juego juego;
    VidaYCreditosHandler handler;


    public BotonEmpezarEventHandler(Button boton, VistaMapa mapa,Juego unJuego,VidaYCreditosHandler Unhandler){
        this.mapa = mapa;
        this.boton = boton;
        this.juego = unJuego;
        this.handler = Unhandler;


    }

    @Override
    public void handle(ActionEvent actionEvent){
        boton.setText("PASAR TURNO");
        try {
            this.mapa.pasarTurno();
            handler.handle(juego.jugador.vida().obtenerVidaTotal(), juego.jugador.credito().obtenerCreditoTotal());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FormatoJSONInvalido e) {
            throw new RuntimeException(e);
        }
    }
}
