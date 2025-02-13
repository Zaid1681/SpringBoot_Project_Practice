package com.zaid.example.Customer.Service;

import java.util.List;

import com.zaid.example.Customer.Entity.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public List<Product> getAllProduct();
	public Product getProductById(Long id);
	public void deleteProductById(Long id);
	public Product updateProductById(Long id , Product pd);
}
