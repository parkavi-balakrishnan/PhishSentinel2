package com.phishsentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phishsentinel.model.UrlCheckResult;
import com.phishsentinel.service.UrlCheckService;

@RestController
public class CheckUrlController {

    private final UrlCheckService urlCheckService;

    public CheckUrlController(UrlCheckService urlCheckService) {
        this.urlCheckService = urlCheckService;
    }

    @GetMapping("/check-url")
    public UrlCheckResult checkUrl(@RequestParam String url) {
        return urlCheckService.checkUrl(url);  // ✅ fixed small 'u'
    }
}
