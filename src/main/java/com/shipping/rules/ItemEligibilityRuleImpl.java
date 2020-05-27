package com.shipping.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shipping.bean.EligibilityForm;
import com.shipping.bean.EligibilityProperties;

@Component
public class ItemEligibilityRuleImpl implements ShippingEligibilityRule {

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
		return isEnrolledSeller;
	}
	
	public boolean isEligiblePrice(double price) {
		boolean isEligiblePrice=false;
		if(price<=properties.getPrice()) {
				isEligiblePrice=true;
				return isEligiblePrice;
		}
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
		return isPreapprovedCategory;
	}

}
