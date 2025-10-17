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

    // ✅ Get all reports
    @GetMapping
    public ResponseEntity<ApiResponse<List<Report>>> getAllReports() {
        List<Report> reports = reportService.getAllReports();
        ApiResponse<List<Report>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(reports);
        return ResponseEntity.ok(response);
    }

    // ✅ Submit a new report
    @PostMapping
    public ResponseEntity<ApiResponse<Report>> submitReport(@RequestBody Report report) {
        Report savedReport = reportService.submitReport(report);
        ApiResponse<Report> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(savedReport);
        return ResponseEntity.ok(response);
    }

    // ✅ Delete a report by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        ApiResponse<Void> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(null);
        return ResponseEntity.ok(response);
    }
}
