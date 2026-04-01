package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Reposotory.ProductRepository;
import com.example.demo.Service.ProductService;

@Service
public class ProductDao implements ProductService{

	 @Autowired
	 private ProductRepository repo;
	 
	 
	@Override
	public Product addProduct(Product product) {
		return repo.save(product);
	}


	@Override
	public Object getAllProducts() {
    return repo.findAll();
	}


	@Override
	public Object getProductById(Long id) {
		 return repo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	}


	@Override
	public Object updateProduct(Long id, Product product) {
		 Product existing = (Product) getProductById(id);

	        existing.setName(product.getName());
	        existing.setDescription(product.getDescription());
	        existing.setPrice(product.getPrice());
	        existing.setStock(product.getStock());

	        return repo.save(existing);
	}


	@Override
	public void deleteProduct(Long id) {
		 repo.deleteById(id);
		
	}

}
