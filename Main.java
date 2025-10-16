package org.example;


import org.example.config.DatabaseConfig;


import java.sql.SQLException;
import java.util.Scanner;
import org.example.ui.AuthenticationMenu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(" ExpenseTracker ");
        AuthenticationMenu authenticationMenu=new AuthenticationMenu();
        boolean login=authenticationMenu.registerOrLogin();
        if(login){
            System.out.println("Further ");
        }else {
            System.out.println("Try again ");
        }
    }
}
