package com.shipping.rules;

import com.shipping.bean.EligibilityForm;

public interface ShippingEligibilityRule {
	boolean isEligible(EligibilityForm eligiblityForm);
}
