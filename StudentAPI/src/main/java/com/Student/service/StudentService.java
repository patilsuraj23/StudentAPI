package com.Student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Entity.Student;
import com.Student.Repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		return studentRepository.findById(id);
	}

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	public Student updateStudent(Long id, Student student) {
		Student existingStudent = studentRepository.findById(id).orElse(null);
		if (existingStudent != null) {
			existingStudent.setName(student.getName());
			existingStudent.setAge(student.getAge());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setPhone(student.getPhone());
			return studentRepository.save(existingStudent);
		} else {
			return null;
		}
	}
}
