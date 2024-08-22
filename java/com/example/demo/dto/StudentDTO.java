package com.example.demo.dto;

import java.time.LocalDate;

public class StudentDTO {
    private String id;
    private String name;
    private String studentClass;
    private String rollNumber;
    private LocalDate dob;

    // Constructors, getters, and setters

    public StudentDTO() {}

    public StudentDTO(String id, String name, String studentClass, String rollNumber, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.studentClass = studentClass;
        this.rollNumber = rollNumber;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
