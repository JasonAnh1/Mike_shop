package com.devpro.shop15.controller.administrator.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.entities.ProductImages;
import com.devpro.shop15.services.ProducImagesService;

@Controller
public class ProductImagesController {
	@Autowired
	private ProducImagesService  producImagesService;
    
	@RequestMapping (value = {"/admin/productImage"}, method = RequestMethod.GET )
	public String get_product(final Model model,
			                  final HttpServletRequest request,
			                  final HttpServletResponse response)


	{ List<ProductImages> list = producImagesService.findAll();
	model.addAttribute("listproduct", list);
		return "administrator/product/productImage";
	}
}
