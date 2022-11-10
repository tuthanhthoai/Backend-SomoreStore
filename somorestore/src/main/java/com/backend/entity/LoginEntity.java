package com.backend.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.backend.Key.MyLoginKey;

@Entity
@Table(name = "login")
@IdClass(MyLoginKey.class)
public class LoginEntity {
	@Id
	@Column(name = "username")
	private String username;

	@Id
	@Column(name = "password")
	private String password;

	@Column()
	private Boolean role;

	@Column()
	private Date session;

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

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private CustomerEntity customer;

}
