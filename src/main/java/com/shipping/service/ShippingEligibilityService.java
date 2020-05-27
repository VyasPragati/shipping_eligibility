package com.shipping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.bean.EligibilityForm;
import com.shipping.rules.ItemEligibilityRuleImpl;
import com.shipping.rules.SeasonEligibilityRuleImpl;
import com.shipping.utility.ShippingConstants;

@Service
public class ShippingEligibilityService {
	
	@Autowired
	private ItemEligibilityRuleImpl itemEligibilityRule;

	@Autowired
	private SeasonEligibilityRuleImpl seasonEligibilityRule;
	
	public boolean isEligibleForShipping(EligibilityForm form) {
		return itemEligibilityRule.isEligible(form)&& seasonEligibilityRule.isEligible(form);
	}
	
	public String isRequestValid(EligibilityForm form) {
		String seller=form.getSeller();	
		Double price=form.getPrice();
		Integer category=form.getCategory();
		if(seller== null || seller.isEmpty()) {
			return ShippingConstants.INVALID_SELLER;
		}
		if(price==null) {
			return ShippingConstants.INVALID_PRICE;
		}
		if(category==null) {
			return ShippingConstants.INVALID_CATEGORY;
		}
		return null;
	}
	
	//Auto Generated Getters and Setters
	public ItemEligibilityRuleImpl getItemEligibilityRule() {
		return itemEligibilityRule;
	}

	public void setItemEligibilityRule(ItemEligibilityRuleImpl itemEligibilityRule) {
		this.itemEligibilityRule = itemEligibilityRule;
	}

	public SeasonEligibilityRuleImpl getSeasonEligibilityRule() {
		return seasonEligibilityRule;
	}

	public void setSeasonEligibilityRule(SeasonEligibilityRuleImpl seasonEligibilityRule) {
		this.seasonEligibilityRule = seasonEligibilityRule;
	}
}
