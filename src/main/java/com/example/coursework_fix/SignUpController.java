//this class is responsible for signup menu

package com.example.coursework_fix;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

        if (Account.getEmail() != null){
            email.setDisable(true);
            password.setDisable(true);
        }

    }


    private void addLine() {
        String line = "\n"+ email.getText() + "," + password.getText() + ","+"0"+"\n";

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



    public void CreateACCclicked(ActionEvent actionEvent) {
        email.setDisable(true);
        password.setDisable(true);


        addLine();
    }

    //this function is created to return  from SignUpMenu to MainMenu.
    public void LoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}




