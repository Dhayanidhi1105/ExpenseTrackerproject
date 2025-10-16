package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConfig {

    static String URL =AppConfig.get("db.url");
    static String DBNAME =AppConfig.get("db.name");
    static String USER = AppConfig.get("db.username");
    static String PASSWORD = AppConfig.get("db.password");

    public static void createDatabase() {
        String sql = "CREATE DATABASE IF NOT EXISTS " + DBNAME;
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement()) {
            st.executeUpdate(sql);
//            System.out.println("Database created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables() {
        String userTable = "CREATE TABLE IF NOT EXISTS User (" +
                "user_id INT AUTO_INCREMENT PRIMARY KEY," +
                "user_name VARCHAR(50) UNIQUE," +
                "user_password VARCHAR(50)" +
                ")";
        String expenseTable = "CREATE TABLE IF NOT EXISTS Expense (" +
                "expense_id INT AUTO_INCREMENT PRIMARY KEY," +
                "user_id INT NOT NULL," +
                "date DATE NOT NULL," +
                "description VARCHAR(255)," +
                "amount DOUBLE NOT NULL," +
                "FOREIGN KEY (user_id) REFERENCES User(user_id)" +
                ")";
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(userTable);
            st.executeUpdate(expenseTable);
//            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String dbUrl = URL;
        return DriverManager.getConnection(dbUrl, USER, PASSWORD);
    }
}
