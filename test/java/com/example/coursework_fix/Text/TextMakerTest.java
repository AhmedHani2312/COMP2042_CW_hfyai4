package com.example.coursework_fix.Text;

import javafx.scene.Group;
import javafx.scene.text.Text;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextMakerTest {
    //testing if functions outputs text we put.
    @Test
    void madeText() {
        TextMaker textMaker = TextMaker.getSingleInstance();
        Group root = new Group();
        Text testString = textMaker.madeText("TestCheck", 0, 0, root);
        assertEquals("TestCheck", ((Text) testString).getText());
    }
}