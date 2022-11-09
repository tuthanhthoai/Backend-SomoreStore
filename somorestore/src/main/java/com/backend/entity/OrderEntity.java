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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
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

	public Boolean getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(Boolean payment_status) {
		this.payment_status = payment_status;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	@Column()
	private Float discount;

	@Column(name = "total_price")
	private Long total_price;

	@Column()
	private Boolean payment_status;

	@OneToMany(mappedBy = "order")
	private List<ProductOrderEntity> productOrders = new ArrayList<>();

	@ManyToOne()
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

	public List<ProductOrderEntity> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<ProductOrderEntity> productOrders) {
		this.productOrders = productOrders;
	}

}
