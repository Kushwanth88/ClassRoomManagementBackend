package com.cms.backend.repository;

import com.cms.backend.model.AssignmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentModel, Integer> {
    List<AssignmentModel> findAllByTeacherId(int teacherId);
//    @Query("SELECT a FROM AssignmentModel a WHERE a.classId = :classId")
//    List<AssignmentModel> findByClassId(int classId);
}
