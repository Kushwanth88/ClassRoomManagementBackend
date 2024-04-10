package com.cms.backend.repository;

import com.cms.backend.model.SubmissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<SubmissionModel, Integer> {
    List<SubmissionModel> findByStudentId(int studentId);
}
