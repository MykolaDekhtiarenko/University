package com.mdekhtiarenko.universitysignin.dao;

import com.mdekhtiarenko.universitysignin.entity.Discipline;
import com.mdekhtiarenko.universitysignin.entity.User;

import java.sql.*;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

/**
 * Created by mykola.dekhtiarenko on 26.11.16.
 */
public class Discipline_has_UserDAOImpl implements Discipline_has_UserDAO {
    Connection connection = null;
    private static final String INSERT = "INSERT INTO Discipline_has_User VALUES ";

    public Discipline_has_UserDAOImpl() {
        this.connection = getConnection();
    }

    public void signIn(int userId, int disciplineId) throws SQLException {

        DisciplineDAOImpl ddi = new DisciplineDAOImpl();
        UserDAOImpl udi = new UserDAOImpl();

        User student = udi.getUser(userId);
        Discipline discipline = ddi.getDiscipline(disciplineId);

        if(student!=null&&discipline!=null){
            //TODO: тут не забути провести перевірку на роль!!!
            if(true){
                ResultSet resultSet = null;
                try {
                    Statement statement = connection.createStatement();
                    String command = INSERT+"(";
                    command+="'"+discipline.getId()+"', ";
                    command+="'"+student.getId()+"'";
                    command+=")";
                    System.out.println(command);
                    statement.execute(command);
                    student.setCredits(student.getCredits()+discipline.getCredits());
                    udi.updateUser(student);
                } catch (MySQLIntegrityConstraintViolationException e) {
                    //e.printStackTrace();
                    System.out.println("Already signed in!");
                    return;
                }

            }
            else{
                //TODO: тут не забути провести перевірку на роль!!!
            }


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

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (connection == null)
                connection = DriverManager.getConnection("jdbc:mysql://localhost/university", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
