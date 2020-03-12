package com.checkers.logic;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for(int n = 0; n < 8; n++)
            rows.add(new BoardRow());
    }

    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure){
        rows.get(row).getCols().set(col, figure);
    }

    public void init(){
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

    public void showOnGrind(GridPane gridPane){
        gridPane.getChildren().clear();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Pawn pawn = new Pawn(getFigure(j, i).getColor());
                if(getFigure(j, i) instanceof Pawn){
                    if(getFigure(j, i).getColor().equals(FigureColor.WHITE)){
                        gridPane.add(pawn.getImage(getFigure(j, i).getColor()),j, i);
                        gridPane.setPadding(new Insets(25,0,30,10));
                        gridPane.setHgap(0);
                        gridPane.setVgap(0);
                        gridPane.setAlignment(Pos.CENTER);
                    }else{
                        gridPane.add(pawn.getImage(getFigure(j, i).getColor()),j, i);
                        gridPane.setPadding(new Insets(25,0,30,10));
                        gridPane.setHgap(0);
                        gridPane.setVgap(0);
                        gridPane.setAlignment(Pos.CENTER);
                    }
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
        for(int row =0; row<8; row++)
            s += rows.get(row).toString();
        s += "|-----------------------|\n";
        return s;
    }
}

