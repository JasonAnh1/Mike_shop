package com.devpro.shop15.controller.administrator.products;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.controller.BaseController;
import com.devpro.shop15.dto.ProductSearchModel;
import com.devpro.shop15.entities.Product;
import com.devpro.shop15.services.ProductService;

@Controller
public class ProductManageController extends BaseController {
	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "/admin/producManage" }, method = RequestMethod.GET)
	public String get_product(final Model model, final HttpServletRequest request, final HttpServletResponse response)

	{
		/*
		 * List<Product> list = productService.findAll(); model.addAttribute("Product",
		 * list);
		 */
////lay keyword
		String keyword = request.getParameter("keyword");

		ProductSearchModel searchModel = new ProductSearchModel();
		searchModel.keyword = keyword;
		searchModel.page = getCurrentPage(request);
		searchModel.categoryId = super.getInteger(request, "categoryId");
		model.addAttribute("productSearch", productService.search(searchModel));
		model.addAttribute("searchModel", searchModel);
		return "administrator/product/productManage";
	}

}
