package com.example.coursework_fix.Text;

import com.example.coursework_fix.Gameplay.GameScene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextMaker {
    private static TextMaker singleInstance = null;

    private TextMaker() {

    }

    /**
     * singleton to instantiate Textmaker
     * @return
     */
    public static TextMaker getSingleInstance() {
        if (singleInstance == null)
            singleInstance = new TextMaker();
        return singleInstance;
    }

    /**
     * generates text displayed on the cell
     * @param input
     * @param xCell
     * @param yCell
     * @param root
     * @return
     */
    public Text madeText(String input, double xCell, double yCell, Group root) {
        double length = GameScene.getLENGTH();
        double fontSize = (3 * length) / 7.0;
        Text text = new Text(input);
        text.setFont(Font.font(fontSize));
        text.relocate((xCell + (1.2) * length / 7.0), (yCell + 2 * length / 7.0));
        text.setFill(Color.WHITE);

        return text;
    }

}
