package com.checkers.logic;

import javafx.scene.layout.GridPane;

public class TestApplication {
    public static void main(String[] args) {
        Board board = new Board();
        board.init();
        System.out.println(board);
    }
}

