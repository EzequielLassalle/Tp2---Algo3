package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

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
    }

    private static final int CELL_SIZE = 50;
    private static final int GRID_SIZE_IN_CELLS = 15;

    private final Juego juego;
    private static Mapa mapa;

    private Pane layout;
    private Pane layoutEnemigosYDefensas;
    public VistaMapa(Juego juego){
        this.juego = juego;
        this.mapa = juego.mapa();
    }

    public Pane crearMapa() {

        ////MostrarMapa

        var layout = new Pane();
        layout.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);
        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                Casillero cell = new Casillero(x, y, Color.YELLOW);
                if(mapa.posicion(y, x).equals(new Pasarela(x, y))){
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
        this.layout = layout;
        return layout;
    }


    public void pasarTurno() throws IOException, FormatoJSONInvalido {
        this.juego.jugar();
        this.layoutEnemigosYDefensas = this.update();

    }

    public Pane update(){
        var layout = new Pane();
        layout.setPrefSize(CELL_SIZE * GRID_SIZE_IN_CELLS, CELL_SIZE * GRID_SIZE_IN_CELLS);

        for(int x = 0; x < GRID_SIZE_IN_CELLS; x++){
            for(int y = 0; y < GRID_SIZE_IN_CELLS; y++){
                if(mapa.posicion(y, x).hayEnemigos()){
                    if(mapa.posicion(y, x).enemigo().equals(new Hormiga())){
                        VistaEnemigo vistaEnemigo = new VistaEnemigo();
                        ////VistaHormiga vistaEnemigo = new VistaHormiga();
                        Casillero cell = (Casillero)this.layout.getChildren().get(y*GRID_SIZE_IN_CELLS+x);
                        cell.getChildren().add(vistaEnemigo);

                    }else if(mapa.posicion(y, x).enemigo().equals(new Arania())){
                        /* VistaArania vistaEnemigo = new VistaArania();
                        Casillero cell = (Casillero)this.layout.getChildren().get(y*GRID_SIZE_IN_CELLS+x);
                        cell.getChildren().add(vistaEnemigo); */

                    }else if(mapa.posicion(y, x).enemigo().equals(new Topo())){
                        /* VistaTopo vistaEnemigo = new VistaTopo();
                        Casillero cell = (Casillero)this.layout.getChildren().get(y*GRID_SIZE_IN_CELLS+x);
                        cell.getChildren().add(vistaEnemigo); */

                    }else if(mapa.posicion(y, x).enemigo().equals(new Lechuza())){
                       /*  VistaLechuza vistaEnemigo = new VistaLechuza();
                        Casillero cell = (Casillero)this.layout.getChildren().get(y*GRID_SIZE_IN_CELLS+x);
                        cell.getChildren().add(vistaEnemigo); */

                    }
                }else if(mapa.posicion(y, x).equals(new Tierra(x,y)) && mapa.posicion(y, x).hayDefensa()){

                        if(mapa.posicion(y,x).defensa().equals(new TorreBlanca(x,y))) {
                            /*  VistaTorreBlanca vistaTorre = new VistaTorreBlanca();
                            Casillero cell = (Casillero)this.layout.getChildren().get(y*GRID_SIZE_IN_CELLS+x);
                            cell.getChildren().add(vistaTorre); */

                        }else if(mapa.posicion(y,x).defensa().equals(new TorrePlateada(x,y))){
                            /*  VistaTorrePlateada vistaTorre = new VistaTorrePlateada();
                            Casillero cell = (Casillero)this.layout.getChildren().get(y*GRID_SIZE_IN_CELLS+x);
                            cell.getChildren().add(vistaTorre); */

                        }

                    } else if(mapa.posicion(y, x).equals(new Pasarela(x,y))){
                        if(mapa.posicion(y, x).defensa().equals(new TrampaArenosa())){
                            /*  VistaTrampaArenosa vistaTorre = new VistaTrampaArenosa();
                            Casillero cell = (Casillero)this.layout.getChildren().get(y*GRID_SIZE_IN_CELLS+x);
                            cell.getChildren().add(vistaTrampaArenosa); */            
                        }
                    }
                }
            }
            return layout;
        }

}
    
 
