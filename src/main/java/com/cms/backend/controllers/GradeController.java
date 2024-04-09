package com.cms.backend.controllers;

import com.cms.backend.model.GradeModel;
import com.cms.backend.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }


    @GetMapping("/grades/{id}")
    public ResponseEntity<List<GradeModel>> getGradeByTeacherId(@PathVariable("id") Integer id) {
        List<GradeModel> grade = gradeService.getGradesByTeacherId(id);
        if (grade != null) {
            return ResponseEntity.ok(grade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/studentgrade/{id}")
    public ResponseEntity<List<GradeModel>> getGradeByStudentId(@PathVariable("id") Integer id) {
        List<GradeModel> grade = gradeService.getGradesByStudentId(id);
        if (grade != null) {
            return ResponseEntity.ok(grade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/editgrade/{id}")
    public ResponseEntity<GradeModel> updateGrade(@PathVariable("id") Integer id, @RequestBody GradeModel updatedGrade) {
        GradeModel existingGrade = gradeService.findById(id);
        System.out.println(existingGrade);
        if (existingGrade != null) {
          // Ensure the ID of the updated grade matches the requested ID
            GradeModel savedGrade = gradeService.updateGrade(id , updatedGrade);
            return ResponseEntity.ok(savedGrade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
