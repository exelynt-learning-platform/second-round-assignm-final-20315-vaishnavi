package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many items → one cart
    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private Cart cart;

    // Many items → one product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Min(1)
    private int quantity;

    // ✅ GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ✅ CONSTRUCTORS

    public CartItem() {
    }

    public CartItem(Long id, Cart cart, Product product, int quantity) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    // ✅ TO STRING

    @Override
    public String toString() {
        return "CartItem [id=" + id + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity + "]";
    }
}