package com.mdekhtiarenko.universitysignin.entity;

import com.mdekhtiarenko.universitysignin.POJOs.POJODiscipline;

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

	}

	public Discipline(String name, String teacher, boolean recommended, double credits) {
		this.name=name;
		this.teacher=teacher;
		this.recommended=recommended;
		this.credits=credits;

		this.description="";
	}

	public Discipline(int id, String name, String teacher, boolean recommended, double credits, String description) {
		this.id=id;
		this.name=name;
		this.teacher=teacher;
		this.recommended=recommended;
		this.credits=credits;
		this.description=description;
	}

	@Override
	public String toString() {
		return "Discipline " +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", teacher='" + teacher + '\'' +
				", recommended=" + recommended +
				", credits=" + credits;
//				+
//				"\nStudents: "+studentsNames.toString();
	}

	public POJODiscipline toPOJO(){
		POJODiscipline pojo = new POJODiscipline();
		pojo.setId(id);
		pojo.setName(name);
		pojo.setCredits(credits);
		pojo.setDescription(description);
		pojo.setRecommended(recommended);
		pojo.setTeacher(teacher);
		if(studentsNames!=null)
			pojo.setStudentsNames((String[]) studentsNames.toArray());
		return pojo;
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
