package com.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.UserDTO;

@RestController
public class UserAPI {
	@GetMapping("/api/user")
	public UserDTO getUser() {
		UserDTO user = new UserDTO();
		return user;
	}

	@PutMapping("/api/user")
	public UserDTO updateUser() {
		UserDTO user = new UserDTO();
		return user;
	}
}
