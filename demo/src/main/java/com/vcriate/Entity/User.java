package com.vcriate.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class User {

	@NotNull(message = "first Name cannot be NULL")
	@Pattern(regexp = "[A-Za-z]+", message = "Enter valid characters in last name")
	private String firstName;
	
	@NotNull(message = "Last Name cannot be NULL")
	@Pattern(regexp = "[A-Za-z]+", message = "Enter valid characters in last name")
	private String lastName;
	
	@Id
	@NotNull(message = "Please enter the mobile Number")
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	private String mobile;
	
	private Integer amount;
	
	private String address;
	
	@Min(value=16)
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Pattern(regexp = "[A-Za-z0-9!@#$%^&*_]{8,15}", message = "Password must be 8-15 characters in length and can include A-Z, a-z, 0-9, or special characters !@#$%^&*_")
	private String password;
	
}