package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PantallaJuego extends VBox{

    private final double INFO_HEIGHT = 130;

  public PantallaJuego(VistaMapa mapa, Juego juego){
 
        var layout = new HBox();
 
        Border borde = new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
 
 
        var boxConstruciones = new StackPane();
        boxConstruciones.setPrefSize(200, INFO_HEIGHT);
        boxConstruciones.setBorder(borde);
        boxConstruciones.setAlignment(Pos.CENTER);
 
        var boxInfo = new StackPane();
        boxInfo.setPrefSize(400, INFO_HEIGHT);
        boxInfo.setBorder(borde);
        boxInfo.setAlignment(Pos.CENTER);
 
        var boxJugador = new StackPane();
        boxJugador.setPrefSize(150, INFO_HEIGHT);
        boxJugador.setBorder(borde);
        boxJugador.setAlignment(Pos.CENTER);
 
        var infoJugador = new VBox();
        infoJugador.setSpacing(10);
        var botonEmpezar = new Button();
        infoJugador.setAlignment(Pos.CENTER);




        HBox vidaD = new HBox();
        HBox creditoD = new HBox();

        Rectangle vidaR = new Rectangle(15, 15, Color.WHITE);
        Rectangle creditoR = new Rectangle(15, 15, Color.WHITE);
    
        vidaR.setFill(new ImagePattern(new Image("file:src/main/java/edu/fiuba/algo3/vistas/images/vida.png")));
        creditoR.setFill(new ImagePattern(new Image("file:src/main/java/edu/fiuba/algo3/vistas/images/credito.png")));

        Label vidaLabel = new Label(": ");
        Label creditosLabel = new Label(": ");

        vidaD.getChildren().addAll(vidaR,vidaLabel);
        creditoD.getChildren().addAll(creditoR,creditosLabel);


        botonEmpezar.setText("EMPEZAR");
        VidaYCreditosHandler vidaYCreditosHandler = new VidaYCreditosHandler(vidaLabel, creditosLabel);
        BotonEmpezarEventHandler botonEmpezarEventHandler = new BotonEmpezarEventHandler(botonEmpezar, mapa,juego,vidaYCreditosHandler);
        botonEmpezar.setOnAction(botonEmpezarEventHandler);
        infoJugador.getChildren().addAll(vidaD,creditoD, botonEmpezar);
        infoJugador.setAlignment(Pos.CENTER);
 
        this.getChildren().add(mapa.crearMapa());
        boxJugador.getChildren().add(infoJugador);
        layout.getChildren().addAll(boxConstruciones, boxInfo, boxJugador);
        this.getChildren().add(layout);
 
    }

    public void jugar(){

    }
}
