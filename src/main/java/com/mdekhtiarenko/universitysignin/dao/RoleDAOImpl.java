package com.mdekhtiarenko.universitysignin.dao;

import com.mdekhtiarenko.universitysignin.entity.User;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.*;

/**
 * Created by mykola.dekhtiarenko on 27.11.16.
 */
public class RoleDAOImpl implements RoleDAO {
    Connection connection = null;

    private static final String SELECT = "SELECT * FROM Role WHERE idRole IN ";

    public RoleDAOImpl() {
        this.connection = getConnection();
    }

    public String getRole(int id) throws SQLException {

        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            String command = SELECT+"(";
            command+="'"+id+"'";
            command+=")";
            resultSet = statement.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(resultSet!=null&&resultSet.next()) {
            String role = resultSet.getString("name");
            return role;
        } else return null;
    }

    public void changeRole(int id, String role) {

        String command = "UPDATE Role SET ";
        command += "name = '"+role+"' ";
        command += "WHERE idRole = '"+id+"'";

        try {
            Statement statement = connection.createStatement();
            statement.execute(command);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            //do nothing
        }
    }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost/university", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
