package com.example.Service;

import com.example.database.Student;

import java.util.List;

public interface StudentService {
    void saveStudent(Student theStudent);

    List<Student> getAllStudents();

    Student getStudent(Long id);

}
