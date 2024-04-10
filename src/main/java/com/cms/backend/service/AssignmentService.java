package com.cms.backend.service;

import com.cms.backend.model.AssignmentModel;
import com.cms.backend.model.ClassModel;
import com.cms.backend.model.SubmissionModel;
import com.cms.backend.repository.AssignmentRepository;
import com.cms.backend.repository.ClassRepository;
import com.cms.backend.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final ClassRepository classRepository;
    private final SubmissionRepository submissionRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, ClassRepository classRepository, SubmissionRepository submissionRepository) {
        this.assignmentRepository = assignmentRepository;
        this.classRepository = classRepository;
        this.submissionRepository = submissionRepository;
    }

    public List<AssignmentModel> getAllAssignmentsByTeacherId(int teacherId) {
        return assignmentRepository.findAllByTeacherId(teacherId);
    }

    public AssignmentModel createAssignment(int teacherId, AssignmentModel assignmentModel) {
        assignmentModel.setTeacherId(teacherId);

        // Save the assignment
        AssignmentModel createdAssignment = assignmentRepository.save(assignmentModel);
        int classId = createdAssignment.getClassId();
        // Get all students in the class and create submissions for them
        List<ClassModel> classStudents = classRepository.findByTeacherIdAndClassId(teacherId, classId);
        for (ClassModel classStudent : classStudents) {
            SubmissionModel submission = new SubmissionModel();
            submission.setTeacherId(teacherId);
            submission.setTitle(createdAssignment.getTitle());
            submission.setDescription(createdAssignment.getDescription());
            submission.setDeadlines(createdAssignment.getDeadlines());
            submission.setAssignmentId(createdAssignment.getId());
            submission.setClassId(classId); // Set classId here
            submission.setStudentId(classStudent.getStudentId());
            submission.setSubmitted(false);
            submissionRepository.save(submission);
        }

        return createdAssignment;
    }

    public AssignmentModel updateAssignment(int id , AssignmentModel updatedAssignment) {
        Optional<AssignmentModel> existingAssignmentOptional = assignmentRepository.findById(id);
        if (existingAssignmentOptional.isPresent()) {
            AssignmentModel existingAssignment = existingAssignmentOptional.get();
            existingAssignment.setInstructions(updatedAssignment.getInstructions());
            existingAssignment.setDeadlines(updatedAssignment.getDeadlines());
            existingAssignment.setMaxScore(updatedAssignment.getMaxScore());
            return assignmentRepository.save(existingAssignment);
        } else {
            throw new RuntimeException("Assignment not found with id");
        }
    }

    public void deleteAssignment(int id) {
        assignmentRepository.deleteById(id);
    }
}
