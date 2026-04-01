package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	    @Autowired
	    private ProductService service;

	    @PostMapping("/add")
	    public Product addProduct(@RequestBody Product product) {
	        return service.addProduct(product);
	    }
	    
	    
	    // Get all products
	    @GetMapping("/all")
	    public ResponseEntity<Object> getAllProducts() {
	        return ResponseEntity.ok(service.getAllProducts());
	    }
	    
	    // ✅ Get product by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Object> getProductById(@PathVariable Long id) {
	        return ResponseEntity.ok(service.getProductById(id));
	    }

	    // ✅ Update product
	    @PutMapping("/{id}")
	    public ResponseEntity<Object> updateProduct(@PathVariable Long id,
	                                                 @RequestBody Product product) {
	        return ResponseEntity.ok(service.updateProduct(id, product));
	    }
	    
	    // ✅ Delete product
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
	    	service.deleteProduct(id);
	        return ResponseEntity.ok("Product deleted successfully");
	    }
}
