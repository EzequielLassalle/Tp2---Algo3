package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;

public class BotonEmpezarEventHandler implements EventHandler<ActionEvent> {

    private VistaMapa mapa;
    private Button boton;
    private Juego juego;
    VidaYCreditosHandler handler;


    public BotonEmpezarEventHandler(Button boton, VistaMapa mapa,Juego unJuego,VidaYCreditosHandler unHandler){
        this.mapa = mapa;
        this.boton = boton;
        this.juego = unJuego;
        this.handler = unHandler;
        boton.setMinSize(150, 150);
        boton.setMaxSize(150,150);
        this.setFondoBoton("file:src/main/java/edu/fiuba/algo3/vistas/images/start.png");


    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.setFondoBoton("file:src/main/java/edu/fiuba/algo3/vistas/images/forward.png");

        try {
            this.mapa.pasarTurno();
            handler.handle(juego.jugador.vida().obtenerVidaTotal(), juego.jugador.credito().obtenerCreditoTotal());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FormatoJSONInvalido e) {
            throw new RuntimeException(e);
        }
    }

    private void setFondoBoton (String path){
        boton.setMinSize(150, 150);
        boton.setMaxSize(150,150);
        Image i = new Image(path);
        BackgroundImage b = new BackgroundImage(i, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(boton.getWidth(), boton.getHeight(), true, true, true, false));
        Background bg = new Background(b);
        boton.setBackground(bg);
    }
}