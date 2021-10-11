package com.example.Service;

import com.example.database.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student theStudent);

    List<Student> getAllStudents();

    Optional<Student> getStudent(Long id);

    void deleteStudent(Long id);
}
