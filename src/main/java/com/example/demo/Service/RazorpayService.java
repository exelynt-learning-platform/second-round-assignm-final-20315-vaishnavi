package com.example.demo.Service;

import com.example.demo.Entity.Order;
import com.example.demo.Reposotory.OrderRepository;
import com.razorpay.*;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

    @Value("${razorpay.key.id}")
    private String keyId;

    @Value("${razorpay.key.secret}")
    private String keySecret;

    @Autowired
    private OrderRepository orderRepository;

    // ✅ Create Razorpay Order
    public String createOrder(Long orderId) throws Exception {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        RazorpayClient client = new RazorpayClient(keyId, keySecret);

        JSONObject options = new JSONObject();
        options.put("amount", (int)(order.getTotalAmount() * 100)); // paise
        options.put("currency", "INR");
        options.put("receipt", "order_rcptid_" + orderId);

        com.razorpay.Order razorOrder = client.orders.create(options);

        return razorOrder.toString();
    }

    // ✅ Mark success
    public void markSuccess(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus("PAID");
        orderRepository.save(order);
    }

    // ❌ Mark failed
    public void markFailed(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        order.setStatus("FAILED");
        orderRepository.save(order);
    }
}