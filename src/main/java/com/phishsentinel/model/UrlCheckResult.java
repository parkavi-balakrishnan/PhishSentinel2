package com.phishsentinel.model;

public class UrlCheckResult {
    private String url;
    private boolean isPhishing;
    private String message;

    // Constructor
    public UrlCheckResult(String url, boolean isPhishing, String message) {
        this.url = url;
        this.isPhishing = isPhishing;
        this.message = message;
    }

    // Getters
    public String getUrl() {
        return url;
    }

    public boolean isPhishing() {
        return isPhishing;
    }

    public String getMessage() {
        return message;
    }
}
