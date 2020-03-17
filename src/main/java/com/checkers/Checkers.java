package com.checkers;

import com.checkers.logic.Board;
import com.checkers.logic.FigureColor;
import com.checkers.logic.Pawn;
import com.checkers.logic.Queen;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Checkers extends Application {

    private Image imageback = new Image("file:src/main/resources/Board.png");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(800, 800, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);

        for (int i = 0; i < 8; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(100));
        }
        for (int i = 0; i < 8; i++) {
            grid.getRowConstraints().add(new RowConstraints(100));
        }
        Scene scene = new Scene(grid, 800, 800, Color.BLACK);

        grid.setHgap(0);
        grid.setVgap(0);
        grid.setAlignment(Pos.CENTER);

        Board board = new Board();
        board.init();

        Pawn pawnWhite = new Pawn(FigureColor.WHITE);
        pawnWhite.getImage(FigureColor.WHITE);
        Pawn pawnBlack = new Pawn(FigureColor.BLACK);
        pawnBlack.getImage(FigureColor.BLACK);
        Queen blackQueen = new Queen(FigureColor.BLACK);
        blackQueen.getImage(FigureColor.BLACK);
        Queen whiteQueen = new Queen(FigureColor.WHITE);
        whiteQueen.getImage(FigureColor.WHITE);

        Game game = new Game(board, grid);
        game.playGame();

        grid.setOnMouseClicked(event -> {
            int x = (int) event.getX()/100;
            int y = (int) event.getY()/100;
            System.out.println(x + " " + y);
            game.doClick(x,y);
        });

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

