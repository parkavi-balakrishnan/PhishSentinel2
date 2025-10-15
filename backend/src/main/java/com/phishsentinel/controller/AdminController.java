package com.phishsentinel.controller;

import com.phishsentinel.model.Report;
import com.phishsentinel.model.User;
import com.phishsentinel.repository.ReportRepository;
import com.phishsentinel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ Get all reported URLs
    @GetMapping("/reports")
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // ✅ Get all registered users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Dashboard overview (basic stats)
    @GetMapping("/stats")
    public String getAdminStats() {
        long totalUsers = userRepository.count();
        long totalReports = reportRepository.count();

        return String.format("Total Users: %d | Total Reports: %d", totalUsers, totalReports);
    }

    // ✅ Delete a report (admin moderation)
    @DeleteMapping("/report/{id}")
    public String deleteReport(@PathVariable Long id) {
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
            return "Report deleted successfully";
        } else {
            return "Report not found";
        }
    }
}
