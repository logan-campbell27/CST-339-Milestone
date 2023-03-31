package com.gcu.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.RegMapper;
import com.gcu.model.RegistrationModel;

@Primary
@Repository
public class RegistrationDataService implements RegistrationDataAccessInterface {



    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long addOne(RegistrationModel newUser) {
        return jdbcTemplate.update("insert into USERS (USERNAME, PASSWORD) values (?,?)",
            newUser.getUsername(), newUser.getPassword());
    }

    @Override
    public RegistrationModel findOne(RegistrationModel regModel) {
       return (RegistrationModel) jdbcTemplate.queryForObject("select * from USERS where USERNAME = ? AND PASSWORD = ?", 
       new RegMapper(), new Object[] {regModel.getUsername(), regModel.getPassword()});
     
    }

    @Override
    public int UpdateRegistrationModel(RegistrationModel updateUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateRegistrationModel'");
    }

   

    


    

   
    
}
