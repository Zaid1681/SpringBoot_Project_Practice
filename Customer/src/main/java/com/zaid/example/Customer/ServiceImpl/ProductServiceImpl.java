package com.zaid.example.Customer.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaid.example.Customer.Entity.Product;
import com.zaid.example.Customer.Exceptions.ResourceNotFoundException;
import com.zaid.example.Customer.Repository.ProductRepository;
import com.zaid.example.Customer.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;

	@Override
	public Product addProduct(Product product) {
		Product productSaved = productRepo.save(product);
		return productSaved;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> pdList = productRepo.findAll();
		if (pdList.isEmpty()) {
			throw new ResourceNotFoundException("Product table is empty");
		} else {
			return pdList;
		}
	}

	@Override
	public Product getProductById(Long id) {
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found for product Id: " + id));

		return product;
	}

	@Override
	public void deleteProductById(Long id) {
		Product product = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found for product Id: " + id));
		productRepo.deleteById(id);

	}

	@Override
	public Product updateProductById(Long id, Product product) {
		Product pd = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found for product Id: " + id));
		pd.setProductName(product.getProductName());
		pd.setPrice(product.getPrice());
		pd.setDescription(product.getDescription());
		return productRepo.save(pd);

	}

}
