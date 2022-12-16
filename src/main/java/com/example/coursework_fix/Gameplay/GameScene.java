/**
 * This class is responsible for viewing the game scene where the user gets to start playing the game
 */
package com.example.coursework_fix.Gameplay;

import com.example.coursework_fix.Cell.Cell;
import com.example.coursework_fix.Text.TextMaker;
import com.example.coursework_fix.Leaderboard;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameScene {
    private static int HEIGHT = 700;
    private static int numberOfCells = 4; //number of cells (this line is used to change the grid)
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((numberOfCells + 1) * distanceBetweenCells)) / (double) numberOfCells;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private static Cell[][] cells = new Cell[numberOfCells][numberOfCells];
    private static Group root;
    private long score = 0;
    Leaderboard leaderboard = new Leaderboard(); // linking with leaderboard class object



    /**
     * number of cells to be set
     * @param number
     */
    static void setNumberOfCells(int number) {
        numberOfCells = number;
        LENGTH = (HEIGHT - ((numberOfCells + 1) * distanceBetweenCells)) / (double) numberOfCells;
    }

    public static double getLENGTH() {
        return LENGTH;
    }

    public static Group getroot() {
        return root;
    }

    /**
     *this function checks cell in the array if empty or not
     * @return -1
     */
    int haveEmptyCell() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (cells[i][j].getNumber() == 0) return 1;
                if (cells[i][j].getNumber() == 2048) return 0;
            }
        }
        return -1;
    }

    /**
     *checks number on cell through array
     * @param i
     * @param j
     * @return false
     */
    private boolean haveSameNumberNearly(int i, int j) {
        if (i < numberOfCells - 1 && j < numberOfCells - 1)
            return (cells[i + 1][j].getNumber() == cells[i][j].getNumber()) ||
                    (cells[i][j + 1].getNumber() == cells[i][j].getNumber());

        return false;
    }

    /**
     *checks the movements
     * @return true
     */
    boolean canNotMove() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param primaryStage
     * @param key
     */
    void gameMovement(Stage primaryStage, KeyEvent key) {
        switch (key.getCode()) {
            case DOWN -> GameMoves.moveDown();
            case UP -> GameMoves.moveUp();
            case LEFT -> GameMoves.moveLeft();
            case RIGHT -> GameMoves.moveRight();
            case ESCAPE -> {
                try {
                    Parent proot = FXMLLoader.load(getClass().getResource("Pause.fxml"));
                    var scene = new Scene(proot);
                    primaryStage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //this else statement is to restrict the whole keyboard except arrow letters to work when usin gthe game
            default -> throw new RuntimeException("wrong key press");
        }
    }

    static Text getScoreText(Group root) {
        Text text = new Text();
        root.getChildren().add(text);
        text.setFill(Color.rgb(255,255,255));
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");
        scoreText.setFill(Color.rgb(255,255,255));
        return scoreText;
    }

    /**
     *  getter method for cell that are used in GameMoves for game movement.
     */

    public static Cell[][] getCells() {
        return cells;
    }

    public static int getNumberOfCells() {
        return numberOfCells;
    }
}

