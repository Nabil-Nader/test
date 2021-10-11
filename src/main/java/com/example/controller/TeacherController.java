package com.example.controller;

import com.example.Exception.UserNotFoundException;
import com.example.Service.TeacherService;
import com.example.database.Student;
import com.example.database.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v2/teachers")
public class TeacherController {

 private final TeacherService teacherService ;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public ResponseEntity< List<Teacher>> getAllTeachers(){
        List<Teacher> teachers = teacherService.getAllTeacher();
        return new ResponseEntity<>(teachers, HttpStatus.OK) ;
    }

    @GetMapping("find/{id}")
    public ResponseEntity <Teacher>  getTeacher(@PathVariable("id") Long id){
        Teacher teacherById = teacherService.getTeacherById(id);

        if (teacherById == null){
            throw new UserNotFoundException("Student id not found :"+id);
        }
        return new ResponseEntity<>(teacherById, HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher newTeacher){

        Teacher saveTeacher = teacherService.saveTeacher(newTeacher);

        return new ResponseEntity<>(saveTeacher, HttpStatus.CREATED) ;
    }
    @PutMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        Teacher updateTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(updateTeacher, HttpStatus.OK) ;
    }

//    @DeleteMapping("delete/{id}")
//    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id){
//        Teacher tempStudent = teacherService.getTeacherById(id);
//
//        if (tempStudent == null) {
//            throw new UserNotFoundException("Student id not found - " + id);
//        }
//
//        teacherService.deleteTeacher(id);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
    @GetMapping("/{id}/allStudents")
    public ResponseEntity<Set<Student>> showTeacherStudents(@PathVariable("id") Long id){
    	
        Teacher teacher = teacherService.getTeacherById(id);
        Set<Student> students = teacher.getStudents();

        return new ResponseEntity<>(students,HttpStatus.OK);
    }


}