package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.database.Teacher;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher,Long> {

    Teacher findTeacherByJobTitle(String  jobTitle);
    Teacher findTeacherById(Long id);




	
}
