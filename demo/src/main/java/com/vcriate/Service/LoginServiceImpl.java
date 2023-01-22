package com.vcriate.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.Dto.LoginDTO;
import com.vcriate.Entity.User;
import com.vcriate.Entity.UserSession;
import com.vcriate.Exception.LoginException;
import com.vcriate.Repository.UserDao;
import com.vcriate.Repository.UserSessionDao;

import net.bytebuddy.utility.RandomString;

	
	@Service
	public class LoginServiceImpl implements LoginService{
		@Autowired
		private UserDao usera;
		 @Autowired
		 private UserSessionDao usersession;

		 @Override
		 public String logOut(String key)throws LoginException {
		 	UserSession us =  usersession.findBySessionId(key);
		 	if(us != null) {
		 		usersession.delete(us);
		 		return "Logged Out!";
		 	}else throw new LoginException("Error Occured Unable to log out !");
			
		 }

		 @Override
		 public String login(LoginDTO dto) throws LoginException {
			
		 	UserSession currentUserSession;
		 		User admin = usera.findByMobile(dto.getMobile());
		 		if(admin == null) {
		 			throw new LoginException("Please Enter a valid mobile number");
		 		}
				
		 	    if(admin.getPassword().equals(dto.getPassword())) {
					
		 			String key= RandomString.make(6);
					
		 			 currentUserSession = new UserSession();
		 			currentUserSession.setMobile(admin.getMobile());
		 			currentUserSession.setSessionId(RandomString.make(6));
		 			currentUserSession.setSessionTime(LocalDateTime.now());
		 			
					
		 			 usersession.save(currentUserSession);
		 			 return currentUserSession.toString();
		 	    }
		 	    else
		 			throw new LoginException("Please Enter a valid password");
			 
				
		 	}
		



	}

		


