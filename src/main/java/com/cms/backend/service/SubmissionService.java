package com.cms.backend.service;

import com.cms.backend.model.GradeModel;
import com.cms.backend.model.SubmissionModel;
import com.cms.backend.repository.GradeRepository;
import com.cms.backend.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public SubmissionService(SubmissionRepository submissionRepository, GradeRepository gradeRepository) {
        this.submissionRepository = submissionRepository;
        this.gradeRepository = gradeRepository;
    }

    public List<SubmissionModel> getSubmissionsByStudentId(int studentId) {
        return submissionRepository.findByStudentId(studentId);
    }

    @Transactional
    public SubmissionModel toggleSubmissionStatus(int submissionId) {
        Optional<SubmissionModel> optionalSubmission = submissionRepository.findById(submissionId);
        if (optionalSubmission.isPresent()) {
            SubmissionModel submission = optionalSubmission.get();
            boolean currentStatus = submission.isSubmitted();
            submission.setSubmitted(!currentStatus);
            submissionRepository.save(submission);
            if (submission.isSubmitted()) {
                // If submission status is true, insert corresponding values into GradeRepository
                GradeModel grade = new GradeModel();
                System.out.println(submission.getTeacherId());
                grade.setTeacherId(submission.getTeacherId());
                grade.setStudentId(submission.getStudentId());
                grade.setAssignmentId(submission.getAssignmentId());
                grade.setClassId(submission.getClassId());
                gradeRepository.save(grade);
            } else {
                // If submission status is false, delete corresponding values from GradeRepository
                GradeModel grade = gradeRepository.findByAssignmentIdAndStudentId(submission.getAssignmentId(), submission.getStudentId());
                if (grade != null) {
                    gradeRepository.delete(grade);
                }
            }
            return submission;
        }
        return null; // Or handle as needed if submission with given ID is not found
    }
}
