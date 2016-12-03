package com.mdekhtiarenko.universitysignin.entity;


import com.mdekhtiarenko.universitysignin.dao.Discipline_has_UserDAOImpl;
import com.mdekhtiarenko.universitysignin.xml.XMLParser;

import java.util.ArrayList;

public class Discipline {

	private int id;
	private String name;
	private String description;
	private String teacher;
	private boolean recommended;
	private double credits;

	private ArrayList<String> studentsNames;

	public Discipline(int id, String name, boolean recommended, double credits) {
		this.id=id;
		this.name=name;
		this.recommended=recommended;
		this.credits=credits;
		XMLParser xml = new XMLParser();
		this.teacher = xml.getTeacher(id);
		this.description = xml.getDescription(id);

	}

	@Override
	public String toString() {
		return "Discipline " +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", teacher='" + teacher + '\'' +
				", recommended=" + recommended +
				", credits=" + credits
				+
				"\nStudents: "+studentsNames.toString();
	}


	public void setStudentsNames(ArrayList<String> studentsNames) {
		this.studentsNames = studentsNames;
	}

	public ArrayList<String> getStudentsNames() {
		return studentsNames;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public int getId() {

		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getTeacher() {
		return teacher;
	}

	public boolean isRecommended() {
		return recommended;
	}
	public int isRecommendedToSQL() {
		if (recommended)
			return 1;
		else return  0;
	}

	public double getCredits() {
		return credits;
	}
}
