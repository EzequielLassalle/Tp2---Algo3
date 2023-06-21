package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.App;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PantallaJuego {

    public void mostrar(){
        var layout = new Pane();
        layout.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);
        var scene = new Scene(layout);
        var stage = new Stage();

        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                App.Casillero cell = new App.Casillero(x, y);
                layout.getChildren().add(cell);
            }
        }
        stage.setScene(scene);
        stage.show();
    }
}
