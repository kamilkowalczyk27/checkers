package com.checkers.logic;

import javafx.scene.image.ImageView;

public interface Figure {
    FigureColor getColor();
    ImageView getImage(FigureColor color);
}

