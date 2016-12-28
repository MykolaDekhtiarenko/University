package com.mdekhtiarenko.universitysignin.dao;

import com.mdekhtiarenko.universitysignin.entity.Period;

import java.sql.*;

/**
 * Created by mykola.dekhtiarenko on 24.11.16.
 */
public class PeriodDAOImpl implements PeriodDAO{
    private static final String DELETE = "DELETE FROM Period";
    private static final String INSERT = "INSERT INTO Period VALUES ";

    Connection connection = null;

    public PeriodDAOImpl() {
        this.connection = getConnection();
    }

    public Period getPeriod() throws SQLException {
        ResultSet resultSet=null;
        try {

            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM period");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(resultSet!=null&&resultSet.next()) {
            Period result = new Period();
            result.setPeriod(resultSet.getString("Period"));
            return result;
        } else return null;
    }

    public void setPeriod(String period) {
        try {

            Statement statement = connection.createStatement();
            statement.execute("DELETE FROM period");
            statement.execute(INSERT+"(1, '"+period+"')");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

//    public void setToDefault() {
//        try {
//
//            Period current = getPeriod();
//            Statement statement = connection.createStatement();
//            statement.execute("DELETE FROM period");
//
//            statement.execute(INSERT + "('" + Period.PREPARATORY + "')");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

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
