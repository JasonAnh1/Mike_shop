package com.devpro.shop15.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_saleorder")
public class SaleOrder extends BaseEntity{
	
	@Column(name = "code", length = 45, nullable = false)
	private String code;
	
	@Column(name = "total", columnDefinition = "DECIMAL(13,2)", nullable = true)
	private BigDecimal total = BigDecimal.ZERO;
	
	@Column(name = "customer_name", length = 100, nullable = true)
	private String customerName;
	
	@Column(name = "customer_address", length = 100, nullable = true)
	private String customerAddress;
	
	@Column(name = "seo", length = 200, nullable = true)
	private String seo;
	
	@Column(name = "customer_phone", length = 100, nullable = true)
	private String customerPhone;
	
	@Column(name = "customer_email", length = 100, nullable = true)
	private String customerEmail;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User usersSale;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleorder")
	private Set<SaleOrderProducts> saleorderProducts = new HashSet<SaleOrderProducts>();
	
	public void addSaleOrderProduct(SaleOrderProducts saleorderProduct) {
		saleorderProduct.setSaleorder(this);
		saleorderProducts.add(saleorderProduct);
	}
	
	public void deleteSaleOrderProduct(SaleOrderProducts saleorderProduct) {
		saleorderProduct.setSaleorder(null);
		saleorderProducts.remove(saleorderProduct);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Set<SaleOrderProducts> getSaleorderProducts() {
		return saleorderProducts;
	}

	public void setSaleorderProducts(Set<SaleOrderProducts> saleorderProducts) {
		this.saleorderProducts = saleorderProducts;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public User getUsersSale() {
		return usersSale;
	}

	public void setUsersSale(User usersSale) {
		this.usersSale = usersSale;
	}
	
}
