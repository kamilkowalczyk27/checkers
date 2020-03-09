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
    public ImageView getImage(FigureColor color) {

        ImageView queenImage = null;
        if(color == FigureColor.WHITE) {
            Image whiteQueen = new Image("file:src/main/resources/whiteQueen.png");
            ImageView whiteQ = new ImageView(whiteQueen);
            whiteQ.setFitHeight(90);
            whiteQ.setFitWidth(90);
            queenImage = whiteQ;
            return queenImage;
        } else {
            Image blackQueen = new Image("file:src/main/resources/blackQueen.png");
            ImageView blackQ = new ImageView(blackQueen);
            queenImage = blackQ;
            blackQ.setFitHeight(90);
            blackQ.setFitWidth(90);
            return queenImage;
        }
    }

    @Override
    public String toString() {
        return colorSymbol() + "Q";
    }

    private String colorSymbol() {
        if(color == FigureColor.WHITE) return "w";
        if(color == FigureColor.BLACK) return "b";
        return " ";
    }
}
