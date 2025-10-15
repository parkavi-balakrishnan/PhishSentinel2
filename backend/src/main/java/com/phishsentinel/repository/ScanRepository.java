package com.phishsentinel.repository;

import com.phishsentinel.model.ScanResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScanRepository extends JpaRepository<ScanResult, Long> {

    // Find by URL exactly
    Optional<ScanResult> findByUrl(String url);

    // Find all by phishing status (true for phishing, false for safe)
    List<ScanResult> findByPhishing(boolean phishing);

    // Search URLs containing keyword (case insensitive)
    List<ScanResult> findByUrlContainingIgnoreCase(String keyword);

}
