package com.backend.dto;

public class UserDTO {
	private String name;
	private String phone;
	private String address;
	private Boolean sex;
	private String email;
	private String image;
	private String username;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public UserDTO() {

	}

	public UserDTO(String name, String phone, String address, Boolean sex, String email, String image, String username,
			String password) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.email = email;
		this.image = image;
		this.username = username;
		this.password = password;
	}

}
