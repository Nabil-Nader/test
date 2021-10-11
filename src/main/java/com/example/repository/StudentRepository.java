package com.example.repository;

import com.example.database.Student;

import com.example.database.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByTeacherId(Long id);


}
