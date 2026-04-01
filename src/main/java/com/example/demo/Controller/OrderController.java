package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 🛒 Place Order

    @PostMapping("/place")
    public Order placeOrder(@RequestBody Map<String, String> request) {
        String address = request.get("address");
        return orderService.placeOrder(address);
    }
    
    
    // 📜 Get Orders
    @GetMapping("/get")
    public List<Order> getMyOrders() {
        return orderService.getMyOrders();
    }
}