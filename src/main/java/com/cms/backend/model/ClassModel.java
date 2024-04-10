package com.cms.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "\"class\"")
public class ClassModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int teacherId;
    private int studentId;
    private int classId;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId(){
        return classId;
    }

    public void setClassId(int classId){
        this.classId = classId;
    }
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
