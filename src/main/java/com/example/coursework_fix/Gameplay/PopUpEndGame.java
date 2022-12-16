package com.example.coursework_fix.Gameplay;

import com.example.coursework_fix.Controller;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpEndGame {
    private static PopUpEndGame singleInstance = null;

    /**
     * singleton design pattern , instantiates end game show.
     * @return
     */
    public static PopUpEndGame getInstance() {
        if (singleInstance == null)
            singleInstance = new PopUpEndGame();
        return singleInstance;
    }

    /**
     * This function is responsible for the popup menu after user loses the game(endGame).
     * also, responsible for the button(Quit,Restart,MainMenu)if user wants to continue the game
     * @param root
     * @param primaryStage
     * @param PopUpScore
     * @param score
     */
    public void endGameShow(Group root, Stage primaryStage, Stage PopUpScore, long score) {
        primaryStage.close();
        //responsible for pop up menu
        PopUpScore.initModality(Modality.APPLICATION_MODAL);
        VBox vBox = new VBox();
        vBox.setSpacing(10);


        Button restartButton = new Button();
        restartButton.setText("Restart Game");
        restartButton.setPrefSize(250, 30);
        restartButton.setTextFill(Color.GREEN);
        restartButton.setFont(Font.font(15));
        root.getChildren().add(restartButton);
        Button quitButton = new Button();
        quitButton.setText("Quit Game");
        quitButton.setPrefSize(250, 30);
        quitButton.setTextFill(Color.GREEN);
        quitButton.setFont(Font.font(15));
        root.getChildren().add(quitButton);
        quitButton.setOnAction(e -> {
            PopUpScore.close();

        });
        Button mainMenuButton = new Button();
        mainMenuButton.setText("Back to Main Menu");
        mainMenuButton.setPrefSize(250, 30);
        mainMenuButton.setTextFill(Color.GREEN);
        mainMenuButton.setFont(Font.font(15));
        root.getChildren().add(mainMenuButton);
        mainMenuButton.setFocusTraversable(false);
        mainMenuButton.setOnAction(e -> {
            try {
                new Controller().switchMainMenu( e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            primaryStage.close();

        });
        restartButton.setOnAction(e -> {
            try {
                new Controller().switchToGameScene(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        Text scoreText = new Text("GAME OVER! \n SCORE: " + score+"\n");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(210, 210);
        scoreText.setFont(Font.font(60));
        //responsible for pop up menu in endGame
        vBox.getChildren().addAll(scoreText, restartButton, mainMenuButton, quitButton);
        vBox.relocate(0, 0);
        vBox.setAlignment(Pos.CENTER);
        Scene endGamePop = new Scene(vBox, 550, 660,Color.rgb(199,188,166));


        PopUpScore.setScene(endGamePop);
        PopUpScore.show();
    }
}
