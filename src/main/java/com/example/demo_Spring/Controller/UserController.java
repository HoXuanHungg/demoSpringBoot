package com.example.demo_Spring.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_Spring.Model.UserModel;
import com.example.demo_Spring.Service.UserService;

@Controller
//khai báo đường dẫn trên ứng dụng
public class UserController {
	@Autowired
	private UserService UserService;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("User_save", new UserModel());
		model.addAttribute("listUser", UserService.listAllUser());
		// thong ke sinh vien
		model.addAttribute("statistical", UserService.statistical());
		return "index";
	}

	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute("user_save") @Validated UserModel UserModel,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("listUser", UserService.listAllUser());
			// thong ke sinh vien
			model.addAttribute("statistical", UserService.statistical());
			return "index";
		}

		UserService.saveUser(UserModel);
		model.addAttribute("listUser", UserService.listAllUser());
		return "redirect:/";
	}

	@RequestMapping("/deleteUser/{idUser}")
	public String deleteUser(@PathVariable String id, Model model) {
		UserService.deteleUser(id);
		model.addAttribute("listUser", UserService.listAllUser());
		return "redirect:/";
	}

	@RequestMapping("/updateUser/{idUser}")
	public String showUpdate(@PathVariable String id, Model model) {
		UserModel detailUser = UserService.deltailUser(id);
		model.addAttribute("user_update", new UserModel());
		model.addAttribute("detailUser", detailUser);
		return "updateUser";
	}
	
	
	//@RequestMapping("/updateUser/{idUser}")
	//public String showUpdate(@RequestBody UserModel userModel,  @PathVariable String id, Model model) {
	//	UserModel detailUser = UserService.deltailUser(id);
	//	model.addAttribute("user_update", new UserModel());
	//	model.addAttribute("detailUser", detailUser);
	//	return "updateUser";
	//}
	
	

	@RequestMapping("/updateStudent")
	public String updateUser(@ModelAttribute("user_update") @Valid UserModel UserModel, Model model) {
		UserService.updateUser(UserModel);
		return "redirect:/";
	}

}
