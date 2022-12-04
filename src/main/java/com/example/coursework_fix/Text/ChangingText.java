// this class is created by me for refactoring purpose (function is in TextMaker class originally)

package com.example.coursework_fix.Text;

import javafx.scene.text.Text;

public class ChangingText {
    public static void changeTwoText(Text first, Text second) {
        String temp;
        temp = first.getText();
        first.setText(second.getText());
        second.setText(temp);

        double tempNumber;
        tempNumber = first.getX();
        first.setX(second.getX());
        second.setX(tempNumber);

        tempNumber = first.getY();
        first.setY(second.getY());
        second.setY(tempNumber);
    }
}
