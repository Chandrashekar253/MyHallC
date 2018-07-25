package com.myhall.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myhall.model.Product;
import com.myhall.model.ProductDetails;
import com.myhall.model.ProductList;
import com.myhall.model.UserLogin;
import com.myhall.model.UserRegistration;
import com.myhall.repository.util.DetailsRowMapper;
import com.myhall.repository.util.ListRowmampper;
import com.myhall.repository.util.LoginrowMapper;
import com.myhall.repository.util.ProductRowMapper;

@Repository("productRepository")
public class ProductRepositoryImp implements ProductRepository {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Autowired
	public HttpSession subcat;

	public String category;
	@Override
	public List<Product> getProducts() {
		String sql = "select * from Products";
		List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());
		return products;

	}

	@Override
	public List<Product> getSubCategories(String category) {
		String sql = "select * from MyHallCatagories where catagory=?";
		Object args[] = { category };
		List<Product> categories = jdbcTemplate.query(sql, new ProductRowMapper(), args);

		return categories;
	}

	@Override
	public List<ProductList> getProductsList() {

		try {
		 category=(String) subcat.getAttribute("subCatSession");
	 //  String subCategory=(String)subcat.getAttribute("subCatSession");
	  System.out.println(category);
}
		catch (NullPointerException e00) {
			System.out.println(" Null exception");
		
	   }
		//System.out.println("Subcategory Session"+ subCategoryObj);
		String sql = "select * from "+category+" ";
		System.out.println(sql);
		List<ProductList> productsList = jdbcTemplate.query(sql, new ListRowmampper());
		return productsList;
	}

	@Override
	public List<ProductDetails> getDetails(int id) {
		String sql = "select * from Halls where hid=?";
		Object arg[] = { id };
		List<ProductDetails> productDetails = jdbcTemplate.query(sql, arg, new DetailsRowMapper());
		return productDetails;
	}

	@Override
	public boolean loginCheck(UserLogin user) {
 
		String username = user.getUserName();
		String password = user.getPassword();
		Object usersdata[] = { username, password };
		String sql = "select uemail,upassword from MyHallCustomers where uemail=? and upassword=?";

		UserLogin status = jdbcTemplate.queryForObject(sql, usersdata, new LoginrowMapper());

		if(status==null) {
			System.out.println("No matches found");
			return false;
		}
		else
			{
			System.out.println("Yes matches found");

			return true;
			}
	}
	
	@Override 
	public int registration(UserRegistration registration) {
		
		String username = registration.getUserName();
		String email = registration.getEmail();
		String password = registration.getPassword();
		String mobile = registration.getMobile();
		Object usersdata[] = { username, email, password, mobile };
		
		String checkmail="select uemail from MyHallCustomers where uemail='"+email+"'";
		//Object mail[]= {email};
		List<UserRegistration> check= jdbcTemplate.query(checkmail,new RowMapper<UserRegistration>() {

			@Override
			public UserRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				UserRegistration users= new UserRegistration();
				users.setEmail(rs.getString(1));
				return users;
			}			
		});
		
	System.out.println(check);
		if(check.isEmpty()) {
			String sql="insert into MyHallCustomers(uname,uemail,upassword,umobile) values(?, ?, ?, ?)";		
			int status= jdbcTemplate.update(sql, usersdata);
			System.out.println(status);
			System.out.println("You can register now");
			return 1;
		}
		
		else {

			System.out.println("Exists already");
			return 0;
		}
		
		
		
	}

}
