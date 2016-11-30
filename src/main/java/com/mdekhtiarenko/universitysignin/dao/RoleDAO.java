package com.mdekhtiarenko.universitysignin.dao;

import java.sql.SQLException;

/**
 * Created by mykola.dekhtiarenko on 27.11.16.
 */
public interface RoleDAO {

    public String getRole(int id) throws SQLException;
    public void changeRole(int id, String role);

}
