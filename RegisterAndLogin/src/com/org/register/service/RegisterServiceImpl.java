package com.org.register.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.register.dao.RegisterDAO;
import com.org.register.dto.LoginDTO;
import com.org.register.dto.RegisterDTO;
import com.org.register.entity.RegisterEntity;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDAO dao;

	public RegisterServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public boolean validateAndSave(RegisterDTO dto) {
		boolean valid = false;
		try {
			System.out.println("Invoked ValidateAndSave() from serviceImpl....");

			if (Objects.nonNull(dto)) {
				System.out.println("starting validation for" + dto);
				String Username = dto.getUserName();

				if (Username != null && !Username.isEmpty() && Username.length() >= 6) {
					System.out.println("Username is valid");
					valid = true;
				} else {

					if (Username == null && Username.isEmpty()) {
						System.out.println("Username is null");
					}
					if (Username.length() < 5) {
						System.out.println("name length is less than 5");
					}
					valid = false;
				}

				String Email = dto.getEmail();

				if (valid && Email != null && !Email.isEmpty() && Email.length() >= 6) {
					System.out.println("Email is valid");
					valid = true;
				} else {
					if (Email == null && Email.isEmpty()) {
						System.out.println("Email given is null.Provide data.");
					}
					if (Email.length() < 10) {
						System.out.println("Email length exceeds.");
					}
					valid = false;
				}
				
				String Password = dto.getPassword();

				if (valid && Password != null && !Password.isEmpty() && Password.length() >= 6) {
					System.out.println("Password is valid");
					valid = true;
				} else {

					if (Password == null && Password.isEmpty()) {
						System.out.println("Password is invalid");
					}
					if (Password.length() < 6) {
						System.out.println("Password is small.Cannot Accept");
					}
					valid = false;

				}

				String ConfirmPassword = dto.getConfirmPassword();
				if (valid && ConfirmPassword != null && !ConfirmPassword.isEmpty()
						&& ConfirmPassword.equals(Password) ) {
					System.out.println("ConfirmPassword is valid");
					valid = true;
				} else {
					if (ConfirmPassword == null && ConfirmPassword.isEmpty()) {
						System.out.println("ConfirmPassword is null.");
					}
					if (!ConfirmPassword.equals(Password)) {
						System.out.println("ConfirmPassword is invalid because its not matching");
					}
					valid = false;

				}
			}

			if (valid) {
				System.out.println("DATA IS VALID ,CAN SAVE IN DATABASE");

				RegisterEntity regEntity = new RegisterEntity();
				BeanUtils.copyProperties(dto, regEntity);
				RegisterEntity regEntity1 = dao.fetchByEmail(dto.getEmail());
				
				if (regEntity1 == null) {
					System.out.println("Entity is ready \t" + regEntity);
					dao.save(regEntity);
					System.out.println("Entity is saved");

				} else {
					System.out.println("DATA NOT VALID ,NOT SAVED IN DATABASE");

				}

				return valid;

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:"+e.getMessage());
		}
		return false;

	}
}