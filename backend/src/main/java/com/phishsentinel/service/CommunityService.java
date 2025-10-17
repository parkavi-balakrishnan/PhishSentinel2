package com.phishsentinel.service;

import com.phishsentinel.model.Report;
import com.phishsentinel.model.Vote;
import com.phishsentinel.model.UserProfile;
import com.phishsentinel.repository.ReportRepository;
import com.phishsentinel.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private VoteRepository voteRepository;

    public Report submitReport(Report report) {
        report.setStatus("PENDING");
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Vote voteOnReport(Long reportId, Long userId, boolean isUpvote) {
        Optional<Vote> existingVote = voteRepository.findByReportIdAndUserId(reportId, userId);

        if (existingVote.isPresent()) {
            Vote vote = existingVote.get();
            vote.setIsUpvote(isUpvote);
            return voteRepository.save(vote);
        } else {
            Vote vote = new Vote();
            vote.setReportId(reportId);
            vote.setUserId(userId);
            vote.setIsUpvote(isUpvote);
            return voteRepository.save(vote);
        }
    }

    public Long getVoteCount(Long reportId) {
        return voteRepository.countByReportId(reportId);
    }

    public UserProfile getUserProfile(Long userId) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(userId);
        userProfile.setDisplayName("Anonymous User");
        userProfile.setBio("This user has not added a bio yet.");
        userProfile.setAvatarUrl(null);
        userProfile.setReputationScore(0);
        userProfile.setContributionCount(0);
        return userProfile;
    }
}
