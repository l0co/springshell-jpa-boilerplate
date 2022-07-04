package com.lifeinide.boilerplate.springshell.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usr")
public class User extends AbstractEntity {

	@Column(name = "login", nullable = false, unique = true)
	private String login;

	public String getLogin() {
		return login;
	}
	
}
