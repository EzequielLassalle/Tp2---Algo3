package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.handlers.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PantallaJuego extends VBox{

    private final double INFO_HEIGHT = 130;

    public PantallaJuego(Stage stage, VistaMapa mapa){

        var layout = new HBox();

        Border borde = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));


        var boxConstruciones = new StackPane();
        boxConstruciones.setPrefSize(200, INFO_HEIGHT);
        boxConstruciones.setBorder(borde);
        var boxInfo = new StackPane();
        boxInfo.setPrefSize(400, INFO_HEIGHT);
        boxInfo.setBorder(borde);
        var boxJugador = new StackPane();
        boxJugador.setPrefSize(150, INFO_HEIGHT);
        boxJugador.setBorder(borde);
        this.getChildren().add(mapa.crearMapa());
        this.getChildren().add(layout);
        var infoJugador = new VBox();
        var botonEmpezar = new Button();
        botonEmpezar.setText("EMPEZAR");
        BotonEmpezarEventHandler botonEmpezarEventHandler = new BotonEmpezarEventHandler(botonEmpezar, mapa);
        botonEmpezar.setOnAction(botonEmpezarEventHandler);
        layout.getChildren().addAll(boxConstruciones, boxInfo, boxJugador);
        infoJugador.getChildren().add(botonEmpezar);
        boxJugador.getChildren().add(infoJugador);


    }

    public void jugar(){

    }
}
