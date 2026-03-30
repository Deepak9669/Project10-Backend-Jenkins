package com.rays.ctl;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.common.UserContext;
import com.rays.config.JWTUtil;
import com.rays.dto.UserDTO;
import com.rays.form.ForgetPasswordForm;
import com.rays.form.LoginForm;
import com.rays.form.UserForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

/**
 * LoginCtl handles authentication related operations such as login,
 * registration (sign up), and logout.
 * 
 * It uses JWT (JSON Web Token) for authentication.
 * 
 * All endpoints are mapped under "/Auth".
 * 
 * @author Deepak Verma
 */
@RestController
@RequestMapping(value = "Auth")
public class LoginCtl extends BaseCtl<UserForm, UserDTO, UserServiceInt> {

	/**
	 * JWT utility for token generation and validation
	 */
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserServiceInt userService;

	/**
	 * Handles user login
	 * 
	 * Validates credentials and generates JWT token if successful
	 * 
	 * @param form          LoginForm containing loginId and password
	 * @param bindingResult validation result
	 * @return ORSResponse with user details and token
	 * @throws Exception in case of error
	 */
	@PostMapping("login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult) throws Exception {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		// Authenticate user
		UserDTO dto = baseService.authenticate(form.getLoginId(), form.getPassword());

		if (dto == null) {
			res.setSuccess(false);
			res.addMessage("Invalid Login ID & Password");
		} else {

			// Create user context
			UserContext context = new UserContext(dto);

			// Generate JWT token
			String token = jwtUtil.generateToken(dto.getId(), dto.getLoginId(), dto.getRoleName());

			res.setSuccess(true);
			res.addData(dto);
			res.addResult("loginId", dto.getLoginId());
			res.addResult("role", dto.getRoleName());
			res.addResult("fname", dto.getFirstName());
			res.addResult("lname", dto.getLastName());
			res.addResult("token", token);

			return res;
		}
		return res;
	}

	/**
	 * Handles user registration (sign up)
	 * 
	 * Validates input and creates new user
	 * 
	 * @param form          UserRegistrationForm containing user details
	 * @param bindingResult validation result
	 * @return ORSResponse with status message
	 */
	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		// Check if loginId already exists
		UserDTO dto = baseService.findByLoginId(form.getLoginId(), userContext);

		if (dto != null) {
			res.setSuccess(false);
			res.addMessage("Login Id already exists");
			return res;
		}

		// Create new user
		dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());
		dto.setGender(form.getGender());
		dto.setPhone(form.getPhone());

		dto.setStatus("Inactive");
		dto.setRoleId(2L);

		baseService.register(dto, userContext);

		res.setSuccess(true);
		res.addMessage("User has been registered successfully..!!");

		return res;
	}

	/**
	 * Handles user logout
	 * 
	 * Invalidates session
	 * 
	 * @param session HttpSession object
	 * @return ORSResponse with logout message
	 * @throws Exception in case of error
	 */
	@GetMapping("logout")
	public ORSResponse logout(HttpSession session) throws Exception {

		ORSResponse res = new ORSResponse();

		session.invalidate();

		res.addMessage("Logout successfully..!!");

		return res;
	}
	
	@PostMapping("forgetPassword")
	public ORSResponse forgetPassword(@RequestBody @Valid ForgetPasswordForm form, BindingResult bindingResult) {ORSResponse res = validate(bindingResult);

	if (!res.isSuccess()) {
		return res;
	}

	boolean flag = userService.forgotPassword(form.getLoginId());

	if (flag == true) {
		res.setSuccess(true);
		res.addMessage("Password sent to your email");
	} else {
		res.setSuccess(false);
		res.addMessage("Login Id not found");
	}

	return res;
}
}