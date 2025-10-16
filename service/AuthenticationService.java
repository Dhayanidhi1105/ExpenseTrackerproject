package org.example.service;

import org.example.config.DatabaseConfig;
import org.example.dao.UserDAO;
import org.example.model.User;

import java.sql.SQLException;

public class AuthenticationService {
    UserDAO userDAO = new UserDAO();
    public boolean register(User user) throws SQLException {
        if (user.getName().isEmpty()) {
            return false;
        }
        return userDAO.register(user); //return true if registration succeeds
    }

    public boolean login(User user) throws SQLException {
        if (user.getName().isEmpty()) {
            return false;
        }
        return userDAO.login(user);//true if login is successful
    }

}

