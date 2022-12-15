package com.example.coursework_fix.Cell;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public interface CellColorBase {
    // moved all switch statements to hash map so we just have one call of setFill()
    // this is faster than going through every single switch statement to get to the desired one
    void setColorByNumber(int number);
}
