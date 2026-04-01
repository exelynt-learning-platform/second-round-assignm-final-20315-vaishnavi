package com.example.demo.Reposotory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
