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
public class AddProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/admin/addProduct" }, method = RequestMethod.GET)
	public String get_addproduct(final Model model, final HttpServletRequest request,
			final HttpServletResponse response) {
		model.addAttribute("product", new Product());
//gui danh sach categories xuong view
 model.addAttribute("categories", categoryService.findAll());

		return "administrator/product/addProduct";
	}

	@RequestMapping(value = { "/admin/addProduct" }, method = RequestMethod.POST)
	public String addCategories(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("product") Product product, @RequestParam("productAvatar") MultipartFile productAvatar,
			@RequestParam("productPictures") MultipartFile[] productPictures) throws IOException {
		productService.add(product, productAvatar, productPictures);
		productService.saveOrUpdate(product);
		return "administrator/product/addProduct";
	}
}
