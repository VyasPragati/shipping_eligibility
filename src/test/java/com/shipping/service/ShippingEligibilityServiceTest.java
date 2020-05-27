package com.shipping.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.shipping.bean.EligibilityForm;
import com.shipping.bean.EligibilityProperties;
import com.shipping.rules.ItemEligibilityRuleImpl;
import com.shipping.rules.SeasonEligibilityRuleImpl;
import com.shipping.utility.ShippingConstants;

class ShippingEligibilityServiceTest {
	
	static EligibilityProperties properties;
	static EligibilityForm eligibilityForm;
	static SeasonEligibilityRuleImpl seasonEligibilityRule;
	static ItemEligibilityRuleImpl itemEligibleRule;
	static ShippingEligibilityService shippingEligibilityService;
	

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
		
	}
	
	@Test
	void test() {
		assertTrue(shippingEligibilityService.isEligibleForShipping(eligibilityForm));
	}
	
	/*
	@Test
	void testNotValidSeller() {
		eligibilityForm=new EligibilityForm(null,12,201.0);
		String message=shippingEligibilityService.isRequestValid(eligibilityForm);
		assertEquals(message,ShippingConstants.INVALID_SELLER);
	}
	
	@Test
	void testNotValidCategory() {
		eligibilityForm=new EligibilityForm("Mattel",null,201.0);
		String message=shippingEligibilityService.isRequestValid(eligibilityForm);
		assertEquals(message,ShippingConstants.INVALID_CATEGORY);
	}
	
	@Test
	void testNotValidPrice() {
		eligibilityForm=new EligibilityForm("Mattel",12,null);
		String message=shippingEligibilityService.isRequestValid(eligibilityForm);
		assertEquals(message,ShippingConstants.INVALID_PRICE);
	}*/
	

}
