package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.handlers.BotonJugarEventHandler;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PantallaInicial {

    public void mostrar() {
        Stage stage = new Stage();
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

}
