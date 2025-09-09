package com.phishsentinel.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.phishsentinel.model.UrlCheckResult;
import com.phishsentinel.service.UrlCheckService;

@RestController
@RequestMapping("/api/url")
public class UrlCheckController {

    @Autowired
    private UrlCheckService urlCheckService;

    @GetMapping("/check")
    public UrlCheckResult checkUrl(@RequestParam String url) {
        return urlCheckService.checkUrl(url);
    }
}
