package com.backend.dto;

import java.sql.Date;

import com.backend.entity.Provider;

public class LoginDTO {
	private String username;
	private String password;
	private Boolean role;
	private Date session;
	private Long customer_id;
	private Provider auth_provider;

	public Provider getAuth_provider() {
		return auth_provider;
	}

	public void setAuth_provider(Provider auth_provider) {
		this.auth_provider = auth_provider;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public Date getSession() {
		return session;
	}

	public void setSession(Date session) {
		this.session = session;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

}
