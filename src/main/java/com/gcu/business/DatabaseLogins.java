package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.RegistrationDataAccessInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.RegistrationModel;

public class DatabaseLogins implements SecurityServiceInterface {

	@Autowired
	RegistrationDataAccessInterface regDAI;


	@Override
	public boolean isAuthenticated(LoginModel loginModel) {

				
		RegistrationModel tempLog = new RegistrationModel(loginModel.getUsername(), loginModel.getPassword());
		tempLog = regDAI.findOne(tempLog);

		if(tempLog == null){
			return false;
		}
		return true;
	}

}
