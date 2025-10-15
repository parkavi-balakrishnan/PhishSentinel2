package com.phishsentinel.controller;

import com.phishsentinel.dto.ApiResponse;
import com.phishsentinel.model.User;
import com.phishsentinel.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/community")
@CrossOrigin(origins = "*")
public class CommunityController {
    @Autowired
    private CommunityService communityService;

    @GetMapping("/profile/{username}")
    public ResponseEntity<ApiResponse<?>> getUserProfile(@PathVariable String username) {
        return ResponseEntity.ok(communityService.getUserProfile(username));
    }
    
    // Add more community endpoints as needed
}
