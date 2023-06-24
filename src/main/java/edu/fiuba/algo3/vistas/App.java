package edu.fiuba.algo3.vistas;
 
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
 
import edu.fiuba.algo3.handlers.BotonJugarEventHandler;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application{
    private static Mapa mapa;
 
    @Override
    public void start(Stage stage) throws IOException, FormatoJSONInvalido {

        Juego juego =   new Juego(new JsonEnemyRepository("src/json/enemigos.json"),
                        new JsonMapRepository("src/json/mapa.json"));



        VistaMapa vistaMapa = new VistaMapa(juego);

        PantallaJuego pantallaJuego = new PantallaJuego(stage, vistaMapa);

        Scene escenaJuego = new Scene(pantallaJuego, 750, 1000);
 
        var layout = new VBox();
        layout.setAlignment(Pos.CENTER);
 
        var welcome = new Label("Grupo 11");
        var error = new Label("");
 
        var scene = new Scene(layout, 400, 600);
 
        var usuario = new TextField();
        usuario.setPromptText("Usuario");
        usuario.setMaxWidth(200);
 
        var jugarButton = new Button();
        jugarButton.setText("JUGAR");
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(usuario.getText(), error, stage, escenaJuego);
        jugarButton.setOnAction(botonJugarEventHandler);
 
        layout.getChildren().add(welcome);
        layout.getChildren().add(usuario);
        layout.getChildren().add(jugarButton);
        layout.getChildren().add(error);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch();
 
    }
 
 
}