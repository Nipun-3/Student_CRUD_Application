package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentDTO studentDTO) {
        studentService.addStudent(studentDTO);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{rollNumber}")
    public StudentDTO getStudent(@PathVariable String rollNumber) {
        return studentService.getStudentByRollNumber(rollNumber);
    }

    @PutMapping("/{rollNumber}")
    public void updateStudentName(@PathVariable String rollNumber, @RequestParam String newName) {
        studentService.updateStudentName(rollNumber, newName);
    }

    @DeleteMapping("/{rollNumber}")
    public void deleteStudent(@PathVariable String rollNumber) {
        studentService.deleteStudentByRollNumber(rollNumber);
    }
}
