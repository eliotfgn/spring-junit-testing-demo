package com.eliotfgn.springbootjunittesting.service;

import com.eliotfgn.springbootjunittesting.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
}
