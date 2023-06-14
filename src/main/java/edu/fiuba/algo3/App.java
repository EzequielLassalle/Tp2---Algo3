package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import edu.fiuba.algo3.handlers.BotonJugarEventHandler;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

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
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(usuario.getText(), error);
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