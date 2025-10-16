package org.example.dao;

import org.example.config.AppConfig;
import org.example.config.DatabaseConfig;
import org.example.model.User;

import java.sql.*;

public class UserDAO {
    public boolean register(User user) throws SQLException {
        String check = "SELECT * FROM User WHERE user_name = ?";
        String insert = "Insert into User (user_name,user_password) values (?,?)";
        try {
            Connection connection = DatabaseConfig.getConnection();
            // Check if the username already exists
            PreparedStatement ps = connection.prepareStatement(check);
            ps.setString(1, user.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false; // Username already exists
            }
            // Insert new user record into database
            PreparedStatement preparedStatement=connection.prepareStatement(insert);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }
    public  boolean login(User user) throws SQLException {
        String check="select * from User where user_name=? and user_password=?";
        try{
            Connection connection=DatabaseConfig.getConnection();
            PreparedStatement ps=connection.prepareStatement(check);
            ps.setString(1,user.getName());
            ps.setString(2, user.getPassword());
            ResultSet rs= ps.executeQuery();
            return rs.next(); // Returns true if a matching record is found
        }catch (SQLException e){
            e.printStackTrace();
            return false;

        }

    }
}
