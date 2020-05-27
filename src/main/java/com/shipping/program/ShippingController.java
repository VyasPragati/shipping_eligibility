package com.shipping.program;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.shipping.bean.EligibilityForm;
import com.shipping.bean.EligibilityProperties;
import com.shipping.exception.ErrorResponse;
import com.shipping.service.ShippingEligibilityService;
import com.shipping.utility.ShippingConstants;

@RestController

public class ShippingController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShippingController.class);

	@Autowired
	private EligibilityProperties properties;
	
	@Autowired
	private ShippingEligibilityService shippingEligibilityService;
	
	@Autowired
	private ErrorResponse errorResponse;
	
	@RequestMapping(method=RequestMethod.POST,value="/v1/isItemEligible")
	public Map<String,Object> checkEligibility(@RequestBody EligibilityForm eligiblityForm ) {
		try {
		if (properties == null) {
			errorResponse.setMessage(ShippingConstants.MISSING_CONFIGURATION);
	    } else {
	    	String error=shippingEligibilityService.isRequestValid(eligiblityForm);
	    	if(error!=null) {
	    		errorResponse.setMessage(error);
	    		properties.setError(errorResponse);
	    	}
	    	else if(shippingEligibilityService.isEligibleForShipping(eligiblityForm)) {
	    		properties.setItemEligible(true);
	    	}else {
	    		errorResponse.setMessage(ShippingConstants.ITEM_INELIGIBLE);
	    		properties.setError(errorResponse);
	    	}
	    }
		}catch(Exception ex) {
			logger.error("Exception Raised="+ex);
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	        errorResponse.setMessageAndDetails(ShippingConstants.SERVER_ERROR,details);
	        properties.setError(errorResponse);
	    }
		return properties.getMappedResponse();
	}



}
