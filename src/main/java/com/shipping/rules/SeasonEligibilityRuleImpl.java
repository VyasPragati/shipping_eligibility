package com.shipping.rules;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shipping.bean.EligibilityForm;
import com.shipping.utility.Season;

@Component
public class SeasonEligibilityRuleImpl implements ShippingEligibilityRule {

	@Autowired
	private ItemEligibilityRuleImpl itemEligibilityRule;

	@Override
	public boolean isEligible(EligibilityForm eligiblityForm) {
		LocalDate currentDate = LocalDate.now();
		Month month = currentDate.getMonth(); 
		if(Season.of(month)==Season.SUMMER && itemEligibilityRule.isPreapprovedCategory(eligiblityForm.getCategory())) {
			return true;
		}
		return false;
	}

}
