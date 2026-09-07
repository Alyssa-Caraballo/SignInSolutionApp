package com.valencia.lab.signin.repository;

import com.valencia.lab.signin.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // this repository provides all save methods
}
