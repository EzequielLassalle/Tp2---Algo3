package edu.fiuba.algo3.vistas;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class VistaLechuza extends Rectangle{
    public Image image = new Image("src/main/java/edu/fiuba/algo3/vistas/images/lechuza.png");
    public VistaLechuza(){
        this.setFill(new ImagePattern(this.image));
    }
}