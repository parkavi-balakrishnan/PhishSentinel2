package com.phishsentinel.service;

import org.springframework.stereotype.Service;
import com.phishsentinel.model.UrlCheckResult;

@Service
public class UrlCheckService {

    public UrlCheckResult checkUrl(String url) {
        // Temporary dummy logic (later we connect ML model here)
        boolean isPhishing = url.contains("phish") || url.contains("malicious");


        String message = isPhishing
                ? "Warning: This URL looks suspicious!"
                : "This URL seems safe.";

        return new UrlCheckResult(url, isPhishing, message);
    }
}

