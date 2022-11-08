package com.backend.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.backend.dto.ProductDTO;
import com.backend.entity.ColorEntity;
import com.backend.entity.ImageEntity;
import com.backend.entity.ProductEntity;
import com.backend.entity.SizeEntity;

@Component
public class ProductEntity_TO_ProductDTO {
	
	public ProductDTO toDTO(ProductEntity productEntity) {
		ProductDTO x = new ProductDTO();
		x.setId(productEntity.getId());
		x.setBrand(productEntity.getBrand().getName());
		x.setCategory(productEntity.getCategory().getName());
		x.setName(productEntity.getName());
		x.setPrice(productEntity.getMoney());
		x.setDiscount(productEntity.getDiscount());
		x.setSold_quantity(x.getSold_quantity());
		x.setStock(productEntity.getStock());
		x.setDescription(productEntity.getDescription());
		List<Double> size = new ArrayList<Double>();
		for (SizeEntity y: productEntity.getSizes()) {
			size.add(y.getSize());
		}
		x.setSize(size);
		List<String> image = new ArrayList<String>();
		for (ImageEntity y : productEntity.getImages()) {
			image.add(y.getImage());
		}
		x.setImage(image);
		List<String> color = new ArrayList<String>();
		for (ColorEntity y : productEntity.getColors()) {
			color.add(y.getColor());
		}
		x.setColor(color);
		return x;
	}
	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity x = new ProductEntity();
			
		return x;
	}

}
