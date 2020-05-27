package com.shipping.bean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



class EligibilityPropertiesTest {


	
	@Test
	void test() {
		EligibilityProperties properties=new EligibilityProperties();
		properties.setPrice(201.0);
		List<String>seller =new ArrayList<String>();
		seller.add("Mattel");
		properties.setSeller(seller);
		assertEquals(201.0, properties.getPrice());
		assertEquals(seller, properties.getSeller());
	}

}
