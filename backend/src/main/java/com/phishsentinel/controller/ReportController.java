package com.phishsentinel.controller;

import com.phishsentinel.dto.ApiResponse;
import com.phishsentinel.model.Report;
import com.phishsentinel.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Report>>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Report>> submitReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.submitReport(report));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteReport(@PathVariable Long id) {
        return ResponseEntity.ok(reportService.deleteReport(id));
    }
}
