package com.checkers;

import com.checkers.logic.Board;
import javafx.scene.layout.GridPane;

public class Game {
    private Board board;
    private GridPane gridPane;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }
}
