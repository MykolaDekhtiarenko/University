package com.mdekhtiarenko.universitysignin.POJOs;

/**
 * Created by mykola.dekhtiarenko on 29.11.16.
 */
public class POJODiscipline {
    private int id;
    private String name;
    private String description;
    private String teacher;
    private boolean recommended;
    private double credits;
    private String[] studentsNames;

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

    public double getCredits() {
        return credits;
    }

    public String[] getStudentsNames() {
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

    public void setStudentsNames(String[] studentsNames) {
        this.studentsNames = studentsNames;
    }
}
