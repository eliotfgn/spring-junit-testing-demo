package com.eliotfgn.springbootjunittesting.service;

import com.eliotfgn.springbootjunittesting.model.Student;
import com.eliotfgn.springbootjunittesting.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Boolean takenEmail = studentRepository.selectExistEmail(student.getEmail());

        if (takenEmail) {
            throw new RuntimeException("Email is already taken!");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("No such user exists.");
        }
        studentRepository.deleteById(id);
    }
}
