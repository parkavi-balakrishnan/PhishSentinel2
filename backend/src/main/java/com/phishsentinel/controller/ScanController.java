package com.phishsentinel.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.phishsentinel.model.ScanResult;
import com.phishsentinel.service.ScanService;

@RestController
@RequestMapping("/api/scan")
public class ScanController {

    @Autowired
    private ScanService scanService;

    // Endpoint: GET /api/scan/url?url=https://example.com&userId=1
    @GetMapping("/url")
    public ResponseEntity<ScanResult> scanUrl(@RequestParam(name = "url") String url,
                                              @RequestParam(name = "userId") String userId) {
        ScanResult result = scanService.scanUrl(url, userId);
        if (result == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(result);
    }

}