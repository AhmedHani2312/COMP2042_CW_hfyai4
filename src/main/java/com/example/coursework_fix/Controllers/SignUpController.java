/**
 * //this class is responsible for signup menu
 */
package com.example.coursework_fix.Controllers;

import com.example.coursework_fix.Account;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class SignUpController implements Initializable {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        email.setText(Account.getEmail());

        password.setText(Account.getPassword());

        if (Account.getEmail() != null) {
            email.setDisable(true);
            password.setDisable(true);
        }
    }

    /**
     * add a line in the text file containing the username and password of the user
     */
    private void addLine() {

        String line = email.getText() + "," + password.getText() + "," + "0" + "\n";

        FileWriter file_writer;
        try {
            file_writer = new FileWriter("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt", true);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
            buffered_Writer.write(line);
            buffered_Writer.close();
            file_writer.close();

        } catch (IOException e) {
            System.out.println("Add line failed!!" + e);
        }
        System.out.println("working");

    }

    /**
     * function works when user click Create account after signup to send credentials to text file
     * @param actionEvent
     */
    public void CreateAccClicked(ActionEvent actionEvent) {
        email.setDisable(true);
        password.setDisable(true);

        addLine();
    }



    /**
     * this function is created to return  from SignUpMenu to MainMenu.
     * @param event
     * @throws IOException
     */
    public void LoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}




