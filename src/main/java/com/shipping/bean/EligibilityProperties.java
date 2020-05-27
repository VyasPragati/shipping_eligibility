package com.shipping.bean;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shipping.exception.ErrorResponse;
import com.shipping.utility.ShippingConstants;


@Configuration
@ConfigurationProperties(prefix = "eligible")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EligibilityProperties {
	
	@Autowired
	ErrorResponse errorResponse;
	
	private EligibilityProperties propertInstance;
	
    public void refreshProperties() {
        synchronized (this) {
        	propertInstance = new EligibilityProperties();
        }
    }
	
	private ErrorResponse error;
	private List<String> seller;
	private List <Integer> category;
	private Double price;
	private boolean isItemEligible=false;
	public List<String> getSeller() {
		return seller;
	}
	public void setSeller(List<String> seller) {
		this.seller = seller;
	}
	public List<Integer> getCategory() {
		return category;
	}
	public void setCategory(List<Integer> category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public ErrorResponse getError() {
		return errorResponse;
	}
	public void setError(ErrorResponse error) {
		this.error = error;
	}
	public boolean isItemEligible() {
		return isItemEligible;
	}
	public void setItemEligible(boolean isItemEligible) {
		this.isItemEligible = isItemEligible;
	}
	
	public Map<String,Object>getMappedResponse(){
		
		 Map<String,Object> response= new HashMap<String,Object>();
		 Map<String,Object> eligibleCriteria= new HashMap<String,Object>();
		 Object sellers=new ArrayList<String>(getSeller());
		 Object category=new ArrayList<Integer>(getCategory());
		 Object minPrice=getPrice();
		 eligibleCriteria.put(ShippingConstants.ENROLLED_SELLERS, sellers);
		 eligibleCriteria.put(ShippingConstants.MIN_PRICE, minPrice);
		 eligibleCriteria.put(ShippingConstants.PRE_APPR_CATEGORY, category);
		 response.put(ShippingConstants.IS_ITEM_ELIGIBLE, isItemEligible());
		 response.put(ShippingConstants.ELIGIBILITY_CRITERIA, eligibleCriteria);
		 response.put(ShippingConstants.ERROR, getError());
		 
		 return response;
		
	}
	
}
