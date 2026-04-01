package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Cart;
import com.example.demo.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // ✅ Get cart (logged-in user)
    @GetMapping("/get")
    public Cart getCart() {
        return cartService.getCart();
    }

    // ✅ Add product to cart
    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long productId,
                          @RequestParam int quantity) {

        return cartService.addToCart(productId, quantity);
    }

    // ✅ Remove product
    @DeleteMapping("/remove")
    public Cart removeFromCart(@RequestParam Long productId) {
        return cartService.removeFromCart(productId);
    }
}