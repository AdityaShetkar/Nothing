package com.cryptocurrencyOrders.exception;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;
    String fieldName;
    Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName,
                                     Object fieldValue) {
        super(String.format("%s not found %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
