package com.example.coursework_fix;

import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

class GameScene {
    private static int HEIGHT = 700;
    private static int numberOfCells = 4; //number of cells (this line is used to change the grid)
    private final static int distanceBetweenCells = 10;
    private static double LENGTH = (HEIGHT - ((numberOfCells + 1) * distanceBetweenCells)) / (double) numberOfCells;
    private TextMaker textMaker = TextMaker.getSingleInstance();
    private static Cell[][] cells = new Cell[numberOfCells][numberOfCells];
    private Group root;
    private long score = 0;

    /*
    * @param number , number if cells to be set*/
    static void setNumberOfCells(int number) {
        numberOfCells = number;
        LENGTH = (HEIGHT - ((numberOfCells + 1) * distanceBetweenCells)) / (double) numberOfCells;
    }

    static double getLENGTH() {
        return LENGTH;
    }

    private void randomFillNumber(int turn) {

        Cell[][] emptyCells = new Cell[numberOfCells][numberOfCells];
        int a = 0;
        int b = 0;
        int aForBound=0,bForBound=0;
        outer:
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (cells[i][j].getNumber() == 0) {
                    emptyCells[a][b] = cells[i][j];
                    if (b < numberOfCells -1) {
                        bForBound=b;
                        b++;

                    } else {
                        aForBound=a;
                        a++;
                        b = 0;
                        if(a== numberOfCells)
                            break outer;
                    }
                }
            }
        }



        Text text;
        Random random = new Random();
        boolean putTwo = true;
        if (random.nextInt() % 2 == 0)
            putTwo = false;
        int xCell, yCell;
            xCell = random.nextInt(aForBound+1);
            yCell = random.nextInt(bForBound+1);
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
    private int  haveEmptyCell() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (cells[i][j].getNumber() == 0)
                    return 1;
                if(cells[i][j].getNumber() == 2048)
                    return 0;
            }
        }
        return -1;
    }

//    private int passDestination(int i, int j, char direct) {
//        int coordinate = j;
//        if (direct == 'l') {
//            for (int k = j - 1; k >= 0; k--) {
//                if (cells[i][k].getNumber() != 0) {
//                    coordinate = k + 1;
//                    break;
//                } else if (k == 0) {
//                    coordinate = 0;
//                }
//            }
//            return coordinate;
//        }
//        coordinate = j;
//        if (direct == 'r') {
//            for (int k = j + 1; k <= numberOfCells - 1; k++) {
//                if (cells[i][k].getNumber() != 0) {
//                    coordinate = k - 1;
//                    break;
//                } else if (k == numberOfCells - 1) {
//                    coordinate = numberOfCells - 1;
//                }
//            }
//            return coordinate;
//        }
//        coordinate = i;
//        if (direct == 'd') {
//            for (int k = i + 1; k <= numberOfCells - 1; k++) {
//                if (cells[k][j].getNumber() != 0) {
//                    coordinate = k - 1;
//                    break;
//
//                } else if (k == numberOfCells - 1) {
//                    coordinate = numberOfCells - 1;
//                }
//            }
//            return coordinate;
//        }
//        coordinate = i;
//        if (direct == 'u') {
//            for (int k = i - 1; k >= 0; k--) {
//                if (cells[k][j].getNumber() != 0) {
//                    coordinate = k + 1;
//                    break;
//                } else if (k == 0) {
//                    coordinate = 0;
//                }
//            }
//            return coordinate;
//        }
//        return -1;
//    }
/*
    private void moveLeft() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 1; j < numberOfCells; j++) {
                moveHorizontally(i, j, passDestination(i, j, 'l'), -1);
            }
            for (int j = 0; j < numberOfCells; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    private void moveRight() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = numberOfCells - 1; j >= 0; j--) {
                moveHorizontally(i, j, passDestination(i, j, 'r'), 1);
            }
            for (int j = 0; j < numberOfCells; j++) {
                cells[i][j].setModify(false);
            }
        }
    }

    private void moveUp() {
        for (int j = 0; j < numberOfCells; j++) {
            for (int i = 1; i < numberOfCells; i++) {
                moveVertically(i, j, passDestination(i, j, 'u'), -1);
            }
            for (int i = 0; i < numberOfCells; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    private void moveDown() {
        for (int j = 0; j < numberOfCells; j++) {
            for (int i = numberOfCells - 1; i >= 0; i--) {
                moveVertically(i, j, passDestination(i, j, 'd'), 1);
            }
            for (int i = 0; i < numberOfCells; i++) {
                cells[i][j].setModify(false);
            }
        }

    }

    private boolean isValidDesH(int i, int j, int des, int sign) {
        if (des + sign < numberOfCells && des + sign >= 0) {
            if (cells[i][des + sign].getNumber() == cells[i][j].getNumber() && !cells[i][des + sign].getModify()
                    && cells[i][des + sign].getNumber() != 0) {
                return true;
            }
        }
        return false;
    }
    */

