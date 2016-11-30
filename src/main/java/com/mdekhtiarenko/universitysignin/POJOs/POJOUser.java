package com.mdekhtiarenko.universitysignin.POJOs;

import java.util.ArrayList;

/**
 * Created by mykola.dekhtiarenko on 28.11.16.
 */
public class POJOUser {

        int id;
        String name;
        String secondname;
        String role;
        double credits;
        int roleId;
        String [] disciplines;

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

        public void setId(int id) {this.id=id;}

        public String getName() {
            return name;
        }

        public String getSecondname() {
            return secondname;
        }

        public double getCredits() {
            return credits;
        }

        public void setDisciplines(String[] disciplines) {
            this.disciplines = disciplines;
        }

        public String[] getDisciplines() {
            return disciplines;
        }

        public void setRoleId(int roleId) {this.roleId = roleId;}

        public int getRoleId() {return roleId;}

        public String getRole() {return role;}

        public void setRole(String role){ this.role=role;}

}
