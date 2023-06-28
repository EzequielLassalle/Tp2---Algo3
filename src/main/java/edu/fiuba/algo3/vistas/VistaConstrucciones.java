package edu.fiuba.algo3.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VistaConstrucciones {

    public VistaConstrucciones(Casillero casillero){
        Stage stage = new Stage();

        HBox all = new HBox();
        all.setPrefSize(360, 200);

        Scene scene = new Scene(all, 360, 200);

        VBox torreBlanca = new VBox();
        torreBlanca.setPrefSize(120, 200);
        //torreBlanca.setBorder();
        torreBlanca.setAlignment(Pos.CENTER);
        VBox torrePlateada = new VBox();
        torrePlateada.setPrefSize(120 ,200);
        torrePlateada.setAlignment(Pos.CENTER);
        VBox trampaArenosa = new VBox();
        trampaArenosa.setPrefSize(120, 200);
        trampaArenosa.setAlignment(Pos.CENTER);

        torreBlanca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event){
                casillero.establecerDefensa(new TorreBlanca());
                stage.close();
            }
        });

        Label torreBlancaInfo = new Label("CREDITOS VIDA");

        Rectangle bg = new Rectangle(100, 100, Color.RED);
        bg.setStroke(Color.BLACK);
        bg.setFill(new ImagePattern(new Image("file:src/main/java/edu/fiuba/algo3/vistas/images/Arania.png")));
        torreBlanca.getChildren().add(bg);
        torreBlanca.getChildren().add(torreBlancaInfo);

        all.getChildren().add(torreBlanca);

        stage.setScene(scene);
        stage.show();
    }
    
}