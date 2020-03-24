package com.checkers;

import com.checkers.logic.Board;
import com.checkers.logic.FigureColor;
import javafx.scene.layout.GridPane;

public class Game {
    private Board board;
    private GridPane gridPane;
    private FigureColor whoseMove = FigureColor.WHITE;
    private int oldX = -1;
    private int oldY = -1;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }

    public void playGame() {
        board.init();
        board.showOnGrind(gridPane);
    }

    public void doClick(int x, int y) {
        if (oldX == -1) {
            if(board.getFigure(x,y).getColor() == whoseMove) {
                oldX = x;
                oldY = y;
                board.showBorder(gridPane,x,y);
            }
        } else {
            if(board.move(oldX, oldY, x, y, whoseMove)){
                whoseMove = getOppositeColor(whoseMove);
                board.gameOver();
            }
            oldX = -1;
            oldY = -1;
            board.showOnGrind(gridPane);
            
        }
    }
    private FigureColor getOppositeColor(FigureColor whoseMove) {
        return whoseMove == FigureColor.WHITE ? FigureColor.BLACK : FigureColor.WHITE;
    }
}
