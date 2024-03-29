package com.example.coursework_fix.Cell;

import com.example.coursework_fix.Text.ChangingText;
import com.example.coursework_fix.Text.TextMaker;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Cell {
    private Rectangle rectangle;
    private Group root;
    private Text textClass;
    private boolean modify = false;


    //Constructor for cell class

    public Cell(double x, double y, double scale, Group root) {
        rectangle = new Rectangle();
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setHeight(scale);
        rectangle.setWidth(scale);
        this.root = root;
        rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
        this.textClass = TextMaker.getSingleInstance().madeText("0", x, y, root);
        root.getChildren().add(rectangle);
    }

    public void setTextClass(Text textClass) {
        this.textClass = textClass;
    }

    /**
     * changes properties of Two cells by exchanging their text elements and colors
     * each time a move happens this function will be used
     * @param cell
     */
    public void changeCell(Cell cell) {

        ChangingText text = new ChangingText();
        text.changeTwoText(textClass, cell.getTextClass());
        root.getChildren().remove(cell.getTextClass());
        root.getChildren().remove(textClass);

        if (!cell.getTextClass().getText().equals("0")) {
            root.getChildren().add(cell.getTextClass());
        }
        if (!textClass.getText().equals("0")) {
            root.getChildren().add(textClass);
        }
        setColor(getNumber());
        cell.setColor(cell.getNumber());
    }

    /**
     * this function adds up the cells together
     * @param cell
     */
    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColor(cell.getNumber());
        setColor(getNumber());
    }

    /**
     * this function sets color from new cellColour class.
     * @param number
     */
    public void setColor(int number) {
        new CellColor(number, rectangle).setColorByNumber(number);
    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    /**
     * this setter is for Modify var.
     * @param modify
     */
    public void setModify(boolean modify) {
        this.modify = modify;
    }

    /**
     * this getter is for Modify var.
     * @return modify
     */
    public boolean getModify() {
        return modify;
    }

    private Text getTextClass() {
        return textClass;
    }
}


