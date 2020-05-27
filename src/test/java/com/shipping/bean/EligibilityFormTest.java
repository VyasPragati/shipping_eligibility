package com.shipping.bean;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)

class EligibilityFormTest {

	@Mock
	static EligibilityForm eligibilityForm;
	
	
	@Test	
	public void validForm() {
		
		Mockito.when(eligibilityForm.getSeller()).thenReturn("Arther");
		assertEquals("Arther",eligibilityForm.getSeller());

		Mockito.when(eligibilityForm.getPrice()).thenReturn(200.0);
		assertTrue(201.0 > eligibilityForm.getPrice());
		
		Mockito.when(eligibilityForm.getCategory()).thenReturn(12);
		assertEquals(12,eligibilityForm.getCategory());

	}
	
	@Test	
	public void invalidRequest() {
		
		Mockito.when(eligibilityForm.getSeller()).thenReturn("");
		assertNotSame("Arther",eligibilityForm.getSeller());

		Mockito.when(eligibilityForm.getPrice()).thenReturn(202.0);
		assertTrue(201.0 < eligibilityForm.getPrice());
		
		Mockito.when(eligibilityForm.getCategory()).thenReturn(100);
		assertNotSame(12,eligibilityForm.getCategory());

	}
}
