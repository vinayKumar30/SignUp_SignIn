package com.org.register.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "register")
@Data
@NamedQueries({ @NamedQuery(name = "fetchByEmail", query = "select re from RegisterEntity re where re.email=:email"),
		@NamedQuery(name = "fetchByName", query = "select re from RegisterEntity re where re.userName=:userName"),
		@NamedQuery(name = "mailAndUserName", query = "select re from RegisterEntity re where re.userName=:n and re.password=:e") })
public class RegisterEntity implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "email")
	private String email;
	@Column(name = "phnNum")
	private long phnNum;
	@Column(name = "password")
	private String password;

	public RegisterEntity() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

}
