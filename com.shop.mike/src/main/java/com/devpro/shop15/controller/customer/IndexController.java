package com.devpro.shop15.controller.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.controller.BaseController;
import com.devpro.shop15.dto.CategorySearchModel;
import com.devpro.shop15.dto.NewsLetterModel;
import com.devpro.shop15.dto.ProductSearchModel;
import com.devpro.shop15.entities.Categories;
import com.devpro.shop15.entities.Product;
import com.devpro.shop15.entities.ProductImages;
import com.devpro.shop15.services.CategoryService;
import com.devpro.shop15.services.PagerData;
import com.devpro.shop15.services.ProducImagesService;
import com.devpro.shop15.services.ProductService;

@Controller
public class IndexController extends BaseController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProducImagesService producImagesService;

	// dinh nghia action
	@RequestMapping(value = { "/index" }, method = RequestMethod.GET)
	public String home(final ModelMap model, final HttpServletRequest request, final HttpServletResponse respone)
			throws IOException {
		ProductSearchModel productSearchModel = new ProductSearchModel();
		productSearchModel.setHot(true);
		productSearchModel.setStatus(true);
		Product product = productService.search(productSearchModel).getData().get(0);
		model.addAttribute("product", productService.search(productSearchModel));
		
		
		// mvc duoc cau hinh chi dinh vao thu muc /scr/main/webapp/web-ìn/views
		// de tim cac views
		// /web-INF/views/user/index.jsp
		
		
		String keyword = request.getParameter("keyword");

		ProductSearchModel searchModel = new ProductSearchModel();
		searchModel.keyword = keyword;
		searchModel.page = getCurrentPage(request);
		searchModel.categoryId = super.getInteger(request, "categoryId");
		searchModel.status = false;
		model.addAttribute("productSearch", productService.search(searchModel));
		model.addAttribute("searchModel", searchModel);
		// tim kiem
		return "customer/index";
	}

	@RequestMapping(value = { "/ajax/index" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_contact(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody NewsLetterModel newsLetterModel) {
		Map<String, Object> jsonResult = new HashMap<String, Object>();

		return ResponseEntity.ok(jsonResult);
	}

	@RequestMapping(value = { "/category/{seo}" }, method = RequestMethod.GET)
	public String category(final ModelMap model, final HttpServletRequest request, final HttpServletResponse respone,
			@PathVariable("seo") String seo) throws IOException {
		
		CategorySearchModel categorySearchModel = new CategorySearchModel();
		categorySearchModel.setSeo(seo);
		Categories categories = categoryService.search(categorySearchModel).getData().get(0);
		ProductSearchModel productSearchModel = new ProductSearchModel();
		productSearchModel.setStatus(true);
		Product product = productService.search(productSearchModel).getData().get(0);
		productSearchModel.categoryId = categories.getId();
		model.addAttribute("producsData", productService.search(productSearchModel));

		return "customer/category";
	}

	@RequestMapping(value = { "/detail/{seo}" }, method = RequestMethod.GET)
	public String detailproduct(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse respone, @PathVariable("seo") String seo) throws IOException {

		ProductSearchModel productSearchModel = new ProductSearchModel();
		productSearchModel.seo = seo;
		PagerData<Product> pagerData = productService.search(productSearchModel);
		Product product = pagerData.getData().get(0);
		model.addAttribute("product", product);
		List<ProductImages> list = producImagesService.findAll();
		model.addAttribute("listimg", list);

		// mvc duoc cau hinh chi dinh vao thu muc /scr/main/webapp/web-ìn/views
		// de tim cac views
		// /web-INF/views/user/index.jsp
		return "customer/detailProduct";
	}
}