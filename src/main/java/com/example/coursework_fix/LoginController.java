package com.example.coursework_fix;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EventObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

    public void changeColor(ActionEvent event) {
        Color myColor = myColorPicker.getValue();
        myPane.setBackground(new Background(new BackgroundFill(myColor, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    Controller controller = new Controller();


    public void SignUpButton(ActionEvent event) throws IOException {
        // use this function anywhere to switch scenes whenever a button is clicked
        // event holds the button/window/scene information
        // the string fileName is the fxml file name you want to change to
        Controller.SceneSwitcher("SignUp.fxml", event);

    }

    //go to main menu without  registering INTO the  game.
    public void DemoButton(ActionEvent event) throws IOException {
        Controller.SceneSwitcher("Menu.fxml", event);
    }


    @FXML
    public void loginButton(ActionEvent event) throws IOException { //switch to main menu
        //Path to text file
        Path path = Paths.get("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt");

        //Counts number of line in text file
        long count = Files.lines(path).count();

        /// read each line
        for (int i = 0; i < count; i++) {
            String line = Files.readAllLines(path).get(i);
            if (!line.trim().equals("")) {
                //According to format Name, Email, Password, Age, Gender
                String[] profile = line.split(",");
                String USER = profile[0];
                String password = profile[1];
                String score = profile[2];
                //Email Matched!
                if (USER.trim().equals(email.getText())) { //Note trim() method remove space from front and behind of string if there is any
                    //Now checking if password match
                    if (password.trim().equals(Password.getText())) {

                        Alert msg = new Alert(AlertType.CONFIRMATION);
                        msg.setTitle(email.getText());
                        msg.setContentText("Email and password matched");
                        msg.showAndWait();

                        //Store values

                        Account.setEmail(USER);
                        Account.setPassword(password);
                        Account.setScore(score);
                        System.out.println(USER);
                        System.out.println(password);
                        controller.switchtoMainMenu(event);
                        break; //Email match and pass match, Close loop
                    }
                }

            }
        }
        //controller.SceneSwitcher("Menu.fxml",event);
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

}