package com.myhall.repository;

import java.util.List;

import com.myhall.model.Product;

public interface ProductRepository {

	List<Product> getProducts();

	List<Product> getSubCategories(String category);

}