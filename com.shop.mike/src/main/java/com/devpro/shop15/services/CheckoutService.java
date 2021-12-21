//package com.devpro.shop15.services;
//
//import java.sql.SQLException;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map;
//import java.util.concurrent.ThreadLocalRandom;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//
//import com.devpro.shop15.components.Utilities;
//import com.devpro.shop15.dto.Cart;
//import com.devpro.shop15.dto.CartItem;
//import com.devpro.shop15.entities.SaleOrder;
//import com.devpro.shop15.entities.SaleOrderProducts;
//import com.devpro.shop15.entities.User;
//import com.ibm.icu.text.DateFormat;
//import com.mysql.cj.Constants;
//
//
//@Service
//public class CheckoutService {
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Autowired
//	private ProductSizeService productSizeService;
//
//	@Autowired
//	public JavaMailSender mailSender;
//
//	@Transactional
//	public Map<String, Object> setUpSaleOrder(HttpServletRequest request, Model model, SaleOrder saleOrder, User user,
//			String message, Integer wardId, String specificAddress) throws SQLException, Exception {
//
//		String code = String.valueOf(new Date().getTime() + ThreadLocalRandom.current().nextInt(10000, 99999));
//
//		saleOrder.setCode(code);
//		saleOrder.setCreatedDate(new Date());
//		saleOrder.setCustomerEmail(user.getEmail());
//		saleOrder.setCustomerName(user.getFullName());
//		saleOrder.setCustomerPhone(user.getPhone());
//		
//		if (user.getId()!=null && user.getId()>0) {
//			user.createSaleOrder(saleOrder);
//			saleOrder.setUser(user);
//		}
//
//		if (Utilities.notEmptyString(user.getAddress())) {
//			saleOrder.setCustomerAddress(user.getAddress());
//		} else {
//			String finalAddress = null;
//
//			finalAddress = this.getAddressFromForm(wardId, specificAddress);
//			saleOrder.setCustomerAddress(finalAddress);
//
//		}
//
//		HttpSession session = request.getSession();
//		Cart cart = (Cart) session.getAttribute("cart");
//
//		// cart rỗng, không lưu saleOrder, mà trả về lỗi
//		if (cart == null || cart.getCartItems().size() <= 0) {
//			throw new Exception("Giỏ hàng trống");
//		}
//
//		// hạ số lượng trong kho
//
//		this.reduceQuantity(cart.getCartItems());
//
//		// không lỗi lầm, tạo ...
//		saleOrder.setTotal(cart.getTotalPrice());
//
//		for (CartItem item : cart.getCartItems()) {
//			SaleOrderProduct orderProduct = new SaleOrderProduct();
//			orderProduct.setQuantity(item.getQuantity());
//			orderProduct.setSizeNo(item.getSizeNo());
//
//			ProductSize productSize = productSizeService.findByIds(item.getProductId(), item.getSizeId());
//			orderProduct.setProductSize(productSize);
//
//			saleOrder.addSaleOrderProduct(orderProduct);
//		}
//
//		Map<String, Object> rs = new HashMap<>();
//		rs.put("message", message);
//
//		return rs;
//	}
//
//	/* gửi email */
//	public void sendEmail(SaleOrder saleOrder) throws MessagingException {
//		MimeMessage message = mailSender.createMimeMessage();
//
//		boolean multipart = true;
//
//		MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
//
//		String nameOfWebsite = Constants.NAME_OF_WEBSITE;
//		
//		
//		String htmlMsg = "<body style=\"background-color: #eee\">\r\n"
//				+ "		<div id=\"app\" style=\"background-color: #fff; max-width: 600px; margin: auto; padding: 15px\">\r\n"
//				+ "			<h3 style=\"font-size: 1.1rem\">Cảm ơn quý khách đã đặt hàng tại " + nameOfWebsite + ",</h3>\r\n"
//				+ "			<p>\r\n"
//				+ nameOfWebsite + " rất vui thông báo đơn hàng của quý khách đã được tiếp nhận và đang trong quá trình xử lý.\r\n"
//				+ nameOfWebsite + " sẽ thông báo đến quý khách ngay khi hàng chuẩn bị được giao.\r\n"
//				+ "			</p>";
//		
//		// handle date format
//		Locale vnLocale = new Locale("vi", "VN");
//		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, vnLocale);
//		String formattedDate = df.format(saleOrder.getCreatedDate());
//		
//		// handle money format
//		java.text.NumberFormat currencyFormatter = java.text.NumberFormat.getCurrencyInstance(vnLocale); 
//		
//		htmlMsg += "<h3 style=\"font-size: 1rem\">THÔNG TIN ĐƠN HÀNG #" + saleOrder.getCode() + "</h3>";
//		htmlMsg += "<p>Được tạo vào " + formattedDate + "</p>";
//		htmlMsg += "<h3>Thông tin thanh toán</h3>";
//		htmlMsg +=  "<p>" + saleOrder.getCustomerName() + "</p>";
//		htmlMsg +=  "<p>" + saleOrder.getCustomerEmail() + "</p>";
//		htmlMsg +=  "<p>" + saleOrder.getCustomerPhone() + "</p>";
//		htmlMsg +=  "<p>Địa chỉ giao hàng: " + saleOrder.getCustomerAddress() + "</p>";
//		htmlMsg +=  "<p><b>Phương thức thanh toán: </b>COD (thanh toán tiền mặt khi nhận hàng)</p>";
//		htmlMsg +=  "<p><b>Thời gian giao hàng dự kiến: </b>3-5 ngày tùy đơn vị vận chuyển</p>";
//		htmlMsg +=	"<h3 style=\"color: #fc5185; border-bottom: 1px solid #aaa; padding-bottom: 10px\">CHI TIẾT ĐƠN HÀNG</h3>";
//		htmlMsg += "<table class=\"\" style=\"width: 100%;border-collapse: collapse\" border=\"1\" cellspacing=\"2\" cellpadding=\"7\">\r\n"
//				+ "				<thead style=\"background: #364f6b; color: #fff; text-align: left\">\r\n"
//				+ "					<th>Sản phẩm</th>\r\n"
//				+ "					<th>Size</th>\r\n"
//				+ "					<th>Đơn giá</th>\r\n"
//				+ "					<th>Số lượng</th>\r\n"
//				+ "					<th style=\"text-align:right\">Tổng tạm</th>\r\n"
//				+ "				</thead>\r\n"
//				+ "				<tbody>";
//		
//		java.math.BigDecimal subTotal = java.math.BigDecimal.ZERO;
//		for (SaleOrderProducts s : saleOrder.getSaleOrderProducts()) {
//			subTotal = subTotal.add(s.getProductSize().getProduct().getPrice().multiply(new java.math.BigDecimal(s.getQuantity())));
//			String priceUnit = currencyFormatter.format(s.getProductSize().getProduct().getPrice());
//			String subTotalOfThisItem = currencyFormatter.format(s.getProductSize().getProduct().getPrice().multiply(new java.math.BigDecimal(s.getQuantity())));
//			
//			String row = "<tr style=\"background-color: #eee; text-align: left\">";
//			row += "<td>" + s.getProductSize().getProduct().getName() + "</td>";
//			row += "<td>" + s.getProductSize().getSize().getSizeNo() + "</td>";
//			row += "<td>" + priceUnit + "</td>";
//			row += "<td>" + s.getQuantity() + "</td>";
//			row += "<td style=\"text-align:right\">" + subTotalOfThisItem  + "</td>";
//			row += "</tr>";
//			
//			htmlMsg += row;
//		}
//		
//		String subTotalString = currencyFormatter.format(subTotal);
//		String shipmentCostString = currencyFormatter.format(0);
//		
//		htmlMsg += "<tr style=\"text-align: right\">\r\n"
//				+ "						<td colspan=\"4\">Tạm tính</td>\r\n";
//		htmlMsg += "<td>" + subTotalString + "</td>";
//		htmlMsg += "</tr>";
//		htmlMsg += "<tr style=\"text-align: right\">\r\n"
//				+ "						<td colspan=\"4\">Phí vận chuyển</td>\r\n"
//				+ "						<td>" + shipmentCostString + "</td>\r\n"
//				+ "					</tr>";
//
//		htmlMsg += "<tr style=\"text-align: right; font-weight: bold; background-color: #eee\">\r\n"
//				+ "						<td colspan=\"4\">Tổng giá trị đơn hàng</td>\r\n";
//		htmlMsg += "<td>" + subTotalString + "</td>";
//		htmlMsg += "</tr>";
//		htmlMsg += "	</tbody>\r\n"
//				+ "			</table>";
//		htmlMsg += "<p>\r\n"
//				+ "				Trường hợp quý khách có những băn khoăn về đơn hàng, có thể gửi câu hỏi trực tiếp qua địa chỉ email này\r\n"
//				+ "				(congtrinhhbangiay@gmail.com)\r\n"
//				+ "			</p>";
//		htmlMsg += "<p><b>Một lần nữa Công'shop cảm ơn quý khách.</b></p>";
//		htmlMsg += "<p style=\"text-align: right; color: #364f6b; font-weight: bold\">" + nameOfWebsite + "</p>";
//		htmlMsg += "</div>\r\n"
//				+ "	</body>";
//		
//		
//		message.setContent(htmlMsg, "text/html; charset=utf-8");
//
//		helper.setTo(saleOrder.getCustomerEmail());// thay
//		helper.setSubject(nameOfWebsite + " - Xác nhận đơn hàng #" + saleOrder.getCode());
//
//		this.mailSender.send(message);
//	}
//
//}