package com.backend.entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_shoes")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false)
	private Long id;

	@Column(name = "order_date")
	private Date order_date;

	@Column()
	private Float discount;

	@Column(name = "total_price")
	private Long total_price;

	@Column()
	private Long quantity;

	@Column()
	private Boolean payment_status;

	@ManyToOne()
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

	@ManyToMany(mappedBy = "orders")
	private List<ProductEntity> products = new ArrayList<>();

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Long getId() {
		return id;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Long getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Long total_price) {
		this.total_price = total_price;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public Boolean getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(Boolean payment_status) {
		this.payment_status = payment_status;
	}
}
