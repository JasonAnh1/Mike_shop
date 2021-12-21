package com.devpro.shop15.controller.customer;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.controller.BaseController;
import com.devpro.shop15.dto.Cart;
import com.devpro.shop15.dto.CartItem;
import com.devpro.shop15.entities.Product;
import com.devpro.shop15.entities.SaleOrder;
import com.devpro.shop15.entities.SaleOrderProducts;
import com.devpro.shop15.services.ProductService;
import com.devpro.shop15.services.SaleOrderService;

@Controller
public class CartController extends BaseController {
	  @Autowired
	    public JavaMailSender emailSender;
	  
	@Autowired 
	SaleOrderService saleOrderService;
	
	@Autowired
	ProductService productService;
	public void sendEmail(String recipientEmail) 
		throws MessagingException , UnsupportedEncodingException {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			helper.setFrom("torukokonoe217@gmail.com");
			helper.setTo(recipientEmail);
			
			String subject = "Thanks for order";
			String content = "<p>Hello,</p>"
					+"<p> cam on ban da mua hang nhan vien se nhanh trong lien lac</p>";
			
					helper.setSubject(subject);
			        helper.setText(content,true);
			        emailSender.send(message);
		}
	
	@RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
	public String cart(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
		return "customer/cart";
	}
	@RequestMapping(value = { "/ajax/cart" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_AddToCart(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody CartItem cartItem) {

		// để lấy session sử dụng thông qua request
		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();

		// kiểm tra nếu có trong giỏ hàng thì tăng số lượng
		boolean isExists = false;
		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				isExists = true;
				item.setQuantity(item.getQuantity() + cartItem.getQuantity());
			}
		}

		// nếu sản phẩm chưa có trong giỏ hàng
		if (!isExists) {
			Product productInDb = productService.getById(cartItem.getProductId());

			cartItem.setProductName(productInDb.getTitle());
			cartItem.setPriceUnit(productInDb.getPrice());
			cartItem.setPath(productInDb.getAvatar());
			cart.getCartItems().add(cartItem);
		}

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("totalItems", getTotalItems(request));
		
		session.setAttribute("totalItems", getTotalItems(request));

		return ResponseEntity.ok(jsonResult);
	}

	@RequestMapping(value = { "/ajax/deleteCart" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_deleteCart(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody CartItem cartItem) {

		// để lấy session sử dụng thông qua request
		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		cart = (Cart) session.getAttribute("cart");

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();

		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				cart.getCartItems().remove(item);
				break;
			}
		}
		session.setAttribute("cart", cart);
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("totalItems", getTotalItems(request));
		
		session.setAttribute("totalItems", getTotalItems(request));

		return ResponseEntity.ok(jsonResult);
	}
	
	@RequestMapping(value = { "/ajax/changeQuantity" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_changeQuantity(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final @RequestBody CartItem cartItem) {

		// để lấy session sử dụng thông qua request
		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		cart = (Cart) session.getAttribute("cart");

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem item : cartItems) {
			if(item.getProductId() == cartItem.getProductId()) {
				item.setQuantity(cartItem.getQuantity());
				session.setAttribute("totalItems", getTotalItems(request));
				break;
			}
		}
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("totalItems", getTotalItems(request));
		return ResponseEntity.ok(jsonResult);
	}
	
	@RequestMapping(value = {"/cart/checkout"}, method = RequestMethod.GET)
	public String get_checkout(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		Cart cart = null;
		cart = (Cart) session.getAttribute("cart");
		if(cart != null) {
			BigDecimal total = BigDecimal.ZERO;
			List<CartItem> cartItems = cart.getCartItems();
			
			for (CartItem item : cartItems) {
				BigDecimal subTotal = BigDecimal.ZERO;
				subTotal = item.getPriceUnit().multiply(BigDecimal.valueOf(item.getQuantity()));
				total = total.add(subTotal);
			}
			cart.setTotalPrice(total);
			session.setAttribute("totalPrice", cart.getTotalPrice());
		}
		else {
			session.setAttribute("totalPrice", 0);
		}
//		User user = Utilities.getLoginedUser();
//		if (user != null) {
//
//			// nếu đã đăng nhập, thì phải là CUSTOMER,
//			// ADMIN, MANAGER,.. ra chỗ khác chơi
//			try {
//				for (GrantedAuthority auth : user.getAuthorities()) {
//					if (Constants.ROLE_CUSTOMER.equals(auth.getAuthority()) == false) {
//						throw new Exception("Bạn phải là một khách hàng");
//					}
//					break;
//				}
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//
//			// thỏa mãn là CUSTOMER, tiếp tục..
//
//		} else {
//			user = new User();
//		}
		
		
		return "customer/checkout";
	}
	
	@RequestMapping(value = {"/cart/checkout"}, method = RequestMethod.POST)
	public String post_checkout(final Model model,
			final HttpServletRequest request,
			final HttpServletResponse response) throws IOException, MessagingException{
		
		String customerFullname = request.getParameter("fullname");
		String customerEmail = request.getParameter("email");
		String customerPhoneNumber = request.getParameter("phonenumber");
		String customerAddress = request.getParameter("address");
		
		SaleOrder saleorder = new SaleOrder();
		saleorder.setCustomerName(customerFullname);
		saleorder.setCustomerEmail(customerEmail);
		saleorder.setCustomerPhone(customerPhoneNumber);
		saleorder.setCustomerAddress(customerAddress);
		//mã hóa đơn
		saleorder.setCode(String.valueOf(System.currentTimeMillis()));
		HttpSession session = request.getSession();
		Cart cart = null;
		cart = (Cart) session.getAttribute("cart");
		for (CartItem item : cart.getCartItems()) {
			SaleOrderProducts saleorderProduct = new SaleOrderProducts();
			saleorderProduct.setProduct(productService.getById(item.getProductId()));
			saleorderProduct.setQuantity(item.getQuantity());
			saleorder.setTotal(cart.getTotalPrice());	
			saleorder.addSaleOrderProduct(saleorderProduct);
		}
		saleOrderService.saveOrUpdate(saleorder);
//		 SimpleMailMessage message = new SimpleMailMessage();
//	        
//	        message.setTo(saleorder.getCustomerAddress());
//	        message.setSubject("Test Simple Email");
//	        message.setText("Hello, Im testing Simple Email");
//
//	        // Send Message!
//	        this.emailSender.send(message);
		this.sendEmail(saleorder.getCustomerEmail());
		session.setAttribute("cart", null);
		session.setAttribute("totalItems", 0);
		session.setAttribute("totalPrice", 0);
		return "redirect:/index";
	}
}

