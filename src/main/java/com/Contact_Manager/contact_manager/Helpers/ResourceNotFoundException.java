package com.Contact_Manager.contact_manager.Helpers;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("resource not found");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
