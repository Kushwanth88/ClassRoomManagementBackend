package com.cms.backend.repository;

import com.cms.backend.model.GradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<GradeModel, Integer> {
    List<GradeModel> findByTeacherId(Integer teacherId); // New method added
    List<GradeModel> findByStudentId(Integer studentId);
}