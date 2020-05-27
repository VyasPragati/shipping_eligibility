package com.shipping.bean;


public class EligibilityForm {
	private String seller;
	private Integer category;
	private Double price;
	
	public EligibilityForm(String seller,Integer category,Double price){
		this.seller=seller;
		this.category=category;
		this.price=price;
	}
	
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
