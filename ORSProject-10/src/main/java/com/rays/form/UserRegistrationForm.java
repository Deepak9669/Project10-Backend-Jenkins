package com.rays.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegistrationForm {

	@Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Invalid name format")
	@NotEmpty(message = "firstName is required")
	private String firstName;

	@Pattern(regexp = "^[A-Za-z]+(?: [A-Za-z]+)*$", message = "Invalid name format")
	@NotEmpty(message = "lastName is required")
	private String lastName;

	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Login ID should contain only letters and numbers")
	@NotEmpty(message = "loginId is required")
	private String loginId;

	@NotEmpty(message = "Password is required")
	@Pattern(regexp = "^[A-Z][a-z0-9]*[@$!%*?&][a-z0-9]*$", message = "Password must start with capital letter, include one special character, and be 8-12 characters long")
	@Size(min = 8, max = 12)
	private String password;

	@NotNull(message = "Date of birth is required")
	private Date dob;

	@NotEmpty(message = "Gender is required")
	private String gender;

	@NotEmpty(message = "Mobile No is required")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}