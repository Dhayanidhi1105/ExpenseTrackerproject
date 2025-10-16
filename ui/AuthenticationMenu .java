package org.example.ui;

import org.example.config.DatabaseConfig;
import org.example.model.User;
import org.example.service.AuthenticationService;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthenticationMenu {
    public  AuthenticationMenu(){
        //Create database and tables
        DatabaseConfig.createDatabase();
        DatabaseConfig.createTables();
    }
    AuthenticationService authenticationService = new AuthenticationService();
    static Scanner sc = new Scanner(System.in);

    public boolean registerOrLogin() throws SQLException {
        //Displays a menu for user registration or login
        boolean itr=true;
        while(itr){
            System.out.println("Enter your choice:");
            System.out.println("a. Register");
            System.out.println("b. Login");
            System.out.println("c. Exit");
            char choice = sc.next().charAt(0);
            if(choice=='c'){
                return false;
            }
            sc.nextLine();
            System.out.println("Enter the username: ");
            String username=sc.nextLine();
            System.out.println("Enter the password: ");
            String password=sc.nextLine();
            switch (choice) {
                case 'a':
                    if (authenticationService.register(new User(username, password))) {
                        System.out.println("Registration success :");
                    } else {
                        System.out.println("Registration failed");
                    }
                    break;
                case 'b':
                    if (authenticationService.login(new User(username, password))){
                        return true;
                    } else {
                        System.out.println("Login failed Try again");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        return false;
    }

}
