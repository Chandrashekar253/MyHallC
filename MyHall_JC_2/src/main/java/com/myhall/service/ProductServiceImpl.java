package com.myhall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhall.model.Product;
import com.myhall.model.ProductDetails;
import com.myhall.model.ProductList;
import com.myhall.model.UserLogin;
import com.myhall.model.UserRegistration;
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
	
	@Override
	public List<ProductList> getproductList(){		
		return productRepository.getProductsList();
	}
	
	@Override
	public List<ProductDetails> getDetails(int id){
		return productRepository.getDetails(id);
	}
	
	@Override 
	public boolean loginCheck(UserLogin user) {
		return productRepository.loginCheck(user);
	}
	
	@Override
	public int registration(UserRegistration register) {
		return productRepository.registration(register);
	}
}

