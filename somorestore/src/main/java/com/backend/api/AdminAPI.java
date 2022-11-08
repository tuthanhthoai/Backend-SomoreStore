package com.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.ProductDTO;
import com.backend.dto.UserDTO;

@RestController
public class AdminAPI {
	@GetMapping("/api/admin/customer")
	public List<UserDTO> getAllUser() {
		UserDTO user = new UserDTO();
		List<UserDTO> result = new ArrayList<UserDTO>();
		return result;
	}

	@PostMapping("/api/admin/product")
	public ProductDTO addProduct(ProductDTO abc) {
		ProductDTO product = new ProductDTO();
		return product;
	}

	@PutMapping("/api/product/get_all")
	public ProductDTO updateProduct() {
		ProductDTO product = new ProductDTO();
		return product;
	}
}
