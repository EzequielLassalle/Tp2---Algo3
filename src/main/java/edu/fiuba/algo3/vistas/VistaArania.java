package edu.fiuba.algo3.vistas;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VistaArania extends Rectangle{
    private Image image = new Image("src/main/java/edu/fiuba/algo3/vistas/images/hormiga.png");
    public VistaArania(){
        this.setFill(new ImagePattern(this.image));
    }
}
