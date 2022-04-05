package com.example.demo_Spring.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_Spring.Model.UserModel;
import com.example.demo_Spring.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserAPI {

	@Autowired
	private UserService UserService;

	// Thong ke sinh vien
	@GetMapping("/statistical")
	public int statistical() {
		return UserService.statistical();
	}

	@GetMapping("/listAllUser")
	public List<UserModel> listAllUser() {
		return (List<UserModel>) UserService.listAllUser();
	}

	@PostMapping("/saveUser")
	public void saveUser(@RequestBody UserModel UserModel) {
		UserService.saveUser(UserModel);
	}

	@PutMapping("/updateUser")
	public void updateUser(@RequestBody UserModel UserModel) {
		UserService.updateUser(UserModel);
	}

	@DeleteMapping("deleteUser/{id}")
	public void deleteUser(@PathVariable String id) {
		UserService.deteleUser(id);
	}

	@GetMapping("/checkId/{id}")
	public int checkIdUser(@PathVariable String id) {
		return UserService.checkId(id);
	}
}
