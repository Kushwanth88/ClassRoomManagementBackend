package com.cms.backend.service;

import com.cms.backend.model.GradeModel;
import com.cms.backend.repository.GradeRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradeServiceImplementation implements GradeService {

    private final List<GradeModel> grades;
    private final GradeRepository gradeRepository;

    public GradeServiceImplementation(List<GradeModel> grades, GradeRepository gradeRepository) {
        this.grades = grades;
        this.gradeRepository = gradeRepository;
    }




//    @Override
//    public List<GradeModel> getGradesByTeacherId(Integer teacherId) {
//        System.out.println("getGradesByTeacherId"+teacherId);
//        return grades.stream()
//                .filter(grade -> grade.getTeacherId().equals(teacherId))
//                .collect(Collectors.toList());
//    }

    @Override
    public GradeModel updateGrade(Integer id, GradeModel updatedGrade) {
        GradeModel existingGrade = gradeRepository.findById(id).orElse(null);
        if (existingGrade != null) {
            existingGrade.setScore(updatedGrade.getScore());
            existingGrade.setFeedback(updatedGrade.getFeedback());
            return gradeRepository.save(existingGrade);
        }
        return null;
    }

//    @Override
    public GradeModel findById(Integer id) {
        Optional<GradeModel> gradeOptional = gradeRepository.findById(id);
        return gradeOptional.orElse(null);
    }

    public List<GradeModel> getGradesByTeacherId(Integer teacherId) {
        return gradeRepository.findByTeacherId(teacherId);
    }

    @Override
    public List<GradeModel> getGradesByStudentId(Integer studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
}
