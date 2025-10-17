package com.phishsentinel.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scan_results")
public class ScanResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    private boolean phishing;

    // Added fields for ML prediction
    @Column(name = "confidence_score")
    private Double confidenceScore;

    @Column(name = "is_phishing")
    private Boolean isPhishing;

    private String prediction;

    // Existing fields
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "report_id")
    private Long reportId;

    @Column(name = "scanned_at")
    private LocalDateTime scannedAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPhishing() {
        return phishing;
    }

    public void setPhishing(boolean phishing) {
        this.phishing = phishing;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public Boolean getIsPhishing() {
        return isPhishing;
    }

    public void setIsPhishing(Boolean isPhishing) {
        this.isPhishing = isPhishing;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public LocalDateTime getScannedAt() {
        return scannedAt;
    }

    public void setScannedAt(LocalDateTime scannedAt) {
        this.scannedAt = scannedAt;
    }
}