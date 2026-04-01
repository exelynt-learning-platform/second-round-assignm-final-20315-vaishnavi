package com.example.demo.Service;
import com.example.demo.Entity.Cart;

public interface CartService {

    Cart getCart();

    Cart addToCart(Long productId, int quantity);

    Cart removeFromCart(Long productId);
}