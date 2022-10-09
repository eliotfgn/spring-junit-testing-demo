package com.eliotfgn.springbootjunittesting.controller;

import com.eliotfgn.springbootjunittesting.model.Student;
import com.eliotfgn.springbootjunittesting.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @Test
    void checkIfStudentEmailExistsWhenEmailIsCreated() {
        String email = "johndoe@gmail.com";
        String name = "John Doe";

        Student student = new Student(email, name);

        studentRepository.save(student);

        assertThat(studentRepository.selectExistEmail(email)).isTrue();
    }

    @Test
    void checkIfStudentEmailExistsWhenItsNotCreated() {
        String name = "John Doe";

        Student student = new Student();
        student.setName(name);

        //studentRepository.save(student);

        assertThat(studentRepository.selectExistEmail("johndoe@gmail.com")).isFalse();
    }
}