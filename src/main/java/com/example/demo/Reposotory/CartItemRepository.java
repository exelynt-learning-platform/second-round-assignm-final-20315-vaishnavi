package com.example.demo.Reposotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}