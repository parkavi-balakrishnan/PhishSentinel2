
package com.phishsentinel.service;

import com.phishsentinel.model.Report;
import com.phishsentinel.model.Vote;
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

    public Vote voteOnReport(String reportId, String userId, boolean isUpvote) {
        // Check if user already voted on this report
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

    public Long getVoteCount(String reportId) {
        return voteRepository.countByReportId(reportId);
    }
}
