package com.example.demo.service;

import com.example.demo.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void addStudent(StudentDTO studentDTO);
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentByRollNumber(String rollNumber);
    void updateStudentName(String rollNumber, String newName);
    void deleteStudentByRollNumber(String rollNumber);
}
