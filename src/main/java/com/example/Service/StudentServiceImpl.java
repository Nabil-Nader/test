
package com.example.Service;

import com.example.database.Student;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student theStudent) {
		return studentRepository.save(theStudent);

	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getStudent(Long id) {
		return studentRepository.findById(id);

	}
	
	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
