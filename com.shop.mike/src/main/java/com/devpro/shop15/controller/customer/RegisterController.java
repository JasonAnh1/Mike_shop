package com.devpro.shop15.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.components.Utilities;
import com.devpro.shop15.controller.BaseController;
import com.devpro.shop15.entities.Role;
import com.devpro.shop15.entities.User;
import com.devpro.shop15.services.RoleService;
import com.devpro.shop15.services.UserService;
@Controller
public class RegisterController extends BaseController {
	@Autowired
	RoleService roleService;
	@Autowired 
	UserService userService;
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String addAccount(final Model model) throws IOException{
		model.addAttribute("account", new User());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addAccountPost(final Model model, HttpServletRequest request, @ModelAttribute("account") User user) throws IOException{
		Role role = roleService.getByTransactQuerySQL("SELECT * FROM shop.tbl_roles r where r.name = 'GUEST'");
		user.addRole(role);
		System.out.println(role);
		user.setPassword(Utilities.encode(user.getPassword()));
		userService.saveOrUpdate(user);
		return "register";
	}

}
