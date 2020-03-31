package com.checkers.logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pawn implements Figure {
    private FigureColor color;

    public Pawn(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    public ImageView getImage() {
        Image image;
        if (color == FigureColor.WHITE) {
            image = new Image("file:src/main/resources/whitePawn.png");
        } else {
            image = new Image("file:src/main/resources/blackPawn.png");
        }
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(90);
        imageView.setFitWidth(90);
        return imageView;
    }

    @Override
    public String toString() {
        return colorSymbol() + "P";
    }

    private String colorSymbol() {
        if (color == FigureColor.WHITE) return "w";
        if (color == FigureColor.BLACK) return "b";
        return " ";
    }
}
