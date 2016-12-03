package com.mdekhtiarenko.universitysignin.spring.delegate;

/**
 * Created by mykola.dekhtiarenko on 03.12.16.
 */

import com.mdekhtiarenko.universitysignin.dao.UserDAOImpl;

import java.sql.SQLException;


public class LoginDelegate {
    private UserDAOImpl userService;

    public UserDAOImpl getUserService() {
        return this.userService;
    }

    public void setUserService(UserDAOImpl userService) {
        this.userService = userService;
    }

    public boolean isValidUser(String username, String password) throws SQLException {
        return userService.isValidUser(username, password);
    }
}
