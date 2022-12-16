/**
 * @author Ahmed Hani Ahmed Ibrahim Moustsafa,20265505
 * This main class will be used to show the whole logic of the game when we run it
 */
package com.example.coursework_fix;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * Shows the game Graphical user interfaces and objects in the Primary Stage
 */
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
     * This method is to start the 2048 App
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
