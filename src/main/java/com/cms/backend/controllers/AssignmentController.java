package com.cms.backend.controller;

import com.cms.backend.model.AssignmentModel;
import com.cms.backend.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignment")
@CrossOrigin(origins = "http://localhost:3000")
public class AssignmentController {
    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AssignmentModel>> getAllAssignmentsByTeacherId(@PathVariable("id") int teacherId) {
        List<AssignmentModel> assignments = assignmentService.getAllAssignmentsByTeacherId(teacherId);
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<AssignmentModel> createAssignment(@PathVariable("id") int teacherId, @RequestBody AssignmentModel assignmentModel) {
        AssignmentModel createdAssignment = assignmentService.createAssignment(teacherId, assignmentModel);
        return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<AssignmentModel> updateAssignment(@PathVariable("id") int id, @RequestBody AssignmentModel assignmentModel) {
        AssignmentModel updatedAssignment = assignmentService.updateAssignment(id, assignmentModel);
        return new ResponseEntity<>(updatedAssignment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable("id") int id) {
        assignmentService.deleteAssignment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
