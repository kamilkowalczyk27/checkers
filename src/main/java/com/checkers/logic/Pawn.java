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

    @Override
    public ImageView getImage(FigureColor color){
        ImageView pawnImage = null;
        if(color == FigureColor.WHITE){
            Image whitePawn = new Image("file:src/main/resources/whitePawn.png");
            ImageView whiteP = new ImageView(whitePawn);
            whiteP.setFitHeight(90);
            whiteP.setFitWidth(90);
            pawnImage = whiteP;
            return pawnImage;
        } else {
            Image blackPawn = new Image("file:src/main/resources/blackPawn.png");
            ImageView blackP = new ImageView(blackPawn);
            blackP.setFitHeight(90);
            blackP.setFitWidth(90);
            pawnImage = blackP;
            return pawnImage;
        }
    }

    @Override
    public String toString() {
        return colorSymbol() + "P";
    }

    private String colorSymbol() {
        if(color == FigureColor.WHITE) return "w";
        if(color == FigureColor.BLACK) return "b";
        return " ";
    }
}

