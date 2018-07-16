package com.myhall.repository;

import java.util.List;

import com.myhall.model.Product;
import com.myhall.model.ProductDetails;
import com.myhall.model.ProductList;
import com.myhall.model.UserLogin;
import com.myhall.model.UserRegistration;

public interface ProductRepository {

	List<Product> getProducts();

	List<Product> getSubCategories(String category);

	List<ProductList> getProductsList();

	List<ProductDetails> getDetails(int id);

	boolean loginCheck(UserLogin user);

	int registration(UserRegistration registration);
}