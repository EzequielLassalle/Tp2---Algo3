package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VistaMapa extends Pane {



    private static class Casillero extends StackPane {

        private Rectangle bg;
        Casillero(int x, int y, Color c){

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
    }

    private static final int CELL_SIZE = 50;
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
                layout.getChildren().add(cell);
                listaCasilleros.add(cell);
            }
        }
        this.layout = layout;
        return layout;
    }


    public void pasarTurno() throws IOException, FormatoJSONInvalido {
        
        ///Pedirle a jugador que construya torres y construirlas
        this.update();
        this.juego.jugar();
        

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

                    }/*else if(mapa.posicion(y, x).enemigo().equals(new Topo())){
                        VistaUnidad enemigo = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/topo.png");
                        Casillero cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                        cell.setImg(enemigo);

                    }*/else if(mapa.posicion(y, x).enemigo().equals(new Lechuza())){
                        VistaUnidad enemigo = new VistaUnidad("file:src/main/java/edu/fiuba/algo3/vistas/images/lechuza.png");
                        cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                        cell.setImg(enemigo);

                    }
                } else if(mapa.posicion(y, x).equals(new Tierra(x,y)) && mapa.posicion(y, x).hayDefensa()){

                        if(mapa.posicion(y,x).defensa().equals(new TorreBlanca(x,y))) {
                            VistaUnidad torre = new VistaUnidad("src/main/java/edu/fiuba/algo3/vistas/images/TorreBlanca.png");
                            cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                            cell.setImg(torre);

                        }else if(mapa.posicion(y,x).defensa().equals(new TorrePlateada(x,y))){
                            VistaUnidad torre = new VistaUnidad("src/main/java/edu/fiuba/algo3/vistas/images/TorrePlateada.png");
                           cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                            cell.setImg(torre);
                        }

                } else if(mapa.posicion(y, x).equals(new Pasarela(x,y))){
                        if(mapa.posicion(y, x).defensa() != null){
                            if(mapa.posicion(y, x).defensa().equals(new TrampaArenosa())){
                                VistaUnidad trampa = new VistaUnidad("src/main/java/edu/fiuba/algo3/vistas/images/TrampaArenosa.png");
                                cell = (Casillero) listaCasilleros.get(x*GRID_SIZE_IN_CELLS+y);
                                cell.setImg(trampa);
                            }
                        }
                    }
                }
            }
            return layout;
        }

}
    
 
