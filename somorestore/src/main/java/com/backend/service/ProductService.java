package com.backend.service;

import java.util.List;

import com.backend.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAll();

	List<ProductDTO> findByDiscount();

	List<ProductDTO> findByHot();

	List<ProductDTO> findByBrand();

	List<ProductDTO> findByCategory();

	List<ProductDTO> findByName();

	List<ProductDTO> findByPrice();

	List<ProductDTO> findBySize();

	List<ProductDTO> findByColor();

	List<ProductDTO> findByBill(Long id);
}
