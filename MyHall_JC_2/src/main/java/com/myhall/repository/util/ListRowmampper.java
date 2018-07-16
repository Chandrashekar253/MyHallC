package com.myhall.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myhall.model.ProductList;

public class ListRowmampper implements RowMapper<ProductList> {

	@Override
	public ProductList mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductList prodlist= new ProductList();
		prodlist.setId(rs.getInt(1));
		prodlist.setProductName(rs.getString(2));
		prodlist.setAddress(rs.getString(3));
		prodlist.setRating(rs.getFloat(4));
		prodlist.setRatingcCount(rs.getInt(5));
		prodlist.setImage(rs.getString(6));
		prodlist.setPrice(rs.getString(8));
		prodlist.setDescription(rs.getString(9));

		return prodlist;
	}
}
