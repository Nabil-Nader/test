package com.example.controller;

import com.example.Exception.UserNotFoundException;
import com.example.Service.StudentService;
import com.example.Service.TeacherService;
import com.example.database.Student;
import com.example.database.Teacher;
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
    private final StudentService studentService ;

    @Autowired
    private final TeacherService teacherService ;

    public StudentController(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

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


        }
        return null;

//        return new ResponseEntity<>(theStudent, HttpStatus.OK) ;
    }

//    @GetMapping("find/student/teacher/{id}")
//    public ResponseEntity<List<Student>> getStudentTeacher(@PathVariable("id")
//                                                                       Long id){
//        Teacher teacher = teacherService.getTeacherById(id);
//        Student s = teacherService.
//        return new ResponseEntity<>(allStudent,HttpStatus.OK);
//    }

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
