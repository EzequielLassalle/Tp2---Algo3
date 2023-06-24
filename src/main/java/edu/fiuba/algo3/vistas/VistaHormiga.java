package edu.fiuba.algo3.vistas;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VistaHormiga extends Rectangle{
    public Image image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/images/hormiga.png");
    public VistaHormiga(){
        this.setFill(new ImagePattern(this.image));
    }
}
