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

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    public boolean getModify() {
        return modify;
    }

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

    public void adder(Cell cell) {
        cell.getTextClass().setText((cell.getNumber() + this.getNumber()) + "");
        textClass.setText("0");
        root.getChildren().remove(textClass);
        cell.setColor(cell.getNumber());
        setColor(getNumber());
    }

    //function to set color from new cellColour class refactored ,
    public void setColor(int number) {
        new CellColor(number, rectangle).setColorByNumber(number);
    }
/*void setColorByNumber(int number) {
    switch (number) {
        case 0:
            rectangle.setFill(Color.rgb(224, 226, 226, 0.5));
            break;
        case 2:
            rectangle.setFill(Color.rgb(232, 255, 100, 0.5));
            break;
        case 4:
            rectangle.setFill(Color.rgb(232, 220, 50, 0.5));
            break;
        case 8:
            rectangle.setFill(Color.rgb(232, 200, 44, 0.8));
            break;
        case 16:
            rectangle.setFill(Color.rgb(232, 170, 44, 0.8));
            break;
        case 32:
            rectangle.setFill(Color.rgb(180, 120, 44, 0.7));
            break;
        case 64:
            rectangle.setFill(Color.rgb(180, 100, 44, 0.7));
            break;
        case 128:
            rectangle.setFill(Color.rgb(180, 80, 44, 0.7));
            break;
        case 256:
            rectangle.setFill(Color.rgb(180, 60, 44, 0.8));
            break;
        case 512:
            rectangle.setFill(Color.rgb(180, 30, 44, 0.8));
            break;
        case 1024:
            rectangle.setFill(Color.rgb(250, 0, 44, 0.8));
            break;
        case 2048:
            rectangle.setFill(Color.rgb(250,0,0,1));


    }*/
//    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public int getNumber() {
        return Integer.parseInt(textClass.getText());
    }

    private Text getTextClass() {
        return textClass;
    }

}

