package com.myhall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhall.model.Product;
import com.myhall.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

	@Override
	public List<Product> getSubCategories(String category) {
		return productRepository.getSubCategories(category);	
	}
}

