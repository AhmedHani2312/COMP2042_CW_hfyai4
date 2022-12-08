//package com.example.coursework_fix.Gameplay;
//
//import com.example.coursework_fix.Cell.Cell;
//import javafx.application.Platform;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//public class Game {
//    private static int numberOfCells = GameScene.getNumberOfCells();
//    private static Group root = GameScene.getroot();
//    private Cell[][]cells=GameScene.getCells();
//    private static long score =0;
//    private final static int distanceBetweenCells=10;
//    private static final int HEIGHT =700;
//    private static double LENGTH = (HEIGHT - ((numberOfCells + 1) * distanceBetweenCells)) / (double) numberOfCells;
//
//    public void game() {
//        this.root = root;
//        GameScene gamescene = new GameScene();
//        for (int i = 0; i < numberOfCells; i++) {
//            for (int j = 0; j < numberOfCells; j++) {
//                cells[i][j] = new Cell((j) * LENGTH + (j + 1) * distanceBetweenCells, (i) * LENGTH + (i + 1) * distanceBetweenCells, LENGTH, root);
//            }
//
//        }
//
//        Text scoreText = gamescene.getScoreText(root);
//
//        gamescene.randomFillNumber(1);
//        gamescene.randomFillNumber(1);
//
//        gameScene.addEventHandler(KeyEvent.KEY_PRESSED, key -> Platform.runLater(() -> {
//            // boolean isMove = false
//            int haveEmptyCell;
//            // changed if statement to Switch case statement
//            gamescene.gameMovement(primaryStage, key);
//
//            gamescene.sumCellNumbersToScore();
//            scoreText.setText(score + "");
//            haveEmptyCell = gamescene.haveEmptyCell();
//            //if isMove = true then ->
//            if (haveEmptyCell == -1) {
//                if (gamescene.canNotMove()) {
//                    primaryStage.setScene(endGameScene);
//
//                    EndGame.getInstance().endGameShow(endGameScene, endGameRoot, primaryStage, score);
//                    root.getChildren().clear();
//                    score = 0;
//                }
//            } else if (haveEmptyCell == 1) gamescene.randomFillNumber(2);
//        }));
//    }
//
//}
