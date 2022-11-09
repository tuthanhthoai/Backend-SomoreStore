package com.backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	@Column()
	private String name;

	@Column()
	private Long money;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMoney() {
		return money;
	}

	public void setMoney(Long money) {
		this.money = money;
	}

	public Long getSold_quantity() {
		return sold_quantity;
	}

	public void setSold_quantity(Long sold_quantity) {
		this.sold_quantity = sold_quantity;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductOrderEntity> getProductOrders() {
		return productOrders;
	}

	public void setProductOrders(List<ProductOrderEntity> productOrders) {
		this.productOrders = productOrders;
	}

	public List<ProductSizeEntity> getProductSizes() {
		return productSizes;
	}

	public void setProductSizes(List<ProductSizeEntity> productSizes) {
		this.productSizes = productSizes;
	}

	public List<ImageEntity> getImages() {
		return images;
	}

	public void setImages(List<ImageEntity> images) {
		this.images = images;
	}

	public List<ColorEntity> getColors() {
		return colors;
	}

	public void setColors(List<ColorEntity> colors) {
		this.colors = colors;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}

	@Column(name = "sold_quantity")
	private Long sold_quantity;

	@Column()
	private Double discount;

	@Column()
	private Long stock;

	@Column()
	private String description;

	@OneToMany(mappedBy = "product")
	private List<ProductOrderEntity> productOrders = new ArrayList<>();

	@OneToMany(mappedBy = "product")
	private List<ProductSizeEntity> productSizes = new ArrayList<>();

	@ManyToMany()
	@JoinTable(name = "product_image", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
	private List<ImageEntity> images = new ArrayList<>();

	@ManyToMany()
	@JoinTable(name = "product_color", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "color_id"))
	private List<ColorEntity> colors = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private CategoryEntity category;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private BrandEntity brand;

}
