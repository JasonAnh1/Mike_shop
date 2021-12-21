package com.devpro.shop15.controller.administrator.products;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.shop15.entities.Product;
import com.devpro.shop15.services.CategoryService;
import com.devpro.shop15.services.ProductService;

@Controller
public class UpdateController {
@Autowired
ProductService productService;
@Autowired
CategoryService categoryService;

@RequestMapping(value = { "/admin/update" }, method = RequestMethod.GET)
public String get_update(final Model model, final HttpServletRequest request,
		final HttpServletResponse response) {
//gui danh sach categories xuong view
	model.addAttribute("categories", categoryService.findAll());
	Product product = new Product();
	Integer id = Integer.parseInt(request.getParameter("uid"));
	product = productService.getById(id);
	model.addAttribute("product", product);		
	return "administrator/product/Update";
}

@RequestMapping(value = { "/admin/update" }, method = RequestMethod.POST)
public String post_update(final Model model, final HttpServletRequest request, final HttpServletResponse response,
		@ModelAttribute("product") Product product,
		 @RequestParam("productAvatar") MultipartFile productAvatar,
			@RequestParam("productPictures") MultipartFile[] productPictures) throws IOException {
	productService.update(product, productAvatar, productPictures);
//	model.addAttribute("categories", categoryService.findAll());
//	productService.saveOrUpdate(product);
	return "administrator/product/Update";
}
}
