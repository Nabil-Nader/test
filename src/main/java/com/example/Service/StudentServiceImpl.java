
package com.example.Service;

import com.example.Exception.UserNotFoundException;
import com.example.database.Student;
 import com.example.repository.StudentRepository;
 import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(Student theStudent) {
        studentRepository.save(theStudent);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("Student by Id"+id+
                        " not found"));
    }

    public List<Student> getStudentByTeacher(Long id){
        return studentRepository.findByTeacherId(id);
    }
}

