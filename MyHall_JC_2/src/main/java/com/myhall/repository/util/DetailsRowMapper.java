package com.myhall.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myhall.model.ProductDetails;

public class DetailsRowMapper implements RowMapper<ProductDetails> {
	
	@Override
	public ProductDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductDetails details = new ProductDetails();
		details.setProdoctId(rs.getInt(1));
		details.setProductName(rs.getString(2));
		details.setProductAddress(rs.getString(3));
		details.setProductRating(rs.getFloat(4));
		details.setProductRateCount(rs.getInt(5));
		details.setProductImage(rs.getString(6));
		details.setProductVideo(rs.getString(7));
		details.setProductPrice(rs.getString(8));
		details.setProductDescription(rs.getString(9));
		details.setProductServices(rs.getString(10));
		details.setProdCategory(rs.getString(12));
		details.setProductowner(rs.getString(13));
		details.setProductFacilities(rs.getString(14));
		return details;
	}

}
