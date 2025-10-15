package com.phishsentinel.util;

import org.springframework.stereotype.Component;

@Component
public class MLHelper {
    public String predictUrl(String url) {
        return "Safe"; // or call your ML model
    }
    public double getConfidenceScore(String url) {
        return 95.0;
    }
}