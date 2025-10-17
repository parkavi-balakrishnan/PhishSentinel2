package com.phishsentinel.service;

import com.phishsentinel.model.Report;
import com.phishsentinel.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private ReportRepository reportRepository;

    // ✅ Fetch all reports with status = PENDING (already fine)
    public List<Report> getPendingReports() {
        return reportRepository.findByStatusOrderByReportedAtDesc("PENDING");
    }

    // ✅ Fix: reportId should be Long, not String
    public Report updateReportStatus(Long reportId, String status) {
        Optional<Report> reportOpt = reportRepository.findById(reportId);
        if (reportOpt.isPresent()) {
            Report report = reportOpt.get();
            report.setStatus(status);
            return reportRepository.save(report);
        }
        return null;
    }
}
