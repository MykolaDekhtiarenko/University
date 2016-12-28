package com.mdekhtiarenko.universitysignin.dao;


import com.mdekhtiarenko.universitysignin.entity.Period;

import java.sql.SQLException;

/**
 * Created by mykola.dekhtiarenko on 24.11.16.
 */
public interface PeriodDAO {
//    public Period getPeriod() throws SQLException;
    public void setPeriod(String period);
//    public void setToDefault();
}
