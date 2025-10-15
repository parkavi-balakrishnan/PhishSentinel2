
package com.phishsentinel.service;

import com.phishsentinel.model.ScanResult;
import com.phishsentinel.repository.ScanRepository;
import com.phishsentinel.util.MLHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ScanService {

    @Autowired
    private ScanRepository scanRepository;

    @Autowired
    private MLHelper mlHelper;

    public ScanResult saveScanResult(String url, String userId, Double confidenceScore, Boolean isPhishing, String prediction) {
        ScanResult result = new ScanResult();
        result.setUrl(url);
        result.setUserId(userId);
        result.setConfidenceScore(confidenceScore);
        result.setIsPhishing(isPhishing);
        result.setPrediction(prediction);
        result.setScannedAt(new Date());
        
        return scanRepository.save(result);
    }

    public List<ScanResult> getUserScanHistory(String userId) {
        return scanRepository.findByUserIdOrderByScannedAtDesc(userId);
    }

    public ScanResult getLatestUserScan(String userId) {
        List<ScanResult> results = scanRepository.findByUserIdOrderByScannedAtDesc(userId);
        return results.isEmpty() ? null : results.get(0);
    }

    // Perform a scan using ML helper and persist the result
    public ScanResult scanUrl(String url, String userId) {
        String prediction = mlHelper.predictUrl(url);
        Double confidence = mlHelper.getConfidenceScore(url);
        Boolean isPhishing = !"Safe".equalsIgnoreCase(prediction);
        return saveScanResult(url, userId, confidence, isPhishing, prediction);
    }
}
