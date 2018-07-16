package com.myhall.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myhall.model.Product;

public class ProductRowMapper implements RowMapper<Product>{
	
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
       Product product = new Product();

		
       if(rs==null) {
           return null;
       } else
       {
           product.setProductId(rs.getInt(1));
           product.setProductName(rs.getString(2));
           product.setProductImage(rs.getString(3));
           return product;
           
       }
		
	}
}
