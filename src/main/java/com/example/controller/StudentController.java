package com.example.controller;

import com.example.Exception.UserNotFoundException;
import com.example.Service.StudentService;
import com.example.database.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/students")
public class StudentController {

    @Autowired
    private StudentService studentService ;

    @GetMapping("/all")
    public ResponseEntity< List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK) ;
    }

    @GetMapping("find/{id}")
    public ResponseEntity <Student>  getStudent(@PathVariable("id") Long id){
        Optional<Student> theStudent = studentService.getStudent(id);

        if (theStudent.isPresent()){
            return ResponseEntity.unprocessableEntity().build();
        } else {
        	 return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }     
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student newStudent){

        Student theStudent = studentService.saveStudent(newStudent);
       return new ResponseEntity<>(theStudent, HttpStatus.CREATED) ;
    }
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student newStudent){
        Student theStudent = studentService.saveStudent(newStudent);
        return new ResponseEntity<>(theStudent, HttpStatus.OK) ;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id){
        Optional<Student> tempStudent = studentService.getStudent(id);

        if (tempStudent == null) {
            throw new UserNotFoundException("Student id not found - " + id);
        }
     studentService.deleteStudent(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
