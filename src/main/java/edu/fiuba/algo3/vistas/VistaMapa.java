package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VistaMapa extends Pane {



    private static class Casillero extends StackPane {

        private Rectangle bg;
        private Integer[] coordinates;
        Casillero(int x, int y, Color c){

            coordinates = new Integer[] { x, y };

            setTranslateX(x * CELL_SIZE);
            setTranslateY(y * CELL_SIZE);
            bg = new Rectangle(CELL_SIZE, CELL_SIZE, c);
            bg.setStroke(Color.WHITE);
            getChildren().add(bg);
        }

        public void setImg (VistaUnidad u){
            ImagePattern img = new ImagePattern(u.image);
            bg.setFill(img);
        }

        public void setNull(){
            bg.setFill(null);
        }

        public Rectangle bg(){
            return bg;
        }

        public void setUserData() {
            setUserData(coordinates);
}
    }

    private static final int CELL_SIZE = 40;
    private static final int GRID_SIZE_IN_CELLS = 15;

    private List listaCasilleros;

    private final Juego juego;
    private static Mapa mapa;

    private int turno;

    private Pane layout;
    private Pane layoutEnemigosYDefensas;
    public VistaMapa(Juego juego){
        this.juego = juego;
        this.mapa = juego.mapa();
    }

    public Pane crearMapa() {
        listaCasilleros = new ArrayList();
        var layout = new Pane();
        layout.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);
        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                Casillero cell = new Casillero(x, y, Color.YELLOW);
                if(mapa.posicion(y, x).equals(new Pasarela(x, y))){
                    if(!mapa.ocupado(y, x)){
                        cell = new Casillero(x, y, Color.GREEN);
                    }
                }else if(mapa.posicion(y, x).equals(new Tierra(x, y)) ){
                    if(!mapa.ocupado(y, x)){
                        cell = new Casillero(x, y, Color.BROWN);

                    }
                }
                else if(mapa.posicion(y, x).equals(new Rocosa(x, y)) ){
                    if(!mapa.ocupado(y, x)){
                        cell = new Casillero(x, y, Color.GRAY);
                    }
                }

                final int currentRow = x;
                final int currentCol = y;

                Integer[] coordinates = { x, y };
                cell.setUserData(coordinates);


                final Casillero finalCasillero = cell;

            finalCasillero.setOnMouseClicked(event -> {
                if (finalCasillero.getUserData() != null) {
                Integer[] clickedCoordinates = (Integer[]) finalCasillero.getUserData();
                int clickedRow = clickedCoordinates[0];
                int clickedCol = clickedCoordinates[1];

        // Ask the user for their choice of method
                showMethodSelectionDialog(clickedRow, clickedCol);
            }
        });

        
 



                layout.getChildren().add(cell);
                listaCasilleros.add(cell);
            }
        }
        this.layout = layout;
        return layout;
    }

    private void showMethodSelectionDialog(int x, int y) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Construir torre");
        alert.setContentText("Elegir Torre:");

        ButtonType buttonTypeA = new ButtonType("Plateada");
        ButtonType buttonTypeB = new ButtonType("Blanca");
        ButtonType buttonTypeC = new ButtonType("Arenosa");

        alert.getButtonTypes().setAll(buttonTypeA, buttonTypeB, buttonTypeC);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == buttonTypeA) {
                // Call method A
                ConstruirTorrePlateada(x, y);
            } else if (result.get() == buttonTypeB) {
                // Call method B
                ConstruirTorreBlanca(x, y);
            } else if (result.get() == buttonTypeC) {
                // Call method C
                ConstruirTrampaArenosa(x, y);
            }
        }
    }

    public void ConstruirTorrePlateada(int x, int y){

        mapa.construir(y, x, new TorrePlateada(),this.juego.jugador());
        this.update();
    }

    
    public void ConstruirTorreBlanca(int x, int y){

        mapa.construir(y, x, new TorreBlanca(),this.juego.jugador());
        this.update();
    }

    public void ConstruirTrampaArenosa(int x, int y){

        mapa.construir(y, x, new TrampaArenosa(),this.juego.jugador());
        this.update();
    }








    public void pasarTurno() throws IOException, FormatoJSONInvalido {
        
        ///Pedirle a jugador que construya torres y construirlas


        this.juego.jugar();
        this.juego.establecerEnemigos();
        this.update();
        

    }

    public Pane update(){
        var layout = new Pane();
        layout.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);

        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                    Casillero cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                    cell.setNull();

                if(mapa.posicion(y, x).equals(new Pasarela(x, y))){
                        cell.bg.setFill(Color.GREEN);
                }else if(mapa.posicion(y, x).equals(new Tierra(x, y)) ){
                        cell.bg.setFill(Color.BROWN);
                }
                else if(mapa.posicion(y, x).equals(new Rocosa(x, y)) ){
                        cell.bg.setFill(Color.GRAY);
                }                   
                    

                if(mapa.posicion(y, x).hayEnemigos()){
                    if(mapa.posicion(y, x).enemigo().equals(new Hormiga())){
                        VistaUnidad enemigo = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/hormiga.png");
                        cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                        cell.setImg(enemigo);

                    }else if(mapa.posicion(y, x).enemigo().equals(new Arania())){
                        VistaUnidad enemigo = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/Arania.png");
                        cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                        cell.setImg(enemigo);

                    }else if(mapa.posicion(y, x).enemigo().equals(new Topo())){
                        VistaUnidad enemigo = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/topo.png");
                        cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                        cell.setImg(enemigo);

                    }else if(mapa.posicion(y, x).enemigo().equals(new Lechuza())){
                        VistaUnidad enemigo = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/lechuza.png");
                        cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                        cell.setImg(enemigo);

                    }
                } else if(mapa.posicion(y, x).equals(new Tierra(x,y)) && mapa.posicion(y, x).hayDefensa()){

                        if(mapa.posicion(y,x).defensa().equals(new TorreBlanca(x,y))) {
                            VistaUnidad torre = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/torreblanca.png");
                            cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                            cell.setImg(torre);

                        }else if(mapa.posicion(y,x).defensa().equals(new TorrePlateada(x,y))){
                            VistaUnidad torre = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/torreplateada.jpg");
                           cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                            cell.setImg(torre);
                        }

                } else if(mapa.posicion(y, x).equals(new Pasarela(x,y)) && mapa.posicion(y, x).defensa() != null){
                            if(mapa.posicion(y, x).defensa().equals(new TrampaArenosa()) && mapa.posicion(y, x).defensa().operativa()){
                                VistaUnidad trampa = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/trampaarenosa.jpg");
                                cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                                cell.setImg(trampa);
                            }
                    }
                }
            }
            return layout;
        }

}
    
 
