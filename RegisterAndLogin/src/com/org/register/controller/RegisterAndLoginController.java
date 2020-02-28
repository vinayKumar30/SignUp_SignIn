package com.org.register.controller;

import java.util.Objects;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.register.dto.LoginDTO;
import com.org.register.dto.RegisterDTO;
import com.org.register.service.LoginService;
import com.org.register.service.RegisterService;

@Controller
@RequestMapping
public class RegisterAndLoginController {

	@Autowired
	private RegisterService ser;
	@Autowired
	private LoginService log;

	public RegisterAndLoginController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/reg.do")
	public String onRegister(RegisterDTO dto, ModelMap map) {

		try {
			System.out.println("Invoked onRegister method");
			System.out.println(dto);

			boolean check = this.ser.validateAndSave(dto);

			if (check) {

				ModelMap x = map.addAttribute("name", dto.getUserName());
				ModelMap suc = map.addAttribute("successMessage", " your form field validation is success");
			} else {
				ModelMap fail = map.addAttribute("failureMessage", "Failure:Data not Saved");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}

		return "signup";

	}

	@RequestMapping("/login.do")
	public String onLogin(LoginDTO loginDTO, ModelMap map) {

		try {

			boolean check = this.log.validateLoginDetails(loginDTO);

			if (check) {

				ModelMap name = map.addAttribute("username", loginDTO.getUserName());

				return "LoginSuccess";

			} else {
				ModelMap fail = map.addAttribute("failureMessage", "Login Unsuccessful");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}
		return "login";

	}

}
