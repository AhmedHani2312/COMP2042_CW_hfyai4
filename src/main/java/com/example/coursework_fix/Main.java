/**
 * Represents the game.
 *
 * @author Ahmed Hani Ahmed Ibrahim Moustsafa
 *
 */

package com.example.coursework_fix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.Scanner;
//This main class will be used to show the whole logic of the game when we run it
public class Main extends Application {
    static final int WIDTH = 900; //width var
    static final int HEIGHT = 900;//height var
    GameScene game = new GameScene();
    private Group gameRoot = new Group(); // object that stores all nodes in Scene graph
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92)); // game scene to take width and height of the squares passed as parameters(the game properties). game root will be assigned to Scene object
    private static Scanner input= new Scanner(System.in); //allows getting input from user

    public Main() throws IOException {
    }

    /**
     * setter method for private group GameScene
     * @param gameScene
     */

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    } // used to set game scene and assign width and height of the square to the new Scene project

    /**
     * setter method for private group gameRoot
     * @param gameRoot
     */
    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    } //

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception { //declaring exceptions that can occur while executing program
        Group menuRoot = new Group();
       // Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        Group rankRoot = new Group();
        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);


        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);

        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);
        accountRoot.getChildren().add(backgroundOfMenuForPlay);

        //TO LINK SCENE
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));//ii
        Scene scene =new Scene(root);//ii
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        setGameScene(gameScene);

        primaryStage.setScene(scene);
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
        primaryStage.show();
        //
    }


    // linking scene builder

   //stage.setScene(scene);
   //stage.show();


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
