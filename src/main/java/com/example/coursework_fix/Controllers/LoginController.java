/**
 * This class is responsible for user login to the game
 */
package com.example.coursework_fix.Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.coursework_fix.Account;
import com.example.coursework_fix.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class LoginController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField Password;

    @FXML
    private Button LoginButton;
    //responsible for color picker
    @FXML
    private Pane myPane;
    @FXML
    private ColorPicker myColorPicker;
    //setting a white blue color as default for GameCells
    public static String ThemeColor = "0x000000";

    /**
     * this function is responsible to change color  of cells from LoginMenu based on user preference.
     * @param event
     */
    public void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue();
        ThemeColor = String.valueOf(myColorPicker.getValue());
        myPane.setBackground(new Background(new BackgroundFill(myColor, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    /**
     * method to look through the textfile and check the username and password
     * @param event
     * @throws IOException
     */
    @FXML
    public void loginButton(ActionEvent event) throws IOException {

        //Path to text file
        Path path = Paths.get("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt");

        //Counts the number of lines inside the text file
        long count = Files.lines(path).count();

        //for loop to read each line inside textfile.
        for (int i = 0; i < count; i++) {
            String line = Files.readAllLines(path).get(i);
            if (!line.trim().equals("")) {
                //According to format Email, Password
                String[] profile = line.split(",");
                String USER = profile[0];
                String password = profile[1];
                String score = profile[2];

                //trim() method removes the space from front and behind of string if there is any
                if (USER.trim().equals(email.getText())) {
                    //checking password matches or not and gives an output based on it
                    if (password.trim().equals(Password.getText())) {
                        //creating popup if credentials given in login are correct or not
                        Alert msg = new Alert(AlertType.CONFIRMATION);
                        msg.setTitle(email.getText());
                        msg.setContentText("Your Email and password have matched");
                        msg.showAndWait();

                        //Saving the values and storing them

                        Account.setEmail(USER);
                        Account.setPassword(password);
                        Account.setScore(score);
                        System.out.println(USER);
                        System.out.println(password);
                        controller.switchMainMenu(event);
                        break; //Email match and pass match, Close loop
                    }
                }

            }
        }
        if (Account.getEmail() == null) {
            System.out.println("No such email");
            //error msg

            Alert msg = new Alert(AlertType.ERROR);
            msg.setTitle(email.getText());
            msg.setContentText("No such Email : " + email.getText());
            msg.showAndWait();
        } else if (Account.getPassword() == null) {
            System.out.println("No such email");
            Alert msg = new Alert(AlertType.ERROR);
            msg.setTitle(Password.getText());
            msg.setContentText("Wrong password");
            msg.showAndWait();

        }
    }

    Controller controller = new Controller();

    /**
     * this function allows user to click on SignUp button to Register and account into the game to be able to record his score in LeaderBoard
     * @param event
     * @throws IOException
     */
    public void SignUpButton(ActionEvent event) throws IOException {

        Controller.SceneSwitcher("SignUp.fxml", event);

    }

    /**
     * //go to main menu without  SignUp INTO the  game.
     * @param event
     * @throws IOException
     */
    public void DemoButton(ActionEvent event) throws IOException {
        Controller.SceneSwitcher("Menu.fxml", event);
    }


}