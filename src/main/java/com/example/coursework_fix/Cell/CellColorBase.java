/**
 *  inheritance created so in the future it is easy to change the color of the GameCells
 *  this interface is responsible for changing the color inr the future to improve game basically .Eg:CellColorGreen Class.
 */

/*
  //function to set color from new cellColour class refactored ,
    public void setColor(int number) {
        new CellColor(number, rectangle).setColorByNumber(number);
    }
    */
package com.example.coursework_fix.Cell;

/**
 * interface creation(CellColor Class).
 */
public interface CellColorBase {
    void setColorByNumber(int number);
}
