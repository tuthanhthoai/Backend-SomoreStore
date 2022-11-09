package com.backend.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class LoginDTO {
	private String username;
	private String password;
	private Boolean role;
	private Date session;
	private Long customer_id;
}
