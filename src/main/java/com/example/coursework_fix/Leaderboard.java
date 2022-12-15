package com.example.coursework_fix;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Leaderboard implements Initializable {
    @FXML
    private ListView<String> HighScoreList = new ListView<>();

    File file = new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt\\");

    public void updateHighscore(Long newscore) {
        try {
            String username = Account.getEmail();
            Long BestScore = Long.valueOf(Account.getScore()); //get the previous high score in the file
            File file = new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(username)) {
                    String[] profile = line.split(",");
                    System.out.println(newscore);
                    if (newscore > BestScore) {
                        System.out.println(newscore);
                        System.out.println(line);
                        String PreviousLine = line;
                        line = line.replace(profile[2], Long.toString(newscore));
                        System.out.println(line);
                        FileWriter writer = new FileWriter("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt", true);
                        writer.write(line);
                        deleteLine(PreviousLine, "C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt");
                        writer.close();
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteLine(String lineContent, String filepath) throws IOException {
        File file = new File(filepath);
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void switchtoMainMenu(ActionEvent event) throws IOException {
        Controller.SceneSwitcher("Menu.fxml", event);
    }

    public void initialize(URL location, ResourceBundle resources) {
        if (file.exists()) {
            List<String> Load = new ArrayList<>();
            Path path = Paths.get(file.toURI());
            try {
                long count = Files.lines(path).count();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                for (int i = 0; i < count; i++) {
                    String line = Files.readAllLines(path).get(i);

                    //System.out.println(line);
                    String[] profile = line.split(",");


                    String user = profile[0];
                    String score = profile[2];
                    System.out.println(user);
                    System.out.println(score);
                    HighScoreList.getItems().addAll(user + "\t" + score);
                    HighScoreList.getItems().addAll(Load);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
