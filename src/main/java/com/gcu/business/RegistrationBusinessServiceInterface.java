package com.gcu.business;

import com.gcu.model.RegistrationModel;

public interface RegistrationBusinessServiceInterface {
    public void test();
    public void init();
    public void destroy();
    public int addOne(RegistrationModel newUser);
    public int findOne(RegistrationModel regModel);
    public int UpdateRegistrationModel(RegistrationModel updateUser);
}
