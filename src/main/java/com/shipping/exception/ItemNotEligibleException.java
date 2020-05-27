package com.shipping.exception;

public class ItemNotEligibleException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public ItemNotEligibleException(String message) {
        super(message);
    }
}
