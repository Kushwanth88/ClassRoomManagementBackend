    package com.cms.backend.model;


    import jakarta.persistence.*;

    @Entity
    @Table(name = "\"assignment\"")

    public class AssignmentModel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String title;
        private String description;
        private int classId;
        private int teacherId;
        private String instructions;
        private String deadlines;
        private int maxScore;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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



        public void setClassId(int classId) {
            this.classId = classId;
        }

        public int getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(int teacherId) {
            this.teacherId = teacherId;
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

        public int getMaxScore() {
            return maxScore;
        }

        public void setMaxScore(int maxScore) {
            this.maxScore = maxScore;
        }

        public int getClassId() {
            return classId;
        }
    }
