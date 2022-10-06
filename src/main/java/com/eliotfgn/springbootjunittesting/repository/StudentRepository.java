package com.eliotfgn.springbootjunittesting.repository;

import com.eliotfgn.springbootjunittesting.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}