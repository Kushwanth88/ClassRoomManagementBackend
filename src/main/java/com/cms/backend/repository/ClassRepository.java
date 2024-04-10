package com.cms.backend.repository;

import com.cms.backend.model.AssignmentModel;
import com.cms.backend.model.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassModel, Integer>{
    List<ClassModel> findByTeacherId(int id);

    List<ClassModel> findByTeacherIdAndClassId(int teacherId, int classId);
}
