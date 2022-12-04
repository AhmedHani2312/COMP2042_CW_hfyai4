/**
 * Represents the game.
 *
 * @author Ahmed Hani Ahmed Ibrahim Moustsafa
 *
 */

package com.example.coursework_fix;

import com.example.coursework_fix.Gameplay.GameScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
      //c1 Group accountRoot = new Group();
      //c1 Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
      //c1 Group getAccountRoot = new Group();
      //c1 Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
      //c1 Group endgameRoot = new Group();
      //c1 Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
      //c1 Group rankRoot = new Group();
      //c1 Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
      //c1 BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
      //c1 Background background = new Background(background_fill);


      //c1 Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
      //c1 backgroundOfMenu.setX(WIDTH / 2 - 120);
      //c1 backgroundOfMenu.setY(180);
      //c1 menuRoot.getChildren().add(backgroundOfMenu);

       //c2 Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
       //c2 backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
       //c2 backgroundOfMenuForPlay.setY(180);
       //c2 accountRoot.getChildren().add(backgroundOfMenuForPlay);

        //TO LINK SCENE
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));//ii
        Scene scene =new Scene(root);//ii
        Group gameRoot = new Group();
        setGameRoot(gameRoot);
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        setGameScene(gameScene);

        primaryStage.setScene(scene);
        //c3 game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
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
