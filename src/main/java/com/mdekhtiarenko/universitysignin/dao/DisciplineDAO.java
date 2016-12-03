package com.mdekhtiarenko.universitysignin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mdekhtiarenko.universitysignin.entity.Discipline;

public interface DisciplineDAO {
	   public ArrayList<Discipline> getAllDiscipline() throws SQLException;
	   
	   public Discipline getDiscipline(int id) throws SQLException;
	   public void delete(int id);
	   public void create(Discipline discipline);
	   public void updateDiscipline(Discipline discipline);
	public void setDisciplineStudents(Discipline discipline) throws SQLException;
}
