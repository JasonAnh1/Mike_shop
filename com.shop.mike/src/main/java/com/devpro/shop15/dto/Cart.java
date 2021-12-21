package com.devpro.shop15.dto;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

public class Cart {


	// tổng số tiền trong giỏ hàng
	private BigDecimal totalPrice = BigDecimal.ZERO;
	
	// danh sách sản phẩm trong giỏ hàng
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}


}
