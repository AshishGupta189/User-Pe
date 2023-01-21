package com.vcriate.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vcriate.Dto.LoginDTO;
import com.vcriate.Entity.Transactions;
import com.vcriate.Entity.User;
import com.vcriate.Exception.LoginException;
import com.vcriate.Service.UserService;
import com.vcriate.Service.Login.LoginService;

@RestController
public class UserController {

	@Autowired
	private LoginService logS;
	@Autowired
	private UserService uService;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInAdminHandler(@Valid @RequestBody LoginDTO dto) throws LoginException {
		String result = logS.login(dto);
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/logout")
	public String logoutAdminHandler(@Valid @RequestParam(required = false) String sessionid) throws LoginException {
		return logS.logOut(sessionid);
	}
	
	@PostMapping("/registerUser")
	public ResponseEntity<User> createAdminHandler(@Valid @RequestBody User user)	{
		User a=uService.registerUser(user);
		return new ResponseEntity<User>(a, HttpStatus.CREATED);
	}
	@PutMapping("/updatePassword")
	public ResponseEntity<String> updatePasswordHandler(@Valid @RequestParam Integer age,@RequestParam String phone,@RequestParam String password){
		String msg=uService.updatePassword(age, phone, password);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	@GetMapping("/viewBalance")
	public ResponseEntity<String> viewBalanceHandler(@RequestParam String sessionid){
		String msg=uService.viewBalance(sessionid);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	@PutMapping("/depositMoney")
	public ResponseEntity<String> depositMoneyHandler(@Valid @RequestParam  String sessionid,@RequestParam Integer amount){
		String msg=uService.depositAmount(sessionid, amount);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/withdrawMoney")
	public ResponseEntity<String> withdrawMoneyHandler(@Valid @RequestParam  String sessionid,@RequestParam Integer amount){
		String msg=uService.withdrawAmount(sessionid, amount);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getTransactions")
	public ResponseEntity<List<Transactions>> getTransactionListHandler(@Valid @RequestParam  String sessionid){
		List<Transactions> list=uService.viewTransactions(sessionid);
		return new ResponseEntity<List<Transactions>>(list,HttpStatus.OK);
	}
}
