package com.example.demo_Spring.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_Spring.DAO.UserDAO;
import com.example.demo_Spring.Model.UserModel;


@Service
@Transactional
//cung cấp dịch vụ.
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public List<UserModel> listAllUser(){
		List<UserModel> listUser = userDAO.listAllUser();
		return listUser;
	}
	
	public int statistical() {
		int sum = 0;
		sum = userDAO.statistical();
		return sum;
	}
	public void saveUser(UserModel userModel) {
		userDAO.saveUser(userModel);
		
	}
	public void updateUser(UserModel userModel) {
		userDAO.updateUser(userModel);
		
	}
	public void deteleUser(String id) {
		userDAO.deleteUser(id);
		
	}
	
	public int checkId(String id) {
		int number = 0;
		number = userDAO.CheckId(id);
		return number;
	}
	public UserModel deltailUser(String id) {
		return userDAO.findById(id);
		
	}
}
