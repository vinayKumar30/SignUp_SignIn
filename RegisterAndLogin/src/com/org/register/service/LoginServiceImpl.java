package com.org.register.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.register.dao.RegisterDAO;
import com.org.register.dto.LoginDTO;
import com.org.register.entity.RegisterEntity;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private RegisterDAO dao;

	public LoginServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public boolean validateLoginDetails(LoginDTO loginDTO) {
		boolean valid = false;
		try {
			System.out.println("Invoked validateLoginDetails()...");

			if (Objects.nonNull(loginDTO)) {
				
				RegisterEntity lg = new RegisterEntity();
				BeanUtils.copyProperties(loginDTO, lg);
				RegisterEntity lg1 = dao.fetchByNameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());
				if (lg1 != null) {
					dao.fetchByNameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());
					System.out.println("User details exist");
					return true;
				}
			} else {
				System.out.println("User doesnt not exist");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INFO:" + e.getMessage());
		}

		return valid;
	}

}
