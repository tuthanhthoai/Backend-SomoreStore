package com.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.backend.dto.ProductDTO;

@RestController
public class ProductAPI {
	@GetMapping("/api/product/get_all")
	public List<ProductDTO> allProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/discount")
	public List<ProductDTO> discountProduct() {
		//ProductDTO product = new ProductDTO(1L, "Nam", "abc", 49L, "Nike", 49.8F, "abc", "red", 0.5F, 5L);
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/hot")
	public List<ProductDTO> hotProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/brand")
	public List<ProductDTO> brandProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/category")
	public List<ProductDTO> categoryProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/name")
	public List<ProductDTO> nameProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/price")
	public List<ProductDTO> priceProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/size")
	public List<ProductDTO> sizeProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/color")
	public List<ProductDTO> colorProduct() {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}

	@GetMapping("/api/product/bill/{id}")
	public List<ProductDTO> billProduct(@PathVariable Long id) {
		ProductDTO product = new ProductDTO();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		return result;
	}
}
