package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.*;
import com.example.demo.Reposotory.CartRepository;
import com.example.demo.Reposotory.OrderRepository;
import com.example.demo.Reposotory.UserRepository;


@Service
public class OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(String address) {

        // 🔐 Get logged-in user
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 🛒 Get cart
        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        // 📦 Create Order
        Order order = new Order();
        order.setUser(user);
        order.setStatus("CREATED");
        order.setShippingAddress(address);
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        // 🔁 Convert CartItems → OrderItems
        for (CartItem cartItem : cart.getItems()) {

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(cartItem.getProduct());
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(cartItem.getProduct().getPrice());

            total += cartItem.getQuantity() * cartItem.getProduct().getPrice();

            orderItems.add(item);
        }

        order.setOrderItems(orderItems);
        order.setTotalAmount(total);

        // 💾 Save order
        Order savedOrder = orderRepository.save(order);

        // 🧹 Clear cart
        cart.getItems().clear();
        cartRepository.save(cart);

        return savedOrder;
    }

    // 📜 Get user orders
    public List<Order> getMyOrders() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return orderRepository.findByUser(user);
    }
}