package com.backend.Key;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class ProductOrderKey implements Serializable{
	@Column(name="product_id")
	private Long product_id;
	
	public Long getProduct_id() {
		return product_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	@Column(name="order_id")
	private Long order_id;
}
