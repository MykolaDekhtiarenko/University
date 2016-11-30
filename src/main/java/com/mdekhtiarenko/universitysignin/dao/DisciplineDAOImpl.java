package com.mdekhtiarenko.universitysignin.dao;

import com.mdekhtiarenko.universitysignin.entity.Discipline;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mykola.dekhtiarenko on 25.11.16.
 */
public class DisciplineDAOImpl implements DisciplineDAO{
    Connection connection = null;

    private static final String INSERT = "INSERT INTO Discipline (name, description, teacher, recommended, credits) VALUES ";
    private static final String SELECT = "SELECT * FROM Discipline WHERE idDiscipline IN ";
    private static final String Dellete = "DELETE FROM Discipline WHERE idDiscipline = ";
    private static final String SELECTEVERYTHING = "SELECT * FROM Discipline";
    private static final String GETDISCIPLINESTUDEBTSIDS = "SELECT * FROM Discipline_has_User WHERE Discipline_idDiscipline =";
    private static final String GETUSERSNAME = "SELECT * FROM User WHERE idUser IN ";

    public DisciplineDAOImpl() {
        this.connection = getConnection();
    }

    public ArrayList<Discipline> getAllDiscipline() throws SQLException {

        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            String command = SELECTEVERYTHING;
            resultSet = statement.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
        while (resultSet!=null&&resultSet.next()){
            disciplines.add(new Discipline(resultSet.getInt("idDiscipline"), resultSet.getString("name"), resultSet.getBoolean("recommended"), resultSet.getDouble("credits")));
        }
        System.out.println(disciplines.size());
        return disciplines;
    }

    public Discipline getDiscipline(int id) throws SQLException {

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
            Discipline result = new Discipline(resultSet.getInt("idDiscipline"), resultSet.getString("name"), resultSet.getBoolean("recommended"), resultSet.getDouble("credits"));
            return result;
        } else return null;
    }

    public void create(Discipline discipline) {

        try {
            Statement statement = connection.createStatement();
            String command = INSERT+"(";
            command+="'"+discipline.getName()+"', ";
            command+="'"+discipline.isRecommendedToSQL()+"', ";
            command+="'"+discipline.getCredits()+"')";
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

    public void updateDiscipline(Discipline discipline) {

        String command = "UPDATE Discipline SET ";
        command += "name = '"+discipline.getName()+"', ";
        command += "recommended = '"+discipline.isRecommendedToSQL()+"', ";
        command += "name = '"+discipline.getCredits()+"' ";
        command += "WHERE idDiscipline = '"+discipline.getId()+"'";

        try {
            Statement statement = connection.createStatement();
            statement.execute(command);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void setDisciplineStudents(Discipline discipline) throws SQLException {

        //Видобуваю ідішніки дисциплін юзвєря
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            String command = GETDISCIPLINESTUDEBTSIDS;
            command+=" ('"+discipline.getId()+"')";
            resultSet = statement.executeQuery(command);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> studentsIds = new ArrayList<Integer>();
        while (resultSet!=null&&resultSet.next()){
            studentsIds.add(resultSet.getInt("User_idUser"));
        }

        if (resultSet!=null)
            resultSet.close();

        //видобуваю cтудентів
        ResultSet resultSetNames = null;
        if(studentsIds.size()>0) {
            try {
                Statement statement = connection.createStatement();
                String command = GETUSERSNAME + "(";

                for (int i = 0; i < studentsIds.size(); i++) {
                    command += "'" + studentsIds.get(i) + "', ";
                }

                command = command.substring(0, command.length() - 2) + ")";
                resultSetNames = statement.executeQuery(command);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //Запис у масив імена
        ArrayList<String> studentsNames = new ArrayList<String>();
        while (resultSetNames!=null&&resultSetNames.next()){
            studentsNames.add(resultSetNames.getString("name")+" "+resultSetNames.getString("secondName"));
        }

        if (resultSetNames!=null)
            resultSetNames.close();

        discipline.setStudentsNames(studentsNames);
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
