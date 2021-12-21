
  package com.devpro.shop15.controller.administrator.history;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.devpro.shop15.dto.Order;
import com.devpro.shop15.entities.SaleOrder;
import com.devpro.shop15.entities.SaleOrderProducts;
import com.devpro.shop15.services.ProductService;
import com.devpro.shop15.services.SaleOrderProductsService;
import com.devpro.shop15.services.SaleOrderService;


 @Controller
 public class HistoryManagementController{
 	
 	@Autowired
 	SaleOrderService saleorderService;
 	
 	@Autowired
 	SaleOrderProductsService saleOrderProductsService;
 	
 	@Autowired
 	ProductService productService;
 	
 	@RequestMapping(value = {"/admin/saleorder"}, method = RequestMethod.GET)
 	public String saleorder(final Model model) {
 		List<SaleOrder> saleorders = saleorderService.findAll();
 		model.addAttribute("saleorder", saleorders);
 		return "administrator/history/historyManagement";
 	}
 	
 	@RequestMapping(value = {"/admin/ajax/detailSaleOrder/{saleorderId}"}, method = RequestMethod.POST)
 	public ResponseEntity<List<Order>> ajax_detailSaleOrder(final Model model,
 			@PathVariable("saleorderId") int id){
 		String sql = "SELECT * FROM shop.tbl_saleorder_products where saleorder_id = " + id;
 		List<SaleOrderProducts> saleorderProducts = saleOrderProductsService.runTransactQuerySQL(sql, 0).getData();
 		
 		
 		List<Order> jsonResult = new ArrayList<Order>();
 		for (SaleOrderProducts s : saleorderProducts) {
			Order order = new Order();
			order.setName(s.getProduct().getTitle());
			order.setPrice(s.getProduct().getPrice().doubleValue());
			order.setQuantity(s.getQuantity());
			order.setPath(s.getProduct().getAvatar());
			jsonResult.add(order);
		}
 		return ResponseEntity.ok(jsonResult);
 	}
 }