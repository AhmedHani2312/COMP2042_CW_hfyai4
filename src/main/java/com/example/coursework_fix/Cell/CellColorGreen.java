package com.example.coursework_fix.Cell;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class CellColorGreen implements CellColorBase {
    private int number;
    private Rectangle rectangle;

    public CellColorGreen(int number, Rectangle rectangle) {  //creating constructor
        this.number = number;
        this.rectangle = rectangle;
    }

    @Override
    public void setColorByNumber(int number) {
        HashMap<Integer, Color> colorMap = new HashMap<>();
        colorMap.put(0, Color.rgb(224, 226, 226, 0.5));
        colorMap.put(2, Color.rgb(23, 255, 100, 0.5));
        colorMap.put(4, Color.rgb(23, 220, 50, 0.5));
        colorMap.put(8, Color.rgb(23, 200, 44, 0.8));
        colorMap.put(16, Color.rgb(23, 170, 44, 0.8));
        colorMap.put(32, Color.rgb(18, 120, 44, 0.7));
        colorMap.put(64, Color.rgb(18, 100, 44, 0.7));
        colorMap.put(128, Color.rgb(18, 80, 44, 0.7));
        colorMap.put(256, Color.rgb(18, 60, 44, 0.8));
        colorMap.put(512, Color.rgb(18, 30, 44, 0.8));
        colorMap.put(1024, Color.rgb(25, 0, 44, 0.8));
        colorMap.put(2048, Color.rgb(25, 0, 0, 1));


        rectangle.setFill(colorMap.get(number));
    }
}
