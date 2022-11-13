package com.backend.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.ProductDTO;
import com.backend.dto.SignupDTO;
import com.backend.dto.UserDTO;

@RestController
public class AuthenticationAPI {
	@PostMapping("/api/auth/signin")
	public List<UserDTO> getAllUser() {
		return null;
	}

	@PostMapping("/api/auth/signup")
	public SignupDTO signup(SignupDTO signupDTO) {
		return signupDTO;
	}

	@PutMapping("/api/auth/signout")
	public ProductDTO updateProduct() {
		return null;
	}
}
