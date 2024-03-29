//cellColour class added for refactoring moved from cell class.
package com.example.coursework_fix.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.HashMap;

/**
 * this class is responsible for color of cells in game
 */
public class CellColor implements CellColorBase {
    private int number;
    private Rectangle rectangle;

    /**
     * This function is responsible for cellColor in game
     * @param number
     * @param rectangle
     */
    public CellColor(int number, Rectangle rectangle) {  //creating constructor
        this.number = number;
        this.rectangle = rectangle;
    }

    /**
     * hash map created as a method of refactoring to allow improvements in the future.eg. want to increase number like 4996 and easy to change colors
     * moved all switch statements to hash map so we just have one call of setFill()
     * this is faster than going through every single switch statement to get to the desired one
     *
     * @param number
     */
    @Override

    public void setColorByNumber(int number) {
        HashMap<Integer, Color> colorMap = new HashMap<>();
        colorMap.put(0, Color.rgb(224, 226, 226, 0.5));
        colorMap.put(2, Color.rgb(232, 255, 100, 0.5));
        colorMap.put(4, Color.rgb(232, 220, 50, 0.5));
        colorMap.put(8, Color.rgb(232, 200, 44, 0.8));
        colorMap.put(16, Color.rgb(232, 170, 44, 0.8));
        colorMap.put(32, Color.rgb(180, 120, 44, 0.7));
        colorMap.put(64, Color.rgb(180, 100, 44, 0.7));
        colorMap.put(128, Color.rgb(180, 80, 44, 0.7));
        colorMap.put(256, Color.rgb(180, 60, 44, 0.8));
        colorMap.put(512, Color.rgb(180, 30, 44, 0.8));
        colorMap.put(1024, Color.rgb(250, 0, 44, 0.8));
        colorMap.put(2048, Color.rgb(250, 0, 0, 1));


        rectangle.setFill(colorMap.get(number));
    }
}
