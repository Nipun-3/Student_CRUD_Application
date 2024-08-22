package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            studentDTOs.add(convertToDTO(student));
        }

        return studentDTOs;
    }

    @Override
    public StudentDTO getStudentByRollNumber(String rollNumber) {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return convertToDTO(student);
            }
        }
        return null;
    }


    @Override
    public void updateStudentName(String rollNumber, String newName) {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                student.setName(newName);
                studentRepository.save(student);
                break;
            }
        }
    }

    @Override
    public void deleteStudentByRollNumber(String rollNumber) {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                studentRepository.delete(student);
                break;
            }
        }
    }

    // Conversion methods
    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getStudentClass(),
                student.getRollNumber(),
                student.getDob()
        );
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getName(),
                studentDTO.getStudentClass(),
                studentDTO.getRollNumber(),
                studentDTO.getDob()
        );
    }
}
