package com.example.coursework_fix;

import java.util.ArrayList;

public class Account  {

    private static String Email;

    private static String score ;
    //added new
    //private String userName;
    private static String Password;
    private static ArrayList<Account> accounts = new ArrayList<>();

    public static void setPassword(String password) {
        Account.Password = password;
    }

    public static void setEmail(String email) {
        Account.Email = email;
    }

    public static void setScore(String score){
        Account.score = score;
    }

    //creating get method for email
    public static String getEmail() {
        return Email;
    }

    //creating get method for password
    public static String getPassword() {
        return Password;
    }

    public static String getScore() {
        return score;
    }
}


