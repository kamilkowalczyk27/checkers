package com.checkers.logic;

import javafx.scene.image.ImageView;

public class None implements Figure {
    @Override
    public FigureColor getColor() {
        return FigureColor.NONE;
    }

    @Override
    public ImageView getImage() {
        return null;
    }

    @Override
    public String toString() {
        return "  ";
    }
}
