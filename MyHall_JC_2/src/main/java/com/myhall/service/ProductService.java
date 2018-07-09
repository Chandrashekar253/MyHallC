package com.myhall.service;

import java.util.List;

import com.myhall.model.Product;

public interface ProductService {

	List<Product> getProducts();

	List<Product> getSubCategories(String category);

}