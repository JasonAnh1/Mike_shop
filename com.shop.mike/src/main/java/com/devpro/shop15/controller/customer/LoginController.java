package com.devpro.shop15.controller.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse respone
			) throws IOException {


		// mvc duoc cau hinh chi dinh vao thu muc /scr/main/webapp/web-ìn/views
		// de tim cac views
		// /web-INF/views/user/index.jsp
		return "customer/login";
	}
}
