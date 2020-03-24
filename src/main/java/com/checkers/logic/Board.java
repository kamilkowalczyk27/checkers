package com.checkers.logic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for (int n = 0; n < 8; n++)
            rows.add(new BoardRow());
    }

    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().set(col, figure);
    }

    public boolean move(int col1, int row1, int col2, int row2, FigureColor color) {
        boolean result = false;
        if (moveIsValid(col1, row1, col2, row2, color)) {
            Figure figure = getFigure(col1, row1);
            setFigure(col2, row2, figure);
            setFigure(col1, row1, new None());
            result = true;
        } else if (moveIsValidWithHit(col1, row1, col2, row2, color)) {
            removeOpponentFigure(col1, row1, col2, row2);
            Figure figure = getFigure(col1, row1);
            setFigure(col2, row2, figure);
            setFigure(col1, row1, new None());
            result = true;
        }
        if (result)
            transformPawnToQueen(color, col2, row2);
        return result;
    }

    private void removeOpponentFigure(int col1, int row1, int col2, int row2) {
        if (Math.abs(col1 - col2) == 2 && Math.abs(row1 - row2) == 2) {
            setFigure((col1 + col2) / 2, (row1 + row2) / 2, new None());
        }
    }

    private boolean moveIsValidWithHit(int col1, int row1, int col2, int row2, FigureColor color) {
        boolean result = true;
        if (!isFieldEmpty(col2, row2))
            result = false;
        if (!isMoveDiagonalTwoFields(col1, row1, col2, row2))
            result = false;
        if (!isDirectionValid(color, row1, row2))
            result = false;
        if (!isOpponentBetween(color, col1, row1, col2, row2))
            result = false;
        return result;
    }

    private boolean isOpponentBetween(FigureColor color, int col1, int row1, int col2, int row2) {
        int x = (col1 + col2) / 2;
        int y = (row1 + row2) / 2;
        boolean result = true;
        if (getFigure(x, y) instanceof None) result = false;
        if (getFigure(x, y).getColor() == color) result = false;
        return result;
    }

    private boolean isMoveDiagonalTwoFields(int col1, int row1, int col2, int row2) {
        return Math.abs(col1 - col2) == 2 && Math.abs(row1 - row2) == 2;

    }

    private boolean moveIsValid(int col1, int row1, int col2, int row2, FigureColor color) {
        if(getFigure(col1, row1) instanceof Queen){
            return isMoveOfQueenValid(col1,row1,col2,row2);
        }else {
            return isMoveOfPawnValid(col1, row1, col2, row2, color);
        }
    }

    private boolean isMoveOfPawnValid(int col1, int row1, int col2, int row2, FigureColor color) {
        boolean result = true;
        if (!isFieldEmpty(col2, row2))
            result = false;
        if (!isMoveDiagonal(col1, row1, col2, row2))
            result = false;
        if (!isDirectionValid(color, row1, row2))
            result = false;
        return result;
    }

    private boolean isDirectionValid(FigureColor color, int row1, int row2) {
        if (color == FigureColor.WHITE) {
            return row2 < row1;
        } else {
            return row2 > row1;
        }
    }

    private boolean isMoveDiagonal(int col1, int row1, int col2, int row2) {
        return Math.abs(col1 - col2) == 1 && Math.abs(row1 - row2) == 1;
    }

    private boolean isFieldEmpty(int x, int y) {
        return getFigure(x, y) instanceof None;
    }

    public void transformPawnToQueen(FigureColor color, int col2, int row2) {
        if (color == FigureColor.WHITE) {
            if (col2 < 8 && row2 == 0) {
                setFigure(col2, row2, new Queen(FigureColor.WHITE));
            }
        } else {
            if (col2 < 8 && row2 == 7) {
                setFigure(col2, row2, new Queen(FigureColor.BLACK));
            }
        }
    }

    private boolean isMoveOfQueenValid(int col1, int row1, int col2, int row2) {
        boolean result = true;
        if (!isFieldEmpty(col2, row2))
            result = false;
        if (!isMoveDiagonalQueen(col1, row1, col2, row2))
            result = false;
        if (!isFiguresBetweenQueen(col1, row1, col2, row2))
            result = false;
        return result;
    }

    private boolean isFiguresBetweenQueen(int col1, int row1, int col2, int row2) {
        int dx = (col2 > col1) ? 1 : -1;
        int dy = (row2 > row1) ? 1 : -1;
        boolean result = true;
        for (int step = 1; step < Math.abs(col1 - col2); step++) {
            if (!(getFigure(col1 + step * dx, row1 + step * dy) instanceof None))
                result = false;
        }
        return result;
    }

    private boolean isMoveDiagonalQueen(int col1, int row1, int col2, int row2) {
        return Math.abs(col1 - col2) == Math.abs(row1 - row2);
    }

    public void init() {
        setFigure(1, 0, new Pawn(FigureColor.BLACK));
        setFigure(3, 0, new Pawn(FigureColor.BLACK));
        setFigure(5, 0, new Pawn(FigureColor.BLACK));
        setFigure(7, 0, new Pawn(FigureColor.BLACK));
        setFigure(0, 1, new Pawn(FigureColor.BLACK));
        setFigure(2, 1, new Pawn(FigureColor.BLACK));
        setFigure(4, 1, new Pawn(FigureColor.BLACK));
        setFigure(6, 1, new Pawn(FigureColor.BLACK));
        setFigure(1, 2, new Pawn(FigureColor.BLACK));
        setFigure(3, 2, new Pawn(FigureColor.BLACK));
        setFigure(5, 2, new Pawn(FigureColor.BLACK));
        setFigure(7, 2, new Pawn(FigureColor.BLACK));

        setFigure(0, 7, new Pawn(FigureColor.WHITE));
        setFigure(2, 7, new Pawn(FigureColor.WHITE));
        setFigure(4, 7, new Pawn(FigureColor.WHITE));
        setFigure(6, 7, new Pawn(FigureColor.WHITE));
        setFigure(1, 6, new Pawn(FigureColor.WHITE));
        setFigure(3, 6, new Pawn(FigureColor.WHITE));
        setFigure(5, 6, new Pawn(FigureColor.WHITE));
        setFigure(7, 6, new Pawn(FigureColor.WHITE));
        setFigure(0, 5, new Pawn(FigureColor.WHITE));
        setFigure(2, 5, new Pawn(FigureColor.WHITE));
        setFigure(4, 5, new Pawn(FigureColor.WHITE));
        setFigure(6, 5, new Pawn(FigureColor.WHITE));
    }

    public void showOnGrind(GridPane gridPane) {
        gridPane.getChildren().clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure figure = getFigure(j, i);
                if (!(figure instanceof None)) {
                    gridPane.add(figure.getImage(), j, i);
                    gridPane.setPadding(new Insets(25, 0, 30, 10));
                    gridPane.setHgap(0);
                    gridPane.setVgap(0);
                    gridPane.setAlignment(Pos.CENTER);
                }
            }
        }
        gridPane.setHgap(0);
        gridPane.setVgap(0);
        gridPane.setAlignment(Pos.CENTER);

    }

    @Override
    public String toString() {
        String s = "|-----------------------|\n";
        for (int row = 0; row < 8; row++)
            s += rows.get(row).toString();
        s += "|-----------------------|\n";
        return s;
    }

    public void showBorder(GridPane gridPane, int x, int y) {
        Rectangle rect = new Rectangle(95, 95);
        gridPane.add(rect, x, y);
        rect.setStroke(Color.YELLOWGREEN);
        rect.setStrokeWidth(10);
    }


    public void gameOver() {
        int blackCount = countFigures(FigureColor.BLACK);
        int whiteCount = countFigures(FigureColor.WHITE);
        if(blackCount == 0 || whiteCount == 0){
            System.out.println("Game Over!");
            //wyświetl komunikat
            Text t = new Text();
            t.setText("Game Over!");
            t.setFont(new Font(20));
            t.setFill(Color.BLACK);
        }
    }

    private int countFigures(FigureColor color) {
        int result = 0;
        for(int col = 0; col < 8; col++){
            for(int row=0; row <8; row++){
                if(getFigure(col, row).getColor() == color)
                    result++;
            }
        }
        return result;
    }


}



