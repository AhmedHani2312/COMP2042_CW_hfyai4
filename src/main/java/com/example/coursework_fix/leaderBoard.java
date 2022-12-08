package com.example.coursework_fix;
        import java.io.*;
        import java.nio.file.Files;
        import java.nio.file.StandardOpenOption;
        import java.util.List;
        import java.util.stream.Collectors;

public class leaderBoard {
    public void updateHighscore(Long newscore){
        try {
            String username = Account.getEmail();
            Long BestScore = Long.valueOf(Account.getScore()); //get the previous high score in the file
            File file = new File("C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            System.out.println("fuck this is working");
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
                        deleteLine(PreviousLine,"C:\\Users\\omen\\IdeaProjects\\coursework_fix\\TextFiles\\data.txt");
                        writer.close();
                        break;
                    }
                }
            }

        }

        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void deleteLine(String lineContent,String filepath) throws IOException
    {
        File file = new File(filepath);
        List<String> out = Files.lines(file.toPath())
                .filter(line -> !line.contains(lineContent))
                .collect(Collectors.toList());
        Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
