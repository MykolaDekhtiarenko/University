package com.mdekhtiarenko.universitysignin.spring.viewBean;

/**
 * Created by mykola.dekhtiarenko on 12.12.16.
 */

public class DisciplineForm {
    private String name;
    private double credits;
    private boolean recommended;

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public String getName() {

        return name;
    }

    public double getCredits() {
        return credits;
    }

    public boolean isRecommended() {
        return recommended;
    }
}
