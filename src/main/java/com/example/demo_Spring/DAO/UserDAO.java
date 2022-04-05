package com.example.demo_Spring.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo_Spring.Mapper.UserMapper;
import com.example.demo_Spring.Model.UserModel;
@Repository
@Transactional
//truy vấn thực hiện các lệnh select, update, insert, delete.
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserModel> listAllUser(){
		String sql = "SELECT * FROM user_information";
		return jdbcTemplate.query(sql, new UserMapper());
	}
	
	public void saveUser(UserModel userModel) {
		if(CheckId(userModel.getId()) ==0) {
			String sql = "insert into user_information (id, name) values (?, ?)";
			jdbcTemplate.update(sql, userModel.getId(), userModel.getName());
		}
	}
	public void deleteUser(String id) {
		String sql = "delete from user_information where id = ?";
		jdbcTemplate.update(sql, id);
	}
	public void updateUser(UserModel userModel) {
		String sql = "update user_information set name = ? where id = ?";
		jdbcTemplate.update(sql, userModel.getName(), userModel.getId());
		
	}
	public List<UserModel> findAll(String search){
		String sql  = "select * from user_information where id like '%" + search +"%' or fullname like '%" + search +"%'";
		return jdbcTemplate.query(sql, new UserMapper());
	}
	
	public UserModel findById(String id) {
		String sql = "select * from user_information where id = ?";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
	}
	//hàm check id xem thử để có chưa để thêm trên hàm public void saveUser(UserModel userModel) ở trên dòng 25.
	public int CheckId(String id) {
		int number = 0;
		String sql = "select count(*) as sum from user_information where id = '" + id + "'";
		number = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return number;
		
	}
	// Thống kê
	public int statistical() {
		int sum =0;
		
		String sql = "select count(id) as sum from user_information";
		sum = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return sum;
		
	}
}
