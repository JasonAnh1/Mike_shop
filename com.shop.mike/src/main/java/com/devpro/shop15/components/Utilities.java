package com.devpro.shop15.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.slugify.Slugify;

public class Utilities {
	public static String slugify(String text) {
		return new Slugify().slugify(text);
	}
	
	public static void main(String[] args) {
		
		// sử dụng slugify tạo seo
		String productTitle = "Java Title 6"; // -> java-title-6
		String productTitleSeo = new Slugify().slugify(productTitle);
		System.out.println(productTitleSeo);
		
	}
	public static String encode(String password) {
		return new BCryptPasswordEncoder(4).encode(password);
	}
}
