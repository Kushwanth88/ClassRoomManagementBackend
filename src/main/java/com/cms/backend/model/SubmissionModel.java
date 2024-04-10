package com.cms.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "\"submission\"")

public class SubmissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int assignmentId;
    private int studentId;
    private int teacherId;
    private String title;
    private String description;
    private int classId;
    private String instructions;
    private String deadlines;
    private boolean isSubmitted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAssignmentId() {
        return assignmentId;
    }
    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherid) {
        this.teacherId = teacherid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDeadlines() {
        return deadlines;
    }

    public void setDeadlines(String deadlines) {
        this.deadlines = deadlines;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
