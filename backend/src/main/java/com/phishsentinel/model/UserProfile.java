package com.phishsentinel.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Ensure proper link to User entity
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "display_name", nullable = false)
    private String displayName = "Anonymous User"; // Default fallback

    @Column(length = 500)
    private String bio = "This user has not added a bio yet.";

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "reputation_score", nullable = false)
    private Integer reputationScore = 0;

    @Column(name = "contribution_count", nullable = false)
    private Integer contributionCount = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    // ✅ Automatically manage timestamps
    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        this.createdAt = now;
        this.updatedAt = now;
        if (this.reputationScore == null) this.reputationScore = 0;
        if (this.contributionCount == null) this.contributionCount = 0;
        if (this.displayName == null) this.displayName = "Anonymous User";
        if (this.bio == null) this.bio = "This user has not added a bio yet.";
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getReputationScore() {
        return reputationScore;
    }

    public void setReputationScore(Integer reputationScore) {
        this.reputationScore = reputationScore;
    }

    public Integer getContributionCount() {
        return contributionCount;
    }

    public void setContributionCount(Integer contributionCount) {
        this.contributionCount = contributionCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
