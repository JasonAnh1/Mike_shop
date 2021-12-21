package com.devpro.shop15.controller.administrator.categories;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.entities.Categories;
import com.devpro.shop15.services.CategoryService;
@Controller
public class CategoriesManagementController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/admin/categoriesManage" }, method = RequestMethod.GET)
	public String get_categoriesManage(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		List<Categories> list = categoryService.findAll();
		model.addAttribute("listcate", list);

		return "administrator/categories/categoriesManage";
	}

}
