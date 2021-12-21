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
public class UpdateCategoriesController {
@Autowired
private CategoryService categoryService;
@RequestMapping(value = "/admin/updateCategories",method = RequestMethod.GET)
public String updateCategories (Model model,
		HttpServletRequest request,
		HttpServletResponse response){
	Categories categories = new Categories();
	Integer id = Integer.parseInt(request.getParameter("cid"));
	categories = categoryService.getById(id);
	model.addAttribute("categories", categories);		
	return "administrator/categories/updateCategories";
	}

@RequestMapping(value = "/admin/updateCategories",method =RequestMethod.POST )
public String updateCategories(Model model,
		HttpServletRequest request,
		HttpServletResponse response,
		@ModelAttribute("categories") Categories categories) throws IOException {
	    categoryService.update(categories);
	    categoryService.saveOrUpdate(categories);
	    response.sendRedirect("categoriesManage");
	return "administrator/categories/updateCategories";
	
}

}
