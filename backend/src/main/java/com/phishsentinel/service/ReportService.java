package com.phishsentinel.service;

import com.phishsentinel.model.Report;
import com.phishsentinel.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for handling report-related logic.
 */
@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    /**
     * Save a new report (or update existing).
     */
    public Report submitReport(Report report) {
        report.setStatus("PENDING"); // default status
        return reportRepository.save(report);
    }

    /**
     * Retrieve all reports.
     */
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    /**
     * Retrieve a single report by ID.
     */
    public Optional<Report> getReportById(Long id) {
        return reportRepository.findById(id);
    }

    /**
     * Delete a report by ID.
     */
    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }

    /**
     * Retrieve all reports by a specific user ID.
     */
    public List<Report> getReportsByUserId(String userId) {
        return reportRepository.findBySubmittedBy(userId);
    }
}