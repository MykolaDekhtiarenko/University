package com.mdekhtiarenko.universitysignin.entity;

import com.mdekhtiarenko.universitysignin.dao.RoleDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {

	private int id;
	private String name;
	private String secondname;
	private String role;
	private double credits;
	private int roleId;
	private ArrayList<String> disciplines;

	public User(int id, String name, String secondname, double credits, int roleId) {
		this.id=id;
		this.name=name;
		this.secondname=secondname;
		this.credits=credits;
		this.roleId=roleId;
		disciplines=new ArrayList<String>();
		RoleDAOImpl RDI = new RoleDAOImpl();
		try {
			role = RDI.getRole(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User(String name, String secondname, double credits, int roleId) {
		this.name=name;
		this.secondname=secondname;
		this.credits=credits;
		this.roleId=roleId;
		disciplines=new ArrayList<String>();
		RoleDAOImpl RDI = new RoleDAOImpl();
		try {
			role = RDI.getRole(roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "User " +
				"id=" + id +
				", name='" + name + '\'' +
				", secondname='" + secondname + '\'' +
				", credits=" + credits+
				", roleId=" + roleId+"\nDisciplines: "+disciplines.toString();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
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

	public String getSecondname() {
		return secondname;
	}

	public double getCredits() {
		return credits;
	}

	public void setDisciplines(ArrayList<String> disciplines) {
		this.disciplines = disciplines;
	}

	public ArrayList<String> getDisciplines() {
		return disciplines;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;

	}

	public int getRoleId() {

		return roleId;
	}

	public String getRole() {

		return role;
	}
}
