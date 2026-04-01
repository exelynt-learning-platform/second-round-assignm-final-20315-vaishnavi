package com.example.demo.Service;

import com.example.demo.Entity.Product;

public interface ProductService {

	Product addProduct(Product product);

	Object getAllProducts();

	Object getProductById(Long id);

	Object updateProduct(Long id, Product product);

	void deleteProduct(Long id);

}
