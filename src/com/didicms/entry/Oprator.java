package com.didicms.entry;

import org.springframework.stereotype.Component;

@Component
public class Oprator {
	public Oprator(){}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String id;
	private String password;
}
