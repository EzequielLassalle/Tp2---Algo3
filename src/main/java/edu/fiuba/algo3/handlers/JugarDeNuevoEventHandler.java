package edu.fiuba.algo3.handlers;

import edu.fiuba.algo3.modelo.FormatoJSONInvalido;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.repositories.JsonEnemyRepository;
import edu.fiuba.algo3.repositories.JsonMapRepository;
import edu.fiuba.algo3.vistas.App;
import edu.fiuba.algo3.vistas.PantallaJuego;
import edu.fiuba.algo3.vistas.VistaMapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JugarDeNuevoEventHandler implements EventHandler<ActionEvent>{

    private Stage buttonStage;
    private Stage gameStage;
    public JugarDeNuevoEventHandler(Stage oldStage, Stage stage){
        this.buttonStage = stage;
        this.gameStage = oldStage;
    }

    @Override
    public void handle(ActionEvent event) {
        buttonStage.close();
        gameStage.close();
        Scene escenaJuego = null;
        try {
            escenaJuego = App.initialize(new Stage());
        } catch (IOException | FormatoJSONInvalido e) {
            throw new RuntimeException(e);
        }
        Stage newStage = new Stage();
        newStage.setScene(escenaJuego);
        newStage.show();

    }
}

