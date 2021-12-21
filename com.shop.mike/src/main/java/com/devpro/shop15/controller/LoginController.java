package com.devpro.shop15.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController extends BaseController {
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)

	public String managerHome(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		
		
		return "login";
	}
}
