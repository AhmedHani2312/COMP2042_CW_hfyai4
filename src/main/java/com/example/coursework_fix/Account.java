package com.example.coursework_fix;

import java.util.ArrayList;

public class Account implements Comparable<Account> {

    private static String Email;

    private long score = 0;
    //added new
    //private String userName;
    private static String Password;
    private static ArrayList<Account> accounts = new ArrayList<>();

   /* public Account(String userName) {
        this.userName = userName;
    }*/

    public static void setPassword(String password) {
        Account.Password = password;
    }

    public static void setEmail(String email) {
        Account.Email = email;
    }

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    public void addToScore(long score) {
        this.score += score;
    }


    //creating get method for email
    public static String getEmail() {
        return Email;
    }

    //creating get method for password
    public static String getPassword() {
        return Password;
    }

    private long getScore() {
        return score;
    }
}


    /*static Account accountHaveBeenExist(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                return account;
            }
        }
        return null;

    }

    static Account makeNewAccount(String userName) {
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }

}*/
