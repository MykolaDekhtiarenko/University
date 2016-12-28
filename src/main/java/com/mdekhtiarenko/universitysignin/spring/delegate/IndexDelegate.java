package com.mdekhtiarenko.universitysignin.spring.delegate;

import com.mdekhtiarenko.universitysignin.dao.DisciplineDAOImpl;
import com.mdekhtiarenko.universitysignin.dao.PeriodDAOImpl;
import com.mdekhtiarenko.universitysignin.entity.Discipline;
import com.mdekhtiarenko.universitysignin.entity.Period;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mykola.dekhtiarenko on 03.12.16.
 */
public class IndexDelegate {
    private DisciplineDAOImpl disciplineService;
    private PeriodDAOImpl periodService;

    public IndexDelegate(){
        disciplineService = new DisciplineDAOImpl();
        periodService = new PeriodDAOImpl();
    }
    public void setPeriodService(PeriodDAOImpl periodService) {
        this.periodService = periodService;
    }

    public PeriodDAOImpl getPeriodService() {

        return periodService;
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

    public String getPeriod() throws SQLException {
        return periodService.getPeriod().toString();
    }
}
