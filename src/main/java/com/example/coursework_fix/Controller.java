package com.example.coursework_fix;
//public class Controller {
//}

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


/**
 * creates emplooyee with last name
 * The employee last name
 */

/**
 * This class is mainly used to switch between the scenes in the game
 */
public class Controller {
    public Controller() {
    }

    @FXML
    private TextField account;
    static final int WIDTH = 900;
    static final int HEIGHT = 900;
    private Stage stage;

    private static Scene scene;

    @FXML
    private Button start;
    @FXML
    private Button quit;
    /* @FXML
     RadioButton AudioOn;
     @FXML
     RadioButton AudioOff;*/
    Group gameRoot = new Group();

    GameScene game = new GameScene();

    //reference to media playerr used in SoundON and SoundOff from scene builder-settings
    Media mp3MusicFile = new Media(new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\src\\main\\resources\\com\\example\\coursework_fix\\unholy.mp3").toURI().toString());
    MediaPlayer musicplayer = new MediaPlayer(mp3MusicFile);

    // to link the login fxml page
    public void switchtoLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //this functions goes to get name
    public void switchtoMainMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("getName.fxml")); //8yr li menu law hn4el el getNamefxml
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label label;
    String acc;

    public void testSigned(ActionEvent event) {
        //to test
        label.setText("signed in");
    }

    //this function goes to main menu
    public void gobacktoMain(ActionEvent event) throws IOException {
        acc = account.getText();
        System.out.println(acc);
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //to switch to settings Menu.
    public void gobacktoSettingsMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * below switches the scene from MainMenu to the game itself
     *
     * @param event
     * @throws IOException
     */
    public void switchToGameScene(ActionEvent event) throws IOException {
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot);
        stage.show();
    }


    /**
     * this code part below will exit from the game
     *
     * @param event
     */
    public void QuitButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit Dialog");
        alert.setHeaderText("Exit this page");
        alert.setContentText("Are you sure you want to exit this page?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

    public void HelpButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Help");
        alert.setHeaderText(" -Press arrow keys to move all Tiles \n -When two tiles with the same number touch,They merge into One!It is over when the board Fills up \n -Join the numbers and Challenge yourself to get the 2048 TILE");
        alert.setContentText(" -OK to EXIT\n -Cancel to continue Playing!");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }
    /*private MediaPlayer mediaPlayer;
    public void SoundON(ActionEvent event) {
        String filename = "audio.mp3";
        if (AudioOn.isSelected()){
            String path =getClass().getResource(filename).getPath();
            File file = new File("C:\\Users\\omen\\IdeaProjects\\coursework\\src\\main\\resources\\com\\example\\demo\\audio.mp3");

            //Media media = new Media(new File(path).toURI().toString());
            Media media = new Media(file.toURI().toString());
            /*mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();*/

    /*  } else if (AudioOff.isSelected()) {
          mediaPlayer.stop();
      }*/
    //TRY THESE LINES Dr Waleed uncomment below:
    public void SoundON(ActionEvent event) {
//        musicplayer.setAutoPlay(true);
        musicplayer.play();
        musicplayer.setVolume(0.9);
    }

    public void SoundOff(ActionEvent event) {
        musicplayer.pause();
    }

}