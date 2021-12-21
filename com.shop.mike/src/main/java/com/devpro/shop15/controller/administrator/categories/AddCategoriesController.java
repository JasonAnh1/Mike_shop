package com.devpro.shop15.controller.administrator.categories;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.entities.Categories;
import com.devpro.shop15.services.CategoryService;

@Controller
public class AddCategoriesController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/admin/addCategories" }, method = RequestMethod.GET)
	public String get_addCategories(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		// day du thong bao xuong tang views
		Categories categories = new Categories();
		model.addAttribute("categories", categories);
		return "administrator/categories/addCategories";
	}

	// actionpost
	@RequestMapping(value = { "/admin/addCategories" }, method = RequestMethod.POST)
	public String addCategories(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("categories") Categories categories) throws IOException {
		categoryService.add(categories);
		categoryService.saveOrUpdate(categories);
		return "administrator/categories/addCategories";
	}

}
