package com.vcriate.Service;

import java.util.List;

import com.vcriate.Entity.Transactions;
import com.vcriate.Entity.User;
import com.vcriate.Exception.LoginException;
import com.vcriate.Exception.UserException;

public interface UserService {
	public User registerUser(User user) throws UserException;
	public String viewBalance(String sessionId) throws UserException,LoginException;
	public String depositAmount(String sessionId,Integer amount) throws UserException,LoginException;
	public String withdrawAmount(String sessionId,Integer amount) throws UserException,LoginException;
	public List<Transactions> viewTransactions(String sessionId) throws UserException,LoginException;
	public String updatePassword(Integer age, String phone, String address);
	
}
