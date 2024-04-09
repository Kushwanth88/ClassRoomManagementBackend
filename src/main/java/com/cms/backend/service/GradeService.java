package com.cms.backend.service;

import com.cms.backend.model.GradeModel;

import java.util.List;

public interface GradeService {

    List<GradeModel> getGradesByTeacherId(Integer teacherId);
    GradeModel findById(Integer id);
    GradeModel updateGrade(Integer id, GradeModel updatedGrade);

    List<GradeModel> getGradesByStudentId(Integer id);
}
