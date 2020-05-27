package com.shipping.rules;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shipping.bean.EligibilityForm;
import com.shipping.bean.EligibilityProperties;
import com.shipping.program.ShippingController;

@Component
public class ItemEligibilityRuleImpl implements ShippingEligibilityRule {

	private static final Logger logger = LoggerFactory.getLogger(ShippingController.class);
	@Autowired
	private EligibilityProperties properties;
	

	@Override
	public boolean isEligible(EligibilityForm eligiblityForm) {
		boolean ItemEligible=false;
		if(isEnrolledSeller(eligiblityForm.getSeller())&& isEligiblePrice(eligiblityForm.getPrice())&& isPreapprovedCategory(eligiblityForm.getCategory())) {
			ItemEligible=true;
		}
		return ItemEligible;
	}
	
	
	
	public boolean isEnrolledSeller(String seller) {
		boolean isEnrolledSeller=false;
		for(String enrSeller:properties.getSeller()) {
			if(enrSeller.equals(seller)) {
				isEnrolledSeller=true;
			    return isEnrolledSeller;
			}
		}
		logger.error("Seller not enrolled");
		return isEnrolledSeller;
	}
	
	public boolean isEligiblePrice(double price) {
		boolean isEligiblePrice=false;
		if(price>=properties.getPrice()) {
				isEligiblePrice=true;
				return isEligiblePrice;
		}
		logger.error("Price less than min value eligible for shipping");
		return isEligiblePrice;
	}
	
	public boolean isPreapprovedCategory(int category) {
		boolean isPreapprovedCategory=false;
		for(int preAprCategory: properties.getCategory()) {
			if(preAprCategory == category) {
				isPreapprovedCategory=true;
				return isPreapprovedCategory;
			}
		}
		logger.error("Category not pre-approved");
		return isPreapprovedCategory;
	}

	public EligibilityProperties getProperties() {
		return properties;
	}


	public void setProperties(EligibilityProperties properties) {
		this.properties = properties;
	}
}
