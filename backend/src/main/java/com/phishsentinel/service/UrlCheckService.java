package com.phishsentinel.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.phishsentinel.model.UrlCheckResult;
import com.phishsentinel.repository.ResultRepository;

@Service
public class UrlCheckService {

    @Autowired
    private ResultRepository resultRepository;

    public UrlCheckResult checkUrl(String url) {
        // Dummy logic (later connect ML model)
        boolean isPhishing = url.contains("phish") || url.contains("malicious");

        String message = isPhishing
                ? "Warning: This URL looks suspicious!"
                : "This URL seems safe.";

        // ✅ Create result object
        UrlCheckResult result = new UrlCheckResult(url, message);

        // ✅ Save to DB
        return resultRepository.save(result);
    }
}

