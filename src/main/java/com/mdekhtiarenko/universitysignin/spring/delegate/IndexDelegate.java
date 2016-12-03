package com.mdekhtiarenko.universitysignin.spring.delegate;

import com.mdekhtiarenko.universitysignin.dao.DisciplineDAOImpl;
import com.mdekhtiarenko.universitysignin.entity.Discipline;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mykola.dekhtiarenko on 03.12.16.
 */
public class IndexDelegate {
    private DisciplineDAOImpl disciplineService;

    public IndexDelegate(){
        disciplineService = new DisciplineDAOImpl();
    }
    public DisciplineDAOImpl getDisciplineService() {
        return this.disciplineService;
    }

    public void setDisciplineService(DisciplineDAOImpl disciplineService) {
        this.disciplineService = disciplineService;
    }

    public ArrayList<Discipline> getAllDiscipline() throws SQLException{
        return disciplineService.getAllDiscipline();
    }
}
