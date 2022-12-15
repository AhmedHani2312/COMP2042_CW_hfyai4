/**
 * Represents the game.
 *
 * @author Ahmed Hani Ahmed Ibrahim Moustsafa
 *
 */

package com.example.coursework_fix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//This main class will be used to show the whole logic of the game when we run it
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception { //declaring exceptions that can occur while executing program
        //TO LINK SCENE
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));//ii
        Scene scene =new Scene(root);//ii
        primaryStage.setScene(scene);
        primaryStage.show();
        //
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
