package com.gcu.data;

import com.gcu.model.RegistrationModel;

public interface RegistrationDataAccessInterface {
    
    public long addOne(RegistrationModel newUser);
    public RegistrationModel findOne(RegistrationModel regModel);
    public int UpdateRegistrationModel(RegistrationModel updateUser);
}
