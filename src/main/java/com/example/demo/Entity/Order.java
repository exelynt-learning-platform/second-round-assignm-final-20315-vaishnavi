package com.example.demo.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // Many orders → one user
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	    private double totalAmount;

	    private String status; // CREATED, PAID, FAILED

	    private String shippingAddress;

	    private LocalDateTime createdAt;

	    // One order → many order items
	    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	    private List<OrderItem> orderItems;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(String shippingAddress) {
			this.shippingAddress = shippingAddress;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}

		public List<OrderItem> getOrderItems() {
			return orderItems;
		}

		public void setOrderItems(List<OrderItem> orderItems) {
			this.orderItems = orderItems;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", user=" + user + ", totalAmount=" + totalAmount + ", status=" + status
					+ ", shippingAddress=" + shippingAddress + ", createdAt=" + createdAt + ", orderItems=" + orderItems
					+ "]";
		}

		public Order(Long id, User user, double totalAmount, String status, String shippingAddress,
				LocalDateTime createdAt, List<OrderItem> orderItems) {
			super();
			this.id = id;
			this.user = user;
			this.totalAmount = totalAmount;
			this.status = status;
			this.shippingAddress = shippingAddress;
			this.createdAt = createdAt;
			this.orderItems = orderItems;
		}

		public Order() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
