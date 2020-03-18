package com.checkers.logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Queen implements Figure {
    private FigureColor color;

    public Queen(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public ImageView getImage() {
        Image image;
        if (color == FigureColor.WHITE) {
            image = new Image("file:src/main/resources/whiteQueen.png");
        } else {
            image = new Image("file:src/main/resources/blackQueen.png");
        }
        ImageView whiteQ = new ImageView(image);
        whiteQ.setFitHeight(90);
        whiteQ.setFitWidth(90);
        return whiteQ;
    }

    @Override
    public String toString() {
        return colorSymbol() + "Q";
    }

    private String colorSymbol() {
        if (color == FigureColor.WHITE) return "w";
        if (color == FigureColor.BLACK) return "b";
        return " ";
    }
}