//    private void moveHorizontally(int i, int j, int des, int sign) {
//        if (isValidDesH(i, j, des, sign)) {
//            cells[i][j].adder(cells[i][des + sign]);
//            cells[i][des].setModify(true);
//        } else if (des != j) {
//            cells[i][j].changeCell(cells[i][des]);
//        }
//    }

//    private boolean isValidDesV(int i, int j, int des, int sign) {
//        if (des + sign < numberOfCells && des + sign >= 0)
//            if (cells[des + sign][j].getNumber() == cells[i][j].getNumber() && !cells[des + sign][j].getModify()
//                    && cells[des + sign][j].getNumber() != 0) {
//                return true;
//            }
//        return false;
//    }

//    private void moveVertically(int i, int j, int des, int sign) {
//        if (isValidDesV(i, j, des, sign)) {
//            cells[i][j].adder(cells[des + sign][j]);
//            cells[des][j].setModify(true);
//        } else if (des != i) {
//            cells[i][j].changeCell(cells[des][j]);
//        }
//    }

    private boolean haveSameNumberNearly(int i, int j) {
        if (i < numberOfCells - 1 && j < numberOfCells - 1) {
            if (cells[i + 1][j].getNumber() == cells[i][j].getNumber())
                return true;
            if (cells[i][j + 1].getNumber() == cells[i][j].getNumber())
                return true;
        }
        return false;
    }

    private boolean canNotMove() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                if (haveSameNumberNearly(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void sumCellNumbersToScore() {
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                score += cells[i][j].getNumber();
            }
        }
    }

    void game(Scene gameScene, Group root, Stage primaryStage, Scene endGameScene, Group endGameRoot) {
        this.root = root;
        for (int i = 0; i < numberOfCells; i++) {
            for (int j = 0; j < numberOfCells; j++) {
                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells,
                        (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
            }

        }

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

        randomFillNumber(1);
        randomFillNumber(1);

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key ->{
                Platform.runLater(() -> {
                    //boolean isMove = false
                    int haveEmptyCell;
                    if (key.getCode() == KeyCode.DOWN) {
                        GameMoves.moveDown();
                    } else if (key.getCode() == KeyCode.UP) {
                        GameMoves.moveUp();
                        //boolean isMove = true
                    } else if (key.getCode() == KeyCode.LEFT) {
                        GameMoves.moveLeft();
                    } else if (key.getCode() == KeyCode.RIGHT) {
                        GameMoves.moveRight();
                    }
                    //this else statement is to restrict the whole keyboard except arrow letters to work when usin gthe game
                    else{
                        throw new RuntimeException("wrong key press");
                    }
                    GameScene.this.sumCellNumbersToScore();
                    scoreText.setText(score + "");
                    haveEmptyCell = GameScene.this.haveEmptyCell();
                    //if isMove = true then ->
                    if (haveEmptyCell == -1) {
                        if (GameScene.this.canNotMove()) {
                            primaryStage.setScene(endGameScene);

                            EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
                            root.getChildren().clear();
                            score = 0;
                        }
                    } else if(haveEmptyCell == 1)
                        GameScene.this.randomFillNumber(2);
                });
            });

    }
//getter method for cell that are used in GameMoves for game movement.
    public static Cell[][] getCells() {
        return cells;
    }

    public static int getNumberOfCells() {
        return numberOfCells;
    }
}
