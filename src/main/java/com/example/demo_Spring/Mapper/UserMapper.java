package com.example.demo_Spring.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo_Spring.Model.UserModel;
// map các trường trong csdl về đối tượng.
public class UserMapper implements RowMapper<UserModel>{
	public UserModel mapRow(ResultSet result, int rowNum) throws SQLException {
		UserModel userModel = new UserModel();
		userModel.setId(result.getString("id"));
		userModel.setName(result.getString("name"));
		
		return userModel;
	}
}
