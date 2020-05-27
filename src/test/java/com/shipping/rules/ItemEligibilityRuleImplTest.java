package com.shipping.rules;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.shipping.bean.EligibilityForm;
import com.shipping.bean.EligibilityProperties;

class ItemEligibilityRuleImplTest {

	static EligibilityProperties properties;
	static EligibilityForm eligibilityForm;
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
		itemEligibleRule.setProperties(properties);
	}
	

	@Test
	public void testisEligible() {
		
		assertTrue(itemEligibleRule.isEligible(eligibilityForm));
		
	}
	
	@Test
	public void testInEligibile() {
		assertFalse(itemEligibleRule.isEligiblePrice(11.0));
		assertFalse(itemEligibleRule.isEnrolledSeller("abc"));
		assertFalse(itemEligibleRule.isPreapprovedCategory(78));
		
	}
	
}
