package com.example.demo.Entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each cart belongs to one user
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // One cart → many cart items
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CartItem> items;

    // ✅ GETTERS & SETTERS

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

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    // ✅ CONSTRUCTORS

    public Cart() {
    }

    public Cart(Long id, User user, List<CartItem> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    // ✅ TO STRING

    @Override
    public String toString() {
        return "Cart [id=" + id + ", user=" + user + ", items=" + items + "]";
    }
}