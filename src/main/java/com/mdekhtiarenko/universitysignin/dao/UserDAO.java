package com.mdekhtiarenko.universitysignin.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import com.mdekhtiarenko.universitysignin.entity.User;

public interface UserDAO {
	   public ArrayList<User> getAllUsers() throws SQLException;

	   public User getUser(int id) throws SQLException;
	   public void delete(int id);
	   public void create(User user);
	   public void updateUser(User user);
	   public User isValidUser(String username, String password);
	   public void setUserDisciplines(User user) throws SQLException;
}
