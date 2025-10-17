package com.phishsentinel.repository;

import com.phishsentinel.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByStatusOrderByReportedAtDesc(String status);
    List<Report> findBySubmittedBy(String submittedBy);
    Optional<Report> findByReportedUrl(String reportedUrl);
}