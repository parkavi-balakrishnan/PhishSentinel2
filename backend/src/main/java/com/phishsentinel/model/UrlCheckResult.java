package com.phishsentinel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UrlCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // primary key

    private String url;
    private boolean isPhishing;  // ✅ new field
    private String message;      // ✅ renamed from status for clarity

    // ✅ Default constructor (required by JPA)
    public UrlCheckResult() {}

    // ✅ Constructor with all fields (except id)
    public UrlCheckResult(String url, boolean isPhishing, String message) {
        this.url = url;
        this.isPhishing = isPhishing;
        this.message = message;
    }

    // ✅ Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPhishing() {
        return isPhishing;
    }

    public void setPhishing(boolean phishing) {
        isPhishing = phishing;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
