package com.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.ProductDTO;
import com.backend.entity.ProductEntity;
import com.backend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository product;

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		List<ProductEntity> get = new ArrayList<ProductEntity>();
		get = (List<ProductEntity>) product.findAll();
		for (ProductEntity x : get) {
			ProductDTO a = new ProductDTO();
			a.setId(x.getId());
			a.setBrand(x.getBrand().getName());
			a.setCategory(x.getCategory().getName());
			a.setSize(null);
			
		}
		return result;
	}

	@Override
	public List<ProductDTO> findByDiscount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findByHot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findByBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findBySize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findByColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findByBill(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
