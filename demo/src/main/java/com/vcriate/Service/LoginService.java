package com.vcriate.Service;

import com.vcriate.Dto.LoginDTO;
import com.vcriate.Exception.LoginException;

public interface LoginService {

	 public String logOut(String key)throws LoginException;
	
	 public String login(LoginDTO ldto)throws LoginException;

	
}
