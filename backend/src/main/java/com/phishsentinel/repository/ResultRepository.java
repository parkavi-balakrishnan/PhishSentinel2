package com.phishsentinel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phishsentinel.model.UrlCheckResult;

public interface ResultRepository extends JpaRepository<UrlCheckResult, Long> {
    // ✅ JPA will auto-generate common methods like save(), findAll(), findById()
}
