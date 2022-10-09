package com.eliotfgn.springbootjunittesting.service;

import com.eliotfgn.springbootjunittesting.model.Student;
import com.eliotfgn.springbootjunittesting.repository.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void canGetAllStudents() {
        // given
        // when
        studentService.getAllStudents();

        // then
        verify(studentRepository).findAll();
    }

    @Test
    void studentAddedWhenEmailDoesntExist() {
        // given
        Student student = new Student("johndoe@gmail.com", "John Doe");

        // when
        studentService.addStudent(student);

        // then ensure that student to add is well added
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        // we capture the student argument passed to studentRepository.save() to verify if it is the one which
        // should be saved
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void studentNotAddedWhenEmailExists() {
        // given
        String email = "johndoe@gmail.com";
        Student student = new Student(email, "John Doe");
        given(studentRepository.selectExistEmail(email)).willReturn(true);
        //when(studentRepository.selectExistEmail(email)).thenReturn(true);

        // when
        // then check if the call of addStudent method throws exception containing a certain message
        assertThatThrownBy(() -> studentService.addStudent(student))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Email is already taken!");

        // verify if studentRepository.save() is never called on student
        verify(studentRepository, never()).save(student);
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}