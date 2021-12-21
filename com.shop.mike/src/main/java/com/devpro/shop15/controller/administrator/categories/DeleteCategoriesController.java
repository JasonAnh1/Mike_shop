package com.devpro.shop15.controller.administrator.categories;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.services.CategoryService;

@Controller
public class DeleteCategoriesController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/admin/deleteCategories" }, method = RequestMethod.GET)
	public String get_addCategories(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		categoryService.deleteById(id);
		response.sendRedirect("categoriesManage");
		return "administrator/categories/categoriesManage";
	}
}
	// actionpost
	
