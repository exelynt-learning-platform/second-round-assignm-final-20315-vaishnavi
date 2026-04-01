package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    private String name;

	    private String description;

	    @Min(1)
	    private double price;

	    @Min(0)
	    private int stock;

	    private String imageUrl;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
					+ ", stock=" + stock + ", imageUrl=" + imageUrl + "]";
		}

		public Product(Long id, @NotBlank String name, String description, @Min(1) double price, @Min(0) int stock,
				String imageUrl) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.stock = stock;
			this.imageUrl = imageUrl;
		}

		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

}
