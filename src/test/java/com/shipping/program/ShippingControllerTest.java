package com.shipping.program;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.shipping.bean.EligibilityForm;
import com.shipping.bean.EligibilityProperties;
import com.shipping.exception.ErrorResponse;
import com.shipping.rules.ItemEligibilityRuleImpl;
import com.shipping.rules.SeasonEligibilityRuleImpl;
import com.shipping.service.ShippingEligibilityService;
import com.shipping.utility.ShippingConstants;

class ShippingControllerTest {
	
	static EligibilityProperties properties;
	static EligibilityForm eligibilityForm;
	static SeasonEligibilityRuleImpl seasonEligibilityRule;
	static ItemEligibilityRuleImpl itemEligibleRule;
	static ShippingEligibilityService shippingEligibilityService;
	static ErrorResponse errorResponse;
	static ShippingController shippingController;

	@BeforeAll
	static void init() {
		properties=new EligibilityProperties();
		List<String>seller =new ArrayList<String>();
		seller.add("Mattel");
		List<Integer>category =new ArrayList<Integer>();
		category.add(12);
		properties.setPrice(201.0);
		properties.setSeller(seller);
		properties.setCategory(category);
		eligibilityForm=new EligibilityForm("Mattel",12,201.0);
		itemEligibleRule=new ItemEligibilityRuleImpl();
		seasonEligibilityRule=new SeasonEligibilityRuleImpl();
		seasonEligibilityRule.setItemEligibilityRule(itemEligibleRule);
		itemEligibleRule.setProperties(properties);
		shippingEligibilityService=new ShippingEligibilityService();
		shippingEligibilityService.setItemEligibilityRule(itemEligibleRule);
		shippingEligibilityService.setSeasonEligibilityRule(seasonEligibilityRule);
		errorResponse=new ErrorResponse();
		shippingController=new ShippingController();
		properties.setError(errorResponse);
		shippingController.setShippingEligibilityService(shippingEligibilityService);
		shippingController.setProperties(properties);
		shippingController.setErrorResponse(errorResponse);
	}


	@Test
	void testEligible() {
		Map<String,Object> map=shippingController.checkEligibility(eligibilityForm);
		Boolean eligible=(Boolean)map.get(ShippingConstants.IS_ITEM_ELIGIBLE);
		assertTrue((boolean)eligible);
	}
	
	


}
