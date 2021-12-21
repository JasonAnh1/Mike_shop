package com.devpro.shop15.controller.administrator.products;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.devpro.shop15.entities.Product;
import com.devpro.shop15.services.ProductService;

@Controller
public class DeleteProductController {
@Autowired
ProductService productService;
@PostMapping(value = {"/admin/ajax/delete/product/{id}"})
public ResponseEntity<Product> delete(Model model, @PathVariable("id") Integer id, HttpServletResponse response){
	System.out.println("ID Products: "+id);
	Product products = this.productService.getById(id);
	if (products != null){
		if(products.getStatus() == false){
			products.setStatus(true);
			this.productService.saveOrUpdate(products);
		}
	}
	return ResponseEntity.ok(products);
}
	
}


