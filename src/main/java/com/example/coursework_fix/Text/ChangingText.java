/**
 * this class is created by me for refactoring purpose (function is in TextMaker class originally)
 * helps changing text like if there is cell 2 and 2 and we join them together it becomes 4
 */

package com.example.coursework_fix.Text;

import javafx.scene.text.Text;

/**
 * Changes the text when cells get added up
 */
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
