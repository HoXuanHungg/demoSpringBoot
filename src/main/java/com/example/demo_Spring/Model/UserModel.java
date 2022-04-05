package com.example.demo_Spring.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class UserModel {
	@NotBlank(message = "Student may not be empty")
	@NotNull(message = "Student may not be null")
	private String id;
	
	@NotBlank(message = "Student may not be empty")
	@NotNull(message = "Student may not be null")
	private String name;
	
	//public UserModel(String id, String name) {
	//	super();
	//	this.id = id;
	//	this.name = name;
	//}
	//public UserModel() {
	//	super();
	}
	//public String getId() {
	//	return id;
	//}
	//public void setId(String id) {
	//	this.id = id;
	//}
	//public String getName() {
	//	return name;
	//}
	//public void setName(String name) {
	//	this.name = name;
	//}
	
	

