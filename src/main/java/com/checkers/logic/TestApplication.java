package com.checkers.logic;

public class TestApplication {
    public static void main(String[] args) {
        Board board = new Board();
        board.init();
        Pawn pawn = new Pawn(FigureColor.WHITE);
        pawn.getImage(FigureColor.WHITE);
        System.out.println(board);
    }
}

