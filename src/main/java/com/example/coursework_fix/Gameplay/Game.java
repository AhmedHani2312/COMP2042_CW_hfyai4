package com.example.coursework_fix.Gameplay;

import com.example.coursework_fix.Cell.Cell;
import com.example.coursework_fix.Text.TextMaker;
import com.example.coursework_fix.leaderBoard;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;
//The below functions are taken from GameScene class have been refactored here in a new class!
public class Game {
    leaderBoard leaderboard = new leaderBoard(); // linking with leaderboard class object

    private static int HEIGHT = 700;
    static final int WIDTH = 900;
    private final static int distanceBetweenCells = 10;
    private Cell[][] cells = GameScene.getCells();
    private int numberOfCells = GameScene.getNumberOfCells();
    private double LENGTH = (HEIGHT - ((numberOfCells + 1) * distanceBetweenCells)) / (double) numberOfCells;
    private long score = 0;
    private leaderBoard hs = new leaderBoard();
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private Stage primaryStage = new Stage();
    private Group root = new Group();
    private Group endgameRoot = new Group();
    private Stage stage;
//used to take an object to access the access functions from gamescene class
    GameScene gameObject = new GameScene();

    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                //the 45 below is responsible to make all the game in the center away from the borders.
                cells[i][j] = new Cell(calculateX(j),
                        calculateY(i),
                        LENGTH, root);
            }

        }

        Text scoreText = GameScene.getScoreText(root);

        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> Platform.runLater(() -> {
            // boolean isMove = false
            int haveEmptyCell;
            // changed if statement to Switch case statement
            gameObject.gameMovement(primaryStage, key);

            sumCellNumbersToScore();
            scoreText.setText(score + "");
            haveEmptyCell = gameObject.haveEmptyCell();
            //if isMove = true then ->
            if (haveEmptyCell == -1) {
                if (gameObject.canNotMove()) {

                    primaryStage.setScene(endGameScene);
                    Stage endgamePOP = new Stage();
                    //endgamePOP.setScene(endGameScene);
                    PopUpEndGame.getInstance().endGameShow(endGameRoot, primaryStage, endgamePOP, score);
                    //this will take the score and put it inside the leaderBoad class.
                    leaderboard.updateHighscore(score);

                    root.getChildren().clear();
                    score = 0;
                }
            } else if (haveEmptyCell == 1) randomFillNumber(2);
        }));
    }

    private double calculateY(int i) {
        return i * LENGTH + (i + 1) * distanceBetweenCells;
    }

    private double calculateX(int j) {
        return j * LENGTH + (j + 1) * distanceBetweenCells + 45;
    }

    void sumCellNumbersToScore() {
        score = 0;
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                score += cells[i][j].getNumber();
            }
        }
    }

    void randomFillNumber(int turn) {
        Cell[][] emptyCells = new Cell[numberOfCells][numberOfCells];
        int a = 0;
        int b = 0;
        int aForBound = 0, bForBound = 0;
        outer:
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < numberOfCells - 1) {
                        bForBound = b;
                        b++;

                    } else {
                        aForBound = a;
                        a++;
                        b = 0;
                        if (a == numberOfCells) break outer;

                    }
                }
            }
        }


        Text text;
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0) putTwo = false;
        int xCell, yCell;
        xCell = random.nextInt(aForBound + 1);
        yCell = random.nextInt(bForBound + 1);
        //duplicate code find solution.
        if (putTwo) {
            text = textMaker.madeText("2", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColor(2);
        } else {
            text = textMaker.madeText("4", emptyCells[xCell][yCell].getX(), emptyCells[xCell][yCell].getY(), root);
            emptyCells[xCell][yCell].setTextClass(text);
            root.getChildren().add(text);
            emptyCells[xCell][yCell].setColor(4);
        }
    }

}
