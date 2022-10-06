package com.eliotfgn.springbootjunittesting.controller;

import com.eliotfgn.springbootjunittesting.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
}
