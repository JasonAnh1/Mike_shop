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
//		// cart r???ng, kh??ng l??u saleOrder, m?? tr??? v??? l???i
//		if (cart == null || cart.getCartItems().size() <= 0) {
//			throw new Exception("Gi??? h??ng tr???ng");
//		}
//
//		// h??? s??? l?????ng trong kho
//
//		this.reduceQuantity(cart.getCartItems());
//
//		// kh??ng l???i l???m, t???o ...
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
//	/* g???i email */
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
//				+ "			<h3 style=\"font-size: 1.1rem\">C???m ??n qu?? kh??ch ???? ?????t h??ng t???i " + nameOfWebsite + ",</h3>\r\n"
//				+ "			<p>\r\n"
//				+ nameOfWebsite + " r???t vui th??ng b??o ????n h??ng c???a qu?? kh??ch ???? ???????c ti???p nh???n v?? ??ang trong qu?? tr??nh x??? l??.\r\n"
//				+ nameOfWebsite + " s??? th??ng b??o ?????n qu?? kh??ch ngay khi h??ng chu???n b??? ???????c giao.\r\n"
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
//		htmlMsg += "<h3 style=\"font-size: 1rem\">TH??NG TIN ????N H??NG #" + saleOrder.getCode() + "</h3>";
//		htmlMsg += "<p>???????c t???o v??o " + formattedDate + "</p>";
//		htmlMsg += "<h3>Th??ng tin thanh to??n</h3>";
//		htmlMsg +=  "<p>" + saleOrder.getCustomerName() + "</p>";
//		htmlMsg +=  "<p>" + saleOrder.getCustomerEmail() + "</p>";
//		htmlMsg +=  "<p>" + saleOrder.getCustomerPhone() + "</p>";
//		htmlMsg +=  "<p>?????a ch??? giao h??ng: " + saleOrder.getCustomerAddress() + "</p>";
//		htmlMsg +=  "<p><b>Ph????ng th???c thanh to??n: </b>COD (thanh to??n ti???n m???t khi nh???n h??ng)</p>";
//		htmlMsg +=  "<p><b>Th???i gian giao h??ng d??? ki???n: </b>3-5 ng??y t??y ????n v??? v???n chuy???n</p>";
//		htmlMsg +=	"<h3 style=\"color: #fc5185; border-bottom: 1px solid #aaa; padding-bottom: 10px\">CHI TI???T ????N H??NG</h3>";
//		htmlMsg += "<table class=\"\" style=\"width: 100%;border-collapse: collapse\" border=\"1\" cellspacing=\"2\" cellpadding=\"7\">\r\n"
//				+ "				<thead style=\"background: #364f6b; color: #fff; text-align: left\">\r\n"
//				+ "					<th>S???n ph???m</th>\r\n"
//				+ "					<th>Size</th>\r\n"
//				+ "					<th>????n gi??</th>\r\n"
//				+ "					<th>S??? l?????ng</th>\r\n"
//				+ "					<th style=\"text-align:right\">T???ng t???m</th>\r\n"
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
//				+ "						<td colspan=\"4\">T???m t??nh</td>\r\n";
//		htmlMsg += "<td>" + subTotalString + "</td>";
//		htmlMsg += "</tr>";
//		htmlMsg += "<tr style=\"text-align: right\">\r\n"
//				+ "						<td colspan=\"4\">Ph?? v???n chuy???n</td>\r\n"
//				+ "						<td>" + shipmentCostString + "</td>\r\n"
//				+ "					</tr>";
//
//		htmlMsg += "<tr style=\"text-align: right; font-weight: bold; background-color: #eee\">\r\n"
//				+ "						<td colspan=\"4\">T???ng gi?? tr??? ????n h??ng</td>\r\n";
//		htmlMsg += "<td>" + subTotalString + "</td>";
//		htmlMsg += "</tr>";
//		htmlMsg += "	</tbody>\r\n"
//				+ "			</table>";
//		htmlMsg += "<p>\r\n"
//				+ "				Tr?????ng h???p qu?? kh??ch c?? nh???ng b??n kho??n v??? ????n h??ng, c?? th??? g???i c??u h???i tr???c ti???p qua ?????a ch??? email n??y\r\n"
//				+ "				(congtrinhhbangiay@gmail.com)\r\n"
//				+ "			</p>";
//		htmlMsg += "<p><b>M???t l???n n???a C??ng'shop c???m ??n qu?? kh??ch.</b></p>";
//		htmlMsg += "<p style=\"text-align: right; color: #364f6b; font-weight: bold\">" + nameOfWebsite + "</p>";
//		htmlMsg += "</div>\r\n"
//				+ "	</body>";
//		
//		
//		message.setContent(htmlMsg, "text/html; charset=utf-8");
//
//		helper.setTo(saleOrder.getCustomerEmail());// thay
//		helper.setSubject(nameOfWebsite + " - X??c nh???n ????n h??ng #" + saleOrder.getCode());
//
//		this.mailSender.send(message);
//	}
//
//}