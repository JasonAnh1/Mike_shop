package com.devpro.shop15.controller.administrator.accout;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.components.Utilities;
import com.devpro.shop15.controller.BaseController;
import com.devpro.shop15.entities.Role;
import com.devpro.shop15.entities.User;
import com.devpro.shop15.services.RoleService;
import com.devpro.shop15.services.UserService;



@Controller
public class AdminAccountController extends BaseController{
	
	@Autowired UserService userService;
	
	@Autowired RoleService roleService;
	
	@RequestMapping(value = "/admin/addAccout", method = RequestMethod.GET)
	public String addAccount(final Model model) throws IOException{
		model.addAttribute("account", new User());
		return "administrator/accout/addAccout";
	}
	
	@RequestMapping(value = "/admin/customerAccount", method = RequestMethod.GET)
	public String customerAccount(final Model model) throws IOException{
		List<User> users = userService.search(null, 1).getData();
		model.addAttribute("users", users);
		return "administrator/accout/userAccout";
	}
	
	@RequestMapping(value = "/admin/adminAccout", method = RequestMethod.GET)
	public String staffAccount(final Model model) throws IOException{
		List<User> users = userService.search(null, 2).getData();
		model.addAttribute("users", users);
		return "administrator/accout/adminAccout";
	}
	
	@RequestMapping(value = "/admin/addAccout", method = RequestMethod.POST)
	public String addAccountPost(final Model model, HttpServletRequest request, @ModelAttribute("account") User user) throws IOException{
		int r = Integer.parseInt(request.getParameter("role"));
		Role role = roleService.getById(r);
		user.addRole(role);
		user.setPassword(Utilities.encode(user.getPassword()));
		userService.saveOrUpdate(user);
		return "administrator/accout/addAccout";
	}
	
	@RequestMapping(value = {"/admin/ajax/account/deleteAccount/{accountId}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> deleteAccount(final Model model,
					@PathVariable("accountId") int productId
					){
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		
		return ResponseEntity.ok(jsonResult);
	}
}
