package com.example.coursework_fix.Gameplay;

import com.example.coursework_fix.Cell.Cell;
import com.example.coursework_fix.Text.TextMaker;
import com.example.coursework_fix.leaderBoard;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;

public class GameScene {
    private static int HEIGHT = 700;
    private static int numberOfCells = 4; //number of cells (this line is used to change the grid)
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((numberOfCells + 1) * distanceBetweenCells)) / (double) numberOfCells;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private static Cell[][] cells = new Cell[numberOfCells][numberOfCells];
    private static Group root;
    private long score = 0;
    leaderBoard leaderboard = new leaderBoard(); // linking with leaderboard class object

    /*
     * @param number , number if cells to be set*/
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

    //2048 NUMBER WHEN IT REACHES IT does not STOP.
    int haveEmptyCell() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (cells[i][j].getNumber() == 0) return 1;
                if (cells[i][j].getNumber() == 2048) return 0;
            }
        }
        return -1;
    }


    private boolean haveSameNumberNearly(int i, int j) {
        if (i < numberOfCells - 1 && j < numberOfCells - 1)
            return (cells[i + 1][j].getNumber() == cells[i][j].getNumber()) ||
                    (cells[i][j + 1].getNumber() == cells[i][j].getNumber());

        return false;
    }

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

    void sumCellNumbersToScore() {
        score = 0;
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                score += cells[i][j].getNumber();
            }
        }
    }

    public void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                //the 45 below is responsible to make all the game in the center away from the borders.
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells + 45, (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

        Text scoreText = getScoreText(root);

        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> Platform.runLater(() -> {
            // boolean isMove = false
            int haveEmptyCell;
            // changed if statement to Switch case statement
            gameMovement(primaryStage, key);

            GameScene.this.sumCellNumbersToScore();
            scoreText.setText(score + "");
            haveEmptyCell = GameScene.this.haveEmptyCell();
            //if isMove = true then ->
            if (haveEmptyCell == -1) {
                if (GameScene.this.canNotMove()) {

                    primaryStage.setScene(endGameScene);
                    Stage endgamePOP = new Stage();
                    //endgamePOP.setScene(endGameScene);
                    PopUpEndGame.getInstance().endGameShow(endGameRoot, primaryStage, endgamePOP, score);
                    //this will take the score and put it inside the leaderBoad class.
                    leaderboard.updateHighscore(score);

                    root.getChildren().clear();
                    score = 0;
                }
            } else if (haveEmptyCell == 1) GameScene.this.randomFillNumber(2);
        }));
    }

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

    Text getScoreText(Group root) {
        Text text = new Text();
        root.getChildren().add(text);
        text.setText("SCORE :");
        text.setFont(Font.font(30));
        text.relocate(750, 100);
        Text scoreText = new Text();
        root.getChildren().add(scoreText);
        scoreText.relocate(750, 150);
        scoreText.setFont(Font.font(20));
        scoreText.setText("0");
        return scoreText;
    }

    //getter method for cell that are used in GameMoves for game movement.
    public static Cell[][] getCells() {
        return cells;
    }

    public static int getNumberOfCells() {
        return numberOfCells;
    }
}