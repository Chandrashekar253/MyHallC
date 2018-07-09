package com.myhall.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myhall.model.Product;
import com.myhall.repository.util.ProductRowMapper;

@Repository("productRepository")
public class ProductRepositoryImp implements ProductRepository {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getProducts() {
		
		String sql="select * from Products";
		List<Product> products= jdbcTemplate.query(sql, new ProductRowMapper());
				//query(sql, new ProductRowMapper());
		
		return products;
		
	}
	
	@Override
	public List<Product> getSubCategories(String category) {
		String sql="select * from MyHallCatagories where catagory=?";
		Object args[]= {category};
		List<Product> categories=jdbcTemplate.query(sql, new ProductRowMapper(),args);
		
		return categories;
	}
	
}
