package com.example.coursework_fix;

import java.util.ArrayList;

public class Account {

    private static String Email;

    private static String score;
    //added new
    //private String userName;
    private static String Password;
    private static ArrayList<Account> accounts = new ArrayList<>();

    /**
     * setter for user email
     *
     * @param email
     */
    public static void setEmail(String email) {
        Account.Email = email;
    }

    /**
     * setter for user password
     *
     * @param password
     */
    public static void setPassword(String password) {
        Account.Password = password;
    }


    /**
     * setter for score
     *
     * @param score
     */
    public static void setScore(String score) {
        Account.score = score;
    }

    /**
     * getter for email
     *
     * @return
     */
    //creating get method for email
    public static String getEmail() {
        return Email;
    }

    /**
     * getter for password
     *
     * @return
     */
    //creating get method for password
    public static String getPassword() {
        return Password;
    }

    /**
     * getter for Score
     *
     * @return
     */
    public static String getScore() {
        return score;
    }
}


