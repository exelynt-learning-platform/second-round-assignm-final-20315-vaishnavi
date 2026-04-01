package com.example.demo.Dao;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.*;
import com.example.demo.Reposotory.CartRepository;
import com.example.demo.Reposotory.ProductRepository;
import com.example.demo.Reposotory.UserRepository;
import com.example.demo.Service.CartService;


@Service
public class CartDao implements CartService {
	  @Autowired
	    private CartRepository cartRepo;

	    @Autowired
	    private ProductRepository productRepo;

	    @Autowired
	    private UserRepository userRepo;

	    // ✅ Get logged-in user
	    private User getLoggedInUser() {
	        String email = SecurityContextHolder.getContext().getAuthentication().getName();
	        return userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
	    }

	    @Override
	    public Cart getCart() {

	        User user = getLoggedInUser();

	        return cartRepo.findByUser(user)
	                .orElseGet(() -> {
	                    Cart cart = new Cart();
	                    cart.setUser(user);
	                    cart.setItems(new ArrayList<>());
	                    return cartRepo.save(cart);
	                });
	    }

	    @Override
	    public Cart addToCart(Long productId, int quantity) {

	        User user = getLoggedInUser();
	        Cart cart = getCart();

	        Product product = productRepo.findById(productId)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        // 🔥 Check if product already exists in cart
	        boolean found = false;

	        for (CartItem item : cart.getItems()) {
	            if (item.getProduct().getId().equals(productId)) {
	                item.setQuantity(item.getQuantity() + quantity);
	                found = true;
	                break;
	            }
	        }

	        // 🔥 If not exists → add new item
	        if (!found) {
	            CartItem item = new CartItem();
	            item.setCart(cart);
	            item.setProduct(product);
	            item.setQuantity(quantity);

	            cart.getItems().add(item);
	        }

	        return cartRepo.save(cart);
	    }

	    @Override
	    public Cart removeFromCart(Long productId) {

	        Cart cart = getCart();

	        cart.getItems().removeIf(item ->
	                item.getProduct().getId().equals(productId)
	        );

	        return cartRepo.save(cart);
	    }
	
	
	
	
	
	
	
	
}
