package com.example.coursework_fix;

import com.example.coursework_fix.Controllers.LoginController;
import com.example.coursework_fix.Gameplay.Game;
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
import javafx.scene.paint.Paint;
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
 * creates employee with last name
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
    private TextField account;
    static final int WIDTH = 900;
    static final int HEIGHT = 900;
    static Stage stage;
    @FXML
    private ListView<String> HighScoreList = new ListView<>();

    File file = new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt\\");

    private static Scene scene;

    @FXML
    public void getText(MouseEvent mouseEvent) {
    }

    private static Scene gScene; //another copy of game scene

    @FXML
    private Button start;
    @FXML
    private Button quit;

    @FXML
    private Label label;
    String acc;

    Group gameRoot = new Group();

    Game game = new Game();

    //reference to media player used in SoundON and SoundOff from scene builder-settings
    Media mp3MusicFile = new Media(new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\src\\main\\resources\\com\\example\\coursework_fix\\GameMusic.mp3").toURI().toString());
    MediaPlayer musicplayer = new MediaPlayer(mp3MusicFile);

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


    /**
     *
     * use this function anywhere to switch scenes whenever a button is clicked
     * event holds the button/window/scene information
     * the string fileName is the fxml file name you want to change to
     *
     * @param fileName
     * @param event
     */
    public static void SceneSwitcher(String fileName, ActionEvent event)  {
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


    /**
     *this functions goes to get name and switches to MainMenu
     * @param event
     * @throws IOException
     */

    public void switchMainMenu(ActionEvent event) throws IOException {
        SceneSwitcher("Menu.fxml", event);
    }

    /**
     * This functions switches to SettingsMenu from Main Menu
     * @param event
     */
    public void gobacktoSettingsMenu(ActionEvent event)  {
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
        //to link theme color with gamscene.
        scene = new Scene(gameRoot, WIDTH, HEIGHT, Paint.valueOf(LoginController.ThemeColor));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        //gScene=gameScene; //gets copy of scene
        game.game(scene, gameRoot, stage, endGameScene, endgameRoot);
        stage.show();
    }

    //pause menu

    /**
     * Method for event handler, to go to the Pause stage after clicking on the ESC button on the keyboard
     * @throws IOException
     */
    public void switchToPauseMenu() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Pause.fxml"));
        //stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method for event handler ,it will go to exit stage
     *
     * @param event
     */
    public void QuitButton(ActionEvent event) {
        showPopup("Quit Dialog", "Exit this page", "Are you sure you want to exit this page?");
    }

    /**
     * This method is created to give user Help about how to play the game when Help button in Main menu is clicked
     * @param event
     */
    public void HelpButton(ActionEvent event) {
        showPopup("Help", " -Press arrow keys to move all Tiles \n -When two tiles with the same number touch,They merge into One!It is over when the board Fills up \n -Join the numbers and Challenge yourself to get the 2048 TILE", " -OK to EXIT\n -Cancel to continue Playing!");
    }

    /**
     * This method is responsible for allowing user to access the Leaderboard to view his last score attained.
     * @param event
     * @throws IOException
     */
    public void leaderBoardButton(ActionEvent event) throws IOException {
        SceneSwitcher("Leaderboard.fxml", event);
    }

    /**
     * this function is created to make a restart button for the user in Pause menu in case he wants to start a new game
     * @param event
     */
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

    /**
     * responsible for playing audio in game
     * @param event
     */
    public void SoundON(ActionEvent event) {
        musicplayer.play();
        musicplayer.setVolume(0.9);
    }

    /**
     * responsible for switching off audio in game
     * @param event
     */
    public void SoundOff(ActionEvent event) {
        musicplayer.pause();
    }

    //added HelpButton , QuitButton and leaderboardButton to endGame PopUpMenu

    /**
     * function responsible for the popup menu in endGame
     * @param title
     * @param headerText
     * @param contentText
     */
    private void showPopup(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        }
    }
}
