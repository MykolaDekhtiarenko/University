package com.mdekhtiarenko.universitysignin.dao;

import java.sql.SQLException;

/**
 * Created by mykola.dekhtiarenko on 26.11.16.
 */
public interface Discipline_has_UserDAO {

    public void signIn(int userId, int disciplineId) throws SQLException;
}
