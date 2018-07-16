package com.myhall.repository.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myhall.model.UserLogin;

public class LoginrowMapper implements RowMapper<UserLogin>{
	@Override
	public UserLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserLogin user=new UserLogin();
		user.setUserName(rs.getString("uemail"));
		user.setPassword(rs.getString("upassword"));
		return user;
	}

}
