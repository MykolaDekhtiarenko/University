package com.mdekhtiarenko.universitysignin.dao;

import com.mdekhtiarenko.universitysignin.spring.viewBean.SignInBean;

import java.sql.SQLException;

/**
 * Created by mykola.dekhtiarenko on 26.11.16.
 */
public interface Discipline_has_UserDAO {

    public SignInBean signIn(int userId, int disciplineId) throws SQLException;
}
