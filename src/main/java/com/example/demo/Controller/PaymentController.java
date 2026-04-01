package com.example.demo.Controller;

import com.example.demo.Service.RazorpayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private RazorpayService razorpayService;

    // ✅ Create payment order
    @PostMapping("/create")
    public String create(@RequestParam Long orderId) throws Exception {
        return razorpayService.createOrder(orderId);
    }

    // ✅ Success
    @PostMapping("/success")
    public String success(@RequestParam Long orderId) {
        razorpayService.markSuccess(orderId);
        return "Payment Success";
    }

    // ❌ Fail
    @PostMapping("/fail")
    public String fail(@RequestParam Long orderId) {
        razorpayService.markFailed(orderId);
        return "Payment Failed";
    }
}