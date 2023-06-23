package edu.fiuba.algo3;
 
import edu.fiuba.algo3.modelo.*;
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
 
/**
 * JavaFX App
 */
public class App extends Application{
    
    private static class Casillero extends StackPane{
 
        private Rectangle bg;
        Casillero(int x, int y, Color c){
            setTranslateX(x * CELL_SIZE);
            setTranslateY(y * CELL_SIZE);
            bg = new Rectangle(CELL_SIZE, CELL_SIZE, c);
            bg.setStroke(Color.WHITE);
            getChildren().add(bg);
        }
    }


 
    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE_IN_CELLS = 15;
 
    private static Mapa mapa;
 
    public static void jugar() {


        /*jugarReal
         
        int turno = 1;

        do{

            List<Enemigo> lista = juego.enemyParser.parsear(turno);
            
            Juego.mapa.establecerEnemigos(lista);

            Botom handlers Pidiendo a jugador que construya y construyendo()

            Juego.mapa.pasarTurno(this.jugador);

            turno++;

            MostrarMapa

        } while(Juego.gano() || Juego.perdio());





         */

         ////MostrarMapa

        var layout = new Pane();
        layout.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);
        var scene = new Scene(layout);
        var stage = new Stage();
        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                Casillero cell = new Casillero(x, y, Color.YELLOW);
                if(mapa.posicion(y, x).equals(new Pasarela(x, y)) ){
                    if(!mapa.ocupado(y, x)){
                        cell = new Casillero(x, y, Color.GREEN);
                    }else{

                     /* 
                        if(mapa.posicion(y,x).enemigo().equals(New Hormiga())){
                            cell = new VistaEnemigo(x,y,imagenHormiga);
                        }
                        else if(mapa.posicion(y,x).enemigo().equals(New Arania())){
                            cell = new VistaEnemigo(x,y,imagenArania);

                        }else if(mapa.posicion(y,x).enemigo().equals(New Topo()))
                            cell = new VistaEnemigo(x,y,imagenArania);

                        else {
                           cell = new VistaEnemigo(x,y,imagenLechuza); 
                        }

                    */

                    }
                }else if(mapa.posicion(y, x).equals(new Tierra(x, y)) ){

                    if(!mapa.ocupado(y, x)){
                        cell = new Casillero(x, y, Color.BROWN);

                    }else{

                       /* 

                        if(mapa.ocupado(y, x).enemigo().equals(New Lechuza()){
                            cell = new VistaEnemigo(x,y,imagenLechuza);

                       } else if(mapa.ocupado(y,x).defensa().equals(New TorreBlanca()){
                            cell = new VistaTorre(x,y,imagenTorreBlanca);

                       }else if(mapa.ocupado(y,x).defensa().equals(New TorrePlateada()){
                            cell = new VistaTorre(x,y,imagenTorrePlateada)
                       }

                       */
                    }
                }
                else if(mapa.posicion(y, x).equals(new Rocosa(x, y)) ){
                    if(!mapa.ocupado(y, x)){
                        cell = new Casillero(x, y, Color.GRAY);
                    }else{

                       /* 
                        if(mapa.ocupado(y,x).enemigo().equals(New Lechuza()){
                                cell = new Lechuza(x,y imagenLechuza);
                       }

                        */

                    }
                }

                


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
        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(usuario.getText(), error);
        jugarButton.setOnAction(botonJugarEventHandler);
 
        layout.getChildren().add(welcome);
        layout.getChildren().add(usuario);
        layout.getChildren().add(jugarButton);
        layout.getChildren().add(error);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args, Mapa map) {
        mapa = map;
        launch();
 
    }
 
 
}