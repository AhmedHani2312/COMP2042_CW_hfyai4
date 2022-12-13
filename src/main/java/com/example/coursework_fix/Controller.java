package com.example.coursework_fix;

import com.example.coursework_fix.Gameplay.GameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


/**
 * creates emplooyee with last name
 * The employee last name
 */

/**
 * This class is mainly used to switch between the scenes in the game
 */
public class Controller implements Initializable {
    public Object SceneSwitcher;

    //reads highscore in listview(leaderboard in game)
    FileChooser fileChooser = new FileChooser();
    @FXML
    private TextArea textArea;

    @FXML
    public void getText(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (file.exists()) {
            List<String> Load;
            try {
                Load = Files.readAllLines(file.toPath());
                HighScoreList.getItems().addAll(Load);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private ListView<String> HighScoreList = new ListView<>();

    File file = new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt\\");

    public Controller() {
    }

    @FXML
    private TextField account;
    static final int WIDTH = 900;
    static final int HEIGHT = 900;
    static Stage stage;

    private static Scene scene;
    private static Scene gScene; //another copy of game scene

    @FXML
    private Button start;
    @FXML
    private Button quit;


    Group gameRoot = new Group();

    GameScene game = new GameScene();

    //reference to media player used in SoundON and SoundOff from scene builder-settings
    Media mp3MusicFile = new Media(new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\src\\main\\resources\\com\\example\\coursework_fix\\UNHOLY.mp3").toURI().toString());
    MediaPlayer musicplayer = new MediaPlayer(mp3MusicFile);

    public static void SceneSwitcher(String fileName, ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(Controller.class.getResource(fileName));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private Label label;
    String acc;

    //this functions goes to get name
    public void switchtoMainMenu(ActionEvent event) throws IOException {
        SceneSwitcher("Menu.fxml", event);
    }


    //to switch to settings Menu.
    public void gobacktoSettingsMenu(ActionEvent event) throws IOException {
        SceneSwitcher("Settings.fxml", event);
    }


    /**
     * below switches the scene from MainMenu to the game itself
     *
     * @param event
     * @throws IOException
     */
    public void switchToGameScene(ActionEvent event) throws IOException {
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.RED);
        scene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(160, 150, 200));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        //gScene=gameScene; //gets copy of scene
        game.game(scene, gameRoot, stage, endGameScene, endgameRoot);
        stage.show();
    }

    //pause menu
    public void switchToPauseMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Pause.fxml"));
        //stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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

    public void leaderBoardButton(ActionEvent event) throws IOException {
        SceneSwitcher("leaderBoard.fxml", event);
    }


    //pause menu button related
    public void RestartButton(ActionEvent event) {
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.RED);
        scene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(160, 150, 200));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        //gScene=gameScene; //gets copy of scene
        game.game(scene, gameRoot, stage, endGameScene, endgameRoot);
        stage.show();

    }

    //sign up button to create an email from login menu
    public void SignUpButton(ActionEvent event) throws IOException {
        SceneSwitcher("SignUp.fxml", event);
    }


    public void BackButton(ActionEvent event) throws IOException {
        SceneSwitcher("Menu.fxml", event);
    }

    public void BacktoLoginMenu(ActionEvent event) throws IOException {
        SceneSwitcher("Login.fxml", event);
    }


    public void SoundON(ActionEvent event) {
        musicplayer.play();
        musicplayer.setVolume(0.9);
    }

    public void SoundOff(ActionEvent event) {
        musicplayer.pause();
    }

}
