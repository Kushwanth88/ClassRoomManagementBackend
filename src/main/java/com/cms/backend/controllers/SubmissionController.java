package com.cms.backend.controllers;

import com.cms.backend.model.SubmissionModel;
import com.cms.backend.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submission")
@CrossOrigin(origins = "http://localhost:3000")
public class SubmissionController {
    private final SubmissionService submissionService;

    @Autowired
    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<SubmissionModel>> getSubmissionsByStudentId(@PathVariable("id") int studentId) {
        List<SubmissionModel> submissions = submissionService.getSubmissionsByStudentId(studentId);
        return new ResponseEntity<>(submissions, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SubmissionModel> toggleSubmissionStatus(@PathVariable("id") int submissionId) {
        SubmissionModel submission = submissionService.toggleSubmissionStatus(submissionId);
        if (submission != null) {
            return new ResponseEntity<>(submission, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
