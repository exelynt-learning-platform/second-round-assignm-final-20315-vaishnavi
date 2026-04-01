package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank
	    private String name;

	    @Column(unique = true)
	    @Email
	    private String email;

	    @NotBlank
	    private String password;

	    @Enumerated(EnumType.STRING)
	    private Role role;

	    // One user → many orders
	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private List<Order> orders;

	    // One user → one cart
	    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	    private Cart cart;

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
					+ role + ", orders=" + orders + ", cart=" + cart + "]";
		}

		public User(Long id, @NotBlank String name, @Email String email, @NotBlank String password, Role role,
				List<Order> orders, Cart cart) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.password = password;
			this.role = role;
			this.orders = orders;
			this.cart = cart;
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
