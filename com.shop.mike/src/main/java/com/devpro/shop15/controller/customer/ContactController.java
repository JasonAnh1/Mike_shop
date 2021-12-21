package com.devpro.shop15.controller.customer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devpro.shop15.controller.BaseController;
import com.devpro.shop15.dto.ContactModel;
import com.devpro.shop15.entities.Contact;
import com.devpro.shop15.services.ContactService;

@Controller
public class ContactController extends BaseController{
	@Autowired
	private ContactService contactService;

	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public String get_contact(final Model model, final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		// day du thong bao xuong tang views
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
//		NewsLetterModel newsLetterMode = new NewsLetterModel();
//		model.addAttribute("newsLetterModel", newsLetterMode);
		/// mvc duoc cau hinh chi dinh vao thu muc /src/main/webapp/web-inf/views
		// de tim cac views
		// web-inf/views/user/index.jsp
		return "customer/contact";
	}

	// actionpost
	@RequestMapping(value = { "/contact" }, method = RequestMethod.POST)
	public String post_contact(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("contact") Contact contact) throws IOException {
//	model.addAttribute("contactModel",contactModel);
//	//doc du lieu tu nguoi dung submit 
//	//String yourName = request.getParameter("name");
//	//String yourEmail = request.getParameter("email");
//	
//	model.addAttribute("Dulieubannhapla", contactModel.getEmail() );
		contactService.saveOrUpdate(contact);

		/// mvc duoc cau hinh chi dinh vao thu muc /src/main/webapp/web-inf/views
		// de tim cac views
		// web-inf/views/user/index.jsp
		return "customer/contact";
	}

	@RequestMapping(value = { "/ajax/contact" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_contact(final Model model, 
			final HttpServletRequest request,
			final HttpServletResponse response, 
			final @RequestBody ContactModel contactModel) {
		System.out.println("ContactModel[Email]:" + contactModel.getEmail() + contactModel.getName());

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("message", contactModel);
		return ResponseEntity.ok(jsonResult);
	}

}
