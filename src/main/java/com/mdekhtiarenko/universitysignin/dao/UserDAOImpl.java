package com.mdekhtiarenko.universitysignin.dao;

import com.mdekhtiarenko.universitysignin.entity.User;

import java.sql.*;
import java.util.ArrayList;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Created by mykola.dekhtiarenko on 26.11.16.
 */
public class UserDAOImpl implements UserDAO{
    Connection connection = null;

    private static final String INSERT = "INSERT INTO User (name, secondName, credits, Role_idRole) VALUES ";
    private static final String SELECT = "SELECT * FROM User WHERE idUser IN ";
    private static final String Dellete = "DELETE FROM User WHERE idUser = ";
    private static final String SELECTEVERYTHING = "SELECT * FROM User";
    private static final String GETUSERDISCIPLINEIDS = "SELECT * FROM Discipline_has_User WHERE User_idUser =";
    private static final String GETDISCIPLINESNAME = "SELECT * FROM Discipline WHERE idDiscipline IN ";

    public UserDAOImpl() {
        this.connection = getConnection();
    }

    public ArrayList<User> getAllUsers() throws SQLException {

        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            String command = SELECTEVERYTHING;
            resultSet = statement.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<User> users = new ArrayList<User>();
        while (resultSet!=null&&resultSet.next()){
            users.add(new User(resultSet.getInt("idUser"), resultSet.getString("name"), resultSet.getString("secondName"), resultSet.getDouble("credits"), resultSet.getInt("Role_idRole")));

        }
        return users;
    }

    public boolean isValidUser(String username, String password) {
        String query = "Select count(1) from User where username = ? and password = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet resultSet = pstmt.executeQuery();
            if(resultSet.next())
                return (resultSet.getInt(1) > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    public User getUser(int id) throws SQLException {

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
            User result = new User(resultSet.getInt("idUser"), resultSet.getString("name"), resultSet.getString("secondName"), resultSet.getDouble("credits"), resultSet.getInt("Role_idRole"));
            setUserDisciplines(result);
            return result;
        } else return null;
    }

    public void create(User user) {

        try {
            Statement statement = connection.createStatement();
            String command = INSERT+"(";
            command+="'"+user.getName()+"', ";
            command+="'"+user.getSecondname()+"', ";
            command+="'"+user.getCredits()+"', ";
            command+="'"+user.getRoleId()+"')";
            statement.execute(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {

        try {
            Statement statement = connection.createStatement();
            statement.execute(Dellete+id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {

        String command = "UPDATE User SET ";
        command += "name = '"+user.getName()+"', ";
        command += "secondName = '"+user.getSecondname()+"', ";
        command += "credits = '"+user.getCredits()+"', ";
        command += "Role_idRole = '"+user.getRoleId()+"' ";
        command += "WHERE idUser = '"+user.getId()+"'";
        System.out.println(command);
        try {
            Statement statement = connection.createStatement();
            statement.execute(command);
            statement.close();
        } catch (MySQLIntegrityConstraintViolationException e) {
            System.out.println("Вже записаний!");
           return;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUserDisciplines(User user) throws SQLException {

        //Видобуваю ідішніки дисциплін юзвєря
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            String command = GETUSERDISCIPLINEIDS;
            command+=" ('"+user.getId()+"')";
            resultSet = statement.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> disciplinesIds = new ArrayList<Integer>();
        while (resultSet!=null&&resultSet.next()){
            disciplinesIds.add(resultSet.getInt("DIscipline_idDiscipline"));
        }

        if (resultSet!=null)
            resultSet.close();

        //видобуваю дисципліни
        ResultSet resultSetNames = null;
        if(disciplinesIds.size()>0) {
            try {
                Statement statement = connection.createStatement();
                String command = GETDISCIPLINESNAME + "(";

                for (int i = 0; i < disciplinesIds.size(); i++) {
                    command += "'" + disciplinesIds.get(i) + "', ";
                }

                command = command.substring(0, command.length() - 2) + ")";
                resultSetNames = statement.executeQuery(command);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //Запис у масив назв дисциплін
        ArrayList<String> disciplinesNames = new ArrayList<String>();
        while (resultSetNames!=null&&resultSetNames.next()){
            disciplinesNames.add(resultSetNames.getString("name"));
        }

        if (resultSetNames!=null)
            resultSetNames.close();

        user.setDisciplines(disciplinesNames);

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
