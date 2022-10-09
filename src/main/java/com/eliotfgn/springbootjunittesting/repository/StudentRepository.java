package com.eliotfgn.springbootjunittesting.repository;

import com.eliotfgn.springbootjunittesting.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("" +
            "select case " +
            "when count(s) > 0 then true " +
            "else false end " +
            "from Student s " +
            "where s.email=?1")
    Boolean selectExistEmail(String email);
}