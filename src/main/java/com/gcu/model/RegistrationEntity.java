package com.gcu.model;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class RegistrationEntity {
    
    
    @Column("USERNAME")
    String username;

    @Column("PASSWORD")
    String password;

    public RegistrationEntity(){
        this.username = "";
        this.password = "";
    }

    public RegistrationEntity(String username, String password){
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
