package com.shipping.rules;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.shipping.bean.EligibilityForm;
import com.shipping.bean.EligibilityProperties;

class SeasonEligibilityRuleImplTest {
	static EligibilityProperties properties;
	static EligibilityForm eligibilityForm;
	static SeasonEligibilityRuleImpl seasonEligibilityRule;
	static ItemEligibilityRuleImpl itemEligibleRule;

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
	}
	
	@Test
	public void testisEligiblity() {
		assertTrue(seasonEligibilityRule.isEligible(eligibilityForm));
	}
	
	@Test
	public void testinEligiblity() {
		eligibilityForm=new EligibilityForm("Mattel",2,201.0);
		assertFalse(seasonEligibilityRule.isEligible(eligibilityForm));
	}

}
