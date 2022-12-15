//in the future if me or another engineer to make another class for different cell colors in the future, this interface is responsible for changing the color to what user wants.Eg:CellColorGreen.
/*
  //function to set color from new cellColour class refactored ,
    public void setColor(int number) {
        new CellColor(number, rectangle).setColorByNumber(number);
    }
    */
package com.example.coursework_fix.Cell;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public interface CellColorBase {
    // moved all switch statements to hash map so we just have one call of setFill()
    // this is faster than going through every single switch statement to get to the desired one
    void setColorByNumber(int number);
}
