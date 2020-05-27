package com.shipping.exception;
import java.util.List;
//import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;
 
//@XmlRootElement(name = "error")
@Component
public class ErrorResponse 
{
	

	//General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setMessageAndDetails(String message,List<String> details) {
		this.details = details;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

 

}