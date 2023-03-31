package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RegMapper implements RowMapper<RegistrationModel>{

    public RegistrationModel mapRow(ResultSet rs, int i) throws SQLException {
            RegistrationModel reg = new RegistrationModel(
                rs.getString("USERNAME"),
                rs.getString("PASSWORD")
            );

            return reg;
    }

    
}
