package com.phishsentinel.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class MLService {

    private final String ML_API_URL = "http://localhost:5000/predict"; // your ML endpoint

    public String predict(String url) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> request = new HashMap<>();
        request.put("url", url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(ML_API_URL, entity, String.class);
            return response.getBody();
        } catch (Exception e) {
            return "Error: Unable to connect to ML model service.";
        }
    }
}