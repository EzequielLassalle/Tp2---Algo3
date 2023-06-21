package edu.fiuba.algo3;

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

import edu.fiuba.algo3.handlers.BotonJugarEventHandler;

/**
 * JavaFX App
 */
public class App extends Application{
    private static class Casillero extends StackPane{

        private Rectangle bg;
        Casillero(int x, int y){
            setTranslateX(x * CELL_SIZE);
            setTranslateY(y * CELL_SIZE);
            bg = new Rectangle(CELL_SIZE, CELL_SIZE, Color.GREEN);
            bg.setStroke(Color.WHITE);

            getChildren().add(bg);
        }
    }

    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE_IN_CELLS = 15;

    public static void jugar() {
        var layout = new Pane();
        layout.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);
        var scene = new Scene(layout);
        var stage = new Stage();

        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                Casillero cell = new Casillero(x, y);
                layout.getChildren().add(cell);
            }
        }
        stage.setScene(scene);
        stage.show();
    }

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
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(usuario.getText(), error, this);
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